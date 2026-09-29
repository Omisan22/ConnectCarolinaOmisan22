package edu.unc.comp301.connectcarolina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adept {

  private Map<String, String> cleEvents;

  public Adept() {
    cleEvents = new HashMap<>();
    initCalendar();
  }

  public void initCalendar() {
    cleEvents.put("August 18", "Fall FDOC");
    cleEvents.put("September 05", "Honor Code Workshop");
    cleEvents.put("October 12", "Leadership Summit");
    cleEvents.put("November 03", "Community Service Night");
    cleEvents.put("December 01", "Study Skills Clinic");
    // Two events of your choice
    cleEvents.put("October 30", "Halloween Career Fair");
    cleEvents.put("November 18", "Resume Review Night");
  }

  public void validateScan(String eventName, List<String> scannedEvents)
      throws CLEEventNotFoundException, CLEAlreadyScannedException {

    if (eventName == null || !cleEvents.containsValue(eventName)) {
      throw new CLEEventNotFoundException(
          "Event \"" + eventName + "\" was not found in the CLE calendar.");
    }

    if (scannedEvents != null && scannedEvents.contains(eventName)) {
      throw new CLEAlreadyScannedException("You have already scanned \"" + eventName + "\".");
    }
  }

  public List<String> getCLECredits(String eventName, List<String> scannedEvents) {
    if (scannedEvents == null) {
      scannedEvents = new ArrayList<>();
    }
    try {
      validateScan(eventName, scannedEvents);
      scannedEvents.add(eventName);
      System.out.println("Thank you for attending!");
    } catch (CLEEventNotFoundException | CLEAlreadyScannedException e) {
      System.out.println("Error scanning event: " + e.getMessage());
    } finally {
      System.out.println("CLE credit processed for: " + eventName);
    }
    return scannedEvents;
  }
}
