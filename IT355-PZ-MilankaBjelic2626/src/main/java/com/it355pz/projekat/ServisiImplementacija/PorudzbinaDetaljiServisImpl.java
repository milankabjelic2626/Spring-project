package com.it355pz.projekat.ServisiImplementacija;

import com.it355pz.projekat.DAO.PorudzbinaDetaljiDAO;
import com.it355pz.projekat.Modeli.PorudzbinaDetalji;
import com.it355pz.projekat.Servisi.PorudzbinaDetaljiServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PorudzbinaDetaljiServisImpl implements PorudzbinaDetaljiServis
{

    @Autowired
    private PorudzbinaDetaljiDAO porudzbinaDetaljiDAO;


    @Override
    public void novaPorudzbinaDetalji(PorudzbinaDetalji porudzbinaDetalji) {
        porudzbinaDetaljiDAO.novaPorudzbinaDetalji(porudzbinaDetalji);
    }
}
