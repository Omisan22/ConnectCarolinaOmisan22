package edu.unc.comp301.connectcarolina;

import java.util.*;

public class Jedi {

  public static String calculateValidDay(double credits) throws IllegalArgumentException {
    if ((credits >= 0.0) && (credits <= 55.0)) return "Wednesday";
    if ((credits > 55) && (credits <= 100.0)) return "Tuesday";
    if (credits > 100.0) return "Monday";
    else throw new IllegalArgumentException("Illegal argument");
  }

  private static Map<String, Set<Student>> enrollment = new HashMap<>();

  public static void initStudents(List<Student> studentsList) throws IllegalArgumentException {
    //    public static void initStudents(List<Student> studentsList) {
    enrollment.put("Monday", null);
    enrollment.put("Tuesday", null);
    enrollment.put("Wednesday", null);
    enrollment.put("Thursday", null);
    enrollment.put("Friday", null);
    String day;
    Set<Student> studentsSet;
    if (studentsList == null) throw new IllegalArgumentException("students list is null");
    for (Student s : studentsList) {
      try {
        if (s == null) throw new IllegalArgumentException("null student");
        day = calculateValidDay(s.getCredits());
        studentsSet = enrollment.get(day);
        //        if (studentsSet == null) throw new IllegalArgumentException("null student set");
        if (studentsSet == null) studentsSet = new HashSet<>();
        studentsSet.add(s);
        enrollment.put(day, studentsSet);
      } catch (IllegalArgumentException e) {
        System.out.println("Student: credits weren’t valid");
        //        System.out.println("Student: " + s.getName() + " credits weren’t valid");
      }
    }
  }

  public static boolean duoAuthenticate(Student student, String day)
      throws DuoAuthenticationFailedException {
    final int MINID = 100000000;
    final int MAXID = 999999999;
    //    if (student == null) throw new DuoAuthenticationFailedException("student is null");
    int id = student.getStudentID();
    //    boolean returnValue = false;
    //    try {
    if ((id < MINID) || (id > MAXID))
      throw new DuoAuthenticationFailedException("invalid student id for student: ");
    //            "invalid student id for student: " + student.getName());
    if (day.equals(calculateValidDay(student.getCredits()))) {
      Set<Student> studentsSet = enrollment.get(day);
      if (studentsSet == null) throw new DuoAuthenticationFailedException("studentsSet is null");
      if (!studentsSet.contains(student)) {
        throw new DuoAuthenticationFailedException(
            "student is not in the list of allowed students");
      }
    } else throw new DuoAuthenticationFailedException("student is not allowed to register today");

    System.out.println("Duo authentication successful! Welcome, " + student.getName());
    return true;
    //    } catch (DuoAuthenticationFailedException e) {
    //      System.out.println(e.getMessage());
    //      return false;
    //    }
  }
}
