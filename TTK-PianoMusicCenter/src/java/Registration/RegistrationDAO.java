package Registration;

import Database.DBUtils;
import OrderCourse.OrderCourseDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class RegistrationDAO implements Serializable {

    public boolean checkLogin(String username, String password) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DBUtils db = new DBUtils();
        try {
            con = db.makeConnection();
            if (con != null) {
                String sql = "Select username, password from Registration"
                        + " Where username = ? and password=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
        return false;
    }
    List<RegistrationDTO> ListAccounts;

    public List<RegistrationDTO> getListAccounts() {
        return ListAccounts;
    }

    public boolean getLogin(String username, String password) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DBUtils db = new DBUtils();
        try {
            con = db.makeConnection();
            if (con != null) {
                String sql = "Select username, password, fullname, isAdmin, sell_id from Registration"
                        + " Where username = ?  and password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1,  username );
                stm.setString(2,  password );
                rs = stm.executeQuery();
                while (rs.next()) {
                    String usernames = rs.getString("username");
                    String passwords = rs.getString("password");
                    String fullname = rs.getString("fullname");
                    boolean roles = rs.getBoolean("isAdmin");
                    int sellid = rs.getInt("sell_id");
                    RegistrationDTO dto = new RegistrationDTO(usernames, passwords, fullname, roles,sellid);
                    if (this.ListAccounts == null) {
                        this.ListAccounts = new ArrayList<RegistrationDTO>();
                    }
                    this.ListAccounts.add(dto);
                    return true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
        return false;
        
    }

    

    public boolean searchByfullname(String searchValue) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DBUtils db = new DBUtils();
        try {
            con = db.makeConnection();
            if (con != null) {
                String sql = "Select username, password, fullname, isAdmin, sell_id from"
                        + " Registration Where fullname Like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");

                rs = stm.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String fullname = rs.getString("fullname");
                    boolean role = rs.getBoolean("isAdmin");
                    int sellid = rs.getInt("sell_id");
                    RegistrationDTO dto = new RegistrationDTO(username, password, fullname, role,sellid);
                    if (this.ListAccounts == null) {
                        this.ListAccounts = new ArrayList<RegistrationDTO>();
                    }
                    this.ListAccounts.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
        return false;
    }

    public boolean deleteRecord(String username) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        DBUtils db = new DBUtils();
        try {
            con = db.makeConnection();
            if (con != null) {
                String sql = "Delete Registration Where username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean updateRecord(String username, String password, String fullname, boolean role) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        DBUtils db = new DBUtils();
        try {
            con = db.makeConnection();
            if (con != null) {
                String sql = "UPDATE Registration Set password = ?, fullname = ?,"
                        + " isAdmin = ? WHERE username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setString(2, fullname);
                stm.setBoolean(3, role);
                stm.setString(4, username);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    public boolean insertRecord(String username, String password, String fullName, boolean role) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        DBUtils db = new DBUtils();
        try {
            con = db.makeConnection();
            if (con != null) {
                
                String sql = "Insert into Registration values(?,?,?,?)";
                        
                stm = con.prepareStatement(sql);
                stm.setString(1,username);
                stm.setString(2,password);
                stm.setString(3,fullName);
                stm.setBoolean(4,role);
                
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    public RegistrationDTO getAcc(String username, String password) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DBUtils db = new DBUtils();
        try {
            con = db.makeConnection();
            if (con != null) {
                String sql = "Select username, password, fullname, isAdmin, sell_id from Registration"
                        + " Where username = ?  and password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1,  username );
                stm.setString(2,  password );
                rs = stm.executeQuery();
                while (rs.next()) {
                    String usernames = rs.getString("username");
                    String passwords = rs.getString("password");
                    String fullname = rs.getString("fullname");
                    boolean roles = rs.getBoolean("isAdmin");
                    int sellid = rs.getInt("sell_id");
                    RegistrationDTO dto = new RegistrationDTO(usernames, passwords, fullname, roles,sellid);
                    
                    
                    return dto;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
        return null;
        
    }
}
