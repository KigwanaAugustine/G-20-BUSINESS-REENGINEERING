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
public class Staff 
{
    private int staffID;
    private String sFname;
    private String sLname;
    private String address;
    private double salary;
    private String sEmail;
    private int managerID;
    private String gender;
}
