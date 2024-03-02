import java.util.NoSuchElementException;

public class SchoolManager extends SingletonController{

    protected static SchoolManager singleton = null;

    public static SchoolManager getInstance() {
        if (singleton == null){
            singleton = new SchoolManager();
        }
        return singleton;
    }
    public void addSchool(String[] data) throws DuplicateObjectException{
        new School(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), data[5]);
    }
    public void deleteSchool(String[] data) throws NoSuchElementException{
        School.removeSchool(data[0], data[1]);
    }
    public void updateSchool(String[] data) throws NoSuchElementException {
        School.update(data);
    }
    public String[] getSchool(String[] data) throws NoSuchElementException{
        return School.findSchool(data[0], data[1]);
    }
    public String[] getSchools(){
        return School.getSchools();
    }
}
