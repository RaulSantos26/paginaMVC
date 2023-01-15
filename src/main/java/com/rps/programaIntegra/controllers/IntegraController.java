package com.rps.programaIntegra.controllers;

import com.rps.programaIntegra.dto.PesquisaDTO;
import com.rps.programaIntegra.entities.TipoPessoa;
import com.rps.programaIntegra.services.FinalidadeService;
import com.rps.programaIntegra.services.PesquisaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;

@Controller
public class IntegraController {

    @Autowired
    private FinalidadeService service;

    @Autowired
    private PesquisaService servicePesquisa;


    @GetMapping("/")
    public ModelAndView site(@Valid PesquisaDTO dto,  BindingResult bindingResult) {
        if (! bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("index");
            mv.addObject("pesquisa", dto);
            mv.addObject("tipoPessoa", TipoPessoa.values());
            mv.addObject("hide", 1);
            return mv;
        }
        return null;
    }


    @PostMapping("/")
    public ModelAndView pesquisa(@Valid PesquisaDTO dto,  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            System.out.println("\n******Tem erros******\n");
            ModelAndView mv = new ModelAndView("index");
            mv.addObject("hide", 1);
            mv.addObject("pesquisa", dto);
            return mv;
        }
        else {

            try {
                PesquisaDTO result = servicePesquisa.findBycontaJudicial(dto.getJudicial());
                System.out.println("####" + result + "####");
                ModelAndView mv = new ModelAndView("index");
                mv.addObject("hide", 0);
                mv.addObject("aof", result);
                mv.addObject("tipoPessoa", TipoPessoa.values());
                mv.addObject("finalidades", service.findAll());
//            System.out.println("$$$$ " + dto.getContaJudicial() + "$$$$");

                return mv;
            } catch (NoSuchElementException e) {
                System.out.println("$$$$$$ NÃO ACHOU O PRODUTO DE ID ");
                return new ModelAndView("redirect:/");

            }
        }
    }


    @GetMapping("/docpreview")
    public String docPreview() {

        return "docpreview";
    }
}
