package com.rps.programaIntegra.controllers;

import com.rps.programaIntegra.dto.DadosResgateDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class DadosResgateController {

    @PostMapping("regaste")
    public String resgate(@ModelAttribute DadosResgateDTO dto){
//        List<DadosResgateDTO> list = new ArrayList();
        try {
            System.out.println("&&&& " + dto + " &&&&");
//            list.add(dto);
            return "index";
        } catch (NoSuchElementException e) {
            System.out.println("$$$$$$ NÃO ACHOU O PRODUTO DE ID ");
            return "Erro";

        }
    }


}

