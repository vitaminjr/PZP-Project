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
    private ListView title_list_proc;
    @FXML
    private ListView desc_list_proc;
    @FXML
    private  ListView title_list_memory;
    @FXML
    private  ListView desc_list_memory;
    @FXML
    private  ListView title_list_graphic;
    @FXML
    private  ListView desc_list_graphic;
    @FXML
    private ListView title_list_drives;
    @FXML
    private ListView desc_list_drives;
    @FXML
    private ListView title_list_device;
    @FXML
    private ListView desc_list_devive;
    @FXML
    private Button buttonExit;



    public void initialize(){
        AllMonitooring monitooring = new AllMonitooring();
        buttonExit.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                Stage stage = (Stage) buttonExit.getScene().getWindow();
                stage.close();
            }
        });

        title_list_proc.edit(1);
     //   title_list_proc.


    }

}
