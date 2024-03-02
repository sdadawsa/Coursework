import java.util.ArrayList;
import java.util.List;

public class NotificationService extends SingletonController implements Runnable {
    protected static NotificationService singleton = null;
    private List<String[]> messageQueue = new ArrayList<>();
    private SMTPService emailer;
    private FaxService fax;
    private String notificationType; //Added this type to distinguish

    public static NotificationService getInstance() {
        if (singleton == null){
            singleton = new NotificationService();
        }
        return singleton;
    }

    @Override
    public void run() {
        if (notificationType == "email") {
            emailer = new SMTPService();
            while (true) {
                for (String[] message : messageQueue) {
                    emailer.sendEmail(message[0], "Your Triple S course has been scheduled", message[1]);
                }
            }
        }
        else if (notificationType == "fax") {
            fax = new FaxService();
            while (true) {
                for (String[] message : messageQueue) {
                    fax.sendFax(message[0], "Your Triple S course has been scheduled" + message[1]);
                }
            }
        }
    }

    public void queueEmail(String recipient, String message) {
        messageQueue.add(new String[] {recipient, message});
        notificationType = "email";
    }

    //Added, basically functions the same as queueEmail()
    public void queueFax(String faxNumber, String message) {
        messageQueue.add(new String[] {faxNumber, message});
        notificationType = "fax";
    }

    @Override
    public void finalize(){
        emailer = null;
        fax = null;
    }

    
}
