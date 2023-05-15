package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User showUser(Integer id);

    void saveUser(User user);

    void deleteUser(Integer id);

    void updateUser(User user);
}
