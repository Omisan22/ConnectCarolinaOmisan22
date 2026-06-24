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
        day = calculateValidDay(s.getCredits());
        studentsSet = enrollment.get(day);
        studentsSet.add(s);
        enrollment.put(day, studentsSet);
      } catch (IllegalArgumentException e) {
        System.out.println("Student: " + s.getName() + " credits weren’t valid");
      }
    }
  }
}
