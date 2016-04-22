package es.uniovi.asw.results.model;

import es.uniovi.asw.results.service.exceptions.PartieNotFoundException;
import es.uniovi.asw.resultsdb.business.ResultsService;
import es.uniovi.asw.resultsdb.domain.Results;
import es.uniovi.asw.resultsdb.infrastructure.ServicesFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrea on 19/04/2016.
 */
public class CurrentResults {

    private List<Results> parties;
    private long totalNumberOfVotes;
    private ResultsService resultService= ServicesFactory.createResultsService();

    public CurrentResults(){
        parties= resultService.getAllResults();
        totalNumberOfVotes=_getTotalNumberOfVotes();

    }

    public CurrentResults(List<Results> parties){
        this.parties=parties;
        totalNumberOfVotes=_getTotalNumberOfVotes();
    }

    public long getResultsOfPartie(String partieName){
        for (Results p: parties)
        {
            if(p.getName().equals(partieName))
                return p.getVotos();
        }
        throw new PartieNotFoundException();
    }

    public long getTotalNumberOfVotes(){
        return totalNumberOfVotes;
    }

    private long _getTotalNumberOfVotes(){
        long total = 0;
        for (Results p: parties) {
            total+=p.getVotos();
        }

        return total;
    }

    private List<Results> update(){
        totalNumberOfVotes=_getTotalNumberOfVotes();
        return parties=resultService.getAllResults();
    }

    public long getVotesOfPartie(String partyName){
        for (Results partie : parties){
            if (partie.getName().equals(partyName)) return partie.getVotos();
        } return 0;
    }

    public List<Results> getParties() {
        return parties;
    }

    public void setParties(List<Results> parties) {
        this.parties = parties;
    }

    public Map<String, Integer> getResults() {
        Map<String, Integer> results = new HashMap<String, Integer>();
        for (Results result : parties) {
            results.put(result.getName(), result.getVotos());
        }
        return results;
    }
}
