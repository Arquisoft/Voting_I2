package es.uniovi.asw.votingdb.business.impl;

import es.uniovi.asw.votingdb.business.exception.BusinessException;

public interface Command<T> {
    T execute() throws BusinessException;
}
