package com.andrzejpe.spring.dao.model;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Random;

/**
 * Created by jedrek on 2016-01-06.
 */
@Repository
@Transactional
public class UserRepoImpl implements UserRepo {

    @PersistenceContext
    private EntityManager em;

    private Random random = new Random();

    @Override
    public Collection<User> getAllUsers() {
        Query query = em.createQuery("SELECT e FROM User e");
        return (Collection<User>) query.getResultList();
    }

    @Override
    public void createUser(User u) {
         u.setId(4 + random.nextInt(30000));
         em.persist(u);
    }
}
