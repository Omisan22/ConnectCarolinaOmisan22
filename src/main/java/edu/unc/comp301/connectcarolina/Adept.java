package edu.unc.comp301.connectcarolina;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adept {
  private Map<String, String> cleEvents = new HashMap<>();

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
}
