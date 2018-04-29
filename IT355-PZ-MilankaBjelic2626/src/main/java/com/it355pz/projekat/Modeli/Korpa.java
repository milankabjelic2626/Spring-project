package com.it355pz.projekat.Modeli;

public class Korpa
{
    private Proizvod proizvod;
    private int proizvodKolicina;

    public Korpa(){
        super();
    }

    public Korpa(Proizvod proizvod, int proizvodKolicina) {
        super();
        this.proizvod = proizvod;
        this.proizvodKolicina = proizvodKolicina;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public int getProizvodKolicina() {
        return proizvodKolicina;
    }

    public void setProizvodKolicina(int proizvodKolicina) {
        this.proizvodKolicina = proizvodKolicina;
    }
}
