package com.zhou;

import com.mongodb.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by icepoint1999 on 3/8/16.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.zhou")
@ComponentScan("com.zhou")

public class Config extends AbstractMongoConfiguration {
    @Override
    protected String getDatabaseName() {

        return "bonday";
    }

    @Override
    public Mongo mongo() throws Exception {
        String host = "127.0.0.1";
        int port = 11011;
        // 数据库
        String database = "bonday";
        // 用户名
        String username = "ice";
        // 密码
        String password = "12345";
        // 最小连接数


        ServerAddress addr = new ServerAddress(host, port);
        MongoCredential mongoCredential = MongoCredential.createCredential(username, database, password.toCharArray());

        List<MongoCredential> mongoCredentialList = new ArrayList<MongoCredential>();
        mongoCredentialList.add(mongoCredential);

        MongoClientOptions options = MongoClientOptions.builder().socketKeepAlive(true).build();

        return new MongoClient(addr , options);
    }

    @Bean
    @Override
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(mongo(), getDatabaseName());
    }

    @Bean
    @Override
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory(), mappingMongoConverter());
    }
}
