package es.uniovi.asw.resultsdb.business.impl.results;

import es.uniovi.asw.resultsdb.business.exception.BusinessException;
import es.uniovi.asw.resultsdb.business.impl.Command;
import es.uniovi.asw.resultsdb.domain.Results;
import es.uniovi.asw.resultsdb.persistence.util.Jpa;

public class RemoveResult implements Command<Results> {

	private Results result;

	public RemoveResult(Results result) {
		this.result = result;
	}
	
	@Override
	public Results execute() throws BusinessException {
		result = Jpa.getManager().merge(result);
		Jpa.getManager().remove(result);
		return null;
	}

}
