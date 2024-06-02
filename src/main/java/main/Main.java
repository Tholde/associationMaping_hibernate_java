package main;

import database.Database;
import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in).useDelimiter("\n");
                System.out.println("1-One to one");
                System.out.println("2-Many to One and One to Many");
                System.out.println("3-Many to many");
                System.out.println("4-Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        OneToOne();
                        break;
                    case 2:
                        ManyToOneAndOneToMany();
                        break;
                    case 3:
                        ManyToMany();
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }

    }

    public static void OneToOne() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        /* ************** One to One ********************** */
        Passport passport = new Passport();
        passport.setCountry("Madagascar");

        Person person = new Person();
        person.setName("Tholde");
        person.setPassport(passport);
//        session.save(passport);
        session.save(person);
        //        tx.commit();
        session.flush();
        session.close();
        factory.close();
    }

    public static void ManyToOneAndOneToMany() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        /* *************** One to Many ******************** */
        Member m1 = new Member();
        Member m2 = new Member();
        Member m3 = new Member();
        Member m4 = new Member();
        Association association1 = new Association();
        m1.setName("Elphin");
        m1.setMember_code(40195);
        m2.setName("Safidy");
        m2.setMember_code(10186);
        m3.setName("Sayno");
        m3.setMember_code(10196);
        m4.setName("Tahina");
        m4.setMember_code(40160);

        List<Member> members = new ArrayList<Member>();
        members.add(m1);
        members.add(m2);
        members.add(m3);
        members.add(m4);
        association1.setName("Jerosalema City");
        association1.setMembers(members);
        session.save(m1);
        session.save(m2);
        session.save(m3);
        session.save(m4);
        session.save(association1);
        //        tx.commit();
        session.flush();
        session.close();
        factory.close();
    }

    public static void ManyToMany() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();
        Cours cours1 = new Cours();
        Cours cours2 = new Cours();
        List<Student> students = new ArrayList<>();
        List<Cours> courses = new ArrayList<>();

        student1.setStudentId(30153);
        student2.setStudentId(30154);
        student3.setStudentId(30155);
        student4.setStudentId(30156);

        student1.setName("Tholde");
        student2.setName("Famonjena");
        student3.setName("Manaja");
        student4.setName("Samara");

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        cours1.setTitle("Cybersecurity");
        cours1.setCredit(6);
        cours1.setStudents(students);
        cours2.setTitle("Attack and Security");
        cours2.setCredit(8);
        cours2.setStudents(students);

        courses.add(cours1);
        courses.add(cours2);

        student1.setCours(courses);
        student2.setCours(courses);
        student3.setCours(courses);
        student4.setCours(courses);

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.save(cours1);
        session.save(cours2);

//        tx.commit();
        session.flush();
        session.close();
        factory.close();
    }
}
