package es.uniovi.asw.resultsdb.business.impl;

import es.uniovi.asw.resultsdb.business.exception.BusinessException;

public interface Command<T> {
    T execute() throws BusinessException;
}
