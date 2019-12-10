package com.cms.model.user;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "user")
public class User {
    
    private static Map<Integer,User> userIdToObjectMap = new HashMap<Integer,User>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer             id;

    @Column(name = "first_name", length = 250)
    private String              firstName;
    
    @Column(name = "last_name", length = 250)
    private String              lastName;
    
    @Column(name ="age", length=11)
    private int age;
    
    @Column(name = "mobile_no", length = 250)
    private String              mobileNo;

    @Column(name = "email", length = 250)
    private String              email;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    UserLoginProfile userLoginProfile;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getMobileNo() {
        return mobileNo;
    }


    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public UserLoginProfile getUserLoginProfile() {
        return userLoginProfile;
    }


    public void setUserLoginProfile(UserLoginProfile userLoginProfile) {
        this.userLoginProfile = userLoginProfile;
    }
    
    
    

}
