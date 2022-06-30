package net.yorksolutions.maymemobackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String username;
    String password;

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserAccount() {};
}
