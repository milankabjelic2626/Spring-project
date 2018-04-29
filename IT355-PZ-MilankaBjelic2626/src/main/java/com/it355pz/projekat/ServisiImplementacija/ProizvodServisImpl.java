package com.it355pz.projekat.ServisiImplementacija;

import com.it355pz.projekat.DAO.ProizvodDAO;
import com.it355pz.projekat.Modeli.Proizvod;
import com.it355pz.projekat.Servisi.ProizvodServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProizvodServisImpl implements ProizvodServis {

    @Autowired
    private ProizvodDAO proizvodDAO;

    @Override
    public Proizvod dodajProizvod(Proizvod proizvod) {
        return proizvodDAO.dodajProizvod(proizvod);
    }

    @Override
    public void izmeniProizvod(Proizvod proizvod) {
        proizvodDAO.izmeniProizvod(proizvod);
    }

    @Override
    public void obrisiProizvod(Proizvod proizvod) {
        proizvodDAO.obrisiProizvod(proizvod);
    }

    @Override
    public List<Proizvod> getProizvodi() {
        return proizvodDAO.getProizvodi();
    }

    @Override
    public Proizvod getProizvodById(int proizvodId) {
        return proizvodDAO.getProizvodById(proizvodId);
    }

    @Override
    public int prebrojProizvode() {
        return proizvodDAO.prebrojProizvode();
    }
}
