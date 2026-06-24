package edu.unc.comp301.connectcarolina;

// The exception should output "Authentication failed: " followed by the message taken through the
// parameter.
// Example output: "Authentication failed, Student ID or day does not match."

public class DuoAuthenticationFailedException extends Exception {
  public DuoAuthenticationFailedException(String message) {
//    String m2 = "Authentication failed: " + message;
    super("Authentication failed: " + message);
  }
}
