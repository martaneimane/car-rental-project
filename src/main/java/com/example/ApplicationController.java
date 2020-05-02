package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping ("/index")
    public String goHome(){
        return "index";
    }

    @GetMapping ("/cars")
    public String goCars(){
        return "Cars";
    }

    @GetMapping ("/customers")
    public String goCustomers(){
        return "Customers";
    }

    @GetMapping ("/employees")
    public String goEmployees(){
        return "Employees";
    }

    @GetMapping ("/bookings")
    public String goBookings(){
        return "Bookings";
    }
}
