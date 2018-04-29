package com.it355pz.projekat.DAO;

import com.it355pz.projekat.Modeli.Proizvod;

import java.util.List;

public interface ProizvodDAO {

    public Proizvod dodajProizvod(Proizvod proizvod);
    public void izmeniProizvod(Proizvod proizvod);
    public void obrisiProizvod(Proizvod proizvod);

    public List<Proizvod> getProizvodi();
    public Proizvod getProizvodById(int proizvodId);
    public int prebrojProizvode();
}
