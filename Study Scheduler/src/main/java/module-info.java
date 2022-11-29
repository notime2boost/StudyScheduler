module com.studyscheduler {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.swing;
    requires java.sql;
    requires com.calendarfx.view;
    requires com.google.gson;
    requires java.desktop;

    opens com.studyscheduler to javafx.fxml;
    exports com.studyscheduler;
}