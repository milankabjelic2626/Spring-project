package com.it355pz.projekat.Kontroleri;

import com.it355pz.projekat.Modeli.Proizvod;
import com.it355pz.projekat.Servisi.ProizvodServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/proizvod")
public class ProizvodKontroler {

    @Autowired
    private ProizvodServis proizvodServis;

    @RequestMapping("/listaProizvoda/sviProizvodi")
    public String sviProizvodi(Model model) {
        List<Proizvod> proizvodi = proizvodServis.getProizvodi();
        model.addAttribute("proizvodi", proizvodi);

        return "listaProizvoda";
    }

    @RequestMapping("/pregledProizvoda/{proizvodId}")
    public String vidiProizvod(@PathVariable int proizvodId, Model model) throws IOException {
        Proizvod proizvod = proizvodServis.getProizvodById(proizvodId);
        model.addAttribute("proizvod", proizvod);

        return "pregledProizvoda";
    }

    @RequestMapping("/pregledProizvodaKupac/{proizvodId}")
    public String vidiProizvodKupac(@PathVariable int proizvodId, Model model) throws IOException {
        Proizvod proizvod = proizvodServis.getProizvodById(proizvodId);
        model.addAttribute("proizvod", proizvod);

        return "pregledProizvodaKupac";
    }
}