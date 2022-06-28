package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class LoginModel {

 public void doStuff(String s){
    System.out.println(s);
 }

 public void insertUser(User user) {
   try(Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/scooteq", "root", null)){
      if(c.isValid(0)){
         //System.out.println("connection success");
         String sql = "INSERT INTO user (username, password_hash) VALUES (?,?)";
         PreparedStatement stmt = c.prepareStatement(sql);
         stmt.setString(1, user.getName());
         stmt.setString(2, user.getPassword());
         stmt.executeUpdate();
      }
   }catch (Exception e){
      e.printStackTrace();
   }
 }
}
