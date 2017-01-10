package me.zhiyuan.spring.booter.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Administrator on 2017/1/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryIntegrationTest {
    @Autowired
    PersonRepository personRepository;

    @Test
    public void executesQuery(){
        Person person = personRepository.findById(1).get();
        assertThat(person.getName()).isEqualTo("mazhiyuan123445");
    }
}
