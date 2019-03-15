package com.example.springbootexperiment01;

import com.example.springbootexperiment01.entity.Address;
import com.example.springbootexperiment01.entity.User;
import com.example.springbootexperiment01.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootExperiment01ApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void addAddressTest() {
       userRepository.addUserAddress();
    }
}

