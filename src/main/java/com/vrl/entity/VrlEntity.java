package com.vrl.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vrl_entity")
public class VrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 144)
    private String name;

    @Column(name = "mobile", nullable = false, unique = true, length = 15)
    private String mobile;

    @Column(name = "email_id", nullable = false, unique = true, length = 200)
    private String emailID;

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

