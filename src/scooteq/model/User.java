package scooteq.model;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        try {
            this.password = encryptPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            this.password = password;
        }
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setPassword(String newPassword) {
        try {
            this.password = encryptPassword(newPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            this.password = newPassword;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean comparePassword(String password) {
        try {
            if (encryptPassword(password).equals(this.password)) {
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    private String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(password.getBytes());
        byte[] bytes = m.digest();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return s.toString();
    }

    public boolean login(){
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/scooteq", "root", null)) {
            String sql = "SELECT * FROM user WHERE username = ? and password_hash = ?";
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, this.getName());
            stmt.setString(2, this.getPassword());
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
