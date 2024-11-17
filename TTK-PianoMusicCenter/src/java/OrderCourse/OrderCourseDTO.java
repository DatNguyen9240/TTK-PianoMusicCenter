/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderCourse;

import java.sql.Date;

/**
 *
 * @author XinWei
 */
public class OrderCourseDTO {
    private String courseID;
    private String image;
    private String name;
    private String description;
    private double price;
    private Date startDate;
    private Date endDate;
    private String cid;
    private int sellid;
    private int quanity;
    private int status;
    public OrderCourseDTO() {
    }

    public OrderCourseDTO(String courseID, String image, String name, String description, double price, Date startDate, Date endDate, String cid, int sellid, int quanity, int status) {
        this.courseID = courseID;
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cid = cid;
        this.sellid = sellid;
        this.quanity = quanity;
        this.status = status;
    }

    

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getSellid() {
        return sellid;
    }

    public void setSellid(int sellid) {
        this.sellid = sellid;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
}
