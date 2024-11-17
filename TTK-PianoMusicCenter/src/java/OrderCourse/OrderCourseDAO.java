/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderCourse;

import Category.CategoryDTO;
import Database.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author XinWei
 */
public class OrderCourseDAO {

    public List<OrderCourseDTO> getAllProduct(int num) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DBUtils db = new DBUtils();
        List<OrderCourseDTO> ListProduct = new ArrayList<>();
        try {
            con = db.makeConnection();
            if (con != null) {
                String sql = "SELECT *\n" +
                            "FROM [dbo].[courses]\n" +
                            "WHERE status = 1 AND quantity > 0\n" +
                            "ORDER BY startDate\n" +
                            "OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY;";
                stm = con.prepareStatement(sql);
                stm.setInt(1, num);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String courseID = rs.getString(1);
                    String image = rs.getString(2);
                    String description = rs.getString(3);
                    double price = rs.getDouble(4);
                    Date startDate = rs.getDate(5);
                    Date endDate = rs.getDate(6);
                    String cid = rs.getString(7);
                    String name = rs.getString(8);
                    int sellid = rs.getInt(9);
                    int quantity = rs.getInt(10);
                    int status = rs.getInt(11);
                    OrderCourseDTO dto = new OrderCourseDTO(courseID, image, name, description, price, startDate, endDate, cid, sellid, quantity, status);
                    ListProduct.add(dto);

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
        return ListProduct;
    }

    public List<CategoryDTO> getAllProductCategory() throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DBUtils db = new DBUtils();
        List<CategoryDTO> ListProduct = new ArrayList<>();
        try {
            con = db.makeConnection();
            if (con != null) {
                String sql = "select * from [dbo].[Categories]";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int cid = rs.getInt(1);
                    String cname = rs.getString(2);

                    CategoryDTO dto = new CategoryDTO(cid, cname);
                    ListProduct.add(dto);

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
        return ListProduct;
    }

    //moi nhat
    public OrderCourseDTO getLast() {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DBUtils db = new DBUtils();
        String query = "select top 1* from [dbo].[courses]"
                + "order by courseID desc";
        try {
            con = db.makeConnection();
            if (con != null) {

                stm = con.prepareStatement(query);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String courseID = rs.getString(1);
                    String image = rs.getString(2);
                    String description = rs.getString(3);
                    double price = rs.getDouble(4);
                    Date startDate = rs.getDate(5);
                    Date endDate = rs.getDate(6);
                    String cid = rs.getString(7);
                    String name = rs.getString(8);
                    int sellid = rs.getInt(9);
                    int quantity = rs.getInt(10);
                    int status = rs.getInt(11);
                    OrderCourseDTO dto = new OrderCourseDTO(courseID, image, name, description, price, startDate, endDate, cid, sellid, quantity, status);
                    return dto;

                }
            }
        } catch (Exception e) {

        }
        return null;

    }

    public List<OrderCourseDTO> getAllProductByCID(String cid) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DBUtils db = new DBUtils();
        List<OrderCourseDTO> ListProduct = new ArrayList<>();
        try {
            con = db.makeConnection();
            if (con != null) {
                String sql = "select * from [dbo].[Courses]\n" +
                            "where cid = ? and status = 1 AND quantity > 0\n" +
                            "ORDER BY startDate\n" +
                            "OFFSET 0 ROWS FETCH NEXT 6 ROWS ONLY";

                stm = con.prepareStatement(sql);
                stm.setString(1, cid);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String courseID = rs.getString(1);
                    String image = rs.getString(2);
                    String description = rs.getString(3);
                    double price = rs.getDouble(4);
                    Date startDate = rs.getDate(5);
                    Date endDate = rs.getDate(6);
                    String cids = rs.getString(7);
                    String name = rs.getString(8);
                    int sellid = rs.getInt(9);
                    int quantity = rs.getInt(10);
                    int status = rs.getInt(11);
                    OrderCourseDTO dto = new OrderCourseDTO(courseID, image, name, description, price, startDate, endDate, cids, sellid, quantity, status);
                    ListProduct.add(dto);

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
        return ListProduct;
    }
//        public String getNameByCid(int cid) throws SQLException {
//        Connection con = null;
//        PreparedStatement stm = null;
//        ResultSet rs = null;
//        DBUtils db = new DBUtils();
//        
//        try {
//            con = db.makeConnection();
//            if (con != null) {
//                String sql = "select cname from [dbo].[Categories]"
//                        + "where cid = ?";
//
//                stm = con.prepareStatement(sql);
//                stm.setInt(1, cid);
//                
//                rs = stm.executeQuery();
//                while (rs.next()) {
//                    
//                    String nameCid = rs.getString(2);
//                    return nameCid;
//
//                }
//            }
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//        }
//        if (stm != null) {
//            stm.close();
//        }
//        if (con != null) {
//            con.close();
//        }
//        return null;
//    }

    public List<OrderCourseDTO> SearchByName(String txtSearch) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DBUtils db = new DBUtils();
        List<OrderCourseDTO> ListProduct = new ArrayList<>();
        try {
            con = db.makeConnection();
            if (con != null) {
                String sql = "select * from [dbo].[courses]"
                        + "where name like ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + txtSearch + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String courseID = rs.getString(1);
                    String image = rs.getString(2);
                    String description = rs.getString(3);
                    double price = rs.getDouble(4);
                    Date startDate = rs.getDate(5);
                    Date endDate = rs.getDate(6);
                    String cid = rs.getString(7);
                    String name = rs.getString(8);
                    int sellid = rs.getInt(9);
                    int quantity = rs.getInt(10);
                    int status = rs.getInt(11);
                    OrderCourseDTO dto = new OrderCourseDTO(courseID, image, name, description, price, startDate, endDate, cid, sellid, quantity, status);
                    ListProduct.add(dto);

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
        return ListProduct;
    }

    public List<OrderCourseDTO> getAllProductByCname(String cid,int num) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DBUtils db = new DBUtils();
        List<OrderCourseDTO> ListProduct = new ArrayList<>();
        try {
            con = db.makeConnection();
            if (con != null) {
                String sql = "select * from [dbo].[Courses]\n" +
                            "where cid = (select cid from [dbo].[courses] where [name] like ?) and status = 1 AND quantity > 0\n" +
                            "ORDER BY startDate\n" +
                            "OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";

                stm = con.prepareStatement(sql);
                stm.setString(1, cid);
                stm.setInt(2, num);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String courseID = rs.getString(1);
                    String image = rs.getString(2);
                    String description = rs.getString(3);
                    double price = rs.getDouble(4);
                    Date startDate = rs.getDate(5);
                    Date endDate = rs.getDate(6);
                    String cids = rs.getString(7);
                    String name = rs.getString(8);
                    int sellid = rs.getInt(9);
                    int quantity = rs.getInt(10);
                    int status = rs.getInt(11);
                    OrderCourseDTO dto = new OrderCourseDTO(courseID, image, name, description, price, startDate, endDate, cids, sellid, quantity, status);
                    ListProduct.add(dto);

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
        return ListProduct;
    }
    public List<OrderCourseDTO> getAllProductBySearch(String searchValue,int num) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DBUtils db = new DBUtils();
        List<OrderCourseDTO> ListProduct = new ArrayList<>();
        try {
            con = db.makeConnection();
            if (con != null) {
                String sql = "select * from [dbo].[Courses]\n" +
                            "where name like ? and status = 1 AND quantity > 0\n" +
                            "ORDER BY startDate\n" +
                            "OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";

                stm = con.prepareStatement(sql);
                stm.setString(1, searchValue+"%");
                stm.setInt(2, num);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String courseID = rs.getString(1);
                    String image = rs.getString(2);
                    String description = rs.getString(3);
                    double price = rs.getDouble(4);
                    Date startDate = rs.getDate(5);
                    Date endDate = rs.getDate(6);
                    String cids = rs.getString(7);
                    String name = rs.getString(8);
                    int sellid = rs.getInt(9);
                    int quantity = rs.getInt(10);
                    int status = rs.getInt(11);
                    OrderCourseDTO dto = new OrderCourseDTO(courseID, image, name, description, price, startDate, endDate, cids, sellid, quantity, status);
                    ListProduct.add(dto);

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
        return ListProduct;
    }

    public List<OrderCourseDTO> getAllProductbyCidPage(String cid,int num) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DBUtils db = new DBUtils();
        List<OrderCourseDTO> ListProduct = new ArrayList<>();
        try {
            con = db.makeConnection();
            if (con != null) {
                String sql = "select * from [dbo].[Courses]\n" +
                            "where cid = ? and status = 1 AND quantity > 0\n" +
                            "ORDER BY startDate\n" +
                            "OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";

                stm = con.prepareStatement(sql);
                stm.setString(1, cid);
                stm.setInt(2, num);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String courseID = rs.getString(1);
                    String image = rs.getString(2);
                    String description = rs.getString(3);
                    double price = rs.getDouble(4);
                    Date startDate = rs.getDate(5);
                    Date endDate = rs.getDate(6);
                    String cids = rs.getString(7);
                    String name = rs.getString(8);
                    int sellid = rs.getInt(9);
                    int quantity = rs.getInt(10);
                    int status = rs.getInt(11);
                    OrderCourseDTO dto = new OrderCourseDTO(courseID, image, name, description, price, startDate, endDate, cids, sellid, quantity, status);
                    ListProduct.add(dto);

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
        return ListProduct;
    }
    public List<OrderCourseDTO> getAllProductBySellid(int sid) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DBUtils db = new DBUtils();
        List<OrderCourseDTO> ListProduct = new ArrayList<>();
        try {
            con = db.makeConnection();
            if (con != null) {
                String sql = "select * from [dbo].[Courses]"
                        + "where sell_id = ?";

                stm = con.prepareStatement(sql);
                stm.setInt(1, sid);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String courseID = rs.getString(1);
                    String image = rs.getString(2);
                    String description = rs.getString(3);
                    double price = rs.getDouble(4);
                    Date startDate = rs.getDate(5);
                    Date endDate = rs.getDate(6);
                    String cids = rs.getString(7);
                    String name = rs.getString(8);
                    int sellid = rs.getInt(9);
                    int quantity = rs.getInt(10);
                    int status = rs.getInt(11);
                    OrderCourseDTO dto = new OrderCourseDTO(courseID, image, name, description, price, startDate, endDate, cids, sellid, quantity, status);
                    ListProduct.add(dto);

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
        return ListProduct;
    }

    public boolean updateRecord(String image, String des, double price, String StartDate, String EndDate, String cid, String name, String quantity, String status, String courseID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        DBUtils db = new DBUtils();
        try {
            con = db.makeConnection();
            if (con != null) {
                String sql = "UPDATE [dbo].[courses]\n"
                        + "set [image]= ?,\n"
                        + "[description] = ?,\n"
                        + "price = ?,\n"
                        + "startDate = ?,\n"
                        + "endDate = ?,\n"
                        + "cid =?,\n"
                        + "name = ?,\n"
                        + "quantity=?,\n"
                        + "status=?\n"
                        + "where courseID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, image);
                stm.setString(2, des);
                stm.setDouble(3, price);
                stm.setString(4, StartDate);
                stm.setString(5, EndDate);
                stm.setString(6, cid);
                stm.setString(7, name);
                stm.setString(8, quantity);
                stm.setString(9, status);
                stm.setString(10, courseID);
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

    public boolean deleteRecord(String courseID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        DBUtils db = new DBUtils();
        try {
            con = db.makeConnection();
            if (con != null) {
                String sql = "Delete [dbo].[courses] Where courseID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, courseID);
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

    public boolean insertProduct(String image, String des, double price, String StartDate, String EndDate, String cid, String name, int sellid, int quantity, int status) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        DBUtils db = new DBUtils();
        try {
            con = db.makeConnection();
            if (con != null) {
                String sql = "insert into [dbo].[courses]\n"
                        + "values(?,?,?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, image);
                stm.setString(2, des);
                stm.setDouble(3, price);
                stm.setString(4, StartDate);
                stm.setString(5, EndDate);
                stm.setString(6, cid);
                stm.setString(7, name);
                stm.setInt(8, sellid);
                stm.setInt(9, quantity);
                stm.setInt(10, status);
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

    public int getTotalCourse() {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DBUtils db = new DBUtils();
        try {
            con = db.makeConnection();
            if (con != null) {
                String sql = "SELECT count(*)\n" +
                            "FROM [dbo].[courses]\n" +
                            "WHERE status = 1 AND quantity > 0";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<OrderCourseDTO> Switch(int cnt) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DBUtils db = new DBUtils();
        List<OrderCourseDTO> ListProduct = new ArrayList<>();
        try {
            con = db.makeConnection();
            if (con != null) {
                String sql = "SELECT *\n" +
                            "FROM [dbo].[courses]\n" +
                            "WHERE status = 1 AND quantity > 0\n" +
                            "ORDER BY startDate\n" +
                            "OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY;";
                
                stm = con.prepareStatement(sql);
                stm.setInt(1, cnt*6);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String courseID = rs.getString(1);
                    String image = rs.getString(2);
                    String description = rs.getString(3);
                    double price = rs.getDouble(4);
                    Date startDate = rs.getDate(5);
                    Date endDate = rs.getDate(6);
                    String cid = rs.getString(7);
                    String name = rs.getString(8);
                    int sellid = rs.getInt(9);
                    int quantity = rs.getInt(10);
                    int status = rs.getInt(11);
                    OrderCourseDTO dto = new OrderCourseDTO(courseID, image, name, description, price, startDate, endDate, cid, sellid, quantity, status);
                    ListProduct.add(dto);

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
        return ListProduct;
    }

}
