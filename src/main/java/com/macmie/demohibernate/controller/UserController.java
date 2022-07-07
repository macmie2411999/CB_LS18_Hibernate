package com.macmie.demohibernate.controller;

import com.macmie.demohibernate.entity.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    SessionFactory sessionFactory;

    @GetMapping("")
    public ResponseEntity<?> getUser() {
        Session session = sessionFactory.getCurrentSession();
        // users lấy được đại diện bởi entity Users
        Query<Users> query = session.createQuery("from users", Users.class);
        List<Users> listUser = query.getResultList();
        return new ResponseEntity<List<Users>>(listUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    // Annotation commit, đẩy về database để thực hiện
    @Transactional
    public String deleteUser(@PathVariable("id") int id) {
        Session session = sessionFactory.getCurrentSession();
        Users users = new Users();
        users.setId(id);
        try {
            session.delete(users);
            return "Ok";
        } catch (Exception e) {
            return "Failed";
        }

//        Query<Users> query = session.createQuery("from users", Users.class);
//        List<Users> listUser = query.getResultList();
//        return new ResponseEntity<List<Users>>(listUser, HttpStatus.OK);
    }
}
