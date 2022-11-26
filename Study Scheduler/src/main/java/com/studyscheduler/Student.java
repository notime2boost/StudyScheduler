package com.studyscheduler;

public class Student {
    String username;
    String password;
    int[][] time = new int[7][24]; //blocked out and free times; determined by checkboxes
    int[][] time1 = new int[7][24]; //1st schedule
    int[][] time2 = new int[7][24]; //2nd schedule
    int[][] time3 = new int[7][24]; //3rd schedule
    int[][] time4 = new int[7][24]; //4th schedule
    String[] coursename = new String[5]; //name of course; determined by first column of textboxes
    int[] difficulty = new int[5]; //difficulty of course; determined by third column of textboxes
    String[] courseid = new String[5]; //name of course ID; determined by second column of textboxes
    int[] id = new int[5]; /* Integer I use to keep track of a class in the time[][] arrays. Can be the values 10,11,12,13,14.
                           10 being the class on the first/top textbox and 14 being the class on the last/bottom textbox.   
                           x.coursename[0] is the class name for 10, x.coursename[1] is the class name for 11, etc.
                           */

}
