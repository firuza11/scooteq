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

    /**
     * Creates a user with the entered password and username. The password will be
     * encrypted during creation.
     * 
     * @param name     The username
     * @param password The password
     * @throws NoSuchAlgorithmException If the user's password can not be encrypted
     */
    public User(String name, String password) throws NoSuchAlgorithmException {
        this.name = name;
        this.password = encryptPassword(password);
    }

    /**
     * Encrypts and compares the entered String with the user's password.
     * 
     * @param password The password to be compared
     * @return boolean whether or not the passwords are equal
     */
    public boolean comparePassword(String password) {
        try {
            if (encryptPassword(password).equals(this.password)) {
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Encrypts entered user password to a MD5 hashsum.
     * 
     * @param password the unencrypted password String
     * @return the encrypted password String
     * @throws NoSuchAlgorithmException if no MD5 algorithm provider is found
     */
    private String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(password.getBytes());
        byte[] bytes = m.digest();
        StringBuilder s = new StringBuilder();

        // Iterate over digested bytes and convert to hexadecimal
        for (byte b : bytes) {
            s.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return s.toString();
    }

    /**
     * Attempts to login a user by establishing a database connection.
     * 
     * @return boolean whether or not the login was successful.
     */
    public boolean login() {
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/scooteq", "root", null)) {
            String sql = "SELECT * FROM user WHERE username = ? and password_hash = ?";
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, this.name);
            stmt.setString(2, this.password);
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
