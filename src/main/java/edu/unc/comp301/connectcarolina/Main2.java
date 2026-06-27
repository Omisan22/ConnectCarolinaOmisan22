package edu.unc.comp301.connectcarolina;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
  // package edu.unc.comp301.connectcarolina;
  //
  // import java.util.ArrayList;
  // import java.util.List;
  //
  // public class AuthenticatorSimulation {

  public static void main(String[] arg) {
    Student s = new Student("b0b", 123456789, 0);
    Adept tim = new Adept();

    tim.getCLECredits("Leadership Summit", s.getScannedCLEEvents());

    List<Student> students = new ArrayList<>();
    students.add(s);
    Jedi.initStudents(students);

    boolean window = false;
    try {
      window = Jedi.duoAuthenticate(s, "Wednesday");
    } catch (DuoAuthenticationFailedException e) {
      System.out.println(e.getMessage());
    } finally {
      System.out.println("Thank you for visiting ConnectCarolina");
      if (window) {
        System.out.println("You are authenticated for the next 10 minutes");
      } else {
        System.out.println("You will have to authenticate again");
      }
    }
  }
}
