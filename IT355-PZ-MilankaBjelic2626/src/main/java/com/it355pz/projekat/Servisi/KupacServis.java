package com.it355pz.projekat.Servisi;

import com.it355pz.projekat.Modeli.Kupac;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KupacServis
{
    public void registracijaKupac(Kupac kupac);

    public Kupac getKupacById(int kupacId);

    public List<Kupac> getKupci();
}
