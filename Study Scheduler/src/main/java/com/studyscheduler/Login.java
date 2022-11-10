package com.studyscheduler;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {
    public Login() {}

    @FXML
    private Button loginButton;
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;


    public void userLogin(ActionEvent action) {
        checkLogin();
    }


    private void checkLogin() {

        if (username.getText().isEmpty() || password.getText().isEmpty()) {
            wrongLogin.setText("Please Enter Credentials");
        }


        // setting them to temporary String variables, can be changed as necessary
        String usernameTemp = username.getText().toString();
        String passwordTemp = password.getText().toString();


        // if wrong credentials
        // wrongLogin.setText("Incorrect Username or Password");

    }

}
