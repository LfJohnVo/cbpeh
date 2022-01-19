package mx.gob.cbpeh.bpd.controlador;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.databind.ObjectMapper;
import mx.gob.cbpeh.bpd.dto.CommonResponse;
import mx.gob.cbpeh.bpd.dto.CommonResponseElement;
import mx.gob.cbpeh.bpd.dto.Comunicado2;
import mx.gob.cbpeh.bpd.dto.ComunicadosDto;
import mx.gob.cbpeh.bpd.dto.UsuarioDto;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatArea;
import mx.gob.cbpeh.bpd.modelo.CatDireccion;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.CatPuesto;
import mx.gob.cbpeh.bpd.modelo.CatTipoComunicado;
import mx.gob.cbpeh.bpd.modelo.Comunicado;
import mx.gob.cbpeh.bpd.modelo.Perfil;
import mx.gob.cbpeh.bpd.modelo.Usuario;
import mx.gob.cbpeh.bpd.servicio.CatAreaServicio;
import mx.gob.cbpeh.bpd.servicio.CatCatalogosDBServicio;
import mx.gob.cbpeh.bpd.servicio.CatDireccionServicio;
import mx.gob.cbpeh.bpd.servicio.CatEstatusServicio;
import mx.gob.cbpeh.bpd.servicio.CatPuestoServicio;
import mx.gob.cbpeh.bpd.servicio.CatTipoComunicadoServicio;
import mx.gob.cbpeh.bpd.servicio.ComunicadoServicio;
import mx.gob.cbpeh.bpd.servicio.PerfilServicio;
import mx.gob.cbpeh.bpd.servicio.UsuarioServicio;

@Controller
@RequestMapping(value = "/admin")
public class AdminControlador {

	private static final Logger LOG = LoggerFactory.getLogger(AdminControlador.class);

	@Autowired
	private PerfilServicio perfilServicio;
	@Autowired
	private CatPuestoServicio puestoServicio;
	@Autowired
	private CatAreaServicio areaServicio;
	@Autowired
	private CatDireccionServicio direccionServicio;
	@Autowired
	private CatTipoComunicadoServicio tipoComunicadoServicio;
	@Autowired
	private CatEstatusServicio estatusServicio;
	@Autowired
	private UsuarioServicio usuarioServicio;
	@Autowired
	private ComunicadoServicio comunicadoServicio;
	@Autowired
	private CatCatalogosDBServicio catCatalogosDBServicio;

	/** Este carga la vista de administracion y con la pre-informacion necesaria **/
	@RequestMapping(method = RequestMethod.GET)
	private ModelAndView showUserView() {

		ModelAndView mav = new ModelAndView("template");

		try {

			LOG.info("Entra en controlador vista  ");

			mav.addObject("perfiles", perfilServicio.getPerfiles());
			mav.addObject("puestos", puestoServicio.getCatPuestos());
			mav.addObject("areas", areaServicio.getCatAreas());
			mav.addObject("direccion", direccionServicio.getCatDirecciones());
			mav.addObject("tipoComunicado", tipoComunicadoServicio.getCatTipoComunicados());
			mav.addObject("estatus", estatusServicio.getCatEstatus());
			mav.addObject("usuarios", usuarioServicio.getUsuarios());
			mav.addObject("comunicados", comunicadoServicio.getComunicados());
			mav.addObject("catCatalogos", catCatalogosDBServicio.getCatCatalogos());
			mav.addObject("nameUser", getNameUser());
			CatTipoComunicado catTipoComunicado = new CatTipoComunicado();
			catTipoComunicado.setIdTipoComunicado(2);
			ComunicadosDto comunicadosDto = new ComunicadosDto();
			List<Comunicado> comunicados = comunicadoServicio.getComunicados(catTipoComunicado);

			for (Comunicado comunicado2 : comunicados) {

				Comunicado2 comunicado22 = new Comunicado2();
				comunicado22.setIdComunicado(comunicado2.getIdComunicado());
				comunicado22.setTitulo(comunicado2.getTitulo());
				comunicado22.setDescripcion(comunicado2.getDescripcion());
				comunicado22.setUrl(comunicado2.getUrl());
				comunicado22.setImagen(comunicado2.getImagen());
				comunicado22.setImagenDetalle(comunicado2.getImagen().toString());

				comunicadosDto.getComunicados().add(comunicado22);
			}

			// Object mapper instance
			ObjectMapper mapper = new ObjectMapper();

			// Convert POJO to JSON
			String json = mapper.writeValueAsString(comunicadosDto);

			// model.addObject("comunicadosCarrusel", comunicado.getComunicados());
			mav.addObject("json", json);
			mav.addObject("tipo", 1);

		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("Se genero un error en showUserView", e);
		}

		return mav;
	}

	/* Guarda usuario */
	@RequestMapping(value = "/acciones/guardar-usuario", method = RequestMethod.POST)
	public ResponseEntity<UsuarioDto> guardarUsuario(
			// @RequestParam("tipoAccion") String accion,
			@RequestParam("nombre") String nombre, @RequestParam("aPaterno") String aPaterno,
			@RequestParam("aMaterno") String aMaterno, @RequestParam("idUsuario") String idUsuario,
			@RequestParam("password") String contrasenia, @RequestParam("idPerfil") int idPerfil,
			@RequestParam("idArea") int idArea, @RequestParam("idDireccion") int idDireccion,
			@RequestParam("idPuesto") int idPuesto, @RequestParam("correo") String correo,
			// @RequestParam("idEstatus") int idEstatus,
			// @RequestParam("llaveSecreta") String llaveSecreta,
			@RequestParam("aplica2FA") String aplica2FA

	) {
		UsuarioDto commonResponse = new UsuarioDto();

		try {

			LOG.info(" Entra guardar usuarios ");
			Usuario usuarioNuevo = usuarioServicio.getUsuario(idUsuario);

			if (usuarioNuevo != null) {
				commonResponse.setEstatus(-1);
				commonResponse.setDescripcion("El usuario ya existe, por favor de intentar con otro.");
				return new ResponseEntity<>(commonResponse, HttpStatus.OK);
			}

			usuarioNuevo = new Usuario();
			usuarioNuevo.setIdUsuario(idUsuario);
			usuarioNuevo.setNombre(nombre);
			usuarioNuevo.setApaterno(aPaterno);
			usuarioNuevo.setAmaterno(aMaterno);
			usuarioNuevo.setContrasenia(contrasenia);
			usuarioNuevo.setAplica2fa(true);
			usuarioNuevo.setLlaveSecreta("6YFX5TVT76OHHNMS");
			Perfil perfil = new Perfil();
			perfil.setIdPerfil(idPerfil);
			usuarioNuevo.setPerfil(perfil);
			CatArea catArea = new CatArea();
			catArea.setIdArea(idArea);
			usuarioNuevo.setCatArea(catArea);
			CatDireccion catDireccion = new CatDireccion();
			catDireccion.setIdDireccion(idDireccion);
			usuarioNuevo.setCatDireccion(catDireccion);
			CatPuesto catPuesto = new CatPuesto();
			catPuesto.setIdPuesto(idPuesto);
			usuarioNuevo.setCatPuesto(catPuesto);
			usuarioNuevo.setCorreoElectronico(correo);
			CatEstatus catEstatus = new CatEstatus();
			catEstatus.setIdEstatus(1);
			usuarioNuevo.setCatEstatus(catEstatus);
			usuarioNuevo.setFechaAlta(new Date());
			usuarioNuevo.setUsuario2(getNameUser());

			usuarioServicio.saveUsuario(usuarioNuevo);
			usuarioNuevo = usuarioServicio.getUsuario(idUsuario);
			commonResponse.setUsuario(usuarioNuevo);

		} catch (Exception e) {
			// TODO: handle exception

			LOG.error("Error al insertar  usuario: " + e);
			commonResponse.setEstatus(-3);
			commonResponse.setDescripcion("Se genero un error al guardar la informacion.");
			return new ResponseEntity<>(commonResponse, HttpStatus.OK);
		}

		commonResponse.setEstatus(1);
		commonResponse.setDescripcion("La informacion se guardo correctamente.");
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}

	/* Editar usuario */
	@RequestMapping(value = "/acciones/editar-usuario", method = RequestMethod.POST)
	public ResponseEntity<UsuarioDto> editarUsuario(
			// @RequestParam("tipoAccion") String accion,
			@RequestParam("nombreE") String nombre, @RequestParam("aPaternoE") String aPaterno,
			@RequestParam("aMaternoE") String aMaterno, @RequestParam("idUsuarioE") String idUsuario,
			@RequestParam("passwordE") String contrasenia, @RequestParam("idPerfilE") int idPerfil,
			@RequestParam("idAreaE") int idArea, @RequestParam("idDireccionE") int idDireccion,
			@RequestParam("idPuestoE") int idPuesto, @RequestParam("correoE") String correo,
			@RequestParam("idEstatusE") int idEstatus,
			// @RequestParam("llaveSecreta") String llaveSecreta,
			@RequestParam("aplica2FAE") boolean aplica2FA

	) {
		UsuarioDto commonResponse = new UsuarioDto();

		try {

			// LOG.info(" Entra en editar o guardar usuarios
			// "+request.getCharacterEncoding() +"/"+ request.getContentType()+"
			// "+aPaterno+" "+aMaterno);
			System.out.println(" Entra en editar usuarios " + nombre + " " + aPaterno + " " + aMaterno);
			Usuario usuarioNuevo = usuarioServicio.getUsuario(idUsuario);

			if (usuarioNuevo == null) {
				commonResponse.setEstatus(-1);
				commonResponse.setDescripcion("Error al editar el usuario, por favor de intentar nuevamente.");
				return new ResponseEntity<>(commonResponse, HttpStatus.OK);
			}

			usuarioNuevo = new Usuario();
			usuarioNuevo.setIdUsuario(idUsuario);
			usuarioNuevo.setNombre(nombre);
			usuarioNuevo.setApaterno(aPaterno);
			usuarioNuevo.setAmaterno(aMaterno);
			usuarioNuevo.setContrasenia(contrasenia);
			usuarioNuevo.setAplica2fa(aplica2FA);
			usuarioNuevo.setLlaveSecreta("6YFX5TVT76OHHNMS");
			Perfil perfil = new Perfil();
			perfil.setIdPerfil(idPerfil);
			usuarioNuevo.setPerfil(perfil);
			CatArea catArea = new CatArea();
			catArea.setIdArea(idArea);
			usuarioNuevo.setCatArea(catArea);
			CatDireccion catDireccion = new CatDireccion();
			catDireccion.setIdDireccion(idDireccion);
			usuarioNuevo.setCatDireccion(catDireccion);
			CatPuesto catPuesto = new CatPuesto();
			catPuesto.setIdPuesto(idPuesto);
			usuarioNuevo.setCatPuesto(catPuesto);
			usuarioNuevo.setCorreoElectronico(correo);
			CatEstatus catEstatus = new CatEstatus();
			catEstatus.setIdEstatus(idEstatus);
			usuarioNuevo.setCatEstatus(catEstatus);
			usuarioNuevo.setFechaAlta(new Date());
			usuarioNuevo.setUsuario2(getNameUser());

			usuarioServicio.saveUsuario(usuarioNuevo);
			usuarioNuevo = usuarioServicio.getUsuario(idUsuario);
			commonResponse.setUsuario(usuarioNuevo);

		} catch (Exception e) {
			// TODO: handle exception

			LOG.error("Error al insertar  usuario: " + e);
			commonResponse.setEstatus(-3);
			commonResponse.setDescripcion("Se genero un error al guardar la información.");
			return new ResponseEntity<>(commonResponse, HttpStatus.OK);
		}

		commonResponse.setEstatus(1);
		commonResponse.setDescripcion("La información se guardo correctamente.");
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}

	/* Editar estatus usuario */
	@RequestMapping(value = "/acciones/eliminar-usuario", method = RequestMethod.GET)
	public ResponseEntity<CommonResponse> editarUsuario(@RequestParam("idUsuario") String idUsuario

	) {

		CommonResponse commonResponse = new CommonResponse();
		try {

			if (idUsuario.trim().equals("") || idUsuario.isEmpty()) {
				commonResponse.setEstatus(-1);
				commonResponse.setDescripcion("La información no pudo ser procesada, por favor intente nuevamente.");
				return new ResponseEntity<>(commonResponse, HttpStatus.OK);
			}

			Usuario usuarioActualizar = usuarioServicio.getUsuario(idUsuario);

			if (usuarioActualizar == null) {
				commonResponse.setEstatus(-1);
				commonResponse.setDescripcion("La operación no se pudo realizar, por favor intente nuevamente.");
				return new ResponseEntity<>(commonResponse, HttpStatus.OK);
			}

			CatEstatus catEstatus = new CatEstatus();
			catEstatus.setIdEstatus(2);
			usuarioActualizar.setCatEstatus(catEstatus);
			usuarioServicio.saveUsuario(usuarioActualizar);

		} catch (Exception e) {
			// TODO: handle exception

			commonResponse.setEstatus(-3);
			commonResponse.setDescripcion("Se genero un error al guardar la informacion.");
			return new ResponseEntity<>(commonResponse, HttpStatus.OK);
		}

		commonResponse.setEstatus(1);
		commonResponse.setDescripcion("La informacion se guardo correctamente.");
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}

	/* Editar estatus usuario */
	@RequestMapping(value = "/acciones/eliminar-comunicado", method = RequestMethod.GET)
	public ResponseEntity<CommonResponse> editarComunicado(@RequestParam("idComunicado") String idComunicado

	) {
        
		CommonResponse commonResponse = new CommonResponse();
		try {

			if (idComunicado.trim().equals("") || idComunicado.isEmpty()) {
				commonResponse.setEstatus(-1);
				commonResponse.setDescripcion("La información no pudo ser procesada, por favor intente nuevamente.");
				return new ResponseEntity<>(commonResponse, HttpStatus.OK);
			}

			Comunicado comunicado = comunicadoServicio.getComunicado(Integer.parseInt(idComunicado));

			if (comunicado == null) {
				commonResponse.setEstatus(-1);
				commonResponse.setDescripcion("La operación no se pudo realizar, por favor intente nuevamente.");
				return new ResponseEntity<>(commonResponse, HttpStatus.OK);
			}

			CatEstatus catEstatus = new CatEstatus();
			//catEstatus.setIdEstatus(3);
			catEstatus.setIdEstatus(2);
			comunicado.setCatEstatus(catEstatus);
			comunicadoServicio.saveComunicado(comunicado);

		} catch (Exception e) {
			// TODO: handle exception
           LOG.error("Error en editar comunicados : "+e);
           System.out.println("Error en editar comunicados : "+e);
			commonResponse.setEstatus(-3);
			commonResponse.setDescripcion("Se genero un error al guardar la informacion.");
			return new ResponseEntity<>(commonResponse, HttpStatus.OK);
		}

		commonResponse.setEstatus(1);
		commonResponse.setDescripcion("La informacion se guardo correctamente.");
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}

	/* Guardar comunicado */
	@RequestMapping(value = "/acciones/guardar-comunicado", method = RequestMethod.POST)
	public ResponseEntity<CommonResponse> guardarComunicado(

			@RequestParam("idTipoComunicado") int idTipoComunicado, @RequestParam("imagen") MultipartFile imagen,
			@RequestParam("titulo") String titulo, @RequestParam("url") String url,
			@RequestParam("idEstatus") int idEstatus, @RequestParam("descripcion") String descripcion

	) {

		ComunicadosDto commonResponse = new ComunicadosDto();
		try {

			if (titulo.trim().equals("") || imagen.isEmpty()) {
				commonResponse.setEstatus(-1);
				commonResponse.setDescripcion("La información no pudo ser procesada, por favor intente nuevamente.");
				return new ResponseEntity<>(commonResponse, HttpStatus.OK);
			}

			Comunicado comunicado = new Comunicado();
			comunicado.setTitulo(titulo);
			comunicado.setFechaCarga(new Date());
			comunicado.setDescripcion(descripcion);
			comunicado.setUrl(url);
			comunicado.setImagen(imagen.getBytes());
			CatTipoComunicado catTipoComunicado = new CatTipoComunicado();
			catTipoComunicado.setIdTipoComunicado(idTipoComunicado);
			comunicado.setCatTipoComunicado(catTipoComunicado);
			CatEstatus catEstatus = new CatEstatus();
			catEstatus.setIdEstatus(idEstatus);
			comunicado.setCatEstatus(catEstatus);
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(getNameUser());
			comunicado.setUsuario(usuario);
			comunicadoServicio.saveComunicado(comunicado);

		} catch (Exception e) {
			// TODO: handle exception

			commonResponse.setEstatus(-3);
			commonResponse.setDescripcion("Se genero un error al guardar la informacion.");
			return new ResponseEntity<>(commonResponse, HttpStatus.OK);
		}

		commonResponse.setEstatus(1);
		commonResponse.setDescripcion("La informacion se guardo correctamente.");
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}

	/* Guardar comunicado */
	@RequestMapping(value = "/acciones/editar-comunicado", method = RequestMethod.POST)
	public ResponseEntity<CommonResponse> editaromunicado(

			@RequestParam("idComunicado") int idComunicado, @RequestParam("idTipoComunicadoE") int idTipoComunicado,
			@RequestParam("imagenE") MultipartFile imagen, @RequestParam("tituloE") String titulo,
			@RequestParam("urlE") String url, @RequestParam("idEstatusE") int idEstatus,
			@RequestParam("descripcionE") String descripcion

	) {

		ComunicadosDto commonResponse = new ComunicadosDto();
		try {

			Comunicado comunicado = comunicadoServicio.getComunicado(idComunicado);

			if (comunicado == null) {
				commonResponse.setEstatus(-1);
				commonResponse.setDescripcion("Error al editar el usuario, por favor de intentar nuevamente.");
				return new ResponseEntity<>(commonResponse, HttpStatus.OK);
			}

			comunicado.setTitulo(titulo);
			// comunicado.setFecha(new Date());
			comunicado.setDescripcion(descripcion);
			comunicado.setUrl(url);
			comunicado.setImagen(imagen.getBytes());
			CatTipoComunicado catTipoComunicado = new CatTipoComunicado();
			catTipoComunicado.setIdTipoComunicado(idTipoComunicado);
			comunicado.setCatTipoComunicado(catTipoComunicado);
			CatEstatus catEstatus = new CatEstatus();
			catEstatus.setIdEstatus(idEstatus);
			comunicado.setCatEstatus(catEstatus);
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(getNameUser());
			comunicado.setUsuario(usuario);
			comunicadoServicio.saveComunicado(comunicado);

		} catch (Exception e) {
			// TODO: handle exception

			commonResponse.setEstatus(-3);
			commonResponse.setDescripcion("Se genero un error al guardar la informacion.");
			return new ResponseEntity<>(commonResponse, HttpStatus.OK);
		}

		commonResponse.setEstatus(1);
		commonResponse.setDescripcion("La informacion se guardo correctamente.");
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}

	/* Obtiene el registros del catalogo */
	@RequestMapping(value = "/acciones/obtener-catalogobd", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<UsuarioDto> obtenerUsuario(@RequestParam("idUsuario") String idUsuario)
			throws ResourceNotFoundException {

		UsuarioDto response = new UsuarioDto();
		Usuario usuario = new Usuario();
		try {

			if (idUsuario.isEmpty() || idUsuario.trim().equals("")) {
				response.setEstatus(-1);
				response.setDescripcion("La informacion seleccionada es invalida.");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

			usuario = usuarioServicio.getUsuario(idUsuario);

			if (usuario == null || usuario.equals(null)) {
				response.setEstatus(1);
				response.setDescripcion("No se encontraron registros.");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

			response.setCatArea(usuario.getCatArea());
			response.setIdDireccion(usuario.getCatDireccion().getIdDireccion());
			response.setIdPuesto(usuario.getCatPuesto().getIdPuesto());

			response.setEstatus(1);
			response.setDescripcion("OK");

		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("Error en obtenerUsuario : " + e);
			response.setEstatus(-3);
			response.setDescripcion("Se genero un error en obtener Usuario.");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	private String getNameUser() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return currentPrincipalName;
	}
	
	@RequestMapping(value = "/acciones/refrescar-comunicado", method = RequestMethod.GET)
	public ResponseEntity<CommonResponse> refrescarComunicado() {
		CommonResponseElement< List <Comunicado> > commonResponse = new CommonResponseElement< List<Comunicado> >();
		try {
			List <Comunicado> comunicados= comunicadoServicio.getComunicados();
			commonResponse.setElemento(comunicados);

		} catch (Exception e) {
			// TODO: handle exception

			commonResponse.setEstatus(-3);
			commonResponse.setDescripcion("Se genero un error al consultar la informacion.");
			return new ResponseEntity<>(commonResponse, HttpStatus.OK);
		}

		commonResponse.setEstatus(1);
		commonResponse.setDescripcion("La informacion se consulto correctamente.");
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/acciones/refrescar-usuario", method = RequestMethod.GET)
	public ResponseEntity<CommonResponse> refrescarUsuario() {
		CommonResponseElement< List <Usuario> > commonResponse = new CommonResponseElement< List<Usuario> >();
		try {
			List <Usuario> usuarios= usuarioServicio.getUsuarios();
			commonResponse.setElemento(usuarios);

		} catch (Exception e) {
			// TODO: handle exception

			commonResponse.setEstatus(-3);
			commonResponse.setDescripcion("Se genero un error al consultar la informacion.");
			return new ResponseEntity<>(commonResponse, HttpStatus.OK);
		}

		commonResponse.setEstatus(1);
		commonResponse.setDescripcion("La informacion se consulto correctamente.");
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}
}
