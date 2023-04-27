package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Employee_Payroll {
    public static void main(String[] args) {
        //UC3 :Ability to update the salary

        try {
            //1.Load a driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2.Create a Connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service","root","Abhi");
            if (connection.isClosed()){
                throw new NewCustomExceptionn("Connection is not created");     //Throwing custom exception if get any error.
            }else {
                System.out.println("Connection is created");
            }

            //3.Write a Query
            String query = "update employee_payroll set salary = 300000 where id = 2";

            //4.prepare a statement
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet set =  statement.executeQuery("select * from employee_payroll");

            System.out.println("...Inserted.");;

            while (set.next()){   // Retrieve all data from employee_payroll table.
                System.out.println("Id : "+set.getInt(1));
                System.out.println("Name : "+set.getString(2));
                System.out.println("Gender : "+set.getString(3));
                System.out.println("Salary : "+set.getInt(4));
                System.out.println("StartDate : "+set.getDate(5));
                System.out.println("PhoneNumber : "+set.getLong(6));
                System.out.println("Address : "+set.getString(7));
                System.out.println("Department : "+set.getString(8));
                System.out.println("BasicPay : "+set.getInt(9));
                System.out.println("Deductions : "+set.getInt(10));
                System.out.println("TaxablePay : "+set.getInt(11));
                System.out.println("IncomeTax : "+set.getInt(12));
                System.out.println("NetPay : "+set.getInt(13));
                System.out.println("==============================================================");
            }
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


