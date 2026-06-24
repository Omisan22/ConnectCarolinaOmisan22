package edu.unc.comp301.connectcarolina;

public class Jedi {

//    calculateValidDay
//    Ever try to add a class and it's already full? Maybe the system is giving people earlier registration days than
//    it should! This helper method will help calculate the valid day of the week that a student with a certain
//    amount of credits should get to register for classes.
//
//    Write a new method that has one parameter for the number of credits (We need to support half credits as well),
//    and output a string of a day of the week.
//
//    This is a utility method which means, it's going to be static.
//
//    If credits are between 0 and 55 (both inclusive), student's registration day should be Wednesday
//    If the credits are more than 55 and up to (inclusive) 100, student's registration day should be Tuesday
//    If the student has more than 100 credits, they get the first day - Monday!
//    Otherwise, this means that the input was invalid and throw an IllegalArgumentException
    public static String calculateValidDay(double credits) throws IllegalArgumentException {
        if ((credits >= 0.0) && (credits <= 55.0))
            return "Wednesday";
        if ((credits > 55 ) && (credits <= 100.0))
            return "Tuesday";
        if (credits > 100.0 )
            return "Monday";
        else throw new IllegalArgumentException("Illegal argument");
    }


}
