package com.api.spotify.service;

import com.api.spotify.entity.User;
import com.api.spotify.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getOne(Long id) {
        return userRepository.findById(id);
    }

    public User getOneUser(Long id) {
        return userRepository.findOneUser(id);
    }

    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    public User update(User newUser, Long id) {
        LocalDate dateNow;
        User userFind = this.getOneUser(id);

        /*
        Evalúa si las contraseñas del RequestBody y el User buscado coinciden,
        de ser diferentes, guarda la fecha actual en dateNow para indicar
        la última vez que se cambió el password.
         */
        if (userFind.getPassword().equals(newUser.getPassword())) dateNow = null;
        else dateNow = LocalDate.now();

        return userRepository.findById(id).map(
                user -> {
                    user.setUsername(newUser.getUsername());
                    user.setFirstAndLastname(newUser.getFirstAndLastname());
                    user.setBirthdate(newUser.getBirthdate());
                    user.setGender(newUser.getGender());
                    user.setZipcode(newUser.getZipcode());
                    user.setPassword(newUser.getPassword());
                    user.setCountry(newUser.getCountry());
                    user.setUserType(newUser.getUserType());
                    user.setPasswordDate(dateNow);  // Acá actualiza la fecha actual, de ser distintas las contraseñas.
                    return userRepository.save(user);
                }
        ).get();
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
