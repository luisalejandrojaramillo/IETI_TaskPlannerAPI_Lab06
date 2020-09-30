package co.edu.eci.taskPlanner.service;

import co.edu.eci.taskPlanner.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(String userId);

    User create(User user);

    User update(User user);

    void remove(String userId);

}
