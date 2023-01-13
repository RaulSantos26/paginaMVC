package com.rps.programaIntegra.controllers;

import com.rps.programaIntegra.dto.DadosResgateDTO;
import com.rps.programaIntegra.dto.PesquisaDTO;
import com.rps.programaIntegra.entities.TipoPessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class IntegraController {


//    @GetMapping("/")
//    public String site (){
//
//        return "index";
//    }

    @GetMapping("/")
    public ModelAndView site (){
        PesquisaDTO dto = new PesquisaDTO();
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("pesquisa", dto);
        mv.addObject("tipoPessoa", TipoPessoa.values());
        mv.addObject("hide",1);
        return mv;
    }



    @PostMapping("/")
    public ModelAndView pesquisa(PesquisaDTO dto){
        List<PesquisaDTO> list = new ArrayList();
        try {
            list.add(dto);
            ModelAndView mv = new ModelAndView("index");
            mv.addObject("hide",0);
            mv.addObject("aof",list);
            mv.addObject("tipoPessoa", TipoPessoa.values());
            System.out.println("$$$$ " + dto.getContaJudicial() + "$$$$");

            return mv;
        } catch (NoSuchElementException e) {
            System.out.println("$$$$$$ NÃO ACHOU O PRODUTO DE ID ");
            return new ModelAndView("redirect:/");

        }
    }



    @GetMapping("/docpreview")
    public String docPreview (){

        return "docpreview";
    }
}
