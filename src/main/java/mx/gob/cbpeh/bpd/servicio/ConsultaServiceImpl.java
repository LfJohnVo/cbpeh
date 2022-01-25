package mx.gob.cbpeh.bpd.servicio;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import mx.gob.cbpeh.bpd.dto.ColaboracionesConcentradoDto;
import mx.gob.cbpeh.bpd.dto.ConcentradoDto;
import mx.gob.cbpeh.bpd.dto.ConsultaConcentradoDto;
import mx.gob.cbpeh.bpd.dto.ConsultaConcetradoResultados;
import mx.gob.cbpeh.bpd.dto.RegistroDiarioDto;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatusLocalizado;
import mx.gob.cbpeh.bpd.modelo.CatMunicipio;
import mx.gob.cbpeh.bpd.modelo.CatSexo;

@Configuration
@EnableTransactionManagement
@PropertySource({
		"META-INF/application.properties"
})
@Service
public class ConsultaServiceImpl implements ConsultaService {

	private static final Logger log = LoggerFactory.getLogger(ConsultaServiceImpl.class);

	@Autowired
	@PersistenceContext
	EntityManager em;

	@Autowired
	Environment env;

	@Autowired
	ExpedienteServicio expedienteServicioImpl;
	@Autowired
	CatSexoServicio catSexoServicioImpl;
	@Autowired
	CatEstatusLocalizadoServicio catEstatusLocalizadoServicioImpl;
	@Autowired
	CatMunicipioServicio catMunicipioServicioImpl;

	@SuppressWarnings("unchecked")
	public List<ConcentradoDto> buscarConcentrado(String idExpediente, String idSexo, String idEdad, String idMunicipio,
			String idEstatusLocalizado) {
		List<ConcentradoDto> concentrados = new ArrayList<ConcentradoDto>();
		// EntityManager em = getEntityManager();
		idExpediente = (null != idExpediente) ? idExpediente : "";
		idSexo = (null != idSexo) ? idSexo : "";
		idEdad = (null != idEdad) ? idEdad : "";
		idMunicipio = (null != idMunicipio) ? idMunicipio : "";
		idEstatusLocalizado = (null != idEstatusLocalizado) ? idEstatusLocalizado : "";

		try {
			ConsultaConcentradoDto resultado = expedienteServicioImpl.getConsultaConcentradoPorFiltros(idExpediente,
					"13", idMunicipio, idSexo, idEdad, idEstatusLocalizado);
			if (null != resultado && !resultado.getEstatus().equals("Sin resultados encontrados")) {

				List<CatSexo> sexos = catSexoServicioImpl.getCatSexo();
				List<CatSexo> sexosFilt = new ArrayList<CatSexo>();

				List<CatMunicipio> municipiosHidalgo = catMunicipioServicioImpl.getCatMunicipiosPorEstado("13");
				List<CatMunicipio> municipiosHidalgoFilt = new ArrayList<CatMunicipio>();

				List<CatEstatusLocalizado> estatusLoc = catEstatusLocalizadoServicioImpl.getCatEstatusLocalizados();
				List<CatEstatusLocalizado> estatusLocFilt = new ArrayList<CatEstatusLocalizado>();

				List<ConsultaConcetradoResultados> resultadosConcentrados = resultado.getResultados();
				for (int i = 0; i < resultadosConcentrados.size(); i++) {
					ConsultaConcetradoResultados concentradoResultadosElem = resultadosConcentrados.get(i);
					sexosFilt = sexos.stream()
							.filter(elemt -> elemt.getIdSexo() == concentradoResultadosElem.getId_sexo())
							.collect(Collectors.toList());
					municipiosHidalgoFilt = municipiosHidalgo.stream().filter(
							elemt -> elemt.getCodigoMunicipio().equals(concentradoResultadosElem.getCodigo_municipio()))
							.collect(Collectors.toList());
					estatusLocFilt = estatusLoc.stream().filter(elemt -> elemt
							.getIdEstatusLocalizado() == concentradoResultadosElem.getId_estatus_localizado())
							.collect(Collectors.toList());
					ConcentradoDto dto = new ConcentradoDto(
							resultadosConcentrados.get(i).getId_expediente(),
							resultadosConcentrados.get(i).getNombre(),
							resultadosConcentrados.get(i).getApaterno(),
							resultadosConcentrados.get(i).getAmaterno(),
							resultadosConcentrados.get(i).getFecha_apertura_expediente(),
							sexosFilt.get(0).getSexoDetalle(),
							municipiosHidalgoFilt.get(0).getMunicipioDetalle(),
							estatusLocFilt.get(0).getEstatusLocalizadoDetalle());
					concentrados.add(dto);
				}
			}
		} catch (Exception e) {

		}
		return concentrados;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroDiarioDto> buscarRegistroDiario(Integer anio, Integer mes, Integer idEstatus,
			String idExpediente) {
		List<Object[]> results = new ArrayList<Object[]>();
		List<RegistroDiarioDto> registros = new ArrayList<RegistroDiarioDto>();
		StringBuilder queryStr = new StringBuilder(
				"SELECT b.id_expediente,pd.nombre,pd.apaterno,pd.amaterno,COUNT(*) AS acciones, es.estatus_localizado_detalle  FROM  busqueda b "
						+ "INNER JOIN expediente ex ON b.id_expediente = ex.id_expediente "
						+ "INNER JOIN persona_desaparecida pd ON ex.id_persona_desaparecida = pd.id_persona_desaparecida "
						+ "INNER JOIN cat_estatus_localizado es ON ex.id_estus_localizado = es.id_estatus_localizado "
						+ "WHERE b.estatus_busqueda = 1");

		queryStr.append((anio != null) ? " AND YEAR(b.fecha_busqueda) = :anio" : "");
		queryStr.append((mes != null) ? " AND MONTH(b.fecha_busqueda) = :mes" : "");
		queryStr.append((idEstatus != null) ? " AND ex.id_estus_localizado= :estatus" : "");
		queryStr.append((idExpediente != null && !idExpediente.equals("")) ? " AND b.id_expediente = :expediente" : "");

		queryStr.append(" GROUP BY ex.id_expediente ORDER BY	ex.id_expediente DESC ");

		Query nativeQueray = em.createNativeQuery(queryStr.toString());

		if (anio != null) {
			nativeQueray.setParameter("anio", anio);
		}
		if (mes != null) {
			nativeQueray.setParameter("mes", mes);
		}
		if (idEstatus != null) {
			nativeQueray.setParameter("estatus", idEstatus);
		}
		if (idExpediente != null && !idExpediente.equals("")) {
			nativeQueray.setParameter("expediente", idExpediente);
		}

		results = nativeQueray.getResultList();
		log.info("tamanio Reg Diario:" + results.size());

		if (results.size() > 0) {
			registros = results
					.stream()
					.map(result -> new RegistroDiarioDto(
							(String) result[0],
							(String) result[1],
							(String) result[2],
							(String) result[3],
							(BigInteger) result[4],
							(String) result[5]))
					.collect(Collectors.toList());
		}
		return registros;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ColaboracionesConcentradoDto> buscarColaboracion(String idExpediententeColaboracion,
			String fechaPeticion, String idInstitucion, String idEstatusColaboracion) {
		List<Object[]> results = new ArrayList<Object[]>();
		List<ColaboracionesConcentradoDto> registros = new ArrayList<ColaboracionesConcentradoDto>();
		StringBuilder queryStr = new StringBuilder(
				"SELECT col.id_expediente_colaboracion,col.numero_officio_peticion,col.fecha_peticion,col.firmado_por,col.nombre,col.apaterno,col.amaterno,col.oficio_colaboracion,ins.institucion_detalle,escol.estatus_colaboracion_detalle "
						+ "FROM cbpeh.colaboracion AS col "
						+ "INNER JOIN cat_institucion AS ins ON col.id_institucion = ins.id_institucion "
						+ "INNER JOIN cat_estatus_colaboracion escol ON col.id_estatus_colaboracion = escol.id_estatus_colaboracion");

		queryStr.append((idExpediententeColaboracion != null && !idExpediententeColaboracion.equals(""))
				? " AND col.id_expediente_colaboracion = :idExpediententeColaboracion"
				: "");
		queryStr.append((fechaPeticion != null && !fechaPeticion.equals(""))
				? " AND col.fecha_peticion = :fechaPeticion"
				: "");
		queryStr.append((idInstitucion != null && !idInstitucion.equals(""))
				? " AND col.id_institucion = :idInstitucion"
				: "");
		queryStr.append((idEstatusColaboracion != null &&
				!idEstatusColaboracion.equals(""))
						? " AND col.id_estatus_colaboracion = :idEstatusColaboracion"
						: "");

		queryStr.append(" ORDER BY col.id_expediente_colaboracion DESC");

		Query nativeQueray = em.createNativeQuery(queryStr.toString());

		if (idExpediententeColaboracion != null && !idExpediententeColaboracion.equals("")) {
			nativeQueray.setParameter("idExpediententeColaboracion", idExpediententeColaboracion);
		}
		if (fechaPeticion != null && !fechaPeticion.equals("")) {
			nativeQueray.setParameter("fechaPeticion", fechaPeticion);
		}
		if (idInstitucion != null && !idInstitucion.equals("")) {
			nativeQueray.setParameter("idInstitucion", idInstitucion);
		}
		if (idEstatusColaboracion != null && !idEstatusColaboracion.equals("")) {
			nativeQueray.setParameter("idEstatusColaboracion", idEstatusColaboracion);
		}

		results = nativeQueray.getResultList();
		log.info("tamanio Reg Diario:" + results.size());

		if (results.size() > 0) {
			registros = results
					.stream()
					.map(result -> new ColaboracionesConcentradoDto(
							(String) result[0],
							(String) result[1],
							(String) result[8],
							(String) result[3],
							(String) result[4],
							(String) result[5],
							(String) result[6],
							(String) result[9]))
					.collect(Collectors.toList());
		}
		return registros;
	}

	public File generarRegistrodiario(Integer anio, Integer mes, Integer idEstatus, String idExpedienten) {
		List<RegistroDiarioDto> lista = null;
		lista = buscarRegistroDiario(anio, mes, idEstatus, idExpedienten);
		if (lista != null) {
			log.info("Generando Excel rows:" + lista.size());
			try {
				Workbook libroTrabajo = new HSSFWorkbook();
				// new HSSFWorkbook() for generating `.xls` file
				Sheet hoja = libroTrabajo.createSheet("Registro Diario busqueda");

				if (libroTrabajo instanceof HSSFWorkbook) {
					((HSSFWorkbook) libroTrabajo).createInformationProperties();
					((HSSFWorkbook) libroTrabajo).getSummaryInformation().setAuthor("By Greck alg2299");
				}

				Font fuenteCabecera = libroTrabajo.createFont(); // Creando fuente para la cabeceras
				fuenteCabecera.setBold(true);
				fuenteCabecera.setFontHeightInPoints((short) 12);
				fuenteCabecera.setColor(IndexedColors.OLIVE_GREEN.getIndex());

				CellStyle estiloCabeceraCelda = libroTrabajo.createCellStyle(); // creando estilo para las celdas
				estiloCabeceraCelda.setFont(fuenteCabecera);
				estiloCabeceraCelda.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
				// estiloCabeceraCelda.setFillPattern(FillPatternType.SOLID_FOREGROUND);

				Row filaCabecera = hoja.createRow(1); // Creando fila para cabeceras
				int rowNum = 2;

				String[] columnasC1 = { "EXPEDIENTE", "PERSONA DESAPARECIDA", "NUMERO DE ACCIONES", "ESTATUS" };
				for (int i = 0; i < columnasC1.length; i++) { // Creando cabeceras
					Cell cell = filaCabecera.createCell(i + 1);
					cell.setCellValue(columnasC1[i]);
					cell.setCellStyle(estiloCabeceraCelda);
				}
				for (RegistroDiarioDto indicador : lista) { // Llenado celdas con datos
					Row filaDatos = hoja.createRow(rowNum++);
					filaDatos.createCell(1).setCellValue(indicador.getIdExpediente());
					filaDatos.createCell(2).setCellValue(indicador.getPersonaDesaparecida());
					filaDatos.createCell(3).setCellValue(indicador.getNumeroAcciones().toString());
					filaDatos.createCell(4).setCellValue(indicador.getEstatus());
					// filaDatos.createCell(5).setCellValue(indicador.getTotalclientesPot());
				}
				for (int i = 1; i < columnasC1.length + 1; i++) { // auto ajustar la celda al contenido
					hoja.autoSizeColumn(i);
				}
				File file = new File(getRuta());
				FileOutputStream archivoSalida = new FileOutputStream(file);

				libroTrabajo.write(archivoSalida);
				archivoSalida.close();

				libroTrabajo.close();
				return file;
			} catch (Exception e) {
				log.info("Ocurrio un inconveniente al generar excel," + e.getMessage());
			}
		}
		return null;
	}

	public File generarColaboraciones(String idExpediententeColaboracion, String fechaPeticion, String idInstitucion,
			String idEstatusColaboracion) {
		List<ColaboracionesConcentradoDto> lista = null;
		lista = buscarColaboracion(idExpediententeColaboracion,
				fechaPeticion,
				idInstitucion,
				idEstatusColaboracion);
		if (lista != null) {
			log.info("Generando Excel rows:" + lista.size());
			try {
				Workbook libroTrabajo = new HSSFWorkbook();
				// new HSSFWorkbook() for generating `.xls` file
				Sheet hoja = libroTrabajo.createSheet("Concentrado de Colaboraciones");

				if (libroTrabajo instanceof HSSFWorkbook) {
					((HSSFWorkbook) libroTrabajo).createInformationProperties();
					((HSSFWorkbook) libroTrabajo).getSummaryInformation().setAuthor("By Greck alg2299");
				}

				Font fuenteCabecera = libroTrabajo.createFont(); // Creando fuente para la cabeceras
				fuenteCabecera.setBold(true);
				fuenteCabecera.setFontHeightInPoints((short) 12);
				fuenteCabecera.setColor(IndexedColors.OLIVE_GREEN.getIndex());

				CellStyle estiloCabeceraCelda = libroTrabajo.createCellStyle(); // creando estilo para las celdas
				estiloCabeceraCelda.setFont(fuenteCabecera);
				estiloCabeceraCelda.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
				// estiloCabeceraCelda.setFillPattern(FillPatternType.SOLID_FOREGROUND);

				Row filaCabecera = hoja.createRow(1); // Creando fila para cabeceras
				int rowNum = 2;

				String[] columnasC1 = { "EXPEDIENTE", "NUMERO DE OFICIO", "INSTITUCION", "FIRMADO POR",
						"PERSONA DESAPARECIDA", "ESTATUS" };
				for (int i = 0; i < columnasC1.length; i++) { // Creando cabeceras
					Cell cell = filaCabecera.createCell(i + 1);
					cell.setCellValue(columnasC1[i]);
					cell.setCellStyle(estiloCabeceraCelda);
				}
				for (ColaboracionesConcentradoDto indicador : lista) { // Llenado celdas con datos
					Row filaDatos = hoja.createRow(rowNum++);
					filaDatos.createCell(1).setCellValue(indicador.getIdExpedienteColaboracion());
					filaDatos.createCell(2).setCellValue(indicador.getNumeroOfficioPeticion());
					filaDatos.createCell(3).setCellValue(indicador.getInstitucion());
					filaDatos.createCell(4).setCellValue(indicador.getFirmadoPor());
					filaDatos.createCell(5).setCellValue(indicador.getPersonaDesaparecida());
					filaDatos.createCell(6).setCellValue(indicador.getEstatusColaboracion());
					// filaDatos.createCell(5).setCellValue(indicador.getTotalclientesPot());
				}
				for (int i = 1; i < columnasC1.length + 1; i++) { // auto ajustar la celda al contenido
					hoja.autoSizeColumn(i);
				}
				File file = new File(getRuta());
				FileOutputStream archivoSalida = new FileOutputStream(file);

				libroTrabajo.write(archivoSalida);
				archivoSalida.close();

				libroTrabajo.close();
				return file;
			} catch (Exception e) {
				log.info("Ocurrio un inconveniente al generar excel," + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public File generarConcentrado(String idExpediente, String idsexo, String idEdad, String idMunicipio,
			String idEstatusLocalizado) {
		List<ConcentradoDto> lista = null;
		lista = buscarConcentrado(idExpediente, idsexo, idEdad, idMunicipio, idEstatusLocalizado);
		if (lista != null) {
			log.info("Generando Excel rows:" + lista.size());
			try {
				Workbook libroTrabajo = new HSSFWorkbook();
				// new HSSFWorkbook() for generating `.xls` file
				Sheet hoja = libroTrabajo.createSheet("Registro Diario busqueda");

				if (libroTrabajo instanceof HSSFWorkbook) {
					((HSSFWorkbook) libroTrabajo).createInformationProperties();
					((HSSFWorkbook) libroTrabajo).getSummaryInformation().setAuthor("By Greck alg2299");
				}

				Font fuenteCabecera = libroTrabajo.createFont(); // Creando fuente para la cabeceras
				fuenteCabecera.setBold(true);
				fuenteCabecera.setFontHeightInPoints((short) 12);
				fuenteCabecera.setColor(IndexedColors.OLIVE_GREEN.getIndex());

				CellStyle estiloCabeceraCelda = libroTrabajo.createCellStyle(); // creando estilo para las celdas
				estiloCabeceraCelda.setFont(fuenteCabecera);
				estiloCabeceraCelda.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
				// estiloCabeceraCelda.setFillPattern(FillPatternType.SOLID_FOREGROUND);

				Row filaCabecera = hoja.createRow(1); // Creando fila para cabeceras
				int rowNum = 2;

				String[] columnasC1 = { "EXPEDIENTE", "PERSONA DESAPARECIDA", "FECHA DE APERTURA", "FECHA CIERRE",
						"SEXO", "MUNICIPIO", "ESTATUS" };
				for (int i = 0; i < columnasC1.length; i++) { // Creando cabeceras
					Cell cell = filaCabecera.createCell(i + 1);
					cell.setCellValue(columnasC1[i]);
					cell.setCellStyle(estiloCabeceraCelda);
				}
				for (ConcentradoDto indicador : lista) { // Llenado celdas con datos
					Row filaDatos = hoja.createRow(rowNum++);
					filaDatos.createCell(1).setCellValue(indicador.getIdExpediente());
					filaDatos.createCell(2).setCellValue(indicador.getPersonaDesaparecida());
					filaDatos.createCell(3).setCellValue(indicador.getFechaApertura());
					filaDatos.createCell(4).setCellValue(indicador.getFechaCierre());
					filaDatos.createCell(5).setCellValue(indicador.getSexo());
					filaDatos.createCell(6).setCellValue(indicador.getMunicipio());
					filaDatos.createCell(7).setCellValue(indicador.getEstatus());
				}
				for (int i = 1; i < columnasC1.length + 1; i++) { // auto ajustar la celda al contenido
					hoja.autoSizeColumn(i);
				}
				File file = new File(getRuta());
				FileOutputStream archivoSalida = new FileOutputStream(file);

				libroTrabajo.write(archivoSalida);
				archivoSalida.close();

				libroTrabajo.close();
				return file;
			} catch (Exception e) {
				log.info("Ocurrio un inconveniente al generar excel," + e.getMessage());
			}
		}
		return null;
	}

	public String getRuta() {
		String so = System.getProperty("os.name");
		String path = "";
		System.out.println(so);
		if (so.contains("Windows")) {
			path = env.getProperty("win.ruta.file.excel");
		} else {
			path = env.getProperty("ruta.file.excel");
		}
		return path;
	}

}
