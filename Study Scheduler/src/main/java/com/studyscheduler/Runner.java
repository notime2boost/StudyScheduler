package com.studyscheduler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import com.calendarfx.view.DetailedWeekView;

public class Runner extends Application {
    private static Stage stageMaster;
    private static String savedUsername = "";


    @Override
    public void start(Stage primaryStage) throws IOException {
        stageMaster = primaryStage;
        primaryStage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Runner.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 400);
        primaryStage.setTitle("Study Scheduler");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void changeLoginScene(String filename) throws IOException {
        stageMaster.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Runner.class.getResource(filename));
        Scene scene = new Scene(fxmlLoader.load(), 300, 400);
        stageMaster.setTitle("Study Scheduler");
        stageMaster.setScene(scene);
        stageMaster.show();
    }

    public void changeScene(String filename) throws IOException {
        stageMaster.setResizable(true);
        FXMLLoader fxmlLoader = new FXMLLoader(Runner.class.getResource(filename));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stageMaster.setTitle("Study Scheduler");
        stageMaster.setScene(scene);
        stageMaster.show();
    }

    public void showSchedule(DetailedWeekView agenda) {
        final Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);



        popup.initOwner(stageMaster);
        Scene popScene = new Scene(agenda, 1280, 720);



        popup.setScene(popScene);
        popup.showAndWait();
    }


    public void setUser(String input) {
        savedUsername = input;
    }

    public String getUser() {
        return savedUsername;
    }


    public static void main(String[] args) {
        launch();
    }
}