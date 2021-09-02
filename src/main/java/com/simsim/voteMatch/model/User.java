package com.simsim.voteMatch.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")

public class User
{

@Id
@Column(name = "ID_USER")
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
private Long id_user;

    @Column(name="userName")
    private String userName;

    @Column(name="age")
    private String age;

    @Column(name="gender")
    private String gender;


    @Column(name="id_hizb")
    private Long id_hizb;

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId_hizb() {
        return id_hizb;
    }

    public void setId_hizb(Long id_hizb) {
        this.id_hizb = id_hizb;
    }
}
