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
public class UserDAO extends DbContext<User> {

    public List<User> findAll() {
        String sql = "SELECT * FROM Users";
        return query(sql, new UserMapper());
    }

    public User getUserByUserNamePassword(String user, String pass) {
        try{
            String query = "SELECT * FROM users WHERE username = ? AND pass = ? LIMIT 1";
            List<User> users = query(query, new UserMapper(), user, pass);

            return users == null ? null : users.get(0);
        }
        catch(Exception ex){
            return null;
        }
    }

    public void InsertUser(String user, String pass) {
        try {
            String query = "INSERT INTO users(username, pass) value(?,?) ";
            insert(query, user, pass);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public List<User> GetRanks(){
        try  {
            String query = "SELECT * FROM users";
            List<User> users = query(query, new UserMapper());
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
