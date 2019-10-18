package com.adidyk.repository;

import com.adidyk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface userRepository.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * findByLogin - find by login.
     * @param login - login.
     */
    User findByLogin(String login);

    /**
     * findByLoginAndPassword - find by login and password.
     * @param login - login.
     * @param password - password.
     * @return - return user.
     */
    User findByLoginAndPassword(String login, String password);

}