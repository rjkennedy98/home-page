package org.jboss.tools.example.springmvc.mvc;

import javax.validation.Valid;

import org.jboss.tools.example.springmvc.domain.AppUser;
import org.jboss.tools.example.springmvc.domain.Member;
import org.jboss.tools.example.springmvc.repo.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/example")
public class ExampleController {
	
    @Autowired
    private MemberDao memberDao;

    @RequestMapping(method=RequestMethod.GET)
    public String displaySortedMembers(Model model)
    {
        model.addAttribute("login", new AppUser());
        model.addAttribute("area1", "This is what I printed");

        return "example";
    }
	
    @RequestMapping(method=RequestMethod.POST)
    public String registerNewMember(@Valid @ModelAttribute("login") AppUser user, BindingResult result, Model model)
    {
        if (!result.hasErrors()) {
            if(memberDao.isRegistered(user.getUsername(), user.getPassword())) {
            	 return "redirect:/";
            } else {
                model.addAttribute("area1", "password is incorrect");        
                model.addAttribute("members", memberDao.findAllOrderedByName());
                model.addAttribute("area2", "password is incorrect");
                return "example";
            }

           
        }
        else {
            model.addAttribute("area1", "Now in else");        
            model.addAttribute("members", memberDao.findAllOrderedByName());
            model.addAttribute("area2", "This is what I printed in Area2");
            return "index";
        }
    }
}
