package com.example.springbootexperiment03;

import com.example.springbootexperiment03.entity.Address;
import com.example.springbootexperiment03.entity.User;
import com.example.springbootexperiment03.entity.UserAddress;
import com.example.springbootexperiment03.reposityory.AddressRepository;
import com.example.springbootexperiment03.reposityory.UserAddressRepository;
import com.example.springbootexperiment03.reposityory.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JPQLTest {
    @Autowired
    private UserRepository userReposityory;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserAddressRepository userAddressRepository;

    @Test
    public void init() {
        User user = new User("BO");
        userReposityory.save(user);
        User user2 = new User("SUN");
        userReposityory.save(user2);

        Address a = new Address("956");
        addressRepository.save(a);
        Address a2 = new Address("925");
        addressRepository.save(a2);

        Address a3 = new Address("1021");
        addressRepository.save(a3);

        UserAddress ua = new UserAddress(user, a);
        userAddressRepository.save(ua);

        UserAddress ua2 = new UserAddress(user, a2);
        userAddressRepository.save(ua2);

        UserAddress ua3 = new UserAddress(user2, a3);
        userAddressRepository.save(ua3);
    }
    @Test
    public void userRepTest() {
        User u = userReposityory.find(1);
        log.debug(u.getName());
    }
    @Test
    public void addressRepTest() {
        addressRepository.list("956")
                .forEach(a -> {
                    log.debug("{}", a.getId());
                });
    }

    @Test
    public void userAddressRepTest() {
        UserAddress ua = userAddressRepository.find("SUN", "1021");
        log.debug("插入时间：{}", ua.getInsertTime());
    }
}
