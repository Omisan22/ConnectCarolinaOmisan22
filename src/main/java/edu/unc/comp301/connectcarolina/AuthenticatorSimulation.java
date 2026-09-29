package edu.unc.comp301.connectcarolina;

import java.util.ArrayList;
import java.util.List;

public class AuthenticatorSimulation {

  public static void main(String[] args) {
    Student freshman = new Student("Rameses", 730123456, 0);

    Adept adept = new Adept();

    List<String> updated = adept.getCLECredits("Leadership Summit", freshman.getScannedCLEEvents());
    freshman.setCLEEvents(updated);

    List<Student> students = new ArrayList<>();
    students.add(freshman);
    Jedi.initStudents(students);

    boolean authWindow = false;
    try {
      authWindow = Jedi.duoAuthenticate(freshman, "Wednesday");
    } catch (DuoAuthenticationFailedException e) {
      System.out.println(e.getMessage());
    }

    System.out.println("Thank you for visiting ConnectCarolina");
    if (authWindow) {
      System.out.println("You are authenticated for the next 10 minutes");
    } else {
      System.out.println("You will have to authenticate again");
    }
  }
}
