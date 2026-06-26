package edu.unc.comp301.connectcarolina;

import java.util.HashMap;
import java.util.Map;

public class Novice {

  private static final Map<String, Double> GRADE_MAP = new HashMap<>();

  static {
    GRADE_MAP.put("A", 4.0);
    GRADE_MAP.put("A-", 3.7);
    GRADE_MAP.put("B+", 3.3);
    GRADE_MAP.put("B", 3.0);
    GRADE_MAP.put("B-", 2.7);
    GRADE_MAP.put("C+", 2.3);
    GRADE_MAP.put("C", 2.0);
    GRADE_MAP.put("C-", 1.7);
    GRADE_MAP.put("D+", 1.3);
    GRADE_MAP.put("D", 1.0);
    GRADE_MAP.put("F", 0.0);
  }

  public static String calculateGPA(int numOfClasses, String[] grades) {
    if (grades == null) throw new IllegalArgumentException("grades is null");
    if (numOfClasses <= 0) {
      throw new IllegalArgumentException("Number of classes is 0 (negative response)");
    }
    if (grades.length != numOfClasses) {
      throw new IllegalArgumentException(
          "number of elements in the grades mismatches the number of classes");
    }
    double cgpa = 0.0;
    double grade;
    for (int i = 0; i < grades.length; i++) {
      grade = charToGrade(grades[i]);
      if (grade < 0) throw new IllegalArgumentException("invalid grade");
      cgpa += grade;
    }
    cgpa = cgpa / numOfClasses;
    return ("Your calculated GPA is: " + cgpa);
  }

  public static double charToGrade(String grade) {
    if (grade == null) {
      return -1; // handle null input gracefully
    }
    Double value = GRADE_MAP.get(grade.toUpperCase());
    return (value == null) ? -1 : value;
  }
}
