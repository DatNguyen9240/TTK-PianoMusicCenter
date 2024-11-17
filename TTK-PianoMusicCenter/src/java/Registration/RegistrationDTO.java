/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class RegistrationDTO implements Serializable{
    private String username;
    private String password;
    private String lastname;
    private boolean role;
    private int sellid;
    public RegistrationDTO() {
    }

    public RegistrationDTO(String username, String password, String lastname, boolean role, int sellid) {
        this.username = username;
        this.password = password;
        this.lastname = lastname;
        this.role = role;
        this.sellid = sellid;
    }

    

    public RegistrationDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isRole() {
        return role;
    }

    public int getSellid() {
        return sellid;
    }

    public void setSellid(int sellid) {
        this.sellid = sellid;
    }

    public void setRole(boolean role) {
        this.role = role;
    }
    
    
}
