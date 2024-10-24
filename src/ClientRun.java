
import btl_ltm.dao.UserDAO;
import btl_ltm.entity.User;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author duckii
 */
public class ClientRun {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        List<User> users = dao.findAll();
    }
}
