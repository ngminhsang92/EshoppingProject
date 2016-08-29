package eshopping.dao;

import com.estore.model.Users;

public interface UserDao {
    void update(Users user);
    Users getUserByUsername(String username);
}

