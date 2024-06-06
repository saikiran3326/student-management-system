import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class studentinformationsystem {
studentinformationsystem(){
Frame f=new Frame();
Label name=new Label("name");
name.setBounds(50,80,40,30);
TextField namefield=new TextField();
namefield.setBounds(110,80,80,30);
Label rollno=new Label("rollno");
rollno.setBounds(50,130,40,30);
TextField rollnofield=new TextField();
rollnofield.setBounds(110,130,80,30);
Label phonenumber=new Label("phonenumber");
phonenumber.setBounds(50,180,40,30);
TextField phonefield=new TextField();
phonefield.setBounds(110,180,80,30);
Label year=new Label("Year");
year.setBounds(50,230,40,30);
TextField yearfield=new TextField();
yearfield.setBounds(110,230,80,30);
f.add(name);
f.add(namefield);
f.add(rollno);
f.add(rollnofield);
f.add(phonenumber);
f.add(phonefield);
f.add(year);
f.add(yearfield);
Button b=new Button("submit");
b.setBounds(80,280,80,30);
f.add(b);
b.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String url="jdbc:mysql://localhost:3306/sai";
String username="root";
String password="";
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection=
DriverManager.getConnection(url,username,password);
String n=namefield.getText();
String p=rollnofield.getText();
String phonenumber=phonefield.getText();
String year=yearfield.getText();
PreparedStatement stmt=connection.prepareStatement("insert into
studentdata values(?,?,?,?)");
stmt.setString(1,n);//1 specifies the first parameter in the query
stmt.setString(2,p);
stmt.setString(3,phonenumber);
stmt.setString(4,year);
stmt.executeUpdate();
stmt.close();
JOptionPane.showMessageDialog(null,"inserted successful");
}
catch(Exception el){
System.out.println(el);
}
}
});
f.setSize(300,400);
f.setLayout(null);
f.setVisible(true);
}
public static void main(String[] args) {
studentinformationsystem si=new studentinformationsystem();
}
}
