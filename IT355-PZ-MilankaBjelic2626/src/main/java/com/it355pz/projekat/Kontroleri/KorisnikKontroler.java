package com.it355pz.projekat.Kontroleri;

import com.it355pz.projekat.Modeli.Kupac;
import com.it355pz.projekat.Servisi.KupacServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class KorisnikKontroler
{

    @Autowired
    private KupacServis kupacServis;

    @RequestMapping("/registracija")
    public String registracija(Model model){
        Kupac kupac = new Kupac();
        model.addAttribute("kupac", kupac);

        return "registracija";
    }

    @RequestMapping(value = "/registracija", method = RequestMethod.POST)
    public String registracijaPost(@Valid @ModelAttribute("kupac") Kupac kupac, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            return "registracija";
        }
        List<Kupac> listaKupaca = kupacServis.getKupci();

        for (int i = 0; i < listaKupaca.size(); i++) {
            if (kupac.getKupacEmail().equals(listaKupaca.get(i).getKupacEmail())) {
                model.addAttribute("emailMsg", "Email already exists");

                return "registracija";
            }

            if (kupac.getKorisnickoIme().equals(listaKupaca.get(i).getKorisnickoIme())) {
                model.addAttribute("usernameMsg", "Username already exists");

                return "registracija";
            }
        }
        kupac.setEnabled(true);
        kupacServis.registracijaKupac(kupac);
        return "uspesnoRegistrovanje";
    }
}
