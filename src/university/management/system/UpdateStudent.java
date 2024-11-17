
package university.management.system;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.sql.ResultSet;
import java.sql.*;


public class UpdateStudent extends JFrame implements ActionListener {
    JTextField tfcourse,   tfaddress,tfphone, tfemail,tfbranch;
    JLabel labelrollno ;
    JButton  submit,cancel;
    Choice crollno;
    
   UpdateStudent(){
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        
//        Heading
        
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        JLabel lblrollno= new JLabel("Select Roll Number");
        lblrollno.setBounds(50,100,200,20);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        
        add(lblrollno);
        
        crollno =  new Choice();
        crollno.setBounds(250,100,200,20);
        add(crollno);
        
        try{
        Conn c =new Conn(); 
        ResultSet rs = c.s.executeQuery("select * from  student");
        while(rs.next()){
            crollno.add(rs.getString("rollno"));
        }
        
        }
        catch (Exception e){
        e.printStackTrace();}     
        
        
//        usernname 

        JLabel lblname = new JLabel("Username");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(200,150,150,30);
        labelname.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelname);
        
//        Fathername
        
        JLabel lblfname = new JLabel("Father's Name");
       lblfname.setBounds(400,150,200,30);
      lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        
      JLabel   labelfname = new JLabel();
        labelfname.setBounds(600,150,150,30);
        labelfname.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelfname);
//        rollno
         JLabel lblrollnumber = new JLabel("Roll No");
       lblrollnumber.setBounds(50,200,200,30);
       lblrollnumber.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollnumber);
        
         labelrollno = new JLabel();
        labelrollno.setBounds(200,200,200,30);
       labelrollno.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelrollno);
        
//        dob using  calender
        
        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(400,200,200,30);
      lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        
       JLabel  labeldob = new JLabel();
        labeldob .setBounds(600,200,150,30);
        labeldob.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labeldob);
        
         JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,250,200,30);
      lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
         JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(400,250,200,30);
       lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
       
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50,300,200,30);
      lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);
        
        tfemail = new JTextField();
         tfemail.setBounds(200,300,150,30);
        add( tfemail);
        
         JLabel lbx = new JLabel("Class X (%)");
        lbx.setBounds(400,300,200,30);
      lbx.setFont(new Font("serif",Font.BOLD,20));
        add(lbx);
        
       JLabel labelx = new JLabel();
        labelx.setBounds(600,300,150,30);
        labelx.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelx);
        
        
      JLabel lblxii = new JLabel(" Class XII(%)");
        lblxii.setBounds(50,350,200,30);
       lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);
        
        JLabel labelxii = new JLabel();
        labelxii.setBounds(200,350,150,30);
        labelxii.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelxii); 
        
         JLabel lblaadhar= new JLabel(" Adhar Number");
        lblaadhar.setBounds(400,350,200,30);
       lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        
        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(600,350,150,30);
        labelaadhar.setFont(new Font("Tahoma",Font.BOLD,18));
        add(labelaadhar); 
        
        JLabel lblcourse= new JLabel("Course");
       lblcourse.setBounds(50,400,200,30);
       lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        
        String course []  ={"b.tech","BBA","BcA","Msc","MBA","MCA","MA"};
      
        tfcourse = new JTextField();
        tfcourse.setBounds(200,400,150,30);
        
        add(tfcourse);
        
        JLabel lblbranch= new JLabel("Branch");
       lblbranch.setBounds(400,400,200,30);
       lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
        
        String branch []  ={"computer science","electronics","IT","Civil","Mechanics"};
      
        tfbranch = new JTextField();
        tfbranch.setBounds(600,400,150,30);
        tfbranch.setBackground(Color.WHITE);
        add(tfbranch);
        
        crollno.addItemListener(new ItemListener() {
    public void itemStateChanged(ItemEvent ie) {
        try {
            Conn c = new Conn();
            String query = "select * from student where rollno = '" + crollno.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
               labelx.setText(rs.getString("class_x"));
                labelxii.setText(rs.getString("class_xii"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelrollno.setText(rs.getString("rollno"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
});

        submit  = new JButton("Update");
        submit.setBounds(250,500,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,15));
        add(submit);
        
         cancel  = new JButton("Cancel");
        cancel.setBounds(450,500,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,15));
        add(cancel);
                
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            
String rollno = labelrollno.getText(); 
String address =  tfaddress.getText();
String phone = tfphone.getText();
String email = tfemail.getText();


String course = tfcourse.getText();
String branch = tfbranch.getText();

try { 
    
    String query = "update student set address ='"+address+"',phone ='"+phone+"',email = '"+email+"',course = '"+course+"', branch = '"+branch+"' where rollno = '"+rollno+"'";
    Conn con = new Conn();
    con.s.executeUpdate(query);
    JOptionPane.showMessageDialog(null,"student Details Updated Succsesfully");
setVisible(false);    
}catch (Exception e){
}
    }
else{
    setVisible(false);
}}
    public static void main(String[]args){
        new UpdateStudent();
    
    }
    
}
//RAM