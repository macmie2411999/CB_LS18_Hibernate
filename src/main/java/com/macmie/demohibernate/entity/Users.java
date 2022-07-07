package com.macmie.demohibernate.entity;

import javax.persistence.*;

@Entity(name = "users")
public class Users {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "username")
    private String userName;

//    @Column(name = "role_id") // foreign key, bỏ đi sau khi đã dùng JoinColumn
//    private int roleId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Roles getRole() { return role; }

    public void setRole(Roles role) { this.role = role; }

    //    public int getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(int roleId) {
//        this.roleId = roleId;
//    }
}
