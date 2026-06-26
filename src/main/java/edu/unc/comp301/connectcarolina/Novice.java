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

  //  Create a static method called calculateGPA that inputs the number of classes a student is
  // taking and an array of grades (Strings represented as "A", "A-" ... "D","F") for
  // each class and returns a sentence that includes the
  //  student's total GPA (more info in a moment)
  //  check out the range of official gradepoints at https://registrar.unc.edu/your-grades/
  //  First, check if the number of classes are invalid (must be positive), and that the number of
  // elements in the grades array matches the number of classes
  //  If these tests fail, throw an IllegalArgumentException with an appropriate output
  //  Then, we'll calculate the GPA
  //  You'll use the given helper method charToGrade() to convert these letter grades into doubles
  //  charToGrade() inputs a string (such as "A-") and outputs the corresponding GPA
  // if it outputs -1, then the input was invalid!
  //  Before summing these doubles, ensure that the output from charToGrade was valid!
  //  If not, throw an IllegalArgumentException with the appropriate message
  //  Sum up the given values for each class by going through all the values of the array containing
  // letter grades and then divide this sum by the number of classes
  //  Lastly, return the string: "Your calculated GPA is: [calculated GPA]"
  //    A = 4.0
  //    A- = 3.7
  //    B+ = 3.3
  //    B = 3.0
  //    B- = 2.7
  //    C+ = 2.3
  //    C = 2.0
  //    C- = 1.7
  //    D+ = 1.3
  //    D = 1.0
  //    F = 0.0
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
