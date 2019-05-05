package com.example.springbootexperiment01.repository;

import com.example.springbootexperiment01.entity.Address;
import com.example.springbootexperiment01.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    public void addUserAddress() {
        User user = new User("Tyrion");
        em.persist(user);
        Address address1 = new Address("123456");
        address1.setUser(user);
        em.persist(address1);

        Address address2 = new Address("654321");
        address2.setUser(user);
        em.persist(address2);
    }
}
