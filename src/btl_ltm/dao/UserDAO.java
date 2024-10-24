/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_ltm.dao;

import btl_ltm.entity.User;
import btl_ltm.mapper.UserMapper;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UserDAO extends DbContext<User>{
    
    public List<User> findAll() {
        String sql = "SELECT * FROM Users";
        return query(sql, new UserMapper());
    }
}
