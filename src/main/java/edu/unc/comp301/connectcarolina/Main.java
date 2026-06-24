package edu.unc.comp301.connectcarolina;

public class Main {
  public static void main(String[] args) {
    //    System.out.println("Assignment 03 - Connect Carolina");
    String[] grades = {"A", "B"};
    //    String[] grades = {null};
    System.out.println(Novice.calculateGPA(2, grades));

    Adept adept = new Adept();
    System.out.println(adept.cleEvents.containsKey("Fall FDOC"));
    System.out.println(adept.cleEvents.containsKey("August 18"));
    System.out.println(adept.cleEvents.containsValue("Fall FDOC"));
    System.out.println(adept.cleEvents.containsValue("August 18"));
  }
}
