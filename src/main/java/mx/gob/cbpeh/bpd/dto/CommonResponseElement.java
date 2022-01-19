package mx.gob.cbpeh.bpd.dto;


public class CommonResponseElement<E> extends CommonResponse {
	
	private E elemento;

	public E getElemento() {
		return elemento;
	}

	public void setElemento(E elemento) {
		this.elemento = elemento;
	}


}
