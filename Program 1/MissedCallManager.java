// MissedCallManager.java
import java.util.*;

public class MissedCallManager {
    private Map<String, String> contactList;
    private List<String> missedCallList;

    public MissedCallManager() {
        contactList = new HashMap<>();
        missedCallList = new ArrayList<>();
    }

    public void addContact(String name, String phoneNumber) {
        contactList.put(phoneNumber, name);
    }

    public void acceptMissedCall(String phoneNumber) {
        String callerDetails = contactList.getOrDefault(phoneNumber, "Private Caller") + " (" + phoneNumber + ")";
        missedCallList.add(callerDetails);
    }

    public void displayMissedCalls() {
        System.out.println("Missed Calls:");
        missedCallList.forEach(System.out::println);
    }

    public void deleteNumber(String phoneNumber) {
        contactList.remove(phoneNumber);
    }
}
