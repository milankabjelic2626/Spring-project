package com.it355pz.projekat.DAO;

import com.it355pz.projekat.Modeli.Kupac;

import java.util.List;

public interface KupacDAO
{
    public void registracijaKupac(Kupac kupac);

    public Kupac getKupacById(int kupacId);

    public List<Kupac> getKupci();
}
