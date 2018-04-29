package com.it355pz.projekat.Servisi;

import com.it355pz.projekat.Modeli.Porudzbina;

import java.util.List;

public interface PorudzbinaServis
{
    public Porudzbina novaPorudzbina(Porudzbina porudzbina);

    public List<Porudzbina> getPorudzbine();
}
