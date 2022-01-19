package mx.gob.cbpeh.bpd.dto;

import java.util.List;
public class CommonResponseListElement<E> extends CommonResponse  {
	
	private List<E> elementos;	

	public CommonResponseListElement() {
	}

	public List<E> getElementos() {
		return elementos;
	}

	public void setElementos(List<E> elementos) {
		this.elementos = elementos;
	}
	

}
