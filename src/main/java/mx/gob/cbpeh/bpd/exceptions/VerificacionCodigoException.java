package mx.gob.cbpeh.bpd.exceptions;

	/**
	 * Exception modeling when something went wrong during verifying the code in second step.
	 */
	public class VerificacionCodigoException extends Exception {

	    public VerificacionCodigoException(String message) {
	        super(message);
	    }
	}