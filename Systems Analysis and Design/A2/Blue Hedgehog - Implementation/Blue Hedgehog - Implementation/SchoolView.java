import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SchoolView implements UserInterface{

    private SchoolManager controller;
    private GUIFramework gui;

    @Override
    public void initializeView() {

        controller = SchoolManager.getInstance();
        gui = new GUIFramework("SchoolMenu.config");
    }

    @Override
    public String eventLoop() {
        List<Event> events = new ArrayList<>();
        while (events.contains(new Event("EXIT"))){
            gui.run(events);
            for (Event event : events) {
                try{
                    switch (event.getType()){                    
                        case "Add":
                            controller.addSchool(event.getData());
                            gui.setScreen("Add Success", null);
                            break;
                        case "Search":                            
                            gui.setScreen("Search Results", controller.getSchool(event.getData()));
                            break;
                        case "View All":
                            gui.setScreen("All Schools", controller.getSchools());
                            break;
                        case "Delete":
                            controller.deleteSchool(event.getData());
                            gui.setScreen("Delete Success", null);
                            break;
                        case "Update":
                            controller.updateSchool(event.getData());
                            gui.setScreen("Update Success", null);
                            break;
                        default:
                            throw new UnsupportedOperationException("The user performed an illegal operation");
                    }
                }
                catch(DuplicateObjectException | NoSuchElementException e) {
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
        controller = null;
    }    
}
