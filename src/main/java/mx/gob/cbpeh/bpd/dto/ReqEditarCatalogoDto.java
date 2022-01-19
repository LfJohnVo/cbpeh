package mx.gob.cbpeh.bpd.dto;

import java.io.Serializable;

public class ReqEditarCatalogoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idCatalogo;
	private ElementoCatDto dto;
	
	public Integer getIdCatalogo() {
		return idCatalogo;
	}
	public void setIdCatalogo(Integer idCatalogo) {
		this.idCatalogo = idCatalogo;
	}
	public ElementoCatDto getDto() {
		return dto;
	}
	public void setDto(ElementoCatDto dto) {
		this.dto = dto;
	}
}
