package com.studyscheduler;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Optional;


import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarEvent;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.model.Interval;
import com.calendarfx.model.Calendar.Style;
import com.calendarfx.view.CalendarView;
import com.calendarfx.view.DetailedDayView;
import com.calendarfx.view.DetailedWeekView;
import com.calendarfx.view.WeekView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.WritableImage;
//import javax.imageio.ImageIO;

// controller for: home and account settings
public class HomeScreen {
    @FXML
    private Button viewButton;
    @FXML
    private Button downloadButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button accountButton;
    @FXML
    private Button backButton;
    @FXML
    private Button delAccountButton;
    @FXML
    private Button updateUserButton;
    @FXML
    private Button updatePassButton;
    @FXML
    private TextField newUsername;
    @FXML
    private TextField newUsernameConfirm;
    @FXML
    private TextField passConfirm;
    @FXML
    private PasswordField originalPassword;
    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField newPasswordConfirm;

    public void gotoAccountSettings(ActionEvent Action) throws IOException {
        Runner r = new Runner();

        r.changeScene("accountSettings.fxml");
    }

    public void userLogout(ActionEvent Action) throws IOException {
        Runner r = new Runner();

        r.changeLoginScene("login.fxml");
    }

    public void returnToHome(ActionEvent Action) throws IOException {
        Runner r = new Runner();

        r.changeScene("home.fxml");
    }

    public void inputData(ActionEvent Action) throws IOException {
        Runner r = new Runner();

        r.changeScene("Blocker.fxml");
    }

    public void userDelAccount(ActionEvent Action) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm Account Deletion");
        String s = "This will permanently delete your account with us, are you sure?";
        alert.setContentText(s);

        Optional<ButtonType> result = alert.showAndWait();

        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            DBConnect dbc = new DBConnect();
            Connection con = dbc.connectToDb();
            dbc.deleteStudentInfo(con, "usernameTemp");
            dbc.closeConnect(con);

            Runner r = new Runner();
            r.changeLoginScene("login.fxml");
        }
    }

    public void userUpdateUsername(ActionEvent Action) throws IOException {
        String usernameTemp = newUsername.getText();
        String usernameTemp2 = newUsernameConfirm.getText();
        String passwordTemp = passConfirm.getText();

        Runner r = new Runner();

        DBConnect dbc = new DBConnect();
        Connection con = dbc.connectToDb();
        Object[] list = new Object[1];
        list[0] = usernameTemp2;
        dbc.updateStudentInfo(con, "username", r.getUser(), list);
        dbc.closeConnect(con);

        r.setUser(usernameTemp);

        r.changeScene("accountSettings.fxml");
    }

    public void userUpdatePassword(ActionEvent Action) throws IOException {
        String originalTemp = originalPassword.getText();
        String newTemp = newPassword.getText();
        String newTemp2 = newPasswordConfirm.getText();

        Runner r = new Runner();

        if (newTemp2.equals(newTemp)) {
            DBConnect dbc = new DBConnect();
            Connection con = dbc.connectToDb();
            Object[] list = new Object[1];
            list[0] = newTemp;
            dbc.updateStudentInfo(con, "password", r.getUser(), list);
            dbc.closeConnect(con);
        }

        r.changeScene("accountSettings.fxml");
    }

    public void userDownload() {
        // TODO: Add code for download

        WritableImage save = new WritableImage(1920, 1080);
        generateSchedule().snapshot(new SnapshotParameters(), save);

        File file = new File("chart.png");

        //ImageIO.write(renderedImage, "png", file);
    }

    public void userViewSchedule() {
        // TODO: add code to view schedule

        Runner r = new Runner();
        r.showSchedule(generateSchedule());
    }

    private DetailedWeekView generateSchedule() {
        // This marks the sunday that begins the week we're looking at.
        // MAY throw an error if the day you are calling this on is sunday, goes to
        // previous week
        LocalDate sunday = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));

        // create the calendar and listen to all changes
        DetailedWeekView view = new DetailedWeekView();
        Calendar calendar = new Calendar("Home");
        calendar.setStyle(Style.STYLE1);

        // Add entries here (DB)
        for (int i = 0; i < 7; i++) {
            String title = "tester";
            Interval time = new Interval(sunday.plusDays(i), LocalTime.of(6, 00), sunday.plusDays(i),
                    LocalTime.of(7, 00));
            calendar.addEntry(new Entry<>(title, time));
        }

        CalendarSource source = new CalendarSource("Online Calendars");
        source.getCalendars().add(calendar);
        view.getCalendarSources().add(source);
        view.setAdjustToFirstDayOfWeek(true);
        view.setDate(LocalDate.now());
        view.setVisibleHours(24);
        return view;
    }

    public void userEdit() throws IOException {
        Runner r = new Runner();

        r.changeScene("home.fxml");
    }
}
