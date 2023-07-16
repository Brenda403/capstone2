package com.devmountain.hopesAndDreams.services;

import com.devmountain.hopesAndDreams.dtos.UserDto;

import java.util.List;

public interface UserService {
    List<String> addUser(UserDto userDto);

    List<String> userLogin(UserDto userDto);
}
