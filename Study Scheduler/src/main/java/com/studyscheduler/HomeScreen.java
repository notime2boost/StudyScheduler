package com.studyscheduler;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class HomeScreen {
    @FXML
    private Button viewButton;
    @FXML
    private Button downloadButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button accountButton;
    @FXML
    private Button backButton;
    @FXML
    private Button delAccountButton;
    @FXML
    private Button updateUserButton;
    @FXML
    private Button updatePassButton;
    @FXML
    private TextField newUsername;
    @FXML
    private TextField newUsernameConfirm;
    @FXML
    private TextField passConfirm;
    @FXML
    private PasswordField originalPassword;
    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField newPasswordConfirm;




    public void gotoAccountSettings(ActionEvent Action) throws IOException  {
        Runner r = new Runner();

        r.changeScene("accountSettings.fxml");
    }
    
    public void userLogout(ActionEvent Action) throws IOException {
        Runner r = new Runner();

        r.changeLoginScene("login.fxml");
    }


    public void returnToHome(ActionEvent Action) throws IOException {
        Runner r = new Runner();

        r.changeScene("home.fxml");
    }


    public void userDelAccount(ActionEvent Action) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm Account Deletion");
        String s = "This will permanently delete your account with us, are you sure?";
        alert.setContentText(s);
        
        Optional<ButtonType> result = alert.showAndWait();
        
        
        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            // TODO: add db account deletion code here
            DBConnect dbc = new DBConnect();
            Connection con = dbc.connectToDb();
            dbc.deleteStudentInfo(con, "usernameTemp");
            dbc.closeConnect(con);

            // TODO: add code to return to login screen after account deletion
        }
    }


    public void userUpdateUsername(ActionEvent Action) {
        String usernameTemp = newUsername.getText();
        String usernameTemp2 = newUsernameConfirm.getText();
        String passwordTemp = passConfirm.getText();

        Runner r = new Runner();

        DBConnect dbc = new DBConnect();
        Connection con = dbc.connectToDb();
        dbc.updateStudentInfo(con, "username", r.getUser(), usernameTemp2);
        dbc.closeConnect(con);

        r.setUser(usernameTemp);
        // TODO: add code to change scenes
    }


    public void userUpdatePassword(ActionEvent Action) {
        String originalTemp = originalPassword.getText();
        String newTemp = newPassword.getText();
        String newTemp2 = newPasswordConfirm.getText();

        Runner r = new Runner();

        if(newTemp2.equals(newTemp)) {
            DBConnect dbc = new DBConnect();
            Connection con = dbc.connectToDb();
            dbc.updateStudentInfo(con, "password", r.getUser(), newTemp);
            dbc.closeConnect(con);
        }
        // TODO: add code to change scenes
    }


    public void userDownload() {
        // TODO: Add code for download
    }


    public void userViewSchedule() {
        // TODO: add code to view schedule
    }

    public void userEdit() throws IOException {
        Runner r = new Runner();

        r.changeScene("home.fxml");
    }
}
