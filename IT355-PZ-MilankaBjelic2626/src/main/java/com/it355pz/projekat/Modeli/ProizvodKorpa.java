package com.it355pz.projekat.Modeli;

public class ProizvodKorpa
{
    private Proizvod proizvodKorpa;
    private int kolicinaUKorpi;

    public ProizvodKorpa()
    {
        super();
    }

    public ProizvodKorpa(Proizvod proizvodKorpa, int kolicinaUKorpi)
    {
        super();
        this.proizvodKorpa = proizvodKorpa;
        this.kolicinaUKorpi = kolicinaUKorpi;
    }

    public Proizvod getProizvodKorpa() {
        return proizvodKorpa;
    }

    public void setProizvodKorpa(Proizvod proizvodKorpa) {
        this.proizvodKorpa = proizvodKorpa;
    }

    public int getKolicinaUKorpi() {
        return kolicinaUKorpi;
    }

    public void setKolicinaUKorpi(int kolicinaUKorpi) {
        this.kolicinaUKorpi = kolicinaUKorpi;
    }
}
