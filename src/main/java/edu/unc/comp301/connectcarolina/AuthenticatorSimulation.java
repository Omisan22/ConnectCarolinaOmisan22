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
    Student s2 = new Student("Mary", 100000002, 3);
    //    Student s2 = new Student("John", 100000001, 0);
    List<String> scannedEvents = new ArrayList<>();

    Adept adept = new Adept();
    adept.validateScan("Leadership Summit", scannedEvents);
    List<Student> studentList = new ArrayList<>();
    studentList.add(s1);
    studentList.add(s2);
    // studentList.add(null);
    //    Jedi.initStudents(studentList);
    //    Jedi.initStudents(Collections.emptyList());
    //    Jedi.duoAuthenticate(null, "Monday");
    //  adept.getCLECredits("Leadership Summit", null);
    // Jedi.initStudents(null);
    System.out.println("Thank you for visiting ConnectCarolina");
    if (Jedi.duoAuthenticate(s2, "Wednesday")) {
      // if (Jedi.duoAuthenticate(null, "Wednesday")) {
      System.out.println("true");
      System.out.println("Leadership Summit");
      System.out.println("You are authenticated for the next 10 minutes");
      scannedEvents.add("Leadership Summit");
      s1.setCLEEvents(scannedEvents);
      adept.getCLECredits("Leadership Summit", s1.getScannedCLEEvents());
    } else {
      System.out.println("You will have to authenticate again");
    }
  }
}
