package me.zhiyuan.spring.booter.service;

import me.zhiyuan.spring.booter.domain.Person;

/**
 * Created by Administrator on 2017/1/9.
 */
public interface BooterService {
    Person getById(int id);

    Person save(Person person);

    void deleteById(int id);

    Person updateById(int id, Person person);
}
