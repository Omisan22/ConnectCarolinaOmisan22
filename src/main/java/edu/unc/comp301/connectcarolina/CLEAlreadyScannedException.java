package edu.unc.comp301.connectcarolina;

// Exceptions
//        CLEAlreadyScannedException
// This exception will be in the same folder as the rest of the files.
// create a custom Exception called CLEAlreadyScannedException()
// Give it a default error message of your choice, but also design it to accept custom messages.

public class CLEAlreadyScannedException extends Exception {
  public CLEAlreadyScannedException() {
    super("Default exception message");
  }

  public CLEAlreadyScannedException(String message) {
    super(message);
  }
}
