package scooteq.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {
    private String username;
    private String password;
    // if this was used more than once it should be in a separate class and dynamic
    // e.g. pulled from properties.
    private final String DB_URL = "jdbc:mysql://localhost:3306/scooteq";
    private final String DB_USER = "root";

    /**
     * Creates a user with the entered password and username. The password will be
     * encrypted during creation.
     * 
     * @param username The username
     * @param password The password
     * @throws NoSuchAlgorithmException If the user's password can not be encrypted.
     */
    public User(String username, String password) throws NoSuchAlgorithmException {
        this.username = username;
        this.password = encryptPassword(password);
    }

    /**
     * Encrypts and compares the entered String with the user's password.
     * 
     * @param password The password to be compared.
     * @return boolean whether or not the passwords are equal.
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
     * @param password the unencrypted password String.
     * @return the encrypted password String.
     * @throws NoSuchAlgorithmException if no MD5 algorithm provider is found.
     */
    private String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(password.getBytes());
        byte[] bytes = m.digest();
        StringBuilder s = new StringBuilder();

        // Iterate over digested bytes and add to String
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
        try (Connection c = DriverManager.getConnection(DB_URL, DB_USER, null)) {
            String sql = "SELECT * FROM user WHERE username = ? and password_hash = ?";
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, this.username);
            stmt.setString(2, this.password);
            ResultSet rst = stmt.executeQuery();
            if (rst.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // return false if login failed regardless of reason
        return false;
    }
}
