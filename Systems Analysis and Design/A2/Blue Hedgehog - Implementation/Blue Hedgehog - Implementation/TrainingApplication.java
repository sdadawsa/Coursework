// *** This class is the entry point for this sub-system. Start your analysis here ***

public class TrainingApplication {
    
    private UserInterface currentView = null;
    private UserInterface previousView = null;
    private NotificationService notifier = null;
    private Thread notificationServiceThread = null;

    private static TrainingApplication singleton = null;

    private TrainingApplication(){
        currentView = new TrainingMenu();
        notifier = NotificationService.getInstance();
        notificationServiceThread = new Thread(notifier);
        notificationServiceThread.start();
    }

    // This is the start point, some other class from the system would call this
    public static TrainingApplication getInstance() {
        if (singleton == null) {
            singleton = new TrainingApplication();
        }
        return singleton;
    }

    public static TrainingApplication resetInstance() {
        if (singleton != null) {singleton.notificationServiceThread.stop();}
        singleton = null;
        singleton = new TrainingApplication();
        return singleton;
    }

    public void run() {
        while (currentView != null && previousView != null) {
            currentView.initializeView();
            String nextView = currentView.eventLoop();
            if (nextView == null) {
                currentView = previousView;
                previousView = null;
            }
            else {
                previousView = currentView;
                currentView = null;
                switch (nextView) {
                    case "SchoolView":
                        currentView = new SchoolView();
                        break;
                    case "CourseView":
                        currentView = new CourseView();
                        break;
                    default:
                        currentView = new TrainingMenu();
                }
            }
        }
        notificationServiceThread.stop();
        notifier = null;
        notificationServiceThread = null;
    }    
}
