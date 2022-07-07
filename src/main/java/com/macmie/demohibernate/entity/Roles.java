package com.macmie.demohibernate.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "roles")
public class Roles {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "role_name")
    private String roleName;

    // map tới property "role" trong Users (chính là khóa ngoại)
    @OneToMany(mappedBy = "role")
    // Nhiều user có 1 role nên tạo List user, không tạo getter setter cho listUsers vì sẽ lặp vô tận
    private Set<Users> listUsers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}


