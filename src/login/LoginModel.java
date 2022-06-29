package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginModel {

   public void insertUser(User user) {
      try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/scooteq", "root", null)) {
         if (c.isValid(0)) {
            String sql = "INSERT INTO user (username, password_hash) VALUES (?,?)";
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public boolean loginUser(User user) {
      try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/scooteq", "root", null)) {
         String sql = "SELECT * FROM user WHERE username = ? and password_hash = ?";
         PreparedStatement stmt = c.prepareStatement(sql);
         stmt.setString(1, user.getName());
         stmt.setString(2, user.getPassword());
         ResultSet rst = stmt.executeQuery();
         if (rst.next()) {
            return true;
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return false;
   }
}
