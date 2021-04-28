package com.study.repository;

import com.study.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Steven
 */

@NoRepositoryBean
public class UserExtendRepository extends SimpleJpaRepository<User, Integer> {


    private JpaEntityInformation<User, ?> entityInformation;

    private EntityManager entityManager;

    public UserExtendRepository(JpaEntityInformation<User, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public UserExtendRepository(Class<User> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    @Override
    public <S extends User> S save(S entity) {


        if (entityInformation.isNew(entity)) {
            entityManager.persist(entity);
            return entity;
        } else {
            return entityManager.merge(entity);
        }
    }

}
