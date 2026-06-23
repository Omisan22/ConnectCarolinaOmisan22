package edu.unc.comp301.connectcarolina;

import java.util.HashMap;
import java.util.Map;

// Exceptions
//        CLEAlreadyScannedException
// This exception will be in the same folder as the rest of the files.
// create a custom Exception called CLEAlreadyScannedException()
// Give it a default error message of your choice, but also design it to accept custom messages.
// CLEEventNotFoundException
// Repeat the steps above to create another custom exception with one difference: this one should
// only take in a custom message and have no default.
// Validating the Scan
// The idea is that we're scanning in event (passing it's name through the parameter), and
// outputting confirmation that the CLE credit has been awarded or throwing and handling exceptions.
//
// Make a new method called validateScan that will take the name of the event, and List<String>
// field called scannedEvents (that contains events that the student has already scanned) as
// parameters and returns nothing when finished.
// These are checked exceptions so you will have to specify them in the method header.
// Validate that the hashmap of CLE Events contains the scanned event
// If not, throw a CLEEventNotFoundException and include an appropriate message
// Next, validate that the scanned event hasn't already been scanned using the List you created
// earlier
// If it is you'll use the given exception CLEAlreadyScannedException!
// If both of these checks are passed, fantastic! The scan has been validated.
//        getCLECredits
// Finally, we are ready to give students a chance to earn those credits!
//
// Define a new method called getCLECredits that also takes in the name of the event, and
// List<String> field called scannedEvents (that contains events that the student has already
// scanned) as parameters
// This method will return a modified List<String> upon completion.
// In a try/catch block
// validate that the scan
// If and only if it is successful, add it to the scannedEvents list and print "Thank you for
// attending!"
// If you catch either of the thrown exceptions, print "Error scanning event: " along with the
// message of the exception
// Finally, print "CLE credit processed for: [eventname]"
// Return the scannedEvents back to the caller either in its original state if it wasn't valid, or
// with the added event if everything went through properly.
public class Adept {

  // Define a new instance variable called cleEvents, which should map a String date to a String
  // name of event.
  Map<String, String> cleEvents = new HashMap<>();

  public Adept() {
    initCalendar();
  }

  // Create a new method called initCalendar() that takes in no parameters, and returns nothing.
  // Instead, it should have the side effect of populating our event calendar with the following
  // events:
  //        "August 18": "Fall FDOC"
  //        "September 05": "Honor Code Workshop"
  //        "October 12": "Leadership Summit"
  //        "November 03": "Community Service Night"
  //        "December 01": "Study Skills Clinic"
  public void initCalendar() {
    cleEvents.put("August 18", "Fall FDOC");
    cleEvents.put("September 05", "Honor Code Workshop");
    cleEvents.put("October 12", "Leadership Summit");
    cleEvents.put("November 03", "Community Service Night");
    cleEvents.put("December 01", "Study Skills Clinic");
    cleEvents.put("Ocotober 10", "Guest lectures by faculty");
    cleEvents.put("November 20", "Panel discussions on current events");
    // Add two more events of your choice.
    //        Finally, initialize the calendar in the constructor.

  }
}
