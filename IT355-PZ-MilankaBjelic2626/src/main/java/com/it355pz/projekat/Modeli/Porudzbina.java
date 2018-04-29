package com.it355pz.projekat.Modeli;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Porudzbina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int porudzbinaId;

    private String korisnickoIme;
    private Date datum;

    public Porudzbina(String korisnickoIme, Date datum) {
        this.korisnickoIme = korisnickoIme;
        this.datum = datum;
    }

    public Porudzbina() {
    }

    public int getPorudzbinaId() {
        return porudzbinaId;
    }

    public void setPorudzbinaId(int porudzbinaId) {
        this.porudzbinaId = porudzbinaId;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "Porudzbina{" +
                "porudzbinaId=" + porudzbinaId +
                ", korisnickoIme='" + korisnickoIme + '\'' +
                ", datum=" + datum +
                '}';
    }
}