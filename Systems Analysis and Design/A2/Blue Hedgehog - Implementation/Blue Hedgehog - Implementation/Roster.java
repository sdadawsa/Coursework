import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Roster {
    private Date startDate;
    private Date endDate;
    private Time startTime;
    private Time endTime;
    private List<Shift> shifts = new ArrayList<>();

    public Roster() {
    }

    public Roster(Date startDate, Date endDate, Time startTime, Time endTime, List<Shift> shifts) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.shifts = shifts;
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

    public List<Shift> getShifts() {
        return this.shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }

    public void addShift(Date startDate, Date endDate, Time startTime, Time endTime) {
        shifts.add(new Shift(startDate, endDate, startTime, endTime));
    }

    @Override
    public String toString() {
        return "{" +
            " startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", shifts='" + getShifts() + "'" +
            "}";
    }
}
