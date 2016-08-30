package eshopping.dao;

import eshopping.domain.Users;

public interface UserDao {
    void update(Users user);
    Users getUserByUsername(String username);
}
