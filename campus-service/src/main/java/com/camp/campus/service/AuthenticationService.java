package com.camp.campus.service;

import com.camp.campus.dto.ProfileDTO;
import com.camp.campus.dto.UserDTO;

public interface AuthenticationService {

    ProfileDTO authenticate(UserDTO userDTO);
}
