package com.it355pz.projekat.ServisiImplementacija;

import com.it355pz.projekat.DAO.PorudzbinaDAO;
import com.it355pz.projekat.Modeli.Porudzbina;
import com.it355pz.projekat.Servisi.PorudzbinaServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorudzbinaServisImpl implements PorudzbinaServis{
    @Autowired
    private PorudzbinaDAO porudzbinaDAO;

    @Override
    public Porudzbina novaPorudzbina(Porudzbina porudzbina) {
        return porudzbinaDAO.novaPorudzbina(porudzbina);
    }

    @Override
    public List<Porudzbina> getPorudzbine() {
        return porudzbinaDAO.getPorudzbine();
    }


}