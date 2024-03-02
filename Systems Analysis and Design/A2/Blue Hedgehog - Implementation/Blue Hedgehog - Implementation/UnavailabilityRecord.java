import java.time.LocalTime;
import java.time.temporal.TemporalField;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Objects;

public class UnavailabilityRecord {
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String reason;

    public UnavailabilityRecord() {
    }

    public UnavailabilityRecord(LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime, String reason) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reason = reason;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UnavailabilityRecord)) {
            return false;
        }
        UnavailabilityRecord unavailabilityRecord = (UnavailabilityRecord) o;
        return Objects.equals(startDate, unavailabilityRecord.startDate) && Objects.equals(endDate, unavailabilityRecord.endDate) && Objects.equals(startTime, unavailabilityRecord.startTime) && Objects.equals(endTime, unavailabilityRecord.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, startTime, endTime);
    }

    @Override
    public String toString() {
        return "{" +
            " startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            "}";
    }

    public boolean rangeOverlap(LocalDateTime start, LocalDateTime end) {
        LocalDateTime startRef = new LocalDateTime(start.getDayOfYear(), start.getNano());
        LocalDateTime endRef = new LocalDateTime(endDate.getDayOfYear(), endTime.getNano());
        if (start.isAfter(startRef) || end.isBefore(endRef)) return false;
        return true;
    }
}
