package es.uniovi.asw.resultsdb.business.exception;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 4233644321823268598L;

    public BusinessException() {
        super();
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

}
