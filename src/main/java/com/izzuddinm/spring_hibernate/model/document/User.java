package com.izzuddinm.spring_hibernate.model.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String email;
    private String fullName;
    private LocalDate dateOfBirth;

    public User(String email, String fullName, LocalDate dateOfBirth) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }
}
