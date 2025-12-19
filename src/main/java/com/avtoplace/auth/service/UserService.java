package com.avtoplace.auth.service;

import com.avtoplace.auth.model.OAuthAccount;
import com.avtoplace.auth.model.User;
import com.avtoplace.auth.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Создание нового пользователя
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Поиск пользователя по email
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Привязка OAuth-аккаунта
    public User addOAuthAccount(User user, OAuthAccount account) {
        user.addOauthAccount(account);
        return userRepository.save(user);
    }
}
