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

  public void validateScan(String eventName, List<String> scannedEvents)
      throws CLEEventNotFoundException, CLEAlreadyScannedException {
    if (!cleEvents.containsValue(eventName)) {
      throw new CLEEventNotFoundException("event not found");
    }
    if (scannedEvents.contains(eventName)) {
      throw new CLEAlreadyScannedException("event already scanned!");
    }
  }

  public void getCLECredits(String eventName, List<String> scannedEvents) {
    if (scannedEvents == null) throw new IllegalArgumentException("scanned events is null");
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
