package edu.unc.comp301.connectcarolina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adept {
  private Map<String, String> cleEvents = new HashMap<>();
  private List<String> scannedEvents = new ArrayList<>() {};

  public Adept() {
    initCalendar();
  }

  public void initCalendar() {
    cleEvents.put("August 18", "Fall FDOC");
    cleEvents.put("September 05", "Honor Code Workshop");
    cleEvents.put("October 12", "Leadership Summit");
    cleEvents.put("November 03", "Community Service Night");
    cleEvents.put("December 01", "Study Skills Clinic");
    cleEvents.put("Ocotober 10", "Guest lectures by faculty");
    cleEvents.put("November 20", "Panel discussions on current events");
  }

  //  Validating the Scan
  //  The idea is that we're scanning in event (passing it's name through the parameter), and
  // outputting confirmation
  //  that the CLE credit has been awarded or throwing and handling exceptions.
  //
  //  Make a new method called validateScan that will take the name of the event, and List<String>
  // field called
  //  scannedEvents (that contains events that the student has already scanned) as parameters and
  // returns nothing when finished.
  //  These are checked exceptions so you will have to specify them in the method header.
  //  Validate that the hashmap of CLE Events contains the scanned event
  //  If not, throw a CLEEventNotFoundException and include an appropriate message
  //  Next, validate that the scanned event hasn't already been scanned using the List you created
  // earlier
  //  If it is you'll use the given exception CLEAlreadyScannedException!
  //  If both of these checks are passed, fantastic! The scan has been validated.

  public void validateScan(String eventName, List<String> scannedEvents) throws Exception {
    if (!cleEvents.containsKey(eventName)) {
      throw new CLEEventNotFoundException("event not found");
    }
    if (scannedEvents.contains(eventName)) {
      throw new CLEAlreadyScannedException("event already scanned!");
    }
  }

  //  getCLECredits
  //  Finally, we are ready to give students a chance to earn those credits!
  //
  //  Define a new method called getCLECredits that also takes in the name of the event, and
  // List<String> field called
  //  scannedEvents (that contains events that the student has already scanned) as parameters
  //  This method will return a modified List<String> upon completion.
  //  In a try/catch block  validate that the scan
  //  If and only if it is successful, add it to the scannedEvents list and print "Thank you for
  // attending!"
  //  If you catch either of the thrown exceptions, print "Error scanning event: " along with the
  // message of the exception
  //  Finally, print "CLE credit processed for: [eventname]"
  //  Return the scannedEvents back to the caller either in its original state if it wasn't valid,
  // or with the added event if everything went through properly.

  public void getCLECredits(String eventName, List<String> scannedEvents) {

    try {
      validateScan(eventName, scannedEvents);
    } catch (Exception e) {
      System.out.println("Error scanning event:" + e.getMessage());
    }
    System.out.println("Thank you for attending!");
    scannedEvents.add(eventName);
    System.out.println("CLE credit processed for: " + eventName);
  }
}
