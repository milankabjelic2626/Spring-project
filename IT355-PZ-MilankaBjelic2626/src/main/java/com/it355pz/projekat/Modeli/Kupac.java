package com.it355pz.projekat.Modeli;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kupac {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int kupacId;

    @NotEmpty(message = "Morate uneti ime i prezime")
    private String kupacIme;

    @NotEmpty(message = "Unesi email adresu")
    private String kupacEmail;

    @NotEmpty(message = "Unesi broj telefona")
    private String kupacTelefon;

    @NotEmpty(message = "Username mora biti unet")
    private String korisnickoIme;

    @NotEmpty(message = "Password mora biti unet")
    private String lozinka;

    private boolean enabled;

    @NotEmpty(message = "Adresa mora biti uneta")
    private String kupacAdresa;

    @NotEmpty(message = "Ovo polje mora biti popunjeno")
    private String kupacGrad;

    public Kupac() {
    }

    public Kupac(String kupacIme, String kupacEmail, String kupacTelefon, String korisnickoIme, String lozinka, boolean enabled, String kupacAdresa, String kupacGrad) {
        this.kupacIme = kupacIme;
        this.kupacEmail = kupacEmail;
        this.kupacTelefon = kupacTelefon;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.enabled = enabled;
        this.kupacAdresa = kupacAdresa;
        this.kupacGrad = kupacGrad;
    }

    public int getKupacId() {
        return kupacId;
    }

    public void setKupacId(int kupacId) {
        this.kupacId = kupacId;
    }

    public String getKupacIme() {
        return kupacIme;
    }

    public void setKupacIme(String kupacIme) {
        this.kupacIme = kupacIme;
    }

    public String getKupacEmail() {
        return kupacEmail;
    }

    public void setKupacEmail(String kupacEmail) {
        this.kupacEmail = kupacEmail;
    }

    public String getKupacTelefon() {
        return kupacTelefon;
    }

    public void setKupacTelefon(String kupacTelefon) {
        this.kupacTelefon = kupacTelefon;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getKupacAdresa() {
        return kupacAdresa;
    }

    public void setKupacAdresa(String kupacAdresa) {
        this.kupacAdresa = kupacAdresa;
    }

    public String getKupacGrad() {
        return kupacGrad;
    }

    public void setKupacGrad(String kupacGrad) {
        this.kupacGrad = kupacGrad;
    }

    @Override
    public String toString() {
        return "Kupac{" +
                "kupacId=" + kupacId +
                ", kupacIme='" + kupacIme + '\'' +
                ", kupacEmail='" + kupacEmail + '\'' +
                ", kupacTelefon='" + kupacTelefon + '\'' +
                ", korisnickoIme='" + korisnickoIme + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", enabled=" + enabled +
                ", kupacAdresa='" + kupacAdresa + '\'' +
                ", kupacGrad='" + kupacGrad + '\'' +
                '}';
    }
}