// step 0
package Frame;

import Entity.*;
import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

// step 1
public class HospitalFrame extends JFrame implements MouseListener, ActionListener
{
    // step 2 – component declarations
    private Font f1, f2, f3;
    private Color c1, c2, c3;
    private JPanel panel;

    // Header
    private JLabel lblTitle, lblSubtitle;

    // Patient Info
    private JLabel lblName, lblAge, lblGender, lblBlood;
    private JTextField tfName, tfAge;
    private JRadioButton rbMale, rbFemale, rbOther;
    private ButtonGroup bgGender;
    private JComboBox<String> cbBlood;

    // Disease checkboxes
    private JLabel lblDisease;
    private JCheckBox chkFever, chkDiabetes, chkBP, chkCovid, chkFracture, chkOther;

    // Doctor & Ward
    private JLabel lblDoctor, lblWard, lblFee;
    private JComboBox<String> cbDoctor, cbWard;
    private JTextField tfFee;

    // Notes
    private JLabel lblNotes;
    private JTextArea taNotes;

    // Buttons
    private JButton btnAdmit, btnClear, btnExit, btnViewRecords;

    // Records display
    private JLabel lblRecords;
    private JTextArea taRecords;

    // Hospital logo
    private ImageIcon imgLogo;
    private JLabel lblLogo;

    // step 4 – constructor
    public HospitalFrame()
    {
        // step 4(a) – frame setup
        super("City General Hospital - Patient Admission System");
        super.setBounds(500, 50, 900, 850);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // step 4(b) – panel
        panel = new JPanel();
        panel.setLayout(null);
        c2 = new Color(220, 240, 255);   // light blue background
        panel.setBackground(c2);

        // step 4(d) – fonts & colors
        f1 = new Font("Georgia",      Font.BOLD,   28);
        f2 = new Font("Courier New",  Font.BOLD,   16);
        f3 = new Font("Courier New",  Font.PLAIN,  14);
        c1 = new Color(0, 70, 140);      // navy blue
        c3 = new Color(0, 140, 70);      // dark green

        // ── Header ──────────────────────────────────────────────
        lblTitle = new JLabel("CITY GENERAL HOSPITAL");
        lblTitle.setBounds(250, 10, 500, 40);
        lblTitle.setFont(f1);
        lblTitle.setForeground(c1);
        lblTitle.addMouseListener(this);
        panel.add(lblTitle);

        lblSubtitle = new JLabel("Patient Admission Form");
        lblSubtitle.setBounds(320, 50, 300, 25);
        lblSubtitle.setFont(new Font("Georgia", Font.ITALIC, 18));
        lblSubtitle.setForeground(new Color(80, 80, 80));
        panel.add(lblSubtitle);

        // ── Hospital Logo ───────────────────────────────────────
        imgLogo = new ImageIcon("Picture/Hospital.png");
        lblLogo = new JLabel(imgLogo);
        lblLogo.setBounds(670, 10, 200, 200);
        panel.add(lblLogo);


        // ── Patient Name ─────────────────────────────────────────
        lblName = new JLabel("Patient Name");
        lblName.setBounds(10, 105, 150, 28);
        lblName.setFont(f2);
        panel.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(170, 105, 200, 28);
        tfName.setFont(f2);
        panel.add(tfName);

        // ── Age ──────────────────────────────────────────────────
        lblAge = new JLabel("Age");
        lblAge.setBounds(400, 105, 60, 28);
        lblAge.setFont(f2);
        panel.add(lblAge);

        tfAge = new JTextField();
        tfAge.setBounds(470, 105, 80, 28);
        tfAge.setFont(f2);
        panel.add(tfAge);

        // ── Gender ───────────────────────────────────────────────
        lblGender = new JLabel("Gender");
        lblGender.setBounds(10, 143, 90, 28);
        lblGender.setFont(f2);
        panel.add(lblGender);

        rbMale = new JRadioButton("Male");
        rbMale.setBounds(110, 143, 90, 28);
        rbMale.setFont(f2);
        rbMale.setBackground(c2);
        panel.add(rbMale);

        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(210, 143, 100, 28);
        rbFemale.setFont(f2);
        rbFemale.setBackground(c2);
        panel.add(rbFemale);

        rbOther = new JRadioButton("Other");
        rbOther.setBounds(320, 143, 90, 28);
        rbOther.setFont(f2);
        rbOther.setBackground(c2);
        panel.add(rbOther);

        bgGender = new ButtonGroup();
        bgGender.add(rbMale);
        bgGender.add(rbFemale);
        bgGender.add(rbOther);

        // ── Blood Group ──────────────────────────────────────────
        lblBlood = new JLabel("Blood Group");
        lblBlood.setBounds(10, 181, 130, 28);
        lblBlood.setFont(f2);
        panel.add(lblBlood);

        String[] bloodGroups = {"", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        cbBlood = new JComboBox<>(bloodGroups);
        cbBlood.setBounds(150, 181, 100, 28);
        cbBlood.setFont(f2);
        panel.add(cbBlood);

        // ── Diseases ─────────────────────────────────────────────
        lblDisease = new JLabel("Disease(s)");
        lblDisease.setBounds(10, 220, 130, 28);
        lblDisease.setFont(f2);
        panel.add(lblDisease);

        chkFever    = new JCheckBox("Fever");
        chkDiabetes = new JCheckBox("Diabetes");
        chkBP       = new JCheckBox("High BP");
        chkCovid    = new JCheckBox("COVID-19");
        chkFracture = new JCheckBox("Fracture");
        chkOther    = new JCheckBox("Other");

        JCheckBox[] checks = {chkFever, chkDiabetes, chkBP, chkCovid, chkFracture, chkOther};
        int cx = 150, cy = 220;
        for (JCheckBox cb : checks) {
            cb.setBounds(cx, cy, 160, 28);
            cb.setFont(f2);
            cb.setBackground(c2);
            panel.add(cb);
            cx += 160;
            if (cx > 750) { cx = 150; cy += 35; }
        }

        // ── Doctor ───────────────────────────────────────────────
        lblDoctor = new JLabel("Assign Doctor");
        lblDoctor.setBounds(10, 300, 150, 28);
        lblDoctor.setFont(f2);
        panel.add(lblDoctor);

        String[] doctors = {
            "", "Dr. Karim Uddin (Cardiology)",
            "Dr. Salma Banu (Neurology)",
            "Dr. Kalam Hossain (Orthopedics)",
            "Dr. Nusrat Fariha (Gynecology)",
            "Dr. Tariqul Islam (General)"
        };
        cbDoctor = new JComboBox<>(doctors);
        cbDoctor.setBounds(170, 300, 300, 28);
        cbDoctor.setFont(f3);
        panel.add(cbDoctor);

        // ── Ward ─────────────────────────────────────────────────
        lblWard = new JLabel("Ward");
        lblWard.setBounds(10, 340, 80, 28);
        lblWard.setFont(f2);
        panel.add(lblWard);

        String[] wards = {"", "General Ward", "ICU", "CCU", "Cabin (Private)", "Emergency"};
        cbWard = new JComboBox<>(wards);
        cbWard.setBounds(100, 340, 200, 28);
        cbWard.setFont(f2);
        panel.add(cbWard);

        // ── Admission Fee ─────────────────────────────────────────
        lblFee = new JLabel("Admission Fee");
        lblFee.setBounds(330, 340, 150, 28);
        lblFee.setFont(f2);
        panel.add(lblFee);

        tfFee = new JTextField();
        tfFee.setBounds(490, 340, 100, 28);
        tfFee.setFont(f2);
        panel.add(tfFee);

        JLabel lblTk = new JLabel("BDT");
        lblTk.setBounds(600, 340, 50, 28);
        lblTk.setFont(f2);
        panel.add(lblTk);

        // ── Notes / Additional Info ───────────────────────────────
        lblNotes = new JLabel("Additional Notes");
        lblNotes.setBounds(10, 380, 180, 28);
        lblNotes.setFont(f2);
        lblNotes.setForeground(c1);
        lblNotes.setOpaque(true);
        lblNotes.setBackground(new Color(180, 210, 255));
        lblNotes.addMouseListener(this);
        panel.add(lblNotes);

        taNotes = new JTextArea();
        taNotes.setBounds(10, 415, 260, 80);
        taNotes.setFont(f3);
        taNotes.setLineWrap(true);
        taNotes.setWrapStyleWord(true);
        taNotes.setBorder(BorderFactory.createLineBorder(c1, 1));
        panel.add(taNotes);

        // ── Buttons ───────────────────────────────────────────────
        btnAdmit = new JButton("ADMIT PATIENT");
        btnAdmit.setBounds(10, 510, 180, 35);
        btnAdmit.setFont(f2);
        btnAdmit.setBackground(new Color(0, 140, 70));
        btnAdmit.setForeground(Color.WHITE);
        btnAdmit.addMouseListener(this);
        btnAdmit.addActionListener(this);
        panel.add(btnAdmit);

        btnClear = new JButton("CLEAR FORM");
        btnClear.setBounds(210, 510, 150, 35);
        btnClear.setFont(f2);
        btnClear.setBackground(new Color(200, 120, 0));
        btnClear.setForeground(Color.WHITE);
        btnClear.addActionListener(this);
        panel.add(btnClear);

        btnViewRecords = new JButton("VIEW ALL RECORDS");
        btnViewRecords.setBounds(380, 510, 220, 35);
        btnViewRecords.setFont(f2);
        btnViewRecords.setBackground(c1);
        btnViewRecords.setForeground(Color.WHITE);
        btnViewRecords.addActionListener(this);
        panel.add(btnViewRecords);

        btnExit = new JButton("EXIT");
        btnExit.setBounds(700, 510, 150, 35);
        btnExit.setFont(f2);
        btnExit.setBackground(Color.RED);
        btnExit.setForeground(Color.WHITE);
        btnExit.addActionListener(this);
        panel.add(btnExit);


        lblRecords = new JLabel("Patient Records");
        lblRecords.setBounds(10, 578, 200, 25);
        lblRecords.setFont(new Font("Georgia", Font.BOLD, 18));
        lblRecords.setForeground(c1);
        panel.add(lblRecords);

        taRecords = new JTextArea();
        taRecords.setEditable(false);
        taRecords.setFont(f3);
        JScrollPane sp = new JScrollPane(taRecords);
        sp.setBounds(10, 608, 860, 200);
        panel.add(sp);

        // step 4(f)
        super.add(panel);
    }

    // ── MouseListener ─────────────────────────────────────────────
    public void mouseClicked(MouseEvent me)
    {
        if (me.getSource() == lblTitle)
        {
            lblTitle.setText("Est. 1994 – Serving with Care");
        }
    }
    public void mousePressed(MouseEvent me)
    {
        if (me.getSource() == lblNotes)
        {
            lblNotes.setText("Write anything here...");
        }
    }
    public void mouseReleased(MouseEvent me)
    {
        if (me.getSource() == lblNotes)
        {
            lblNotes.setText("Additional Notes");
        }
    }
    public void mouseEntered(MouseEvent me)
    {
        if (me.getSource() == btnAdmit)
        {
            btnAdmit.setBackground(new Color(0, 100, 50));
        }
    }
    public void mouseExited(MouseEvent me)
    {
        if (me.getSource() == btnAdmit)
        {
            btnAdmit.setBackground(new Color(0, 140, 70));
        }
    }

    // ── ActionListener ────────────────────────────────────────────
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == btnExit)
        {
            System.exit(0);
        }

        if (ae.getSource() == btnClear)
        {
            clearForm();
        }

        if (ae.getSource() == btnViewRecords)
        {
            loadRecords();
        }

        if (ae.getSource() == btnAdmit)
        {
            String name, gender, blood, diseases, doctor, ward;
            int    age;
            double fee;

            name = tfName.getText().trim();

            if      (rbMale.isSelected())   gender = "Male";
            else if (rbFemale.isSelected()) gender = "Female";
            else if (rbOther.isSelected())  gender = "Other";
            else                            gender = "";

            blood  = cbBlood.getSelectedItem().toString();

            // Build disease string
            StringBuilder sb = new StringBuilder();
            if (chkFever.isSelected())    sb.append("Fever ");
            if (chkDiabetes.isSelected()) sb.append("Diabetes ");
            if (chkBP.isSelected())       sb.append("High BP ");
            if (chkCovid.isSelected())    sb.append("COVID-19 ");
            if (chkFracture.isSelected()) sb.append("Fracture ");
            if (chkOther.isSelected())    sb.append("Other ");
            diseases = sb.toString().trim();

            doctor = cbDoctor.getSelectedItem().toString();
            ward   = cbWard.getSelectedItem().toString();

            // ── Validate Age (must be a whole number) ────────────────
            String ageText = tfAge.getText().trim();
            if (ageText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Age cannot be empty!");
                return;
            }
            try {
                age = Integer.parseInt(ageText);
                if (age <= 0) {
                    JOptionPane.showMessageDialog(this, "Age must be a positive integer!");
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid Age! Please enter a whole number (e.g. 24)");
                return;
            }

            // ── Validate Fee (must be a decimal/double number) ────────
            String feeText = tfFee.getText().trim();
            if (feeText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Admission Fee cannot be empty!");
                return;
            }
            try {
                fee = Double.parseDouble(feeText);
                if (fee < 0) {
                    JOptionPane.showMessageDialog(this, "Admission Fee cannot be negative!");
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid Fee! Please enter a numeric value (e.g. 1500 or 1500.50)");
                return;
            }

            if (name.isEmpty() || gender.isEmpty() ||
                blood.isEmpty() || diseases.isEmpty() || doctor.isEmpty() ||
                ward.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please fill in all fields before admitting!");
            }
            else
            {
                Patient p = new Patient(name, age, gender, blood, diseases, doctor, ward, fee);
                p.insertRecord();
                JOptionPane.showMessageDialog(this,
                    "Patient '" + name + "' admitted successfully!\n" +
                    "Assigned to: " + doctor + "\nWard: " + ward);
                clearForm();
                loadRecords();
            }
        }
    }

    // ── Helpers ───────────────────────────────────────────────────
    private void clearForm()
    {
        tfName.setText("");
        tfAge.setText("");
        tfFee.setText("");
        taNotes.setText("");
        bgGender.clearSelection();
        cbBlood.setSelectedIndex(0);
        cbDoctor.setSelectedIndex(0);
        cbWard.setSelectedIndex(0);
        chkFever.setSelected(false);
        chkDiabetes.setSelected(false);
        chkBP.setSelected(false);
        chkCovid.setSelected(false);
        chkFracture.setSelected(false);
        chkOther.setSelected(false);
    }

    private void loadRecords()
    {
        try
        {
            File file = new File("./Data/patients.txt");
            if (file.exists())
            {
                taRecords.setText("");   // clear old content first
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null)
                {
                    taRecords.append(line + "\n");
                }
                br.close();
            }
            else
            {
                taRecords.setText("No records found yet.");
            }
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading records!");
        }
    }
}
