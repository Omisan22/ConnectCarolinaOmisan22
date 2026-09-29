package edu.unc.comp301.connectcarolina;

public class DuoAuthenticationFailedException extends Exception {

  public DuoAuthenticationFailedException(String message) {
    super("Authentication failed: " + message);
  }
}
