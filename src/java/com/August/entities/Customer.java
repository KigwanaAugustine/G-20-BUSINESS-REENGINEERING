/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.August.entities;

import lombok.Data;

/**
 *
 * @author Tanuki
 */
@Data
public class Customer 
{

    private int customerID;
    private String cFname;
    private String cLname;
    private String gender;
    private String location;
    private String cEmail;
     private String cPassword;
    private String cUserName;
   
    public Customer(int customerID, String cFname, String cLname, String gender, String location, String cEmail, String cPassword, String cUserName) {
        this.customerID = customerID;
        this.cFname = cFname;
        this.cLname = cLname;
        this.gender = gender;
        this.location = location;
        this.cEmail = cEmail;
        this.cPassword = cPassword;
        this.cUserName = cUserName;
    }
    

    public Customer() {
    }
   
           
}
