package com.it355pz.projekat.Modeli;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class Proizvod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "proizvodId")
    private int proizvodId;

    @NotEmpty(message = "Moras uneti naziv")
    @Column(name = "proizvodNaziv")
    private String proizvodNaziv;

    @Min(value = 0, message = "The product price must not be less then zero")
    @Column(name = "proizvodCena")
    private double proizvodCena;

    @Column(name = "proizvodOpis")
    private String proizvodOpis;

    @Column(name = "proizvodKategorija")
    private String proizvodKategorija;

    @Min(value = 0, message = "The product unit must not be less then zero")
    @Column(name = "proizvodKolicina")
    private int proizvodKolicina;

    @Column(name = "proizvodSlika")
    private String proizvodSlika;

    public int getProizvodId() {
        return proizvodId;
    }

    public void setProizvodId(int proizvodId) {
        this.proizvodId = proizvodId;
    }

    public String getProizvodNaziv() {
        return proizvodNaziv;
    }

    public void setProizvodNaziv(String proizvodNaziv) {
        this.proizvodNaziv = proizvodNaziv;
    }

    public double getProizvodCena() {
        return proizvodCena;
    }

    public void setProizvodCena(double proizvodCena) {
        this.proizvodCena = proizvodCena;
    }

    public String getProizvodOpis() {
        return proizvodOpis;
    }

    public void setProizvodOpis(String proizvodOpis) {
        this.proizvodOpis = proizvodOpis;
    }

    public String getProizvodKategorija() {
        return proizvodKategorija;
    }

    public void setProizvodKategorija(String proizvodKategorija) {
        this.proizvodKategorija = proizvodKategorija;
    }

    public int getProizvodKolicina() {
        return proizvodKolicina;
    }

    public void setProizvodKolicina(int proizvodKolicina) {
        this.proizvodKolicina = proizvodKolicina;
    }

    public String getProizvodSlika() {
        return proizvodSlika;
    }

    public void setProizvodSlika(String proizvodSlika) {
        this.proizvodSlika = proizvodSlika;
    }

    @Override
    public String toString() {
        return "Proizvod{" +
                "proizvodId=" + proizvodId +
                ", proizvodNaziv='" + proizvodNaziv + '\'' +
                ", proizvodCena=" + proizvodCena +
                ", proizvodOpis='" + proizvodOpis + '\'' +
                ", proizvodKategorija='" + proizvodKategorija + '\'' +
                ", proizvodKolicina=" + proizvodKolicina +
                ", proizvodSlika='" + proizvodSlika + '\'' +
                '}';
    }
}
