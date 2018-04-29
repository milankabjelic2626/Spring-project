package com.it355pz.projekat.DAOImplementacija;

import com.it355pz.projekat.DAO.PorudzbinaDAO;
import com.it355pz.projekat.Modeli.Kupac;
import com.it355pz.projekat.Modeli.Porudzbina;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class PorudzbinaDAOImpl implements PorudzbinaDAO
{

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Porudzbina novaPorudzbina(Porudzbina porudzbina) {
        getSession().saveOrUpdate(porudzbina);
        getSession().flush();
        return porudzbina;
    }

    @Override
    public List<Porudzbina> getPorudzbine() {
        List<Porudzbina> rezultat = (List<Porudzbina>) getSession().createCriteria(Porudzbina.class).list();
        return rezultat;
    }
}
