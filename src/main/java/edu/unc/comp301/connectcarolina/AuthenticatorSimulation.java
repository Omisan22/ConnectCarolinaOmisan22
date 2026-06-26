package edu.unc.comp301.connectcarolina;

import java.util.ArrayList;
import java.util.List;

public class AuthenticatorSimulation {
  //    In AuthenticatorSimulation, write a main method that does the following:
  //    Create a student. Give it whatever name you want, and an ID, and give them 0 credits.
  //    Create an Adept object.
  //    Have your student scan an event for "Leadership Summit".
  //    Ensure that the output shows that the leadership summit was successful.
  //            Next, create a list of students, add your freshman to it, and use it to initialize
  // the student enrollment in Jedi.
  //    Create a boolean that represents the authentication window;
  //    in a try/catch block, authenticate your student on the proper day. If there are any errors,
  // catch it and print out the error.
  //    Finally, print out "Thank you for visiting ConnectCarolina". If it was successful, print
  // "You are authenticated for the next 10 minutes", otherwise, "You will have to authenticate
  // again".

  public static void main(String[] args)
      throws DuoAuthenticationFailedException,
          CLEAlreadyScannedException,
          CLEEventNotFoundException {
    //    Student s1 = new Student("John", 100000001, 2);
    Student s1 = new Student("John", 100000001, 0);
    List<String> scannedEvents = new ArrayList<>();

    Adept adept = new Adept();
    adept.validateScan("Leadership Summit", scannedEvents);

    List<Student> studentList = new ArrayList<>();
    studentList.add(s1);
    //  Jedi jedi = new Jedi();
    //      Jedi.initStudents(null);
    Jedi.initStudents(studentList);
    //    System.out.println(Jedi.duoAuthenticate(s1, "Wednesday"));

    System.out.println("Thank you for visiting ConnectCarolina");
    if (Jedi.duoAuthenticate(s1, "Wednesday")) {
      System.out.println("You are authenticated for the next 10 minutes");
    } else {
      System.out.println("You will have to authenticate again");
    }
  }
}
