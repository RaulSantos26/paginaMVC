package com.rps.programaIntegra.controllers;

import com.rps.programaIntegra.dto.DadosResgateDTO;
import com.rps.programaIntegra.services.DadosResgateService;
import com.rps.programaIntegra.services.exceptions.DatabaseException;
import com.rps.programaIntegra.services.exceptions.ResourcesNotFoudException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;

@Controller
public class DadosResgateController {

    @Autowired
    private DadosResgateService service;


    @PostMapping("regaste")
    public ModelAndView insert(@ModelAttribute @Valid DadosResgateDTO dto,  BindingResult bindingResult){

            if (bindingResult.hasErrors()) {
                String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
                System.out.println("\n******Tem erros******\n");
                ModelAndView mv = new ModelAndView("index");
                mv.addObject("hide", 1);
                mv.addObject("pesquisa", dto);
                return mv;
            }
            else {
                try {
                    dto = service.insert(dto);

                } catch (ResourcesNotFoudException erro) {
                    String sucesso = "Teve sucesso";
                    ModelAndView mv = new ModelAndView("index");
                    mv.addObject("erro", erro.getMessage());
                    mv.addObject("hide", 0);
                    return mv;


                }
            }
        return null;
    }


}

