package com.it355pz.projekat.DAOImplementacija;

import com.it355pz.projekat.DAO.KupacDAO;
import com.it355pz.projekat.Modeli.Korisnik;
import com.it355pz.projekat.Modeli.Kupac;
import com.it355pz.projekat.Modeli.Rola;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class KupacDAOImpl implements KupacDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void registracijaKupac(Kupac kupac)
    {
        Korisnik noviKorisnik = new Korisnik();
        noviKorisnik.setKorisnickoIme(kupac.getKorisnickoIme());
        noviKorisnik.setLozinka(kupac.getLozinka());
        noviKorisnik.setEnabled(true);

        Rola rola = new Rola();
        rola.setKorisnickoIme(kupac.getKorisnickoIme());
        rola.setRolaNaziv("ROLA_KORISNIK");

        getSession().saveOrUpdate(noviKorisnik);
        getSession().saveOrUpdate(rola);

        getSession().saveOrUpdate(kupac);

        getSession().flush();
    }

    @Override
    public Kupac getKupacById(int kupacId) {
        Kupac kupac = (Kupac) getSession().createCriteria(Kupac.class).add(Restrictions.eq("id", kupacId)).uniqueResult();
        return kupac;
    }

    @Override
    public List<Kupac> getKupci() {
        List<Kupac> rezultat = (List<Kupac>) getSession().createCriteria(Kupac.class).list();
        return rezultat;
    }
}
