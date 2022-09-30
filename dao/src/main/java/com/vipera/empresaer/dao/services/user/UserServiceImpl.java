package com.vipera.empresaer.dao.services.user;

import com.vipera.empresaer.dao.models.User;
import com.vipera.empresaer.dao.repositories.UserRepository;
import com.vipera.empresaer.dao.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {


    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repository;


    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User object) {
        LOGGER.info(LogUtils.daoMarker, "DAO -   UserServiceImpl   - INPUT - save - Saving User");

        User saved =  repository.save(object);

        LOGGER.info(LogUtils.daoMarker, "DAO -   UserServiceImpl   - OUTPUT - save - Returning saved User");

        return saved;
    }

    @Override
    public void delete(User object) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return repository.findByUsername(username);
    }
}
