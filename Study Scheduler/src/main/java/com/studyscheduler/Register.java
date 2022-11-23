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

public class Register {
    public Register() {}

    @FXML
    private Button registerButton;
    @FXML
    private Button returnButton;
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField passwordConfirm;


    public void userReturn(ActionEvent action) throws IOException {
        returnToLogin();
    }

    public void userRegister(ActionEvent action) throws SQLException {
        registerAccount();
    }


    public void registerAccount() throws SQLException {
        String usernameTemp = username.getText();
        String passwordTemp = password.getText();
        String passwordTemp2 = passwordConfirm.getText();

        if (usernameTemp.isEmpty() || passwordTemp.isEmpty()) {
            wrongLogin.setText("Please Enter Credentials");
        }

        if (!passwordTemp.equals(passwordTemp2)) {
            wrongLogin.setText("Passwords Do Not Match");
        }

        DBConnect dbc = new DBConnect();
        Connection con = dbc.connectToDb();

        // Check to see if this username is already taken.
        ResultSet student = dbc.retrieveStudentInfo(con, "login", usernameTemp);
        student.next();

        // If it is taken, let the user know
        if (usernameTemp.equals(student.getString("username"))) {
            wrongLogin.setText("Username Is Already Taken. Please Choose Another.");
        }

        // If it is available create a new account
        else {
            Object[] list = new Object[2];
            list[0] = usernameTemp;
            list[1] = passwordTemp;
            dbc.insertStudentInfo(con, "NewStudent", list);
        }
        dbc.closeConnect(con);
    }

    private void returnToLogin() throws IOException {
        Runner r = new Runner();
        r.changeLoginScene("login.fxml");
    }


}
