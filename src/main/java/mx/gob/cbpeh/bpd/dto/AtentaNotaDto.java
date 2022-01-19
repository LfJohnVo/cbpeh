package mx.gob.cbpeh.bpd.dto;

import java.util.List;

import mx.gob.cbpeh.bpd.modelo.AtentaNota;

public class AtentaNotaDto extends CommonResponse {
	
	private List<AtentaNota> atentaNota;
	
	public AtentaNotaDto() {
		// TODO Auto-generated constructor stub
	}

	public List<AtentaNota> getAtentaNota() {
		return atentaNota;
	}

	public void setAtentaNota(List<AtentaNota> atentaNota) {
		this.atentaNota = atentaNota;
	}
	
	
	

}
