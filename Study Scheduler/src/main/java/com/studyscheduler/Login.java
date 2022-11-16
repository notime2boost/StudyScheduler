package com.studyscheduler;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;

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

    public void userRegister(ActionEvent action) throws IOException {
        registerAccount();
    }


    private void checkLogin() {

        // setting them to temporary String variables, can be changed as necessary
        String usernameTemp = username.getText();
        String passwordTemp = password.getText();

        if (usernameTemp.isEmpty() || passwordTemp.isEmpty()) {
            wrongLogin.setText("Please Enter Credentials");
        }


        // if wrong credentials
        // wrongLogin.setText("Incorrect Username or Password");

    }


    private void registerAccount() throws IOException {
        Runner r = new Runner();

        r.changeLoginScene("register.fxml");
    }
}
