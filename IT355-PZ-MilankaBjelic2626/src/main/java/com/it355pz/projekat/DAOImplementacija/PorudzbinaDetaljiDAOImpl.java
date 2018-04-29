package com.it355pz.projekat.DAOImplementacija;

import com.it355pz.projekat.DAO.PorudzbinaDetaljiDAO;
import com.it355pz.projekat.Modeli.PorudzbinaDetalji;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public class PorudzbinaDetaljiDAOImpl implements PorudzbinaDetaljiDAO{


    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void novaPorudzbinaDetalji(PorudzbinaDetalji porudzbinaDetalji) {
        getSession().saveOrUpdate(porudzbinaDetalji);
        getSession().flush();
    }
}
