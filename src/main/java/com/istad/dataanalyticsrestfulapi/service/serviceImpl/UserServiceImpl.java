package com.istad.dataanalyticsrestfulapi.service.serviceImpl;

import com.istad.dataanalyticsrestfulapi.model.User;
import com.istad.dataanalyticsrestfulapi.model.UserAccount;
import com.istad.dataanalyticsrestfulapi.model.request.UserRequest;
import com.istad.dataanalyticsrestfulapi.repository.UserRepository;
import com.istad.dataanalyticsrestfulapi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // inject repository
    UserRepository userRepository;
    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public List<User> allUsers() {
        return userRepository.allUsers();
    }

    @Override
    public List<User> findUserByName() {
        return null;
    }

    @Override
    public User findUserByID(int id) {
        return userRepository.findUserByID(id);
    }

    @Override
    public int createNewUser(UserRequest user) {
        return userRepository.createNewUser(user);
    }

    @Override
    public int updateUser(UserRequest user, int id ) {
        return userRepository.updateUser(user, id);
    }

    @Override
    public int removeUser(int id) {
        return userRepository.removeUser(id);
    }

    @Override
    public List<UserAccount> getAllUserAccounts() {
        return userRepository.getAllUserAccounts();
    }
}
