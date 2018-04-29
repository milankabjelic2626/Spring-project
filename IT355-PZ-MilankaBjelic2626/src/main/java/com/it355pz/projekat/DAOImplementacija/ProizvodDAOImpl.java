package com.it355pz.projekat.DAOImplementacija;


import com.it355pz.projekat.DAO.ProizvodDAO;
import com.it355pz.projekat.Modeli.Proizvod;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Service
public class ProizvodDAOImpl implements ProizvodDAO {


    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Proizvod dodajProizvod(Proizvod proizvod) {
        return (Proizvod) getSession().merge(proizvod);
    }

    @Override
    public void izmeniProizvod(Proizvod proizvod) {
        getSession().saveOrUpdate(proizvod);
    }

    @Override
    public void obrisiProizvod(Proizvod proizvod) {
        getSession().delete(getSession().merge(proizvod));
    }

    @Override
    public List<Proizvod> getProizvodi() {
        List<Proizvod> rezultati = (List<Proizvod>) getSession().createCriteria(Proizvod.class).list();
        return rezultati;
    }

    @Override
    public Proizvod getProizvodById(int proizvodId) {
        Proizvod proizvod = (Proizvod) getSession().createCriteria(Proizvod.class).add(Restrictions.eq("proizvodId", proizvodId)).uniqueResult();
        return proizvod;
    }

    @Override
    public int prebrojProizvode() {
        Number rezultat = (Number) getSession().createSQLQuery("select count(*) from proizvod").uniqueResult();
        return Integer.parseInt(rezultat.toString());
    }
}