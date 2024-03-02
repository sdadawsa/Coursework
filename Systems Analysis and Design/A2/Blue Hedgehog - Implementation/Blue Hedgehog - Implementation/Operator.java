import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Operator {

    private String name;
    private String contactNumber;
    private String loginName;
    private String passwordHash;
    private List<UnavailabilityRecord> notAvailable = new ArrayList<>();
    private static List<Operator> operators = new ArrayList<>();

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", contactNumber='" + getContactNumber() + "'" +
            "}";
    }

    public Operator() {
        operators.add(this);
    }

    public Operator(String name, String contactNumber, String loginName, String passwordHash) throws DuplicateObjectException{
        this.name = name;
        this.contactNumber = contactNumber;
        this.loginName = loginName;
        this.passwordHash = passwordHash;
        if (operators.contains(this)) {throw new DuplicateObjectException();}
        operators.add(this);
    }

    public String getUnavailability() {
        String val = "";
        for (UnavailabilityRecord rec : notAvailable) {
            val += rec.toString();
        }
        return val;
    }

    public void addUnavailability(LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime, String reason){
        notAvailable.add(new UnavailabilityRecord(startDate, endDate, startTime, endTime, reason));
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return this.contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public static List<Operator> getOperators(){
        return operators;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Operator)) {
            return false;
        }
        Operator operator = (Operator) o;
        return (Objects.equals(name, operator.name) && Objects.equals(loginName, operator.loginName));
    }

    public boolean isOperatorAvailable(LocalDateTime start, LocalDateTime end) {
        for (UnavailabilityRecord rec : notAvailable) {
            if (rec.rangeOverlap(start, end)) return false;
        }        
        return true;
    }
}
