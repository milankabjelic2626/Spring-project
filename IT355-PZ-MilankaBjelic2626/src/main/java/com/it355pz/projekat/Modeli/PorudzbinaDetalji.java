package com.it355pz.projekat.Modeli;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PorudzbinaDetalji {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detaljiId;

    private int proizvodId;

    private int porudzbinaId;

    private double cena;

    private int kolicina;

    public PorudzbinaDetalji(int proizvodId, int porudzbinaId, double cena, int kolicina) {
        this.proizvodId = proizvodId;
        this.porudzbinaId = porudzbinaId;
        this.cena = cena;
        this.kolicina = kolicina;
    }

    public PorudzbinaDetalji() {
    }

    public int getDetaljiId() {
        return detaljiId;
    }

    public void setDetaljiId(int detaljiId) {
        this.detaljiId = detaljiId;
    }

    public int getProizvodId() {
        return proizvodId;
    }

    public void setProizvodId(int proizvodId) {
        this.proizvodId = proizvodId;
    }

    public int getPorudzbinaId() {
        return porudzbinaId;
    }

    public void setPorudzbinaId(int porudzbinaId) {
        this.porudzbinaId = porudzbinaId;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public String toString() {
        return "PorudzbinaDetalji{" +
                "detaljiId=" + detaljiId +
                ", proizvodId=" + proizvodId +
                ", porudzbinaId=" + porudzbinaId +
                ", cena=" + cena +
                ", kolicina=" + kolicina +
                '}';
    }
}