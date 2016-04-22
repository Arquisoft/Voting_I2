package es.uniovi.asw.resultsdb.business.impl.results;

import javax.persistence.NoResultException;

import es.uniovi.asw.resultsdb.business.exception.BusinessException;
import es.uniovi.asw.resultsdb.business.exception.ResultsNotFoundException;
import es.uniovi.asw.resultsdb.business.impl.Command;
import es.uniovi.asw.resultsdb.domain.Results;
import es.uniovi.asw.resultsdb.persistence.ResultsFinder;

public class GetResultByName implements Command<Results> {

	private String name;

	public GetResultByName(String name) {
		this.name = name;
	}

	@Override
	public Results execute() throws BusinessException {
		try {
			return ResultsFinder.findByOptionName(name);
		}catch(NoResultException e){
			throw new ResultsNotFoundException();
		}
	}

}
