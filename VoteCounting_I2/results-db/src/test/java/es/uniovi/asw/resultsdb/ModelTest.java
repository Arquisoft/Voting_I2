package es.uniovi.asw.resultsdb;

import org.junit.Test;

import es.uniovi.asw.resultsdb.business.ResultsService;
import es.uniovi.asw.resultsdb.business.exception.BusinessException;
import es.uniovi.asw.resultsdb.business.exception.ResultsNotFoundException;
import es.uniovi.asw.resultsdb.business.impl.Command;
import es.uniovi.asw.resultsdb.business.impl.CommandExecutor;
import es.uniovi.asw.resultsdb.domain.Results;
import es.uniovi.asw.resultsdb.infrastructure.ServicesFactory;
import es.uniovi.asw.resultsdb.persistence.util.Jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.junit.After;

public class ModelTest {
	
	private ResultsService resServ = ServicesFactory.createResultsService();
	
    @Test
    public void testCreateEntry() {
    	Results opcionA = resServ.createResultEntry("opcionA", "A");
    	Results opcionB = resServ.createResultEntry("opcionB", "B",42);
    	
    	Results myOpcionA = new Results("opcionA","A");
    	Results myOpcionB = new Results("opcionB","B",42);
    	
    	assertEquals(opcionA.getName(),myOpcionA.getName());
    	assertEquals(opcionA.getComment(),myOpcionA.getComment());
    	assertEquals(opcionA.getVotos(), myOpcionA.getVotos());
    	
    	assertEquals(opcionB.getName(),myOpcionB.getName());
    	assertEquals(opcionB.getComment(),myOpcionB.getComment());
    	assertEquals(opcionB.getVotos(), myOpcionB.getVotos());
    }
    
    @Test
    public void testUpdateEntry(){
    	Results opcionA = resServ.createResultEntry("opcionA", "A");
    	
    	opcionA.setComment("0");
    	opcionA.setName("opcion0");
    	opcionA.addVote();
    	opcionA.addVote();
    	opcionA.removeVote();
    	opcionA.setVotos(22);
    	
    	Results opcion0 = resServ.updateResultEntry(opcionA);
    	
    	assertEquals(opcionA.getName(),opcion0.getName());
    	assertEquals(opcionA.getComment(),opcion0.getComment());
    	assertEquals(opcionA.getVotos(), opcion0.getVotos());
    	opcionA.equals(opcion0);
    }
    
    @Test
    public void testGetAllResults(){
    	
    	String[] grupos = {"NMK Pro","BNM Pro","KRI Pro","SAI Pro"};
    	String[] codigos = {"765","876","961","361"};
    	
    	Results opcionA = resServ.createResultEntry(grupos[0],codigos[0]);
    	Results opcionB = resServ.createResultEntry(grupos[1],codigos[1]);
    	Results opcionC = resServ.createResultEntry(grupos[2],codigos[2]);
    	Results opcionD = resServ.createResultEntry(grupos[3],codigos[3]);
    	
    	List<Results> inDB = new ArrayList<Results>();
    	inDB.add(opcionA);
    	inDB.add(opcionB);
    	inDB.add(opcionC);
    	inDB.add(opcionD);
    	
    	List<Results> results = resServ.getAllResults();
    	
    	assertNotNull(results);
    	assertEquals(results.size(),4);
    	
    	for (int i = 0; i < codigos.length; i++) {
			assertEquals(results.get(i).getName(), grupos[i]);
			assertEquals(results.get(i).getComment(), codigos[i]);
			assertEquals(results.get(i).getVotos(), 0);
			assertEquals(inDB.get(i), results.get(i));
		}
    }
    
    @Test
    public void testGetResultByName(){
    	String[] grupos = {"Acceleration","Alice or Guilty","Nostalgia","Starting Line"};
    	String[] codigos = {"Leon","Jupiter","Miki","Beit"};
    	int[] votos = {100,961,69,9001};
    	
    	Results opcionA = resServ.createResultEntry(grupos[0],codigos[0],votos[0]);
    	Results opcionB = resServ.createResultEntry(grupos[1],codigos[1],votos[1]);
    	Results opcionC = resServ.createResultEntry(grupos[2],codigos[2],votos[2]);
    	Results opcionD = resServ.createResultEntry(grupos[3],codigos[3],votos[3]);
    	
    	List<Results> inDB = new ArrayList<Results>();
    	inDB.add(opcionA);
    	inDB.add(opcionB);
    	inDB.add(opcionC);
    	inDB.add(opcionD);
    	
    	for (int i = 0; i < votos.length; i++) {
			Results out = resServ.getResultByName(grupos[i]);
			assertEquals(out.getName(), grupos[i]);
			assertEquals(out.getComment(), codigos[i]);
			assertEquals(out.getVotos(), votos[i]);
			assertEquals(inDB.get(i), out);
		}
    }
    
    @Test
    public void testRemoveEntry(){
    	String[] grupos = {"NMK Pro","BNM Pro","KRI Pro","SAI Pro","CGZ Pro"};
    	String[] codigos = {"765","876","961","361", "346"};
    	
    	Results opcionA = resServ.createResultEntry(grupos[0],codigos[0]);
    	Results opcionB = resServ.createResultEntry(grupos[1],codigos[1]);
    	Results opcionC = resServ.createResultEntry(grupos[2],codigos[2]);
    	Results opcionD = resServ.createResultEntry(grupos[3],codigos[3]);
    	Results opcionFalsa = resServ.createResultEntry(grupos[4],codigos[4]);
    	
    	List<Results> inDB = new ArrayList<Results>();
    	inDB.add(opcionA);
    	inDB.add(opcionB);
    	inDB.add(opcionC);
    	inDB.add(opcionD);
    	
    	resServ.removeResultEntry(opcionFalsa); //serves you right ha ha
    	
    	List<Results> results = resServ.getAllResults();
    	
    	assertNotNull(results);
    	assertEquals(results.size(),4);
    	
    	assertFalse(results.contains(opcionFalsa)); // what a life would be
    	
    	for (int i = 0; i < codigos.length - 1; i++) {
			assertEquals(results.get(i).getName(), grupos[i]);
			assertEquals(results.get(i).getComment(), codigos[i]);
			assertEquals(results.get(i).getVotos(), 0);
			assertEquals(inDB.get(i), results.get(i));
		}
    }
    
    @Test(expected=ResultsNotFoundException.class)
    public void testNoResult(){
    	resServ.getResultByName("Can't wake up");
    }
    
    @After
    public void cleanUp(){
    	CommandExecutor.execute(new Command<Results>() {
			@Override
			public Results execute() throws BusinessException {
				Query query = Jpa.getManager().createNativeQuery("DELETE FROM Results");
				query.executeUpdate();
				return null;
			}
		});
    }
}
