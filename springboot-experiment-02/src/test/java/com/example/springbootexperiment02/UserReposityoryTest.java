package com.example.springbootexperiment02;

import com.example.springbootexperiment02.entity.User;
import com.example.springbootexperiment02.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserReposityoryTest {
    @Autowired
    private UserRepository userRepository;
    /**
     * 编写单元测试用例，测试方法实现的结果是否正确
     */

    @Test
    public void addUserTest() {
        User user = userRepository.addUser(new User("BO"));
        log.debug("{}", user.getInsertTime());
    }
}
