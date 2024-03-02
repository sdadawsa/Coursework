import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CourseView implements UserInterface{

    private CourseManager controller;
    private GUIFramework gui;

    @Override
    public void initializeView() {

        controller = CourseManager.getInstance();
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
                            controller.addCourse(event.getData());
                            gui.setScreen("Add Success", null);
                            break;
                        case "Search":                            
                            gui.setScreen("Search Results", controller.getCourse(event.getData()));
                            break;
                        case "View All":
                            gui.setScreen("All Schools", controller.getCourses());
                            break;
                        case "Delete":
                            controller.deleteCourse(event.getData());
                            gui.setScreen("Delete Success", null);
                            break;
                        case "Update":
                            controller.updateCourse(event.getData());
                            gui.setScreen("Update Success", null);
                            break;
                        case "Schedule":
                            controller.scheduleCourse(event.getData());
                            gui.setScreen("Schedule Success", null);
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
