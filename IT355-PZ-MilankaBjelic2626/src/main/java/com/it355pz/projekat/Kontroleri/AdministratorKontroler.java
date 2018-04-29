package com.it355pz.projekat.Kontroleri;


import com.it355pz.projekat.Modeli.Kupac;
import com.it355pz.projekat.Modeli.Porudzbina;
import com.it355pz.projekat.Modeli.Proizvod;
import com.it355pz.projekat.Servisi.KupacServis;
import com.it355pz.projekat.Servisi.PorudzbinaServis;
import com.it355pz.projekat.Servisi.ProizvodServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/administrator")
public class AdministratorKontroler {

    @RequestMapping
    public String stranicaAdmin() {
        return "administratorMain";
    }

    @Value("${spring.slike.lokacija}")
    private String lokacijaSlika;

    @Value("${spring.slike.brisanje.lokacija}")
    private String lokacijaBrisanje;

    @Autowired
    private ProizvodServis proizvodServis;

    @Autowired
    private PorudzbinaServis porudzbinaServis;

    @Autowired
    private KupacServis kupacServis;

    private Path putanja;

    @Autowired
    private org.springframework.core.env.Environment environment;

    @RequestMapping("/dodajProizvod")
    public ModelAndView dodajProizvod(ModelMap model, Proizvod proizvod) {
        model.addAttribute("proizvod", new Proizvod());

        return new ModelAndView("dodajProizvod", "command", new Proizvod());
    }

    @RequestMapping(value = "/dodajProizvod", method = RequestMethod.POST)
    public ModelAndView dodajProizvod(@ModelAttribute("proizvod") Proizvod proizvod, ModelAndView model, @RequestParam("file") MultipartFile file,
                                      HttpServletResponse response) throws Exception {

        try {
            String filename = file.getOriginalFilename();
            String putanja = Paths.get(lokacijaSlika, filename).toString();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(putanja)));
            stream.write(file.getBytes());
            stream.close();
        } catch (IOException e){
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        proizvod.setProizvodSlika("/Slike/" + file.getOriginalFilename());
        model.addObject("object", proizvod);
        proizvod.setProizvodId(proizvodServis.prebrojProizvode() + 1);
        proizvodServis.dodajProizvod(proizvod);
        model.setViewName("redirect:/administrator/prikazProizvodaAdmin");
        return model;

    }

    @RequestMapping("/proizvod/izmeniProizvod/{id}")
    public String izmeniProizvod(@PathVariable("id") int id, Model model){
        Proizvod proizvod = proizvodServis.getProizvodById(id);
        model.addAttribute("proizvod", proizvod);
        return "izmenaProizvoda";
    }
    @RequestMapping(value = "/proizvod/izmeniProizvod", method = RequestMethod.POST)
    public String izmeniProizvodPost(@Valid @ModelAttribute("proizvod") Proizvod proizvod, BindingResult rezultat, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (rezultat.hasErrors()) {
            return "izmenaProizvoda";
        }
        //if (product.getSlika() != "/images/" + file.getOriginalFilename()) {
        try {
            String nazivFajla = file.getOriginalFilename();
            String putanja = Paths.get(lokacijaSlika, nazivFajla).toString();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(putanja)));
            stream.write(file.getBytes());
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // }
        proizvod.setProizvodSlika("/Slike/" + file.getOriginalFilename());
        proizvodServis.izmeniProizvod(proizvod);
        return "redirect:/administrator/prikazProizvodaAdmin";
    }
    @RequestMapping("/proizvod/obrisiProizvod/{id}")
    public String obrisiProizvod(@PathVariable int id, Model model, HttpServletRequest request) {
        Proizvod proizvod = proizvodServis.getProizvodById(id);

        String nazivfajla = proizvod.getProizvodSlika();
        putanja = Paths.get(lokacijaBrisanje + nazivfajla);
        if (Files.exists(putanja)) {
            try {
                Files.delete(putanja);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        proizvodServis.obrisiProizvod(proizvod);



        return "redirect:/administrator/prikazProizvodaAdmin";
    }

    @RequestMapping("/prikazProizvodaAdmin")
    public String proizvodPrikaz(Model model) {
        List<Proizvod> proizvodi = proizvodServis.getProizvodi();
        model.addAttribute("proizvodi", proizvodi);

        return "prikazProizvodaAdmin";
    }

    @RequestMapping("/listaKupaca")
    public String upravljanjeKupcima(Model model) {

        List<Kupac> listaKupaca = kupacServis.getKupci();
        model.addAttribute("listaKupaca", listaKupaca);

        return "listaKupaca";
    }

    @RequestMapping("/listaPorudzbina")
    public String upravljanjePorudzbinama(Model model) {

        List<Porudzbina> listaPorudzbina = porudzbinaServis.getPorudzbine();
        model.addAttribute("listaPorudzbina", listaPorudzbina);

        return "listaPorudzbina";
    }
}
