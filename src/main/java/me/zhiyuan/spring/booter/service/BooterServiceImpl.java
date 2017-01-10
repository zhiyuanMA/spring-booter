package me.zhiyuan.spring.booter.service;

import me.zhiyuan.spring.booter.domain.Person;
import me.zhiyuan.spring.booter.domain.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * Created by Administrator on 2017/1/9.
 */
@Component("booterService")
@Transactional
public class BooterServiceImpl implements BooterService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value="booter",key = "#id")
    public Person getById(int id) {
        Optional<Person> op = personRepository.findById(id);
        return op.isPresent()? op.get() : null;
    }

    @Override
    @CachePut(value="booter",key = "#person.getId()")
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    @CacheEvict(value="booter",key = "#id")
    public void deleteById(int id) {
        personRepository.deleteById(id);
    }

    @Override
    @CachePut(value="booter",key = "#id")
    public Person updateById(int id, Person person) {
        person.setId(id);
        return personRepository.save(person);
    }
}
