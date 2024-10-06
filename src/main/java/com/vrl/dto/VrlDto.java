package com.vrl.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import javax.xml.crypto.Data;
import java.util.Date;

public class VrlDto {

    private Long id;
    @NotNull
    @Size(min =2,message = "should be at lease 2 character")
    private String name;

    private String mobile;

    private String emailID;

   // private Date date;

    //public Date getDate() {
       // return date;
 //   }


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
