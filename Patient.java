package Entity;

import java.lang.*;
import javax.swing.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Patient
{
    private String name;
    private int age;
    private String gender;
    private String bloodGroup;
    private String diseases;
    private String doctor;
    private String ward;
    private double fee;

    private File file;
    private FileWriter fwriter;

    public Patient() { }

    public Patient(String name, int age, String gender, String bloodGroup,
                   String diseases, String doctor, String ward, double fee)
    {
        this.name      = name;
        this.age       = age;
        this.gender    = gender;
        this.bloodGroup = bloodGroup;
        this.diseases  = diseases;
        this.doctor    = doctor;
        this.ward      = ward;
        this.fee       = fee;
    }

    public void insertRecord()
    {
        try
        {
            file = new File("./Data/patients.txt");
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");
            String timeAndDate = now.format(fmt);

            fwriter = new FileWriter(file, true);
            fwriter.write("Admission Date/Time: " + timeAndDate + "\n");
            fwriter.write("========================================================\n");
            fwriter.write("Patient Name   : " + name      + "\n");
            fwriter.write("Age            : " + age       + "\n");
            fwriter.write("Gender         : " + gender    + "\n");
            fwriter.write("Blood Group    : " + bloodGroup + "\n");
            fwriter.write("Disease(s)     : " + diseases  + "\n");
            fwriter.write("Assigned Doctor: " + doctor    + "\n");
            fwriter.write("Ward           : " + ward      + "\n");
            fwriter.write("Admission Fee  : " + fee       + " BDT\n");
            fwriter.write("--------------------------------------------------------\n");
            fwriter.flush();
            fwriter.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error writing patient record!");
        }
    }
}
