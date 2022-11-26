package com.studyscheduler;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Arrays;
public class Blocker {
    //Checkboxes Variables
    @FXML
    private CheckBox s0,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23;
    @FXML
    private CheckBox m0,m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15,m16,m17,m18,m19,m20,m21,m22,m23;
    @FXML
    private CheckBox t0,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23;
    @FXML
    private CheckBox w0,w1,w2,w3,w4,w5,w6,w7,w8,w9,w10,w11,w12,w13,w14,w15,w16,w17,w18,w19,w20,w21,w22,w23;
    @FXML
    private CheckBox h0,h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,h11,h12,h13,h14,h15,h16,h17,h18,h19,h20,h21,h22,h23;
    @FXML
    private CheckBox f0,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23;
    @FXML
    private CheckBox z0,z1,z2,z3,z4,z5,z6,z7,z8,z9,z10,z11,z12,z13,z14,z15,z16,z17,z18,z19,z20,z21,z22,z23;
    //Textbox Variables
    @FXML
    private TextField c0,c1,c2,c3,c4;
    @FXML
    private TextField id0,id1,id2,id3,id4;
    @FXML
    private TextField d0,d1,d2,d3,d4;
    Student x = new Student(); //Holds variables/info on Student
    int i,j,k,z = 0; //Loop variables
    int blocked, open = 0; //Tracks how many hours are open and blocked

    public void returnToHome(ActionEvent Action) throws IOException {
        Runner r = new Runner();

        r.changeScene("home.fxml");
    }
    //Checkboxes used to determine blocked out hours
    public void checkboxchange(ActionEvent event){
        //Did checkboxes this way cause I couldn't find anything about an array of checkboxes with each checkbox having a unique id
        if(s0.isSelected()){x.time[0][0] = 1;} else{x.time[0][0] = 0;}      if(s1.isSelected()){x.time[0][1] = 1;} else{x.time[0][1] = 0;}
        if(s2.isSelected()){x.time[0][2] = 1;} else{x.time[0][2] = 0;}      if(s3.isSelected()){x.time[0][3] = 1;} else{x.time[0][3] = 0;}
        if(s4.isSelected()){x.time[0][4] = 1;} else{x.time[0][4] = 0;}      if(s5.isSelected()){x.time[0][5] = 1;} else{x.time[0][5] = 0;}
        if(s6.isSelected()){x.time[0][6] = 1;} else{x.time[0][6] = 0;}      if(s7.isSelected()){x.time[0][7] = 1;} else{x.time[0][7] = 0;}
        if(s8.isSelected()){x.time[0][8] = 1;} else{x.time[0][8] = 0;}      if(s9.isSelected()){x.time[0][9] = 1;} else{x.time[0][9] = 0;}
        if(s10.isSelected()){x.time[0][10] = 1;} else{x.time[0][10] = 0;}   if(s11.isSelected()){x.time[0][11] = 1;} else{x.time[0][11] = 0;}
        if(s12.isSelected()){x.time[0][12] = 1;} else{x.time[0][12] = 0;}   if(s13.isSelected()){x.time[0][13] = 1;} else{x.time[0][13] = 0;}
        if(s14.isSelected()){x.time[0][14] = 1;} else{x.time[0][14] = 0;}   if(s15.isSelected()){x.time[0][15] = 1;} else{x.time[0][15] = 0;}
        if(s16.isSelected()){x.time[0][16] = 1;} else{x.time[0][16] = 0;}   if(s17.isSelected()){x.time[0][17] = 1;} else{x.time[0][17] = 0;}
        if(s18.isSelected()){x.time[0][18] = 1;} else{x.time[0][18] = 0;}   if(s19.isSelected()){x.time[0][19] = 1;} else{x.time[0][19] = 0;}
        if(s20.isSelected()){x.time[0][20] = 1;} else{x.time[0][20] = 0;}   if(s21.isSelected()){x.time[0][21] = 1;} else{x.time[0][21] = 0;}
        if(s22.isSelected()){x.time[0][22] = 1;} else{x.time[0][22] = 0;}   if(s23.isSelected()){x.time[0][23] = 1;} else{x.time[0][23] = 0;}

        if(m0.isSelected()){x.time[1][0] = 1;} else{x.time[1][0] = 0;}      if(m1.isSelected()){x.time[1][1] = 1;} else{x.time[1][1] = 0;}
        if(m2.isSelected()){x.time[1][2] = 1;} else{x.time[1][2] = 0;}      if(m3.isSelected()){x.time[1][3] = 1;} else{x.time[1][3] = 0;}
        if(m4.isSelected()){x.time[1][4] = 1;} else{x.time[1][4] = 0;}      if(m5.isSelected()){x.time[1][5] = 1;} else{x.time[1][5] = 0;}
        if(m6.isSelected()){x.time[1][6] = 1;} else{x.time[1][6] = 0;}      if(m7.isSelected()){x.time[1][7] = 1;} else{x.time[1][7] = 0;}
        if(m8.isSelected()){x.time[1][8] = 1;} else{x.time[1][8] = 0;}      if(m9.isSelected()){x.time[1][9] = 1;} else{x.time[1][9] = 0;}
        if(m10.isSelected()){x.time[1][10] = 1;} else{x.time[1][10] = 0;}   if(m11.isSelected()){x.time[1][11] = 1;} else{x.time[1][11] = 0;}
        if(m12.isSelected()){x.time[1][12] = 1;} else{x.time[1][12] = 0;}   if(m13.isSelected()){x.time[1][13] = 1;} else{x.time[1][13] = 0;}
        if(m14.isSelected()){x.time[1][14] = 1;} else{x.time[1][14] = 0;}   if(m15.isSelected()){x.time[1][15] = 1;} else{x.time[1][15] = 0;}
        if(m16.isSelected()){x.time[1][16] = 1;} else{x.time[1][16] = 0;}   if(m17.isSelected()){x.time[1][17] = 1;} else{x.time[1][17] = 0;}
        if(m18.isSelected()){x.time[1][18] = 1;} else{x.time[1][18] = 0;}   if(m19.isSelected()){x.time[1][19] = 1;} else{x.time[1][19] = 0;}
        if(m20.isSelected()){x.time[1][20] = 1;} else{x.time[1][20] = 0;}   if(m21.isSelected()){x.time[1][21] = 1;} else{x.time[1][21] = 0;}
        if(m22.isSelected()){x.time[1][22] = 1;} else{x.time[1][22] = 0;}   if(m23.isSelected()){x.time[1][23] = 1;} else{x.time[1][23] = 0;}

        if(t0.isSelected()){x.time[2][0] = 1;} else{x.time[2][0] = 0;}      if(t1.isSelected()){x.time[2][1] = 1;} else{x.time[2][1] = 0;}
        if(t2.isSelected()){x.time[2][2] = 1;} else{x.time[2][2] = 0;}      if(t3.isSelected()){x.time[2][3] = 1;} else{x.time[2][3] = 0;}
        if(t4.isSelected()){x.time[2][4] = 1;} else{x.time[2][4] = 0;}      if(t5.isSelected()){x.time[2][5] = 1;} else{x.time[2][5] = 0;}
        if(t6.isSelected()){x.time[2][6] = 1;} else{x.time[2][6] = 0;}      if(t7.isSelected()){x.time[2][7] = 1;} else{x.time[2][7] = 0;}
        if(t8.isSelected()){x.time[2][8] = 1;} else{x.time[2][8] = 0;}      if(t9.isSelected()){x.time[2][9] = 1;} else{x.time[2][9] = 0;}
        if(t10.isSelected()){x.time[2][10] = 1;} else{x.time[2][10] = 0;}   if(t11.isSelected()){x.time[2][11] = 1;} else{x.time[2][11] = 0;}
        if(t12.isSelected()){x.time[2][12] = 1;} else{x.time[2][12] = 0;}   if(t13.isSelected()){x.time[2][13] = 1;} else{x.time[2][13] = 0;}
        if(t14.isSelected()){x.time[2][14] = 1;} else{x.time[2][14] = 0;}   if(t15.isSelected()){x.time[2][15] = 1;} else{x.time[2][15] = 0;}
        if(t16.isSelected()){x.time[2][16] = 1;} else{x.time[2][16] = 0;}   if(t17.isSelected()){x.time[2][17] = 1;} else{x.time[2][17] = 0;}
        if(t18.isSelected()){x.time[2][18] = 1;} else{x.time[2][18] = 0;}   if(t19.isSelected()){x.time[2][19] = 1;} else{x.time[2][19] = 0;}
        if(t20.isSelected()){x.time[2][20] = 1;} else{x.time[2][20] = 0;}   if(t21.isSelected()){x.time[2][21] = 1;} else{x.time[2][21] = 0;}
        if(t22.isSelected()){x.time[2][22] = 1;} else{x.time[2][22] = 0;}   if(t23.isSelected()){x.time[2][23] = 1;} else{x.time[2][23] = 0;}

        if(w0.isSelected()){x.time[3][0] = 1;} else{x.time[3][0] = 0;}      if(w1.isSelected()){x.time[3][1] = 1;} else{x.time[3][1] = 0;}
        if(w2.isSelected()){x.time[3][2] = 1;} else{x.time[3][2] = 0;}      if(w3.isSelected()){x.time[3][3] = 1;} else{x.time[3][3] = 0;}
        if(w4.isSelected()){x.time[3][4] = 1;} else{x.time[3][4] = 0;}      if(w5.isSelected()){x.time[3][5] = 1;} else{x.time[3][5] = 0;}
        if(w6.isSelected()){x.time[3][6] = 1;} else{x.time[3][6] = 0;}      if(w7.isSelected()){x.time[3][7] = 1;} else{x.time[3][7] = 0;}
        if(w8.isSelected()){x.time[3][8] = 1;} else{x.time[3][8] = 0;}      if(w9.isSelected()){x.time[3][9] = 1;} else{x.time[3][9] = 0;}
        if(w10.isSelected()){x.time[3][10] = 1;} else{x.time[3][10] = 0;}   if(w11.isSelected()){x.time[3][11] = 1;} else{x.time[3][11] = 0;}
        if(w12.isSelected()){x.time[3][12] = 1;} else{x.time[3][12] = 0;}   if(w13.isSelected()){x.time[3][13] = 1;} else{x.time[3][13] = 0;}
        if(w14.isSelected()){x.time[3][14] = 1;} else{x.time[3][14] = 0;}   if(w15.isSelected()){x.time[3][15] = 1;} else{x.time[3][15] = 0;}
        if(w16.isSelected()){x.time[3][16] = 1;} else{x.time[3][16] = 0;}   if(w17.isSelected()){x.time[3][17] = 1;} else{x.time[3][17] = 0;}
        if(w18.isSelected()){x.time[3][18] = 1;} else{x.time[3][18] = 0;}   if(w19.isSelected()){x.time[3][19] = 1;} else{x.time[3][19] = 0;}
        if(w20.isSelected()){x.time[3][20] = 1;} else{x.time[3][20] = 0;}   if(w21.isSelected()){x.time[3][21] = 1;} else{x.time[3][21] = 0;}
        if(w22.isSelected()){x.time[3][22] = 1;} else{x.time[3][22] = 0;}   if(w23.isSelected()){x.time[3][23] = 1;} else{x.time[3][23] = 0;}

        if(h0.isSelected()){x.time[4][0] = 1;} else{x.time[4][0] = 0;}      if(h1.isSelected()){x.time[4][1] = 1;} else{x.time[4][1] = 0;}
        if(h2.isSelected()){x.time[4][2] = 1;} else{x.time[4][2] = 0;}      if(h3.isSelected()){x.time[4][3] = 1;} else{x.time[4][3] = 0;}
        if(h4.isSelected()){x.time[4][4] = 1;} else{x.time[4][4] = 0;}      if(h5.isSelected()){x.time[4][5] = 1;} else{x.time[4][5] = 0;}
        if(h6.isSelected()){x.time[4][6] = 1;} else{x.time[4][6] = 0;}      if(h7.isSelected()){x.time[4][7] = 1;} else{x.time[4][7] = 0;}
        if(h8.isSelected()){x.time[4][8] = 1;} else{x.time[4][8] = 0;}      if(h9.isSelected()){x.time[4][9] = 1;} else{x.time[4][9] = 0;}
        if(h10.isSelected()){x.time[4][10] = 1;} else{x.time[4][10] = 0;}   if(h11.isSelected()){x.time[4][11] = 1;} else{x.time[4][11] = 0;}
        if(h12.isSelected()){x.time[4][12] = 1;} else{x.time[4][12] = 0;}   if(h13.isSelected()){x.time[4][13] = 1;} else{x.time[4][13] = 0;}
        if(h14.isSelected()){x.time[4][14] = 1;} else{x.time[4][14] = 0;}   if(h15.isSelected()){x.time[4][15] = 1;} else{x.time[4][15] = 0;}
        if(h16.isSelected()){x.time[4][16] = 1;} else{x.time[4][16] = 0;}   if(h17.isSelected()){x.time[4][17] = 1;} else{x.time[4][17] = 0;}
        if(h18.isSelected()){x.time[4][18] = 1;} else{x.time[4][18] = 0;}   if(h19.isSelected()){x.time[4][19] = 1;} else{x.time[4][19] = 0;}
        if(h20.isSelected()){x.time[4][20] = 1;} else{x.time[4][20] = 0;}   if(h21.isSelected()){x.time[4][21] = 1;} else{x.time[4][21] = 0;}
        if(h22.isSelected()){x.time[4][22] = 1;} else{x.time[4][22] = 0;}   if(h23.isSelected()){x.time[4][23] = 1;} else{x.time[4][23] = 0;}

        if(f0.isSelected()){x.time[5][0] = 1;} else{x.time[5][0] = 0;}      if(f1.isSelected()){x.time[5][1] = 1;} else{x.time[5][1] = 0;}
        if(f2.isSelected()){x.time[5][2] = 1;} else{x.time[5][2] = 0;}      if(f3.isSelected()){x.time[5][3] = 1;} else{x.time[5][3] = 0;}
        if(f4.isSelected()){x.time[5][4] = 1;} else{x.time[5][4] = 0;}      if(f5.isSelected()){x.time[5][5] = 1;} else{x.time[5][5] = 0;}
        if(f6.isSelected()){x.time[5][6] = 1;} else{x.time[5][6] = 0;}      if(f7.isSelected()){x.time[5][7] = 1;} else{x.time[5][7] = 0;}
        if(f8.isSelected()){x.time[5][8] = 1;} else{x.time[5][8] = 0;}      if(f9.isSelected()){x.time[5][9] = 1;} else{x.time[5][9] = 0;}
        if(f10.isSelected()){x.time[5][10] = 1;} else{x.time[5][10] = 0;}   if(f11.isSelected()){x.time[5][11] = 1;} else{x.time[5][11] = 0;}
        if(f12.isSelected()){x.time[5][12] = 1;} else{x.time[5][12] = 0;}   if(f13.isSelected()){x.time[5][13] = 1;} else{x.time[5][13] = 0;}
        if(f14.isSelected()){x.time[5][14] = 1;} else{x.time[5][14] = 0;}   if(f15.isSelected()){x.time[5][15] = 1;} else{x.time[5][15] = 0;}
        if(f16.isSelected()){x.time[5][16] = 1;} else{x.time[5][16] = 0;}   if(f17.isSelected()){x.time[5][17] = 1;} else{x.time[5][17] = 0;}
        if(f18.isSelected()){x.time[5][18] = 1;} else{x.time[5][18] = 0;}   if(f19.isSelected()){x.time[5][19] = 1;} else{x.time[5][19] = 0;}
        if(f20.isSelected()){x.time[5][20] = 1;} else{x.time[5][20] = 0;}   if(f21.isSelected()){x.time[5][21] = 1;} else{x.time[5][21] = 0;}
        if(f22.isSelected()){x.time[5][22] = 1;} else{x.time[5][22] = 0;}   if(f23.isSelected()){x.time[5][23] = 1;} else{x.time[5][23] = 0;}

        if(z0.isSelected()){x.time[6][0] = 1;} else{x.time[6][0] = 0;}      if(z1.isSelected()){x.time[6][1] = 1;} else{x.time[6][1] = 0;}
        if(z2.isSelected()){x.time[6][2] = 1;} else{x.time[6][2] = 0;}      if(z3.isSelected()){x.time[6][3] = 1;} else{x.time[6][3] = 0;}
        if(z4.isSelected()){x.time[6][4] = 1;} else{x.time[6][4] = 0;}      if(z5.isSelected()){x.time[6][5] = 1;} else{x.time[6][5] = 0;}
        if(z6.isSelected()){x.time[6][6] = 1;} else{x.time[6][6] = 0;}      if(z7.isSelected()){x.time[6][7] = 1;} else{x.time[6][7] = 0;}
        if(z8.isSelected()){x.time[6][8] = 1;} else{x.time[6][8] = 0;}      if(z9.isSelected()){x.time[6][9] = 1;} else{x.time[6][9] = 0;}
        if(z10.isSelected()){x.time[6][10] = 1;} else{x.time[6][10] = 0;}   if(z11.isSelected()){x.time[6][11] = 1;} else{x.time[6][11] = 0;}
        if(z12.isSelected()){x.time[6][12] = 1;} else{x.time[6][12] = 0;}   if(z13.isSelected()){x.time[6][13] = 1;} else{x.time[6][13] = 0;}
        if(z14.isSelected()){x.time[6][14] = 1;} else{x.time[6][14] = 0;}   if(z15.isSelected()){x.time[6][15] = 1;} else{x.time[6][15] = 0;}
        if(z16.isSelected()){x.time[6][16] = 1;} else{x.time[6][16] = 0;}   if(z17.isSelected()){x.time[6][17] = 1;} else{x.time[6][17] = 0;}
        if(z18.isSelected()){x.time[6][18] = 1;} else{x.time[6][18] = 0;}   if(z19.isSelected()){x.time[6][19] = 1;} else{x.time[6][19] = 0;}
        if(z20.isSelected()){x.time[6][20] = 1;} else{x.time[6][20] = 0;}   if(z21.isSelected()){x.time[6][21] = 1;} else{x.time[6][21] = 0;}
        if(z22.isSelected()){x.time[6][22] = 1;} else{x.time[6][22] = 0;}   if(z23.isSelected()){x.time[6][23] = 1;} else{x.time[6][23] = 0;}

    }

    //Used to obtain values from the textbox input
    public void textbox(ActionEvent event) {
        x.id[0] = 11;
        x.coursename[0] = c0.getText();
        x.courseid[0] = id0.getText();
        try{x.difficulty[0] = Integer.parseInt(d0.getText());}
        catch(NumberFormatException e){x.difficulty[0] = 1;}
        catch(Exception e){System.out.println(e);}

        x.id[1] = 12;
        x.coursename[1] = c1.getText();
        x.courseid[1] = id1.getText();
        try{x.difficulty[1] = Integer.parseInt(d1.getText());}
        catch(NumberFormatException e){x.difficulty[1] = 1;}
        catch(Exception e){System.out.println(e);}

        x.id[2] = 13;
        x.coursename[2] = c2.getText();
        x.courseid[2] = id2.getText();
        try{x.difficulty[2] = Integer.parseInt(d2.getText());}
        catch(NumberFormatException e){x.difficulty[2] = 1;}
        catch(Exception e){System.out.println(e);}

        x.id[3] = 14;
        x.coursename[3] = c3.getText();
        x.courseid[3] = id3.getText();
        try{x.difficulty[3] = Integer.parseInt(d3.getText());}
        catch(NumberFormatException e){x.difficulty[3] = 1;}
        catch(Exception e){System.out.println(e);}

        x.id[4] = 15;
        x.coursename[4] = c4.getText();
        x.courseid[4] = id4.getText();
        try{x.difficulty[4] = Integer.parseInt(d4.getText());}
        catch(NumberFormatException e){x.difficulty[4] = 1;}
        catch(Exception e){System.out.println(e);}

        //Checks to make sure no values are too high or low.
        //Also checks if coursename and courseid textboxes are empty
        for(i = 0; i < 5; i++){
            if(x.difficulty[i] > 5)
                x.difficulty[i] = 5;
            if(x.difficulty[i] < 1)
                x.difficulty[i] = 1;
            if(x.coursename[i].length() == 0 || x.courseid[i].length() == 0)
                x.difficulty[i] = 0;
        }

        int temp = 0;
        String tempo;

        //Sorting algorithm that makes the class with the lowest difficulty be at the start of the array
        for(i = 0; i < 4; i++){
            for(j= 0; j < 4 - i; j++){
                if(x.difficulty[j] > x.difficulty[j + 1]){
                    temp = x.difficulty[j]; x.difficulty[j] = x.difficulty[j + 1]; x.difficulty[j + 1] = temp;
                    temp = x.id[j]; x.id[j] = x.id[j + 1]; x.id[j + 1] = temp;
                    tempo = x.coursename[j]; x.coursename[j] = x.coursename[j + 1]; x.coursename[j + 1] = tempo;
                    tempo = x.courseid[j]; x.courseid[j] = x.courseid[j + 1]; x.courseid[j + 1] = tempo;
                }
            }
        }
    }


    // Generates Schedule
    // 1 means blockedout time
    // 0 means open time
    // 11,12,13,14,15 are ids for study hours for classes
    public void submit(ActionEvent event) {
        blocked = 0;
        open = 0;
        //Copies blocked times to the other schedules. Ensures a proper reset if user clicks submit again
        for (i = 0; i < 7; i++) {
            for (j = 0; j < 24; j++) {
                x.time1[i][j] = x.time[i][j];
                x.time2[i][j] = x.time[i][j];
                x.time3[i][j] = x.time[i][j];
                x.time4[i][j] = x.time[i][j];
                if (x.time[i][j] == 1)
                    blocked++;
                else if (x.time[i][j] == 0) {
                    open++;
                }
            }
        }
        //Calculates total study hours
        int totalstudyhours = 0;
        for(i = 0; i<5; i++){
            totalstudyhours += x.difficulty[i]*2;
        }

        System.out.println();
        System.out.println("You have this many free hours: " + open);
        System.out.println("You have blocked out this many hours: " + blocked);
        System.out.println("You will study for this many hours: " + totalstudyhours);
        System.out.println();

        int hours = 0;
        int idd = 0;

        //Checks if we have enough study hours
        if(totalstudyhours > open)
            System.out.println("NEED MORE OPEN HOURS");
        else {

            //1st schedule plan, prioritize easier class first and work up from there
            for (i = 0; i < 5; i++) {
                hours = x.difficulty[i] * 2;
                idd = x.id[i];
                for (j = 0; j < 7; j++) {
                    for (k = 0; k < 24; k++) {
                        if (hours == 0) break;
                        if (x.time1[j][k] == 0) {
                            x.time1[j][k] = idd;
                            hours--;
                        }

                    }
                }

            }

            //2nd schedule plan, prioritize harder class first and work down from there
            for (i = 4; i > -1; i--) {
                hours = x.difficulty[i] * 2;
                idd = x.id[i];
                for (j = 0; j < 7; j++) {
                    for (k = 0; k < 24; k++) {
                        if (hours == 0) break;
                        if (x.time2[j][k] == 0) {
                            x.time2[j][k] = idd;
                            hours--;
                        }

                    }
                }
            }

            //3rd schedule plan, Study all classes every day, starting with easier ones
            for(i=0;i<5;i++){
                hours = x.difficulty[i] * 2;
                idd = x.id[i];
                for (j = 0; j < 24; j++) {
                    if (hours == 0) break;
                    for(k = 0; k < 7; k++){
                        if (hours == 0) break;
                        if (x.time3[k][j] == 0) {
                            x.time3[k][j] = idd;
                            hours--;
                        }
                        //ensures that each day should have at least 1 hour of study for every class
                        else if(j != 23){
                            for(z = j; z < 23; z++){
                                if(x.time3[k][z] == 0) {
                                    x.time3[k][z] = idd;
                                    hours--;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            //4th schedule plan, Study all classes every day, starting with harder ones
            for(i = 4; i > -1; i--){
                hours = x.difficulty[i] * 2;
                idd = x.id[i];
                for (j = 0; j < 24; j++) {
                    for(k = 0; k < 7; k++){
                        if (hours == 0) break;
                        if (x.time4[k][j] == 0) {
                            x.time4[k][j] = idd;
                            hours--;
                        }
                        //ensures that each day should have at least 1 hour of study for every class
                        else if(j != 23){
                            for(z = j; z < 23; z++){
                                if(x.time4[k][z] == 0) {
                                    x.time4[k][z] = idd;
                                    hours--;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            System.out.println("SCHEDULE 1");
            System.out.println(Arrays.deepToString(x.time1).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
            System.out.println();
            System.out.println("SCHEDULE 2");
            System.out.println(Arrays.deepToString(x.time2).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
            System.out.println();
            System.out.println("SCHEDULE 3");
            System.out.println(Arrays.deepToString(x.time3).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
            System.out.println();
            System.out.println("SCHEDULE 4");
            System.out.println(Arrays.deepToString(x.time4).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

        }
        /*
        Schedules are in 2d array format and are the variables: x.time1, x.time2, x.time3, x.time4
        x.time[7][24]: First array represents what day. Ex: x.time[0][y] = Sunday, x[1][y] = Monday, etc.
        x.time[7][24]: Second array represents what hour formatted in military time. Ex: x.time[z][0] = 0:00 or 12:00 am, x.time[z][1] = 1:00 or 1:00 am, etc.
        1 means blocked out time
        0 means open time
        11,12,13,14,15 are study hours for the respective classes
        11 being the class on the first/top textbox and 15 being the class on the last/bottom textbox.
        Variables for database are listed in the Student.java class
        */
    }

}
