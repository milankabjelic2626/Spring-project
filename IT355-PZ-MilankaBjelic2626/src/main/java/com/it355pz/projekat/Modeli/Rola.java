package com.it355pz.projekat.Modeli;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rola")
public class Rola {

    @Id
    @GeneratedValue
    private int rolaId;
    private String korisnickoIme;
    private String rolaNaziv;

    public int getRolaId() {
        return rolaId;
    }

    public void setRolaId(int rolaId) {
        this.rolaId = rolaId;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getRolaNaziv() {
        return rolaNaziv;
    }

    public void setRolaNaziv(String rolaNaziv) {
        this.rolaNaziv = rolaNaziv;
    }
}
