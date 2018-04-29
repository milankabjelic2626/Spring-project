package com.it355pz.projekat.DAO;


import com.it355pz.projekat.Modeli.Porudzbina;

import java.util.List;

public interface PorudzbinaDAO
{
    public Porudzbina novaPorudzbina(Porudzbina porudzbina);

    public List<Porudzbina> getPorudzbine();
}
