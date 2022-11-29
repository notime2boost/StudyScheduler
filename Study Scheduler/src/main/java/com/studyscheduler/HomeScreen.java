package com.studyscheduler;

import java.awt.image.RenderedImage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.swing.Renderer;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.model.Interval;
import com.calendarfx.model.Calendar.Style;
import com.calendarfx.view.DetailedWeekView;
import com.google.gson.Gson;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.WritableImage;


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

    public void userDownload() throws SQLException {
        System.out.println("Initializing Download");



        //WritableImage image = new WritableImage(1920, 1080);
        //generateSchedule().snapshot(new SnapshotParameters(), image);
        Scene scenehold = new Scene(generateSchedule(), 1920, 1080);
        WritableImage image = scenehold.snapshot(null); 
        
        String filename = "schedule";
        String home = System.getProperty("user.home");
        File file = new File(home+"/Downloads/" + filename + ".png"); 
        

        try {
            if (!ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file)) System.out.println("Failed to download for non IO reason");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to dowload:\n");
            e.printStackTrace();
        }
    }

    public void userViewSchedule() throws SQLException {
        Runner r = new Runner();
        r.showSchedule(generateSchedule());
    }

    private DetailedWeekView generateSchedule() throws SQLException {
        // This marks the sunday that begins the week we're looking at.
        LocalDate sunday = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
        DetailedWeekView view = new DetailedWeekView();
        Calendar calendar = new Calendar("Home");
        calendar.setStyle(Style.STYLE1);

        // DB connection
        Runner r = new Runner();
        DBConnect dbc = new DBConnect();
        Connection con = dbc.connectToDb();
        ResultSet student = dbc.retrieveStudentInfo(con, "schedule", r.getUser());
        student.next();
        String sched = student.getString("schedules");
        ResultSet classList = dbc.retrieveStudentInfo(con, "class", r.getUser());
        classList.next();
        String classes = classList.getString("classes");


        // converting from String to array
        String[][] classArr = new Gson().fromJson(classes, String[][].class);
        String[][] schedArr = stringToDeep(sched);

        
        // Add entries here (DB)
        int dayOffset = 0;
        for (String s2[] : schedArr) {
            for (int j = 0; j < 24; j++) {
                //Skip consecutive times that have already been handled
                if (j >= 1)
                    if (s2[j].equals(s2[j-1])) continue;
                // skip empty and blockout days, or null just in case
                if (s2[j].equals("1") || s2[j].equals("0") || s2[j].equals(null)) continue;
                else {
                    int classIndex = Integer.parseInt(s2[j]);
                    String title = classArr[classIndex - 10][0];

                    // if it continues for multiple hours we want to group it, but not if it is the end of the day
                    int temp = j;
                    int duration = 1;
                    if (j < 24) {
                        while (s2[j + 1].equals(s2[j])) {
                            j++;
                            duration++;
                        }
                    }
                    j = temp;

                    Interval time = new Interval(sunday.plusDays(dayOffset), LocalTime.of(j, 00), sunday.plusDays(dayOffset),
                            LocalTime.of(j + duration, 00));
    
    
                    calendar.addEntry(new Entry<>(title, time));
                }

                
            }
            dayOffset++;
            if (dayOffset >= 7) break;
        }

        
        
        CalendarSource source = new CalendarSource("Online Calendars");
        source.getCalendars().add(calendar);
        view.getCalendarSources().add(source);
        view.setAdjustToFirstDayOfWeek(true);
        view.setDate(LocalDate.now());
        view.setVisibleHours(24);
        dbc.closeConnect(con);
        return view;
    }

    public void userEdit() throws IOException {
        Runner r = new Runner();

        r.changeScene("home.fxml");
    }


    // converts the schedule from a string to a 2d array of strings
    private static String[][] stringToDeep(String str) {
        int row = 0;
        int col = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[') {
                row++;
            }
        }
        row--;
        for (int i = 0;; i++) {
            if (str.charAt(i) == ',') {
                col++;
            }
            if (str.charAt(i) == ']') {
                break;
            }
        }
        col++;

        String[][] out = new String[row][col];

        str = str.replaceAll("\\[", "").replaceAll("\\]", "");

        String[] s1 = str.split(", ");

        int j = -1;
        for (int i = 0; i < s1.length; i++) {
            if (i % col == 0) {
                j++;
            }
            out[j][i % col] = s1[i];
        }
        return out;
    }



}
