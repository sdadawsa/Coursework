import java.util.ArrayList;
import java.util.List;

public class TrainingMenu implements UserInterface{

    private GUIFramework gui;

    @Override
    public void initializeView() {
        gui = new GUIFramework("TrainingMainMenu-Sub.config");
    }

    @Override
    public String eventLoop() {
        List<Event> events = new ArrayList<>();
        while (events.contains(new Event("EXIT"))){
            gui.run(events);
            for (Event event : events) {
                try{
                    switch (event.getType()){                    
                        case "Manage Schools":
                            closeView();
                            return "SchoolView";
                        case "Manage Courses":    
                            closeView();
                            return "CourseView";
                        default:
                            throw new UnsupportedOperationException("The user performed an illegal operation");
                    }
                }
                catch(UnsupportedOperationException e) {
                    gui.setScreen("Error", e);
                }
            }

        }

        closeView();
        return null;
    }

    @Override
    public void refresh() {
        gui.clearBuffer();
        gui.drawBack();
        gui.screenUpdate();
        gui.clearBack();
    }

    @Override
    public void closeView() {
        gui.clearBuffer();
        gui.clearBack();
        gui.close();
        gui = null;
    }  
    
}
