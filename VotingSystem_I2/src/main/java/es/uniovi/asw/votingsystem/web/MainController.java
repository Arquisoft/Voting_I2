package es.uniovi.asw.votingsystem.web;

import es.uniovi.asw.votingsystem.model.Vote;
import es.uniovi.asw.votingsystem.service.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private VoteRepository voteRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String landing(Model model) {
        List<String> options = new ArrayList<String>();
        options.add("PP");
        options.add("PSOE");
        options.add("CIUDADANOS");
        options.add("PODEMOS");
        model.addAttribute("options", options);
        return "landing";
    }

    @RequestMapping(value = "/vote/{option}", method = RequestMethod.GET)
    public String vote(@PathVariable(value="option") String option,
                       Model model) {
        voteRepository.save(new Vote(option));
        model.addAttribute("option", option);
        return "vote";
    }

}