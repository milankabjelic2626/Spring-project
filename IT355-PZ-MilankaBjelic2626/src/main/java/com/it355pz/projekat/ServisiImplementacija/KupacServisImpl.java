package com.it355pz.projekat.ServisiImplementacija;

import com.it355pz.projekat.DAO.KupacDAO;
import com.it355pz.projekat.Modeli.Kupac;
import com.it355pz.projekat.Servisi.KupacServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KupacServisImpl implements KupacServis{
    @Autowired
    private KupacDAO kupacDAO;

    @Override
    public void registracijaKupac(Kupac kupac) {
        kupacDAO.registracijaKupac(kupac);
    }

    @Override
    public Kupac getKupacById(int kupacId) {
        return kupacDAO.getKupacById(kupacId);
    }

    @Override
    public List<Kupac> getKupci() {
        return kupacDAO.getKupci();
    }
}
