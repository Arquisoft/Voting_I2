package es.uniovi.asw.resultsdb.infrastructure;

import es.uniovi.asw.resultsdb.business.ResultsService;
import es.uniovi.asw.resultsdb.business.impl.ResultsServiceImpl;

public class ServicesFactory {

    public static ResultsService createResultsService() {
        return new ResultsServiceImpl();
    }
}
