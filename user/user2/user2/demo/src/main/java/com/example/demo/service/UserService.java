package com.example.demo.service;

import com.example.demo.dto.UserDto;

import java.util.List;

public interface UserService {
    public void addUser(UserDto userDto);
    public void updateUser(UserDto userDto);
    public List<UserDto> getAllUsers();
    public void deleteUser(Integer id);

    UserDto getUserById(Integer userId);
}
