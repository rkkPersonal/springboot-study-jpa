package com.study;

import com.study.entity.User;
import com.study.entity.UserRole;
import com.study.repository.UserRepository;
import com.study.repository.UserRoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
class ApplicationTests {

    @Autowired
    private UserRepository respository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Test
    public void testAsync(){
        Future<User> steven = respository.findUserByUsername("steven");

    }

    @Test
    public void testBachInsert(){

        System.out.println(System.currentTimeMillis());
        List<UserRole> userRoleList=new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            UserRole userRole = new UserRole();
            userRole.setRoleId(new Random().nextInt(3));
            userRole.setUserId(new Random().nextInt(3));
            userRoleList.add(userRole);
        }

        List<UserRole> userRoleList1 = userRoleRepository.saveAll(userRoleList);
        System.out.println(userRoleList1.size());
        System.out.println(System.currentTimeMillis());
    }

    @Test
    void contextLoads() {
        List<User> all = respository.findAll();
        System.out.println(all);

        User james = User.builder().username("peck").password("123456")
                .email("5232432@qq.com")
                .createTime(Timestamp.valueOf(LocalDateTime.now()))
                .updateTime(Timestamp.valueOf(LocalDateTime.now())).build();

        User save = respository.save(james);
        System.out.println(save);

    }

    @Test
    void query() {
/*
        User steven = respository.findUserByUsername("steven");
        System.out.println(steven);*/

        Page<User> id = respository.findAll(PageRequest.of(0, 10, Sort.Direction.DESC, "id"));

        System.out.println(Arrays.toString(id.stream().toArray()
        ));




    }

    public static void main(String[] args) {
      long l=  1619575872153L-1619575871604L;
        System.out.println(l);
    }
}
