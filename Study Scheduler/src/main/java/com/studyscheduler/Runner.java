package com.studyscheduler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Runner extends Application {
    private static Stage stageMaster;



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

    public static void main(String[] args) {
        launch();
    }
}