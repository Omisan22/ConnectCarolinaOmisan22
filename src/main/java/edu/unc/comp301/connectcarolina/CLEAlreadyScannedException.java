package edu.unc.comp301.connectcarolina;

public class CLEAlreadyScannedException extends Exception {

    public CLEAlreadyScannedException() {
        super("This CLE event has already been scanned.");
    }

    public CLEAlreadyScannedException(String message) {
        super(message);
    }
}