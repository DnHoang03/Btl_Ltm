/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_ltm.mapper;

import btl_ltm.entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Admin
 */
public class UserMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet rs) {
        try {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setScore(rs.getInt("score"));
            user.setMatch(rs.getInt("match"));
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } 
    }
    
}
