package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;

import web.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        System.out.println("Предоставлен список всех пользователей из базы данных");
        return userDAO.getAllUsers();
    }

    @Override
    public User showUser(Integer id) {
        System.out.println("Найден пользователь с ID – " + id);
        return userDAO.showUser(id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
        System.out.println("Пользователь с именем – " + user.getName() + " добавлен в базу данных");
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) {
        userDAO.deleteUser(id);
        System.out.println("Пользователь с ID – " + id + " удалён из базы данных");
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
        System.out.println("Данные о пользователе с ID – " + user.getId() + " изменены в базе данных");
    }
}
