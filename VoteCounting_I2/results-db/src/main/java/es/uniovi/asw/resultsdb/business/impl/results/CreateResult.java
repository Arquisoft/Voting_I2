package es.uniovi.asw.resultsdb.business.impl.results;

import es.uniovi.asw.resultsdb.business.exception.BusinessException;
import es.uniovi.asw.resultsdb.business.impl.Command;
import es.uniovi.asw.resultsdb.domain.Results;
import es.uniovi.asw.resultsdb.persistence.util.Jpa;

public class CreateResult implements Command<Results> {
	
	private String name;
	private String comment;
	private int votos;

	public CreateResult(String name, String comment) {
		this.name = name;
		this.comment = comment;
		this.votos = 0;
	}
	
	public CreateResult(String name, String comment, int votos) {
		this.name = name;
		this.comment = comment;
		this.votos = votos;
	}
	
	@Override
	public Results execute() throws BusinessException {
		Results r = new Results(name, comment,votos);
		Jpa.getManager().persist(r);
		return r;
	}

}
