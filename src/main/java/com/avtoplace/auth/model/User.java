package com.avtoplace.auth.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users") // Рекомендуется явное имя таблицы, чтобы избежать конфликтов с ключевыми словами
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, unique = true)
    private String username;

    @Column(nullable = true, unique = true)
    private String email;

    @Column(nullable = true, unique = true)
    private String phone;

    private String password; // хэш пароля

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OAuthAccount> oauthAccounts = new ArrayList<>();

    // --- Геттеры и сеттеры ---

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<OAuthAccount> getOauthAccounts() {
        return oauthAccounts;
    }

    public void addOauthAccount(OAuthAccount account) {
        oauthAccounts.add(account);
        account.setUser(this);
    }

    public void removeOauthAccount(OAuthAccount account) {
        oauthAccounts.remove(account);
        account.setUser(null);
    }
}
