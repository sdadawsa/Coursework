import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class School {
    private String name;
    private String primaryContact;
    private String contactNumber;
    private String contactEmail;
    private int studentCount;
    private String address;
    private List<CourseOffering> courses = new ArrayList<>();
    private static List<School> schools = new ArrayList<>();

    public School() {
        schools.add(this);
    }

    public School(String name, String primaryContact, String contactNumber, String contactEmail, int studentCount, String address) throws DuplicateObjectException {
        this.name = name;
        this.primaryContact = primaryContact;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
        this.studentCount = studentCount;
        this.address = address;
        if (schools.contains(this)) {throw new DuplicateObjectException();}
        schools.add(this);
    }

    public School(String name, String primaryContact, String contactNumber, String contactEmail, int studentCount, String address, List<CourseOffering> courses) {
        this.name = name;
        this.primaryContact = primaryContact;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
        this.studentCount = studentCount;
        this.address = address;
        this.courses = courses;
        schools.add(this);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryContact() {
        return this.primaryContact;
    }

    public void setPrimaryContact(String primaryContact) {
        this.primaryContact = primaryContact;
    }

    public String getContactNumber() {
        return this.contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getStudentCount() {
        return this.studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<CourseOffering> getCourses() {
        return this.courses;
    }

    public void setCourses(List<CourseOffering> courses) {
        this.courses = courses;
    }

    public static int getSchoolCount() {
        return schools.size();
    }

    public static String[] getSchools() {
        if (schools.isEmpty()) {
            return new String[]{"No schools registered"};
        }
        String[] output = new String[schools.size()];
        for (int idx = 0; idx < schools.size(); idx++) {
            output[idx] = schools.get(idx).toString();
        }
        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof School)) {
            return false;
        }
        School school = (School) o;
        return Objects.equals(name, school.name) && Objects.equals(primaryContact, school.primaryContact) && Objects.equals(contactNumber, school.contactNumber) && Objects.equals(contactEmail, school.contactEmail) && studentCount == school.studentCount && Objects.equals(address, school.address) && Objects.equals(courses, school.courses);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", primaryContact='" + getPrimaryContact() + "'" +
            ", contactNumber='" + getContactNumber() + "'" +
            ", contactEmail='" + getContactEmail() + "'" +
            ", studentCount='" + getStudentCount() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }

    public static String[] findSchool(String name, String address) throws NoSuchElementException {
        for (School school : schools) {
            if (school.getName().equals(name) && school.getAddress().equals(address)) {return new String[]{school.toString()};}
        }
        throw new NoSuchElementException("Error: Search results are empty");
    }

    public static void removeSchool(String name, String address) throws NoSuchElementException{
        for (School school : schools) {
            if (school.getName().equals(name) && school.getAddress().equals(address)) {
                schools.remove(school);
                return;
            }
        }
        throw new NoSuchElementException("Error: Search results are empty");
    }

    public static void update(String[] data) throws NoSuchElementException{
        for (School school : schools) {
            if (school.getName().equals(data[0]) && school.getAddress().equals(data[1])) {
                for (int idx = 0; idx < data.length; idx++) {
                    if (idx < 2) continue;
                    switch (idx) {
                        case 2:
                            school.setName(data[idx]);
                            break;
                        case 3:
                            school.setAddress(data[idx]);
                            break;
                        case 4:
                            school.setPrimaryContact(data[idx]);
                            break;
                        case 5:
                            school.setContactNumber(data[idx]);
                            break;
                        case 6:
                            school.setContactEmail(data[idx]);
                            break;
                        case 7:
                            school.setStudentCount(Integer.parseInt(data[idx]));
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        throw new NoSuchElementException("Error: The school specified does not exist");
    }

    public static School getSchool(String schoolName) throws NoSuchElementException {
        for (School school : schools) {
            if (school.getName().equals(schoolName)) {return school;}
        }
        throw new NoSuchElementException("Error: Search results are empty");
    }
}
