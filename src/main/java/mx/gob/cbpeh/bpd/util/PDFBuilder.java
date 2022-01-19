package mx.gob.cbpeh.bpd.util;

import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import mx.gob.cbpeh.bpd.modelo.AtentaNota;
import mx.gob.cbpeh.bpd.modelo.Expediente;
import mx.gob.cbpeh.bpd.modelo.PersonaDesaparecida;
import mx.gob.cbpeh.bpd.modelo.Usuario;

public class PDFBuilder extends AbstractITextPdfView {
	//public static final String IMG = "recursos/img/logo1.PNG";
	//public static final String IMG2 = "recursos/img/logo2.PNG";
	public static final String IMG = "recursos/img/logo1.png";
	public static final String IMG2 = "recursos/img/logo2.png";
	private static final Logger LOG = LoggerFactory.getLogger(PDFBuilder.class);
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
			AtentaNota aNota = (AtentaNota) model.get("atentaNota");
			Usuario remitenteU = (Usuario) model.get("remitente");
			Usuario destinatarioU = (Usuario) model.get("destinatario");
			Expediente expediente = (Expediente) model.get("expediente");
			PersonaDesaparecida desaparecido = (PersonaDesaparecida) model.get("desaparecido");
			
			String pathAbsoluto= (PDFBuilder.class.getProtectionDomain().getCodeSource().getLocation().getFile());
			int tam = pathAbsoluto.lastIndexOf("WEB-INF");
			String cadena = pathAbsoluto.substring(1, tam);
			// Design ParaGraph
		
			Image image = Image.getInstance(cadena+IMG);
			image.setAlignment(Element.ALIGN_LEFT);
			image.scalePercent(50f);
			image.setAbsolutePosition (40f, 765f);
			doc.add(image);

			Image image2 = Image.getInstance(cadena+IMG2);
			image2.scalePercent(25f);
			image2.setAbsolutePosition(500f, 750f);
			doc.add(image2);
		 			
	        try {
	        	Font negro = FontFactory.getFont("/fonts/Verdana.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 11.0f, Font.BOLD, BaseColor.BLACK);
	        	Font normal = FontFactory.getFont("/fonts/Verdana.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 12.0f, Font.NORMAL, BaseColor.BLACK);
	        	//Font negro = new Font(FontFamily.HELVETICA, 11, Font.BOLD,BaseColor.BLACK);
	        	//Font normal = new Font(FontFamily.TIMES_ROMAN, 12, Font.NORMAL,BaseColor.BLACK);

	        	Chunk titulo = new Chunk("ATENTA NOTA "+aNota.getIdAtentaNota(), negro);
		
	        	Chunk fecha = new Chunk("Pachuca de Soto, Hidalgo a " + new SimpleDateFormat("EEEE d 'de' MMMM 'de' yyyy").format(aNota.getFechaCreacion()), negro);
	        	Chunk vacio = new Chunk(" ");
	        	Paragraph pVacio = new Paragraph(vacio);
	        	Paragraph p = new Paragraph(titulo);		        
	        	p.setAlignment( Element.ALIGN_CENTER);
		          
	        	Paragraph p2 = new Paragraph(fecha);		        
	        	p2.setAlignment( Element.ALIGN_RIGHT );		                 
		     
	        	doc.add(pVacio);
	        	doc.add(pVacio);
	        	doc.add(pVacio);
	        	
	        	doc.add(p2);	
	        	doc.add(pVacio);
	        	doc.add(pVacio);
	          
	        	doc.add(p);		     
	        	doc.add(pVacio);
	        	doc.add(pVacio);
	        	doc.add(pVacio);
	        	//Chunk destinatario = new Chunk("LIC. " + destinatarioU.getNombre()+" " + destinatarioU.getApaterno()+" " + destinatarioU.getApaterno()+"\n"
	        	Chunk destinatario = new Chunk("LIC. " + destinatarioU.getNombre()+" " + destinatarioU.getApaterno()+" " + destinatarioU.getAmaterno()+"\n"
		    		 + destinatarioU.getCatPuesto().getPuestoDetalle()+"\n"
		    		 + "", negro);
	        	Paragraph destinatarioP = new Paragraph(destinatario);
	        	doc.add(destinatarioP);
	        	doc.add(pVacio);
	        	doc.add(pVacio);
		      
	        	//Chunk descripcion = new Chunk(aNota.getDescripcionNota(),normal);
	        	String desCadena=""; 
	        	if(null==aNota.getDescripcionNota()) {
	        		desCadena ="A través del presente, le hago llegar en medio digital la atenta nota correspondiente";
		        	if(null != aNota.getIdExpediente()) {
		        		if(null !=expediente && null !=expediente.getIdExpediente()) {
		        			desCadena+=" al expediente Número: "+aNota.getIdExpediente();
		        			if(null != desaparecido && null != desaparecido.getNombre()){
		        				String nombre =(null != desaparecido.getNombre())?desaparecido.getNombre():"";
		        				String paterno =(null!=desaparecido.getApaterno())?desaparecido.getApaterno():"";
		        				String materno =(null!=desaparecido.getNombre())?desaparecido.getAmaterno():"";
		        				desCadena+=" del caso de la C. ";
		        				desCadena+=nombre+" "+paterno+" "+materno;
		        			}	        			
		        		}
		        	}	        		
	        	}else {
	        		desCadena=aNota.getDescripcionNota();
	        	}
	        	
	        	Chunk descripcion = new Chunk(desCadena,normal);
	        	
	        	Paragraph descP = new Paragraph(descripcion);
	        	descP.setAlignment( Element.ALIGN_JUSTIFIED );	
	        	doc.add(descP);
	        	doc.add(pVacio);
	        	doc.add(pVacio);
	        	Chunk despedida = new Chunk("Sin otro en particular, envío un cordial saludos.",normal);
	        	Paragraph despP = new Paragraph(despedida);
	        	descP.setAlignment( Element.ALIGN_LEFT);	
	        	doc.add(despP);
	        	doc.add(pVacio);
	        	doc.add(pVacio);
	        	doc.add(pVacio);
	        	doc.add(pVacio);
		      
	        	Chunk  atenta = new Chunk("ATENTAMENTE", negro);
	        	Paragraph atentaP = new Paragraph(atenta);
	        	atentaP.setAlignment( Element.ALIGN_CENTER);	
	        	doc.add(atentaP);
	        	doc.add(pVacio);
	        	doc.add(pVacio);
	        	doc.add(pVacio);
	        	doc.add(pVacio);
	        	doc.add(pVacio);
	        	//Chunk  remitente =  new Chunk("Lic. " + remitenteU.getNombre()+" " + remitenteU.getApaterno()+" " + remitenteU.getApaterno()+"\n"
	        	Chunk  remitente =  new Chunk("Lic. " + remitenteU.getNombre()+" " + remitenteU.getApaterno()+" " + remitenteU.getAmaterno()+"\n"
	    		     + remitenteU.getCatPuesto().getPuestoDetalle()+"\n"
		    		 + "", negro);
	        	Paragraph remitenteP = new Paragraph(remitente);
	        	remitenteP.setAlignment( Element.ALIGN_CENTER);	
	        	doc.add(remitenteP);
			
	        } catch (NullPointerException e) {
	        	LOG.error("Error al Construir el PDF atenta nota : " + e);
	        }
	}
	
	public String esNulo(String parametro)
    {
		try {
			if (parametro.equals("null")){
				return "";
			}
			else {
				return parametro;
			}
		}
		catch (NullPointerException e){
			return "";
		}
    }
}