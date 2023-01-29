package com.stackroute;

import com.stackroute.model.Employee;
import com.stackroute.model.Owner;
import com.stackroute.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Project Started...");

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sf = configuration.buildSessionFactory();

        Person person1= new Person();
        person1.setPersonId(101);
        person1.setFirstName("Tanu");
        person1.setLastName("Bindal");






        Owner owner = new Owner();
        owner.setPersonId(102);
        owner.setFirstName("Sanpreet");
        owner.setLastName("Kaur");
        owner.setStocks(200);
        owner.setPartnershipStake(75);


        Employee employee = new Employee();
        employee.setPersonId(103);
        employee.setFirstName("Swati");
        employee.setLastName("Shakya");
      //  employee.setJoiningDate(2021/09/02);
        employee.setDepartmentName("IT");


        Session session = sf.openSession();

        Transaction tx= session.beginTransaction();
        session.save(person1);
        session.save(owner);
        session.save(employee);

        tx.commit();




        sf.close();



    }
}