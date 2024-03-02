import java.util.NoSuchElementException;

public class CourseManager extends SingletonController{

    protected static CourseManager singleton = null;
    private NotificationService notifier;
    private CourseScheduler scheduler;

    public static CourseManager getInstance() {
        if (singleton == null){
            singleton = new CourseManager();
        }
        return singleton;
    }

    private CourseManager() {
        notifier = NotificationService.getInstance();
        scheduler = CourseScheduler.getInstance();
    }

    public void addCourse(String[] data) throws DuplicateObjectException {
        new Course(data[0], data[1], data[2], data[3], data[4]);
    }

    public String getCourse(String[] data) throws NoSuchElementException {
        return Course.findCourse(data[0]);
    }

    public String[] getCourses() {
        return Course.getCourses();
    }

    public void deleteCourse(String[] data) throws NoSuchElementException {
        Course.removeCourse(data[0]);
    }

    public void updateCourse(String[] data) throws NoSuchElementException {
        Course.update(data);
    }

    public void scheduleCourse(String[] data) throws NoSuchElementException {
        String notifyEmail = scheduler.scheduleCourse(data[0], data[1], data[2], data[3], data[4], data[5]);
        notifier.queueEmail(notifyEmail, "Your course: " + data[1] + " has been scheduled for " + data[2] + " from " + data[3] + " to " + data[4] + ". \nThe course will be delivered by our friendly and experienced Triple S operator " + data[5]);

    }        
}
