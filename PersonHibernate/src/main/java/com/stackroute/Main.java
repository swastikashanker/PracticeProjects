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
        System.out.println("Hibernate Project Started!!!");

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sf = configuration.buildSessionFactory();


        Owner owner = new Owner();
        owner.setStocks(200);
        owner.setPartnershipStake(75);
        owner.setPersonId(101);

        Employee employee = new Employee();
       // employee.setJoiningDate(2021/09/02);
        employee.setDepartmentName("IT");
        employee.setPersonId(102);


        Person person1= new Person();
        person1.setPersonId(101);
        person1.setFirstName("Tanu");
        person1.setLastName("Bindal");
        person1.setOwner(owner);


        Person person2 =new Person();
        person2.setPersonId(102);
        person2.setFirstName("Sanpreet");
        person2.setLastName("Kaur");
        person2.setEmployee(employee);

        Session session = sf.openSession();

        Transaction tx= session.beginTransaction();
        session.save(person1);
        session.save(person2);
        session.save(owner);
        session.save(employee);

        tx.commit();




        sf.close();


    }
}