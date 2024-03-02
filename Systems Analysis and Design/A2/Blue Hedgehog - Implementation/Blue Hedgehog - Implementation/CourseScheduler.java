import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

public class CourseScheduler extends SingletonController{

    protected static CourseScheduler singleton = null;

    public static CourseScheduler getInstance() {
        if (singleton == null){
            singleton = new CourseScheduler();
        }
        return singleton;
    }
    
    public List<Operator> getAvailableOperators(LocalDateTime start, LocalDateTime end){
        List<Operator> ops = Operator.getOperators();
        for (Operator op : ops) {
            if (!(op.isOperatorAvailable(start, end))) ops.remove(op);
        }
        return ops;
    }

    public String scheduleCourse(String courseName, String schoolName, String operatorName, String deliveryDate, String startTime, String endTime) throws NoSuchElementException{
        Course course = Course.getCourse(courseName);
        CourseOffering offering = course.addOffering(School.getSchool(schoolName), new LocalDate(deliveryDate), new LocalTime(startTime), new LocalTime(endTime));
        offering.setAssignedOperatorByName(operatorName);
        return offering.getRequestingSchool().getContactEmail();
    }
}
