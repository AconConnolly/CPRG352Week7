/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author alexc
 */
public class Role implements Serializable {
    String role;
    
    public Role() {}

    public Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (role.equals(1)) {
            this.role = "System Admin";
        }
        else {
            this.role = "Regular User";
        }
    }
   
}
