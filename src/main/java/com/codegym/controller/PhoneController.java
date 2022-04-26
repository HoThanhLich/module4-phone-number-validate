package com.codegym.controller;

import com.codegym.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping("/")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("phoneNumber", new PhoneNumber());
        return modelAndView;
    }

    @PostMapping("/")
    public ModelAndView checkValidation (@Valid @ModelAttribute("phoneNumber") PhoneNumber phoneNumber, BindingResult bindingResult) {
        ModelAndView modelAndView;
        new PhoneNumber().validate(phoneNumber,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("index");
        } else {
            modelAndView = new ModelAndView("result");
            modelAndView.addObject("phoneNumber", phoneNumber);
            return modelAndView;
        }
    }
}
