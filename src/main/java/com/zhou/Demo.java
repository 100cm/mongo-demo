package com.zhou;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by icepoint1999 on 3/8/16.
 */


public class Demo {



    public static void main(String args[]){


        ApplicationContext applicationContext =  new AnnotationConfigApplicationContext(Config.class);


        RepositoryService repositoryService =  applicationContext.getBean(RepositoryService.class);

        repositoryService.doWork();
    }

}
