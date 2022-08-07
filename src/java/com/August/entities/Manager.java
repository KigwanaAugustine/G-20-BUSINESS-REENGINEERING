/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.August.entities;

import lombok.Data;

@Data
public class Manager 
{
    private  int managerID;
    private String sFname;
    private String sLname;
    private String address;
    private double salary;
    private String sEmail;
    private String sPassword;
    private String sUserName;

    public Manager() {
    }

    public Manager(int managerID, String sFname, String sLname, String address, double salary, String sEmail, String sPassword, String sUserName) {
        this.managerID = managerID;
        this.sFname = sFname;
        this.sLname = sLname;
        this.address = address;
        this.salary = salary;
        this.sEmail = sEmail;
        this.sPassword = sPassword;
        this.sUserName = sUserName;
    }
   
    
}
