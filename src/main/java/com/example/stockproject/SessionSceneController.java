package com.example.stockproject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SessionSceneController extends Controller implements Initializable {

    @FXML
    private RadioButton candleId,lineId;
    @FXML
    private TitledPane profileVeiw;

    @FXML
    private ListView <String> companyList;
    @FXML
    private Label usernameField , UserId , checkerLabel;

    private String selectedItem;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        companyList.getItems().addAll(Data.stockData.keySet());
        companyList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                selectedItem = companyList.getSelectionModel().getSelectedItem();

            }
        });
        profileVeiw.setExpanded(false);
        checkerLabel.setVisible(false);
        setInformation();
    }

    public void displayChart(ActionEvent event) {
        if (candleId.isSelected() && selectedItem!=null){
          CandlestickGraph graph = new CandlestickGraph(selectedItem,Data.CSVDirectory, 1700,700);

            Scene scene =new Scene( graph.graph(), 1100,700);
            Controller.currStage.setScene(scene);
            Controller.currStage.show();
        }
        else if (lineId.isSelected() && selectedItem!=null){

        }
        else
        {
            checkerLabel.setVisible(true);
        }
    }

//    private void ShowStage(String name ,ActionEvent event  ) throws IOException {
//        root = (FXMLLoader.load(getClass().getResource(name)));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }


    public void setInformation(){
        usernameField.setText(Data.Users.get(Data.getUserIndex()).username);  ;
        UserId.setText(String.valueOf((Data.Users.get(Data.getUserIndex()).getId())));
    }



    @FXML
    public void changeName(ActionEvent event) throws IOException {
//        ShowStage("ChangeName.fxml", event);
        display("ChangeName.fxml");
    }



    @FXML
    public void changeToAccount(ActionEvent event) throws IOException {
//        ShowStage("Market.fxml",event);
        display("Market.fxml");
    }
    @FXML
    public void back(ActionEvent event) throws IOException{
//        ShowStage("NormalUserScene.fxml",event);
        display("NormalUserScene.fxml");
    }
    @FXML
    public void changePassword(ActionEvent event) throws IOException{
//        ShowStage("ChangePassword.fxml",event);
        display("ChangePassword.fxml");

    }



}
