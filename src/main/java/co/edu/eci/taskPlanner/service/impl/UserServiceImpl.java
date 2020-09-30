package co.edu.eci.taskPlanner.service.impl;

import co.edu.eci.taskPlanner.model.User;
import co.edu.eci.taskPlanner.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    List<User> users = new ArrayList<>();

    public UserServiceImpl(){
        this.users = new ArrayList<>();
        this.users.add(new User("1","Luis","luis@mail.com","ieti123"));
        this.users.add(new User("2","Alejo","alejo@mail.com","ieti123"));
        this.users.add(new User("3","Zeus","zeus@mail.com","ieti123"));
    }

    @Override
    public List<User> getAll(){
        return users;
    }

    @Override
    public User getById(String userId){
        for(User i:users){
            if(i.getUserId().equals(userId)){
                return i;
            }
        }
        return null;
    }

    @Override
    public User create(User user){
        users.add(user);
        return user;
    }

    @Override
    public User update(User user){
        User userUpdate = getById(user.getUserId());
        if(user.getUserName()!=null){
            userUpdate.setUserName(user.getUserName());
        }if(user.getEmail()!=null){
            userUpdate.setEmail(user.getEmail());
        }if(user.getPassword()!=null){
            userUpdate.getPassword();
        }
        return userUpdate;
    }

    @Override
    public void remove(String userId){
        User user = getById(userId);
        users.remove(user);
    }

}
