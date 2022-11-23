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

    public void userLogin(ActionEvent action) throws SQLException, IOException {
        checkLogin();
    }

    public void userRegister(ActionEvent action) throws IOException {
        registerAccount();
    }


    private void checkLogin() throws SQLException, IOException {

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
        if (usernameTemp.equals(student.getString("username")) && passwordTemp.equals(student.getString("password"))) {
            wrongLogin.setText("Success");

            // Change scene
            Runner r = new Runner();
            r.setUser(usernameTemp);
            r.changeScene("home.fxml");
            

        }
        else if (!usernameTemp.equals(student.getString("username"))) {
            wrongLogin.setText("Incorrect Username");
        }

        else if (!passwordTemp.equals(student.getString("password"))) {
            wrongLogin.setText("Incorrect Password");
        }

        dbc.closeConnect(con);
    }


    private void registerAccount() throws IOException {
        Runner r = new Runner();

        r.changeLoginScene("register.fxml");
    }
}
