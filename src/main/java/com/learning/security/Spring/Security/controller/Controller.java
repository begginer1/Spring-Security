package com.learning.security.Spring.Security.controller;

import jakarta.servlet.http.HttpServletRequest;
import com.learning.security.Spring.Security.model.Student;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {


    @GetMapping("/hello")
    public String SayHEllo(HttpServletRequest request)
    {
        System.out.println("clicked");
        return "HEllo Spring"+request.getSession().getId();
    }

    @GetMapping("/Students")
    public List<Student> getAllStudents()
    {
        List<Student> l=new ArrayList<>(List.of(new Student(1,"suresh",99),new Student(2,"Roney",87)));
        l.add(new Student(12,"Kunal",9));
        return l;
    }


    @PostMapping("/createStudents")
    public ResponseEntity<List<Student>> CreateStudents(@RequestBody List<Student> st)
    {
        List<Student> p=st;
        return ResponseEntity.ok(p);
    }
//    @GetMapping("/csrf-token")
//    public CsrfToken getToken(HttpServletRequest request)
//    {
//        return (CsrfToken) request.getAttribute("_csrf");
//    }

}
