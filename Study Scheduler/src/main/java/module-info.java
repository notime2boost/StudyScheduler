module com.studyscheduler {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.studyscheduler to javafx.fxml;
    exports com.studyscheduler;
}