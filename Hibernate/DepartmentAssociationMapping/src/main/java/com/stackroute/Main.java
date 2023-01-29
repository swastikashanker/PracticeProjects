package com.stackroute;

import com.stackroute.model.Department;
import com.stackroute.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hibernate Project Started!!!");

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sf = configuration.buildSessionFactory();

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        List<Employee> list1 = new ArrayList<Employee>();
        list1.add(employee1);
        list1.add(employee2);

        Department department1 = new Department();

        department1.setDepartmentId(101);
        department1.setDepartmentName("IT");
        department1.setEmployee(list1);



        Employee employee3 = new Employee();
        Employee employee4 = new Employee();
        List<Employee> list2 = new ArrayList<Employee>();
        list2.add(employee3);
        list2.add(employee4);

        Department department2 = new Department();

        department2.setDepartmentId(102);
        department2.setDepartmentName("Marketing");
        department2.setEmployee(list2);


        employee1.setEmployeeId(111);
        employee1.setFirstName("Tanu");
        employee1.setLastName("Bindal");
        employee1.setBirthDate("02-10-1998");
        employee1.setCellPhone("927228929");
        employee1.setDepartment(department1);

        employee2.setEmployeeId(112);
        employee2.setFirstName("Sanpreet");
        employee2.setLastName("Kaur");
        employee2.setBirthDate("09-10-2000");
        employee2.setCellPhone("9877288911");
        employee2.setDepartment(department1);


        employee3.setEmployeeId(113);
        employee3.setFirstName("Swati");
        employee3.setLastName("Shakya");
        employee3.setBirthDate("02-11-1998");
        employee3.setCellPhone("92722637329");
        employee3.setDepartment(department2);

        employee4.setEmployeeId(114);
        employee4.setFirstName("Swastika");
        employee4.setLastName("Shanker");
        employee4.setBirthDate("09-10-2009");
        employee4.setCellPhone("9877277911");
        employee4.setDepartment(department2);


        Session session = sf.openSession();

        Transaction tx= session.beginTransaction();
        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        session.save(employee4);
        session.save(department1);
        session.save(department2);

        tx.commit();

        session.close();

        System.out.println("Done");

    }
}