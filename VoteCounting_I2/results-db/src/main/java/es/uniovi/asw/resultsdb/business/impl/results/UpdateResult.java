package es.uniovi.asw.resultsdb.business.impl.results;

import es.uniovi.asw.resultsdb.business.exception.BusinessException;
import es.uniovi.asw.resultsdb.business.impl.Command;
import es.uniovi.asw.resultsdb.domain.Results;
import es.uniovi.asw.resultsdb.persistence.util.Jpa;

public class UpdateResult implements Command<Results> {

	private Results result;

	public UpdateResult(Results result) {
		this.result = result;
	}
	
	@Override
	public Results execute() throws BusinessException {
		return Jpa.getManager().merge(result);
	}

}
