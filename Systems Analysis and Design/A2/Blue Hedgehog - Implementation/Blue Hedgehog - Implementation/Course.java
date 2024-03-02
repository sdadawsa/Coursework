import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Course {
    private String courseName;
    private String courseDescription;
    private String content;
    private String learningOutcomes;
    private CourseType courseType;
    private List<CourseOffering> offerings = new ArrayList<>();
    private static List<Course> courses = new ArrayList<>();

    public Course() {
        courses.add(this);
    }

    public Course(String courseName, String courseType, String courseDescription, String content, String learningOutcomes) throws DuplicateObjectException {
        this.courseName = courseName;
        if (courseType.equals("fire")) this.courseType = new FireSafetyCourse();
        else if (courseType.equals("medical")) this.courseType = new MedicalEmergencyCourse();
        this.courseDescription = courseDescription;
        this.content = content;
        this.learningOutcomes = learningOutcomes;
        if (courses.contains(this)) {throw new DuplicateObjectException();}
        courses.add(this);
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return this.courseType.getType();
    }

    public void setCourseType(String courseType) {
        if (courseType.equals("fire")) this.courseType = new FireSafetyCourse();
        else if (courseType.equals("medical")) this.courseType = new MedicalEmergencyCourse();
    }

    public String getCourseDescription() {
        return this.courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLearningOutcomes() {
        return this.learningOutcomes;
    }

    public void setLearningOutcomes(String learningOutcomes) {
        this.learningOutcomes = learningOutcomes;
    }

    public List<CourseOffering> getOfferings() {
        return this.offerings;
    }

    public void setOfferings(List<CourseOffering> offerings) {
        this.offerings = offerings;
    }

    public CourseOffering addOffering(School requestingSchool, LocalDate deliveryDate, LocalTime startTime, LocalTime endTime)
    {
        CourseOffering newOffering = new CourseOffering(this, requestingSchool, deliveryDate, startTime, endTime);
        offerings.add(newOffering);
        return newOffering;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Course)) {
            return false;
        }
        Course course = (Course) o;
        return Objects.equals(courseName, course.courseName) && Objects.equals(courseType, course.courseType) && Objects.equals(courseDescription, course.courseDescription) && Objects.equals(content, course.content) && Objects.equals(learningOutcomes, course.learningOutcomes) && Objects.equals(offerings, course.offerings);
    }

    @Override
    public String toString() {
        return "{" +
            " courseName='" + getCourseName() + "'" +
            ", courseType='" + getCourseType() + "'" +
            ", courseDescription='" + getCourseDescription() + "'" +
            ", content='" + getContent() + "'" +
            ", learningOutcomes='" + getLearningOutcomes() + "'" +
            "}";
    }

    public static String findCourse(String name) throws NoSuchElementException{
        for (Course course : courses) {
            if (course.getCourseName().equals(name)) {return course.toString();}
        }
        throw new NoSuchElementException("Error: Search results are empty");
    }

    public static Course getCourse(String name) throws NoSuchElementException{
        for (Course course : courses) {
            if (course.getCourseName().equals(name)) {return course;}
        }
        throw new NoSuchElementException("Error: Course does not exist");
    }

    public static String[] getCourses() {
        if (courses.isEmpty()) {
            return new String[]{"No courses registered"};
        }
        String[] output = new String[courses.size()];
        for (int idx = 0; idx < courses.size(); idx++) {
            output[idx] = courses.get(idx).toString();
        }
        return output;
    }

    public static void removeCourse(String name) throws NoSuchElementException{
        for (Course course : courses) {
            if (course.getCourseName().equals(name)) {
                courses.remove(course);
                return;
            }
        }
        throw new NoSuchElementException("Error: Specified course does not exist");
    }

    public static void update(String[] data)  throws NoSuchElementException{
        for (Course course : courses) {
            if (course.getCourseName().equals(data[0])) {
                for (int idx = 0; idx < data.length; idx++) {
                    if (idx < 1) continue;
                    switch (idx) {
                        case 1:
                            course.setCourseName(data[idx]);
                            break;
                        case 2:
                            course.setCourseType(data[idx]);
                            break;
                        case 3:
                            course.setCourseDescription(data[idx]);
                            break;
                        case 4:
                            course.setLearningOutcomes(data[idx]);
                            break;
                        case 5:
                            course.setContent(data[idx]);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        throw new NoSuchElementException("Error: The course specified does not exist");
    }
}
