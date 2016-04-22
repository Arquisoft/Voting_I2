package es.uniovi.asw.resultsdb.business.exception;

public class DatabaseFailException extends BusinessException{
	private static final long serialVersionUID = -2038842463964760660L;
	public DatabaseFailException(Throwable cause) {
		super(cause);
	}
}
