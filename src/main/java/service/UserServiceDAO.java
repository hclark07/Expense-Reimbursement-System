package service;

import model.User;

public interface UserServiceDAO {
    User checkCredentials(String email, String password);
    User getUserByUsername (String username);

}
