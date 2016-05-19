package mainForm;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.SystemInformationController;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;


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
    @FXML
    private Button button_Generation;

    private boolean isRun = false;

    public void initialize(){
        AddData testClass = new AddData();


        buttonExit.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                Stage stage = (Stage) buttonExit.getScene().getWindow();
                stage.close();
            }
        });

        button_Generation.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!isRun){
                    button_Generation.setText("Обробка...");
                    button_Generation.setDisable(true);
                    isRun = true;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            File file = SystemInformationController.getInstance().getFullDescriptionOfSystem();
                            if (file != null){
                                try {
                                    Desktop.getDesktop().open(file);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            Platform.runLater(new Runnable() {
                                @Override public void run() {
                                    isRun = false;
                                    button_Generation.setText("Згенерувати повний опис системи");
                                    button_Generation.setDisable(false);
                                }
                            });
                        }
                    }).start();
                }
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

        title_list_graphic.setItems(FXCollections.observableList(testClass.getGraphicsList().get(0)));
        desc_list_graphic.setItems(FXCollections.observableList(testClass.getGraphicsList().get(1)));

        ObservableList<String> itemsTitleDrives = FXCollections.observableList(testClass.getTitle_list_drives());
        title_list_drives.setItems(itemsTitleDrives);

        ObservableList<String> itemsDescDrives = FXCollections.observableList(testClass.getDesc_list_drives());
        desc_list_drives.setItems(itemsDescDrives);

        title_list_device.setItems(FXCollections.observableList(testClass.getListDevice().get(0)));
        desc_list_devive.setItems(FXCollections.observableList(testClass.getListDevice().get(1)));




    }


}
