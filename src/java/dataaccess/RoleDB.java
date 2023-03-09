/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Role;
import models.User;

/**
 *
 * @author alexc
 */
public class RoleDB {
    
    public Role getRole (int id) {
        Role role;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "Select * from role where role_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id+"");
            rs = ps.executeQuery();
            while (rs.next()) {
                int roleId = rs.getInt(1);
                String name = rs.getString(2);
                role = new Role(name, roleId);
                return role;
            }
        }
        catch(Exception e) {
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return null;
    
    }
    
     
    public List<Role> getAll () throws Exception {
        List<Role> roles = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM role";
        
        try {
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                int roleId = rs.getInt(1);
                String name = rs.getString(2);
                Role role = new Role(name, roleId);
                roles.add(role);
       
            }
        } finally { 
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return roles;
  
    }
}
