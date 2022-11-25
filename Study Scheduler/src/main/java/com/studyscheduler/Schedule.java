package com.studyscheduler;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


// controller for: schedule and classes
public class Schedule {
    public Schedule() {}

    @FXML
    private Button classButton;
    @FXML
    private Button backButton;
    @FXML
    private Button downloadButton;
    @FXML
    private Button viewButton;
    @FXML
    private Button blockButton;


    

    public void userReturn() throws IOException {
        Runner r = new Runner();

        r.changeScene("home.fxml");
    }

    public void userBack() throws IOException {
        Runner r = new Runner();

        r.changeScene("schedule.fxml");
    }

    public void userDownload() {
        // TODO: Add code for download
    }


    public void userViewSchedule() {
        // TODO: add code to view schedule
    }

    

// TODO: complete class functions

    // change scene to classes.fxml
    public void viewClass() {
        
    }

// functions within calsses.fxml-------
    public void addClass() {

    }

    public void editClass() {

    }

    public void delClass() {

    }
//--------------------------------------

    


// TODO: complete blockout functions

    // change scene to classes.fxml
    public void viewBlockout() {
        
    }

// functions within blockout.fxml-------

//--------------------------------------

}
