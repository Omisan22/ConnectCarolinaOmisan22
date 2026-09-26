package edu.unc.comp301.connectcarolina;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Jedi {

    private static Map<String, Set<Student>> enrollment = new HashMap<>();

    public static String calculateValidDay(double credits) {
        if (credits >= 0 && credits <= 55) {
            return "Wednesday";
        } else if (credits > 55 && credits <= 100) {
            return "Tuesday";
        } else if (credits > 100) {
            return "Monday";
        } else {
            throw new IllegalArgumentException("Invalid number of credits: " + credits);
        }
    }

    public static void initStudents(List<Student> students) {
        enrollment = new HashMap<>();
        enrollment.put("Monday", new HashSet<>());
        enrollment.put("Tuesday", new HashSet<>());
        enrollment.put("Wednesday", new HashSet<>());
        enrollment.put("Thursday", new HashSet<>());
        enrollment.put("Friday", new HashSet<>());

        if (students == null) {
            return;
        }

        for (Student student : students) {
            if (student == null) {
                continue;
            }
            try {
                String day = calculateValidDay(student.getCredits());
                enrollment.get(day).add(student);
            } catch (IllegalArgumentException e) {
                System.out.println("Credits for " + student.getName() + " are not valid.");
            }
        }
    }

    public static boolean duoAuthenticate(Student student, String day)
            throws DuoAuthenticationFailedException {

        boolean authenticated = false;

        if (student == null) {
            throw new DuoAuthenticationFailedException("Student cannot be null.");
        }
        if (day == null) {
            throw new DuoAuthenticationFailedException("Day cannot be null.");
        }

        int studentID = student.getStudentID();

        if (studentID < 100000000 || studentID > 999999999) {
            throw new DuoAuthenticationFailedException("Student ID must be 9 digits.");
        }

        String validDay;
        try {
            validDay = calculateValidDay(student.getCredits());
        } catch (IllegalArgumentException e) {
            throw new DuoAuthenticationFailedException("Student has invalid credits.");
        }
        if (!validDay.equals(day)) {
            throw new DuoAuthenticationFailedException(
                    "Today is not " + student.getName() + "'s registration day.");
        }

        Set<Student> studentsToday = enrollment.get(day);
        if (studentsToday == null || !studentsToday.contains(student)) {
            throw new DuoAuthenticationFailedException(
                    student.getName() + " is not on the list of students registering today.");
        }

        System.out.println("Duo authentication successful! Welcome, " + student.getName() + ".");
        authenticated = true;
        return authenticated;
    }
}