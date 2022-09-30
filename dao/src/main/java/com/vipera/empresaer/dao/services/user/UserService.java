package com.vipera.empresaer.dao.services.user;

import com.vipera.empresaer.dao.models.User;
import com.vipera.empresaer.dao.services.BaseService;

import java.util.Optional;

public interface UserService extends BaseService<User> {


     Optional<User> findUserByUsername(String username);
}
