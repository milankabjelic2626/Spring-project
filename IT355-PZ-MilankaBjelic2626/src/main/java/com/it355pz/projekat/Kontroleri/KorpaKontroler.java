package com.it355pz.projekat.Kontroleri;

import com.it355pz.projekat.Modeli.Porudzbina;
import com.it355pz.projekat.Modeli.PorudzbinaDetalji;
import com.it355pz.projekat.Modeli.ProizvodKorpa;
import com.it355pz.projekat.Servisi.KupacServis;
import com.it355pz.projekat.Servisi.PorudzbinaDetaljiServis;
import com.it355pz.projekat.Servisi.PorudzbinaServis;
import com.it355pz.projekat.Servisi.ProizvodServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/kupac/korpa")
public class KorpaKontroler
{
    @Autowired
    private ProizvodServis proizvodServis;

    @Autowired
    private KupacServis kupacServis;

    @Autowired
    private PorudzbinaServis porudzbinaServis;

    @Autowired
    private PorudzbinaDetaljiServis porudzbinaDetaljiServis;

    @RequestMapping(method = RequestMethod.GET)
    public String korpa(ModelMap model) {
        model.put("naslov", "Korpa");
        model.put("akcija", "korpa");
        return "korpa";

    }

    @RequestMapping(value = "/kupi/{id}", method = RequestMethod.GET)
    public String kupi(@PathVariable("id") int id, HttpSession session, ModelMap model) {
        model.put("naslov", "Korpa");
        if (session.getAttribute("korpa") == null) {
            List<ProizvodKorpa> korpa = new ArrayList<ProizvodKorpa>();
            korpa.add(new ProizvodKorpa(proizvodServis.getProizvodById(id), 1));
            session.setAttribute("korpa", korpa);

        } else {
            List<ProizvodKorpa> korpa = (List<ProizvodKorpa>) session.getAttribute("korpa");
            int index = postojiUKorpi(id, session);
            if (index == -1) {
                korpa.add(new ProizvodKorpa(proizvodServis.getProizvodById(id), 1));
            } else {
                int kolicinaUKorpi = korpa.get(index).getKolicinaUKorpi() + 1;
                korpa.get(index).setKolicinaUKorpi(kolicinaUKorpi);
                session.setAttribute("korpa", korpa);
            }
            double ukupno = 0.0;

            for (int i = 0; i < korpa.size(); i++){
                
            }


        }
        return "korpa";
    }

    private int postojiUKorpi(int id, HttpSession session) {
        List<ProizvodKorpa> korpa = (List<ProizvodKorpa>) session.getAttribute("korpa");
        for (int i = 0; i < korpa.size(); i++) {
            if (korpa.get(i).getProizvodKorpa().getProizvodId() == id) {
                return i;
            }

        }
        return -1;
    }

    @RequestMapping(value = "/ukloni/{index}", method = RequestMethod.GET)
    public String ukloni(@PathVariable("index") int index, HttpSession session) {
        List<ProizvodKorpa> korpa = (List<ProizvodKorpa>) session.getAttribute("korpa");
        korpa.remove(index);
        return "redirect:/kupac/korpa";
    }

    @RequestMapping(value = "/potvrdaPorudzbine", method = RequestMethod.GET)
    public String potvrdaPorudzbine(HttpSession session, ModelMap model, Principal principal) {
        model.put("naslov", "Korpa");

        if (session.getAttribute("korpa") == null) {
            model.addAttribute("error", "Please insert products to cart");
            return "korpa";
        } else {
            Porudzbina porudzbina = new Porudzbina();
            porudzbina.setKorisnickoIme(principal.getName());
            porudzbina.setDatum(new Date());


            Porudzbina novaPorudzbina = porudzbinaServis.novaPorudzbina(porudzbina);
            List<ProizvodKorpa> korpa = (List<ProizvodKorpa>) session.getAttribute("korpa");
            for(ProizvodKorpa pr : korpa){
                PorudzbinaDetalji porudzbinaDetalji = new PorudzbinaDetalji();
                porudzbinaDetalji.setProizvodId(pr.getProizvodKorpa().getProizvodId());
                porudzbinaDetalji.setPorudzbinaId(novaPorudzbina.getPorudzbinaId());
                porudzbinaDetalji.setCena(pr.getProizvodKorpa().getProizvodCena());
                porudzbinaDetalji.setKolicina(pr.getKolicinaUKorpi());
                porudzbinaDetaljiServis.novaPorudzbinaDetalji(porudzbinaDetalji);
            }

            session.removeAttribute("korpa");

            return "uspesnaKupovina";
        }

    }
}

