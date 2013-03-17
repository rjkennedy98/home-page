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
@RequestMapping(value="/register")
public class RegisterController {

    @Autowired
    private MemberDao memberDao;

    @RequestMapping(method=RequestMethod.GET)
    public String displaySortedMembers(Model model)
    {
        model.addAttribute("newUser", new AppUser());
        model.addAttribute("users", memberDao.findAll());
        return "register";
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String registerNewMember(@Valid @ModelAttribute("newUser") AppUser newUser, BindingResult result, Model model)
    {
        if (!result.hasErrors()) {
            memberDao.register(newUser);
            model.addAttribute("users", memberDao.findAll());
            return "register";
        }
        else {
            model.addAttribute("users", memberDao.findAll());
            return "register";
        }
    }
}
