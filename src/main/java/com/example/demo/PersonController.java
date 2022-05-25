package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class PersonController {
    @Resource
    private PersonRepository personRepo;
    @Resource
    private IdCardRepository idRepo;

    @RequestMapping("")
    public String greetingForm(Model model){
        model.addAttribute("person",new Person());
        return "greeting";
    }

    @PostMapping("/person")
    public String addPerson(Model model, @RequestParam String perName,@RequestParam int perAge,@RequestParam String perJob){
        IdCard x = new IdCard(perJob);
        idRepo.save(x);
        Person y = new Person(perName,perAge,x);
        personRepo.save(y);

        model.addAttribute("people",personRepo.findAll());
        return "result";
    }


}
