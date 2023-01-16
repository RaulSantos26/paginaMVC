package com.rps.programaIntegra.controllers;

import com.rps.programaIntegra.dto.DadosResgateDTO;
import com.rps.programaIntegra.services.DadosResgateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.NoSuchElementException;

@Controller
public class DadosResgateController {

    @Autowired
    private DadosResgateService service;


    @PostMapping("regaste")
    public String insert(@ModelAttribute DadosResgateDTO dto){
        try {

            System.out.println("&&&& " + dto + "&&&&\n");
            System.out.println("****" + dto.getFinalidade() + "****");
            dto = service.insert(dto);


//            list.add(dto);
            return "index";
        } catch (NoSuchElementException e) {
            System.out.println("$$$$$$ NÃO ACHOU O PRODUTO DE ID ");
            return "Erro";

        }
    }


}

