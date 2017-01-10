package me.zhiyuan.spring.booter.web;

import me.zhiyuan.spring.booter.domain.Person;
import me.zhiyuan.spring.booter.service.BooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/1/9.
 */
@RestController
public class BooterController {

    @Autowired
    private BooterService booterService;

    @Value("${person.name}")
    String name;

    @Value("${person.age}")
    int age;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
        return "Hello Stranger";
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public Person get(@PathVariable("id") int id) {
        return booterService.getById(id);
    }

    @RequestMapping(value = "/person/save", method = RequestMethod.POST)
    public String save(@RequestBody Person person) {
        Person p = booterService.save(person);
        return "Hello " + p.getName() + ", id:" + p.getId();
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    public String del(@PathVariable int id) {
        booterService.deleteById(id);
        return "Success! ID=" + id + " has been deleted!";
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
    public String put(@PathVariable int id, @RequestBody Person person) {
        booterService.updateById(id,person);
        return "Success!";
    }
}
