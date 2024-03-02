import java.time.LocalDateTime;
import java.util.List;

public class RosterScheduler extends SingletonController{

    protected static RosterScheduler singleton = null;

    public static RosterScheduler getInstance() {
        if (singleton == null){
            singleton = new RosterScheduler();
        }
        return singleton;
    }

    public List<Operator> checkOperatorAvailability(LocalDateTime start, LocalDateTime end) {
        List<Operator> result = Operator.getOperators();
        for (Operator op : result) {
            if (!(op.isOperatorAvailable(start, end))) result.remove(op);
        }
        return result;
    }
}
