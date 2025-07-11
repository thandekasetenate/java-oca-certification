import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TimeCapsule {

    // Fields
    private final String title;
    private String message;
    private final String date;  // format: "yyyy-MM-dd"
    private final String time;  // format: "HH:mm"
    private final String zone;  // e.g., "Asia/Tokyo"
    private boolean reminderSet;

    // Constructor
    public TimeCapsule(String title, String message, String date, String time, String zone, boolean reminderSet) {
        this.title = title;
        this.message = message;
        this.date = date;
        this.time = time;
        this.zone = zone;
        this.reminderSet = reminderSet;
    }

    // Getter for zone (used later)
    public String getZone() {
        return zone;
    }

    // Helper method to convert Strings to ZonedDateTime
    private ZonedDateTime getZonedDateTime() {
        LocalDate localDate = LocalDate.parse(date);          // Convert date string to LocalDate
        LocalTime localTime = LocalTime.parse(time);          // Convert time string to LocalTime
        ZoneId zoneId = ZoneId.of(zone);                      // Convert zone string to ZoneId
        return ZonedDateTime.of(localDate, localTime, zoneId); // Combine to ZonedDateTime
    }

    // Format output for displaying capsule info
    public String toFormattedString() {
        ZonedDateTime zonedDateTime = getZonedDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z");
        return title + " set for " + zonedDateTime.format(formatter);
    }

    // Main method
    public static void main(String[] args) {
        // Step 1: Create a list of capsules
        List<TimeCapsule> capsuleList = new ArrayList<>();

        // Step 2: Add sample capsules
        capsuleList.add(new TimeCapsule("Birthday", "Happy Birthday!", "2025-12-25", "10:00", "Asia/Tokyo", true));
        capsuleList.add(new TimeCapsule("Anniversary", "Celebrate our anniversary!", "2025-08-15", "09:30", "Europe/Paris", false));
        capsuleList.add(new TimeCapsule("Meeting", "Team meeting at 2 PM", "2025-07-10", "14:00", "America/New_York", true));

        // Step 3: Print all capsules
        System.out.println("All Time Capsules:");
        for (TimeCapsule capsule : capsuleList) {
            System.out.println(capsule.toFormattedString());
        }

        // Step 4: Filter and print only those in Asia/Tokyo timezone
        System.out.println("\nCapsules in Asia/Tokyo timezone:");
        for (TimeCapsule capsule : capsuleList) {
            if (capsule.getZone().equalsIgnoreCase("Asia/Tokyo")) {
                System.out.println(capsule.toFormattedString());
            }
        }

        // Step 5: Show remaining time for the first capsule
        TimeCapsule firstCapsule = capsuleList.getFirst();
        ZonedDateTime capsuleDateTime = firstCapsule.getZonedDateTime();
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(firstCapsule.getZone()));

        Duration duration = Duration.between(now, capsuleDateTime);
        long daysRemaining = duration.toDays();
        long minutesRemaining = duration.toMinutes() % 60;

        System.out.println("\nTime until " + firstCapsule.title + ": " + daysRemaining + " days and " + minutesRemaining + " minutes");

        // Step 6: Print the same date in French locale
        Locale locale = Locale.FRANCE;
        DateTimeFormatter frenchFormatter = DateTimeFormatter.ofPattern("d MMM yyyy", locale);
        System.out.println("Formatted (French): " + capsuleDateTime.format(frenchFormatter));
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isReminderSet() {
        return reminderSet;
    }

    public void setReminderSet(boolean reminderSet) {
        this.reminderSet = reminderSet;
    }
}

