package com.stackroute;


import com.stackroute.model.Address;
import com.stackroute.model.Employee;
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

        Employee employee = new Employee();
       Address address1 =new Address();


        employee.setEmpId(101);
        employee.seteName("Swastika");
        employee.seteSalary(1888888);

       employee.setAddress(address1);

        address1.setCity("Patna");
        address1.setHouseNumber(341);
        address1.setStreet("Ara more");

        System.out.println(employee);

        Session session = sf.openSession();

        Transaction tx= session.beginTransaction();
        session.save(employee);
       // session.save(address1);

        tx.commit();

        session.close();

        System.out.println("Done");

    }
}