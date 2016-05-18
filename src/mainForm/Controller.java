package mainForm;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



public class Controller {
    @FXML
    private Button show_data_processor;
    @FXML
    private Button show_data_memory;
    @FXML
    private  Button show_data_graphic;
    @FXML
    private  Button show_data_drives;
    @FXML
    private  Button show_devises;
    @FXML
    private  Button buttonExit;
    @FXML
    private ListView listViewProcessor;


    public void initialize(){
        AllMonitooring monitooring = new AllMonitooring();
        buttonExit.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                Stage stage = (Stage) buttonExit.getScene().getWindow();
                stage.close();
            }
        });

        show_data_drives.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                monitooring.getDrives();
            }
        });

        show_data_graphic.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                monitooring.getGraphic();
            }
        });

        show_data_memory.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                monitooring.getMemory();
            }
        });

        show_data_processor.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                monitooring.getProcessor();
            }
        });

        show_devises.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                monitooring.getDevises();
            }
        });
        listViewProcessor.setAccessibleText("аплвалдп");


    }

}
