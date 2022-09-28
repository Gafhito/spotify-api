package com.api.spotify.service;

import com.api.spotify.entity.UserType;
import com.api.spotify.repository.UserTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTypeService {

    private UserTypeRepository userTypeRepository;

    public UserTypeService(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    public List<UserType> getAll() {
        return userTypeRepository.findAll();
    }

    public Optional<UserType> getOne(Long id) {
        return userTypeRepository.findById(id);
    }

    public UserType save(UserType newUserType) {
        return userTypeRepository.save(newUserType);
    }

    public UserType update(UserType newUsertype, Long id) {
        return userTypeRepository.findById(id).map(
                userType -> {
                    userType.setUserType(newUsertype.getUserType());
                    return userTypeRepository.save(userType);
                }
        ).get();
    }

    public void delete(Long id) {
        userTypeRepository.deleteById(id);
    }

}
