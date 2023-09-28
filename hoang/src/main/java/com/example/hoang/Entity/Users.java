package com.example.hoang.Entity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.math.BigInteger;
import java.sql.Date;

@Entity
@Data
@Table(name="Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userID;
    @Column(name = "username")
    private String userName;
    @Column(name= "password")
    private String pasdsWord;
    @Column (name = "fullname")
    private String fullName;
    private Integer status;
    @Column (name = "roleid")
    private BigInteger roleID;
    @Column (name = "createddate")
    private Date createdDate;
    @Column (name = "modifieddate")
    private Date modifiedDate;
    @Column (name = "createdBy")
    private String createdby;
    @Column (name = "modifiedby")
    private String modifiedBy;
    @Column (name= "salt")
    private String salt;
    @Column (name = "email")
    private String email;
}
