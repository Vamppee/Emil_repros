package com.example.proectst;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button searchbtn;

    @FXML
    private Button deletebtn;

    @FXML
    private Button opendtn;

    @FXML
    private Button editbtn;

    @FXML
    private TextField searchrtxt;

    @FXML
    private Label labelCount;

    @FXML
    private TableView<Person> table;

    @FXML
    private Button Exitbutton;

    @FXML
    private TableColumn<Person, String> columnPip;

    @FXML
    private TableColumn<Person, String> columnPhone;

    @FXML
    private VBox scenePane;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    private Stage stage;

    private Stage newStage;
    private Stage editDialogStage;
    private Parent root;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private ControllerModalWindow controllerModalWindow;
    public void setNewStage(Stage newStage) {

        this.newStage = newStage;
    }
    CollectionAddressBook addressBookImpl = new CollectionAddressBook();

    @FXML
    public void initialize(){

        try {
            fxmlLoader.setLocation(HelloController.class.getResource("/com/example/proectst/ModalWindow.fxml"));
            root = fxmlLoader.load();
            controllerModalWindow = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }

        columnPip.setCellValueFactory(new PropertyValueFactory<Person,String>("pip"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person,String>("phone"));

        addressBookImpl.fillTestData();
        table.setItems(addressBookImpl.getPersonList());
    }
    @FXML
    void open(ActionEvent event) throws IOException,URISyntaxException{

        Button clickedButton = (Button) event.getSource();

        switch (clickedButton.getId()){
            case "opendtn":
                controllerModalWindow.setPerson(new Person());
                showDialog();
                addressBookImpl.add(controllerModalWindow.getPerson());
                break;
            case "editbtn":
                controllerModalWindow.setPerson((Person) table.getSelectionModel().getSelectedItem());
                showDialog();
                break;
            case "deletebtn":
                addressBookImpl.delete((Person) table.getSelectionModel().getSelectedItem());
                break;
        }
    }
    public void showDialog(){
        editDialogStage = new Stage();
        Scene scene1 = new Scene(root);
        editDialogStage.setScene(scene1);
        scene1.getStylesheets().clear();
        File file = new File("D:PROECTst/src/main/java/com/example/proectst/my.css");
        String file_s = file.toURI().toString();
        scene1.getStylesheets().add(file_s);

        //stage.setScene(new Scene(root));
        editDialogStage.setTitle("Редагування");
        editDialogStage.setMinHeight(170);
        editDialogStage.setMinWidth(600);
        editDialogStage.setResizable(false);
        editDialogStage.initOwner(newStage);
        editDialogStage.initModality(Modality.WINDOW_MODAL);
        editDialogStage.showAndWait();
    }
    public void openOtherLabs(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloControllerOtherLabs.class.getResource("OtherLabs.fxml"));
        Scene scene = new Scene(root, 800, 800);
        Stage stage = new Stage();

        stage.setTitle("Other labs");

        stage.setScene(scene);

        stage.show();
    }




    public void edit(ActionEvent actionEvent) {
    }

    public void delete(ActionEvent actionEvent) {
    }

    public void searchfield(ActionEvent actionEvent) {
    }

    public void btnsearch(ActionEvent actionEvent) {
    }

    public void Exit(ActionEvent actionEvent) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Вихід з програми");
            alert.setContentText("Ви дійсно бажаєте вийти ? ");
            if (alert.showAndWait().get() == ButtonType.OK) {
                Stage stage = (Stage) scenePane.getScene().getWindow();
                System.out.println("Ви успішно вийшли з програми");
                stage.close();
        }
    }

    public void open_other_labs(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloControllerOtherLabs.class.getResource("OtherLabs.fxml"));
        Scene scene = new Scene(root, 800, 800);
        Stage stage = new Stage();

        stage.setTitle("Other labs");
        stage.setScene(scene);

        stage.show();
    }

    public void openotherlabs(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloControllerOtherLabs.class.getResource("OtherLabs.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1035, 500);
        Stage stage = new Stage();
        stage.setTitle("Інші лабораторні");
        stage.setScene(scene);
        stage.show();
    }
}