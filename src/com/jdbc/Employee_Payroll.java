package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Employee_Payroll {
    public static void main(String[] args) {
        //Uc1 : Ability to create a payroll service database and have java program connect to database.

        try {
            //1.Load a driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2.Create a Connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service","root","Abhi");
            if (connection.isClosed()){
                System.out.println("Connection is closed");
            }else {
                System.out.println("Connection is created");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


