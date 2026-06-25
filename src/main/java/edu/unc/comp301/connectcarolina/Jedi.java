package edu.unc.comp301.connectcarolina;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Jedi {

  //    calculateValidDay
  //    Ever try to add a class and it's already full? Maybe the system is giving people earlier
  // registration days than
  //    it should! This helper method will help calculate the valid day of the week that a student
  // with a certain
  //    amount of credits should get to register for classes.
  //
  //    Write a new method that has one parameter for the number of credits (We need to support half
  // credits as well),
  //    and output a string of a day of the week.
  //
  //    This is a utility method which means, it's going to be static.
  //
  //    If credits are between 0 and 55 (both inclusive), student's registration day should be
  // Wednesday
  //    If the credits are more than 55 and up to (inclusive) 100, student's registration day should
  // be Tuesday
  //    If the student has more than 100 credits, they get the first day - Monday!
  //    Otherwise, this means that the input was invalid and throw an IllegalArgumentException
  public static String calculateValidDay(double credits) throws IllegalArgumentException {
    if ((credits >= 0.0) && (credits <= 55.0)) return "Wednesday";
    if ((credits > 55) && (credits <= 100.0)) return "Tuesday";
    if (credits > 100.0) return "Monday";
    else throw new IllegalArgumentException("Illegal argument");
  }

  //  Creating the enrollment Map
  //  Before we can authenticate anyone, we need to keep track of which students belong to which
  // registration day.
  //
  //  Define a new instance variable called enrollment, which should map a String day of the week to
  // a set of students.
  //
  //  In addition to private, it should be static so that there is only one copy of the proper
  // enrollment list.
  //  The key will be the day of the week (e.g., "Monday", "Tuesday").
  //  The value will be a data collection set of Student containing all students assigned to that
  // day.

  private static Map<String, Set<Student>> enrollment = new HashMap<>();

  //  Create a new method called initStudents() that takes in a List<Student> and returns nothing.
  // Instead, it will:
  //  Initialize the map with the weekdays ("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
  // each pointing to an empty Set.
  //  Loop through the provided students:
  //  Use the helper calculateValidDay() to figure out which registration day matches their number
  // of credits.
  //  Add the student to the appropriate Set in the map.
  //  If a student has invalid credits (like negative numbers), catch the IllegalArgumentException
  // and print an error message saying their credits weren’t valid.
  //  note: We are creating a static utility class. Because of that, we won't need to call a
  // constructor, so therefor we aren't making one.

  public static void initStudents(List<Student> studentsList) {
    enrollment.put("Monday", null);
    enrollment.put("Tuesday", null);
    enrollment.put("Wednesday", null);
    enrollment.put("Thursday", null);
    enrollment.put("Friday", null);
    String day;
    Set<Student> studentsSet;
    for (Student s : studentsList) {
      try {
        if (s == null) throw new IllegalArgumentException("null student");
        day = calculateValidDay(s.getCredits());
        studentsSet = enrollment.get(day);
        if (studentsSet == null) throw new IllegalArgumentException("null student set");
        studentsSet.add(s);
        enrollment.put(day, studentsSet);
      } catch (IllegalArgumentException e) {
        System.out.println("Student: " + s.getName() + " credits weren’t valid");
      }
    }
  }

  //  duoAuthenticate
  //  Have you ever been tired of authenticating duo everytime you open ConnectCarolina? Especially
  // on registration days,
  //  when you don't want to miss those precious seconds to a stupid notification on your phone
  // asking you if you're
  //  logging in to your computer? I'm just trying to make sure I get those gen-eds fulfilled :/
  //
  //  Now, you will create a method that will help the system start a short no authentication window
  // when a student opens
  //  ConnectCarolina on their registration day. You will simulate what Duo should do: recognize
  // that if a student logs
  //  in on their assigned Registration Day, require no further authentication by starting a
  // 10-minute window representation
  //  by a boolean variable. -- The idea is that if this boolean is true, the window is active, and
  // vice versa.
  //
  //  duoAuthenticate will take 2 parameters - one for the Student and one for the day the student
  // is logging in on
  //  It will return the true/false value that we talked about above
  //  This method will use calculateValidDay() that we implemented earlier; You can get the number
  // of credits that a
  //  student has by using student.getCredits();
  //  Create a variable that will store the authentication true/false value. Remember that the idea
  // is that if this value
  //  is true, that means the 10 minute no authentication window is open.
  //  Grab the students ID from the student passed in.
  //          First, validate that the student ID is valid (is 9 digits)
  //  If not, throw the DuoAuthenticationFailedException that you just made with an appropriate
  // message

  //  Check to see if the current day is the student's registration day.

  //  If it is, validate that the student is actually in the list of students allowed to register
  // today.

  //  If either of these is not true, throw a DuoAuthenticationFailedException with an appropriate
  // message.
  //  Once the student has been validated, print "Duo authentication successful! Welcome, Bob.",
  // using the student's name
  //  in the message. Once finished, remember to return your boolean value!
  public boolean duoAuthenticate(Student student, String day)
      throws DuoAuthenticationFailedException {
    final int MINID = 100000000;
    final int MAXID = 999999999;
    int id = student.getStudentID();
    try {
      if (student == null) throw new DuoAuthenticationFailedException("student is null");
      if ((id < MINID) || (id > MAXID))
        throw new DuoAuthenticationFailedException("invalid student id for student: ");
      //            "invalid student id for student: " + student.getName());
      if (day.equals(calculateValidDay(student.getCredits()))) {
        Set<Student> studentsSet = enrollment.get(day);
        if (!studentsSet.contains(student)) {
          throw new DuoAuthenticationFailedException(
              "student is not in the list of allowed students");
        }
      } else throw new DuoAuthenticationFailedException("student is not allowed to register today");

      System.out.println("Duo authentication successful! Welcome, " + student.getName());
      return true;
    } catch (DuoAuthenticationFailedException e) {
      return false;
    }
  }
}
