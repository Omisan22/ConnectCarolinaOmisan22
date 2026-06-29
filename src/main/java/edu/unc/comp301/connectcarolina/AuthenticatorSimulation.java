package edu.unc.comp301.connectcarolina;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuthenticatorSimulation {
  public static void main(String[] args)
      throws DuoAuthenticationFailedException,
          CLEAlreadyScannedException,
          CLEEventNotFoundException {
    Student s1 = new Student("John", 100000001, 2);

    Adept adept = new Adept();
    adept.getCLECredits("Leadership Summit", s1.getScannedCLEEvents());
    List<Student> studentList = new ArrayList<>();
    studentList.add(s1);
    Jedi.initStudents(studentList);
    System.out.println("Thank you for visiting ConnectCarolina");
    if (Jedi.duoAuthenticate(s1, "Wednesday")) {
      //    if (Jedi.duoAuthenticate(null, "Wednesday")) {
      //      System.out.println("true");
      //      System.out.println("Leadership Summit");
      System.out.println("You are authenticated for the next 10 minutes");
    } else {
      System.out.println("You will have to authenticate again");
    }
  }
}
