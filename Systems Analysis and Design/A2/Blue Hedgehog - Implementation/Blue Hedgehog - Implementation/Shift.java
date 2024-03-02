import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Shift {
    private Date startDate;
    private Date endDate;
    private Time startTime;
    private Time endTime;
    private List<Operator> operators = new ArrayList<>();

    public Shift() {
    }

    public Shift(Date startDate, Date endDate, Time startTime, Time endTime) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Shift(Date startDate, Date endDate, Time startTime, Time endTime, List<Operator> operators) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.operators = operators;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Time getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public List<Operator> getOperators() {
        return this.operators;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }

    public void addOperator(Operator op){
        operators.add(op);
    }

    public boolean removeOperator(Operator op){
        return operators.remove(op);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Shift)) {
            return false;
        }
        Shift shift = (Shift) o;
        return Objects.equals(startDate, shift.startDate) && Objects.equals(endDate, shift.endDate) && Objects.equals(startTime, shift.startTime) && Objects.equals(endTime, shift.endTime) && Objects.equals(operators, shift.operators);
    }

    @Override
    public String toString() {
        return "{" +
            " startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", operators='" + getOperators() + "'" +
            "}";
    }
}
