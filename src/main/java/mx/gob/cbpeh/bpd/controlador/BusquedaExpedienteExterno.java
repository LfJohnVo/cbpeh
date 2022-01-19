package mx.gob.cbpeh.bpd.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mx.gob.cbpeh.bpd.dto.ConsultaPublicaDto;
import mx.gob.cbpeh.bpd.dto.PersonaDesaparecidaDto;
import mx.gob.cbpeh.bpd.dto.ConsultaPublicaResultados;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.Expediente;
import mx.gob.cbpeh.bpd.modelo.PersonaDesaparecida;
import mx.gob.cbpeh.bpd.servicio.CatEstatusLocalizadoServicio;
import mx.gob.cbpeh.bpd.servicio.ExpedienteServicio;
import mx.gob.cbpeh.bpd.servicio.PersonaDesaparecidaServicio;

@Controller
@RequestMapping(value = "/consultaexterna")
public class BusquedaExpedienteExterno {

	private static final Logger log = LoggerFactory.getLogger(BusquedaExpedienteExterno.class);

	@Autowired
	ExpedienteServicio expedienteServicio;
	
	@Autowired
	CatEstatusLocalizadoServicio estatusLocalizadoServicio;

	@Autowired
	PersonaDesaparecidaServicio personaDesaparecidaServicio;


	/* Obtiene el expediente por idExpediente */
	@RequestMapping(value = "/persona-desaparecida", method = RequestMethod.POST)
	public ResponseEntity<PersonaDesaparecidaDto> consultarEstatusExpediente(
			@RequestParam("folioExpediente") String folioExpediente, @RequestParam("curp") String curp,
			@RequestParam("nombre") String nombre, @RequestParam("apaterno") String aPaterno,
			@RequestParam("amaterno") String aMaterno) throws ResourceNotFoundException, NullPointerException {

		PersonaDesaparecidaDto response = new PersonaDesaparecidaDto();
		
		try {

			if ((folioExpediente.isEmpty() || folioExpediente.trim().equals(""))
					&& (curp.isEmpty() || curp.trim().equals("")) && (nombre.isEmpty() || nombre.trim().equals(""))
					&& (aPaterno.isEmpty() || aPaterno.trim().equals(""))
					&& (aMaterno.isEmpty() || aMaterno.trim().equals(""))) {

				response.setEstatus(-1);
				response.setDescripcion(
						"Por favor de capturar los campos de búsqueda, por folio expediente, CURP o nombre y apellidos.");
				return new ResponseEntity<>(response, HttpStatus.OK);

			} else if (!folioExpediente.isEmpty() || !folioExpediente.trim().equals("")) {
				System.out.println("Filtro por Id expediente "+folioExpediente.toUpperCase() );
				ConsultaPublicaDto publicaDto = expedienteServicio.getConsultaPublicaPorExp(folioExpediente.toUpperCase());

				if (publicaDto.getResultados() == null) {

					response.setEstatus(1);
					response.setDescripcion("No se encontrarón registros.");
					return new ResponseEntity<>(response, HttpStatus.OK);
				}
				
				for (ConsultaPublicaResultados resultBusqueda : publicaDto.getResultados()) {
					
					response.setNombre(resultBusqueda.getNombre() == null ? "" : resultBusqueda.getNombre());
					response.setApaterno(resultBusqueda.getApaterno() == null ? "" : resultBusqueda.getApaterno());
					response.setAmaterno(resultBusqueda.getAmaterno() == null ? "" : resultBusqueda.getAmaterno());
					response.setCurp(resultBusqueda.getCurp() == null ? "" : resultBusqueda.getCurp());
					response.setFechaDesaparecion(	resultBusqueda.getFecha_desaparicion() == null ? "" : resultBusqueda.getFecha_desaparicion());
					response.setFolioExpediente(resultBusqueda.getId_expediente());
					response.setEstatusDesaparecido( estatusLocalizadoServicio.getCatEstatusLocalizado( resultBusqueda.getId_estatus_localizado()).getEstatusLocalizadoDetalle());
				}
				response.setEstatus(1);
				response.setDescripcion("OK");
				return new ResponseEntity<>(response, HttpStatus.OK);

			}

			else if ((folioExpediente.isEmpty() || folioExpediente.trim().equals("")) && (!curp.trim().isEmpty() || !curp.trim().equals(""))) {
				System.out.println("Filtro por CURP" +curp.toUpperCase());
				ConsultaPublicaDto publicaDto = expedienteServicio.getConsultaPublicaPorCurp(curp.toUpperCase(), "1");

				if (publicaDto.getResultados() == null) {

					response.setEstatus(1);
					response.setDescripcion("No se encontrarón registros.");
					return new ResponseEntity<>(response, HttpStatus.OK);
				}

				
				for (ConsultaPublicaResultados resultBusqueda : publicaDto.getResultados()) {
					
					response.setNombre(resultBusqueda.getNombre() == null ? "" : resultBusqueda.getNombre());
					response.setApaterno(resultBusqueda.getApaterno() == null ? "" : resultBusqueda.getApaterno());
					response.setAmaterno(resultBusqueda.getAmaterno() == null ? "" : resultBusqueda.getAmaterno());
					response.setCurp(resultBusqueda.getCurp() == null ? "" : resultBusqueda.getCurp());
					response.setFechaDesaparecion(	resultBusqueda.getFecha_desaparicion() == null ? "" : resultBusqueda.getFecha_desaparicion());
					response.setFolioExpediente(resultBusqueda.getId_expediente());
					response.setEstatusDesaparecido( estatusLocalizadoServicio.getCatEstatusLocalizado( resultBusqueda.getId_estatus_localizado()).getEstatusLocalizadoDetalle());
				}
				response.setEstatus(1);
				response.setDescripcion("OK");
				return new ResponseEntity<>(response, HttpStatus.OK);

			}
			else if (curp.trim().equals("") && folioExpediente.trim().equals("") && !nombre.trim().equals("") && !aPaterno.trim().equals("")) {
				System.out.println("Filtro por nombre completo" );
				ConsultaPublicaDto publicaDto = expedienteServicio.getConsultaPublicaPorNombreCompleto(nombre, aPaterno, aMaterno, "3");
				if (publicaDto.getResultados() == null) {

					response.setEstatus(1);
					response.setDescripcion("No se encontrarón registros.");
					return new ResponseEntity<>(response, HttpStatus.OK);
				}

				
				for (ConsultaPublicaResultados resultBusqueda : publicaDto.getResultados()) {
					
					response.setNombre(resultBusqueda.getNombre() == null ? "" : resultBusqueda.getNombre());
					response.setApaterno(resultBusqueda.getApaterno() == null ? "" : resultBusqueda.getApaterno());
					response.setAmaterno(resultBusqueda.getAmaterno() == null ? "" : resultBusqueda.getAmaterno());
					response.setCurp(resultBusqueda.getCurp() == null ? "" : resultBusqueda.getCurp());
					response.setFechaDesaparecion(resultBusqueda.getFecha_desaparicion() == null ? "" : resultBusqueda.getFecha_desaparicion());
					response.setFolioExpediente(resultBusqueda.getId_expediente());
					response.setEstatusDesaparecido( estatusLocalizadoServicio.getCatEstatusLocalizado( resultBusqueda.getId_estatus_localizado()).getEstatusLocalizadoDetalle());
				}
				response.setEstatus(1);
				response.setDescripcion("OK");
				return new ResponseEntity<>(response, HttpStatus.OK);

			}
				

			
			response.setEstatus(1);
			response.setDescripcion("OK");
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			log.error("Error al consultar folio expediente externo : " + e);
			response.setEstatus(-3);
			response.setDescripcion("Se genero un error en  al consultar persona desaparecida.");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

	}

}
