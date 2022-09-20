package com.api.spotify.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_type")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_type", nullable = false, length = 50)
    private String userType;

    public UserType() {
    }

    public UserType(Long id) {
        this.id = id;
    }

    public UserType(Long id, String userType) {
        this.id = id;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}
