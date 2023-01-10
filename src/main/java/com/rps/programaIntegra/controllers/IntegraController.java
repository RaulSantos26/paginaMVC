package com.rps.programaIntegra.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntegraController {

    @GetMapping("/")
    public String site (){

        return "index";
    }
    @GetMapping("/docpreview")
    public String docPreview (){

        return "docpreview";
    }
}
