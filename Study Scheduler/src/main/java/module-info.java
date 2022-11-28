module com.studyscheduler {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires com.calendarfx.view;

    opens com.studyscheduler to javafx.fxml;
    exports com.studyscheduler;
}