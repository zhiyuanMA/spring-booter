package me.zhiyuan.spring.booter.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Administrator on 2017/1/9.
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findById(int id);

    Optional<Person> findByName(String name);

    void deleteById(int id);
}
