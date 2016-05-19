package mainForm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
        AddData testClass = new AddData();


        buttonExit.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                Stage stage = (Stage) buttonExit.getScene().getWindow();
                stage.close();
            }
        });


        ObservableList<String> itemsTitleProc = FXCollections.observableList(testClass.getTitle_list_proc());
        title_list_proc.setItems(itemsTitleProc);

        ObservableList<String> itemsDescProc = FXCollections.observableList(testClass.getDesc_list_proc());
        desc_list_proc.setItems(itemsDescProc);

        ObservableList<String> itemsTitleMemory = FXCollections.observableList(testClass.getTitle_list_memory());
        title_list_memory.setItems(itemsTitleMemory);

        ObservableList<String> itemsDescMemory = FXCollections.observableList(testClass.getDesc_list_memory());
        desc_list_memory.setItems(itemsDescMemory);

        ObservableList<String> itemsTitleGraphic = FXCollections.observableList(testClass.getTitle_list_graphic());
        title_list_graphic.setItems(itemsTitleGraphic);

        ObservableList<String> itemsDescGraphic = FXCollections.observableList(testClass.getDesc_list_graphic());
        desc_list_graphic.setItems(itemsDescGraphic);

        ObservableList<String> itemsTitleDrives = FXCollections.observableList(testClass.getTitle_list_drives());
        title_list_drives.setItems(itemsTitleDrives);

        ObservableList<String> itemsDescDrives = FXCollections.observableList(testClass.getDesc_list_drives());
        desc_list_drives.setItems(itemsDescDrives);

        ObservableList<String> itemsTitleDeice = FXCollections.observableList(testClass.getTitle_list_device());
        title_list_device.setItems(itemsTitleDeice);

        ObservableList<String> itemsDescDevice = FXCollections.observableList(testClass.getDesc_list_device());
        desc_list_devive.setItems(itemsDescDevice);




    }


}
