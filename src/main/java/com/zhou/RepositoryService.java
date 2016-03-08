package com.zhou;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by icepoint1999 on 3/8/16.
 */

@Service
public class RepositoryService {

    @Resource
    PersonRepository personRepository;
//
//    @Resource
//    MongoTemplate mongoTemplate;

    public void  doWork(){



        personRepository.deleteAll();
        Person person =new Person();

        person.setName("abc");
        personRepository.save(person);
    }
}
