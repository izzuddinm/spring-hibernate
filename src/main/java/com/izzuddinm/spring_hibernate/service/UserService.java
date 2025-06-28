package com.izzuddinm.spring_hibernate.service;

import com.izzuddinm.spring_hibernate.model.document.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public String generateUsers(int total) {
        mongoTemplate.dropCollection(User.class);
        List<User> users = new ArrayList<>();

        for (int i = 0; i < total; i++) {
            String email = "user" + i + "@test.com";
            String name = "User " + i;
            users.add(new User(email, name, LocalDate.of(1990, 1, 1)));
        }

        mongoTemplate.insertAll(users);
        return "Generated " + total + " users.";
    }

    public String createIndex() {
        Index index = new Index().on("email", Sort.Direction.ASC);
        mongoTemplate.indexOps(User.class).ensureIndex(index);
        return "Index created on field 'email'.";
    }

    public String dropIndex() {
        mongoTemplate.indexOps(User.class).dropIndex("email_1");
        return "Index 'email_1' dropped.";
    }

    public String searchByEmail(String email) {
        Query query = new Query(Criteria.where("email").is(email));

        long totalTime = 0;
        for (int i = 1; i <= 5; i++) {
            long start = System.currentTimeMillis();
            mongoTemplate.find(query, User.class);
            long duration = System.currentTimeMillis() - start;
            totalTime += duration;
            System.out.println("Run " + i + ": " + duration + " ms");
        }

        long average = totalTime / 5;
        return "Rata-rata waktu eksekusi query: " + average + " ms";
    }
}
