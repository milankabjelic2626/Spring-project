package com.it355pz.projekat.Kontroleri;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PocetnaKontroler {

    @RequestMapping("/")
    public String pocetna(){
        return "pocetna";
    }

        @RequestMapping("/prijavljivanje")
        public String login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "odjavljivanje", required = false) String odjavljivanje,
                            Model model) {

            if (error != null) {
                model.addAttribute("error", "Pogresno korisnicko ime ili lozinka");
            }

            if (odjavljivanje != null) {
                model.addAttribute("msg", "Uspesno odjavljivanje");
            }

            return "prijavljivanje";
        }

        @RequestMapping("/zabranjenpristup")
        public String errorPg(){
            return "zabranjenpristup";
        }
    }

