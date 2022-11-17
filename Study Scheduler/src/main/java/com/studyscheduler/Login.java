package com.studyscheduler;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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


    public void userLogin(ActionEvent action) throws SQLException {
        checkLogin();
    }

    public void userRegister(ActionEvent action) throws IOException {
        registerAccount();
    }


    private void checkLogin() throws SQLException {

        // setting them to temporary String variables, can be changed as necessary
        String usernameTemp = username.getText();
        String passwordTemp = password.getText();

        if (usernameTemp.isEmpty() || passwordTemp.isEmpty()) {
            wrongLogin.setText("Please Enter Credentials");
        }

        // Check for wrong credentials
        DBConnect dbc = new DBConnect();
        Connection con = dbc.connectToDb();

        ResultSet student = dbc.retrieveStudentInfo(con, "login", usernameTemp);
        student.next();

        // if wrong credentials
        if (usernameTemp.equals(student.getString("username")) && passwordTemp.equals(student.getString("password")))
            wrongLogin.setText("Success");
        else{
            wrongLogin.setText("Incorrect Username or Password");
        }
    }


    private void registerAccount() throws IOException {
        Runner r = new Runner();

        r.changeLoginScene("register.fxml");
    }
}
