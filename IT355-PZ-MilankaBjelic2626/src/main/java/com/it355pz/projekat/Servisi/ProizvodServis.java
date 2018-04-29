package com.it355pz.projekat.Servisi;

import com.it355pz.projekat.Modeli.Proizvod;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProizvodServis
{
    public Proizvod dodajProizvod(Proizvod proizvod);
    public void izmeniProizvod(Proizvod proizvod);
    public void obrisiProizvod(Proizvod proizvod);

    public List<Proizvod> getProizvodi();
    public Proizvod getProizvodById(int proizvodId);
    public int prebrojProizvode();
}
