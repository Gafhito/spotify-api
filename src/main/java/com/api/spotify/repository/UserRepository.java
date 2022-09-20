package com.api.spotify.repository;

import com.api.spotify.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from user u where u.id = ?1", nativeQuery = true)
    User findOneUser(Long id);

}
