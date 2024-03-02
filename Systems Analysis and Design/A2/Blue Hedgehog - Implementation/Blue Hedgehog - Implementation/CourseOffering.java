import java.time.LocalTime;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CourseOffering {
    private Course baseCourse;
    private School requestingSchool;
    private Operator assignedOperator;
    private LocalDate deliveryDate;
    private LocalTime startTime;
    private LocalTime endTime;

    public CourseOffering() {
    }

    public CourseOffering(Course baseCourse, School requestingSchool, Operator assignedOperator, LocalDate deliveryDate, LocalTime startTime, LocalTime endTime) {
        this.baseCourse = baseCourse;
        this.requestingSchool = requestingSchool;
        this.assignedOperator = assignedOperator;
        this.deliveryDate = deliveryDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public CourseOffering(Course baseCourse, School requestingSchool, LocalDate deliveryDate, LocalTime startTime, LocalTime endTime) {
        this.baseCourse = baseCourse;
        this.requestingSchool = requestingSchool;
        this.deliveryDate = deliveryDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public CourseOffering(Course baseCourse, School requestingSchool) {
        this.baseCourse = baseCourse;
        this.requestingSchool = requestingSchool;
    }

    public Course getBaseCourse() {
        return this.baseCourse;
    }

    public void setBaseCourse(Course baseCourse) {
        this.baseCourse = baseCourse;
    }

    public School getRequestingSchool() {
        return this.requestingSchool;
    }

    public void setRequestingSchool(School requestingSchool) {
        this.requestingSchool = requestingSchool;
    }

    public Operator getAssignedOperator() {
        return this.assignedOperator;
    }

    public void setAssignedOperator(Operator assignedOperator) {
        this.assignedOperator = assignedOperator;
    }

    public void setAssignedOperatorByName(String assignedOperator) throws NoSuchElementException {
        for (Operator op : Operator.getOperators()) {
            if (op.getName().equals(assignedOperator)) {this.assignedOperator = op;}
        }
        throw new NoSuchElementException("Error: The specified operator does not exist");        
    }

    public LocalDate getDeliveryDate() {
        return this.deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return this.endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public CourseOffering baseCourse(Course baseCourse) {
        setBaseCourse(baseCourse);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CourseOffering)) {
            return false;
        }
        CourseOffering courseOffering = (CourseOffering) o;
        return Objects.equals(baseCourse, courseOffering.baseCourse) && Objects.equals(requestingSchool, courseOffering.requestingSchool) && Objects.equals(assignedOperator, courseOffering.assignedOperator) && Objects.equals(deliveryDate, courseOffering.deliveryDate) && Objects.equals(startTime, courseOffering.startTime) && Objects.equals(endTime, courseOffering.endTime);
    }

    @Override
    public String toString() {
        return "{" +
            " baseCourse='" + getBaseCourse() + "'" +
            ", requestingSchool='" + getRequestingSchool() + "'" +
            ", assignedOperator='" + getAssignedOperator() + "'" +
            ", deliveryDate='" + getDeliveryDate() + "'" +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            "}";
    }

}
