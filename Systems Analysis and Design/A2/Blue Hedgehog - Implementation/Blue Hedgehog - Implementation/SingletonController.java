public class SingletonController {

    // This class implements the singleton pattern.
    // The design idea is to enforce a restriction that only a single instance of the class is ever allowed to exist.
    protected static SingletonController singleton = null;

    protected SingletonController(){}

    public static SingletonController getInstance() {
        if (singleton == null){
            singleton = new SingletonController();
        }
        return singleton;
    }
}
