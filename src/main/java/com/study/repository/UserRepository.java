package com.study.repository;

import com.study.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.concurrent.Future;

/**
 * @author Steven
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor {

    /**
     * 异步获取用户信息
     *
     * @param username
     * @return
     */
    @Async
    Future<User> findUserByUsername(String username);
}
