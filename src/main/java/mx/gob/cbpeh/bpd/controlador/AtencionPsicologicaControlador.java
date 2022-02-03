package mx.gob.cbpeh.bpd.controlador;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mx.gob.cbpeh.bpd.dto.CommonResponse;
import mx.gob.cbpeh.bpd.modelo.AtencionPsicologica;
import mx.gob.cbpeh.bpd.modelo.Expediente;
import mx.gob.cbpeh.bpd.servicio.AtencionPsicologicaServicio;
import mx.gob.cbpeh.bpd.servicio.ExpedienteServicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(value = "/atencion-psicologica")
public class AtencionPsicologicaControlador {
    private static final Logger log = LoggerFactory.getLogger(AtencionPsicologicaControlador.class);

    @Autowired
    private AtencionPsicologicaServicio atencionPsicologicaServicio;

    @Autowired
    private ExpedienteServicio expedienteServicio;

    @RequestMapping(value = "/guardar", method = RequestMethod.POST, produces = "application/json") // @ResponseBody
    public ResponseEntity<CommonResponse> guardarAtencionPsicologica(
            @RequestParam("nombre") String nombre,
            @RequestParam("parentesco") String parentesco,
            @RequestParam("fecha") String fecha,
            @RequestParam("observaciones") String observaciones,
            @RequestParam("numExpedienteAb") String numExpedienteAb) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setEstatus(-3);
        commonResponse.setDescripcion("Se genero un inconveniente al guardar la informacion.");
        try {
            SimpleDateFormat formatter1 = new SimpleDateFormat("YYYY-MM-DD");
            Date fechaFormateada = formatter1.parse(fecha);
            Expediente expedienteSearched = expedienteServicio.getExpediente(numExpedienteAb);
            AtencionPsicologica atencionPsicologica = new AtencionPsicologica();
            atencionPsicologica.setNombre(nombre);
            atencionPsicologica.setParentesco(parentesco);
            atencionPsicologica.setFecha(fechaFormateada);
            atencionPsicologica.setObservaciones(observaciones);
            atencionPsicologica.setExpediente(expedienteSearched);
            atencionPsicologica = atencionPsicologicaServicio.save(atencionPsicologica);
            if (atencionPsicologica != null && atencionPsicologica.getId() > 0) {// guardo el
                // archivo?
                log.info("Archivo guardado:" + atencionPsicologica.getId());
                commonResponse.setEstatus(1);
                commonResponse.setDescripcion("La informacion se guardo correctamente.");
            }
        } catch (Exception e) {
            log.error("Ocurrio un inconveniente al guardar Atencion Psicologica:" + e.getMessage());
            return new ResponseEntity<>(commonResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

}
