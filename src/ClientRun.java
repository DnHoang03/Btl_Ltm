
import btl_ltm.dao.UserDAO;
import btl_ltm.entity.User;
import btl_ltm.view.DisplayColor;
import btl_ltm.view.Login;
import btl_ltm.view.Register;
import java.awt.Color;
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
//        List<Color> colors = new ArrayList<>();
//        colors.add(new Color(1, 1, 1));
//        colors.add(new Color(55, 55, 55));
//        colors.add(new Color(100, 100, 100));
//        DisplayColor dis = new DisplayColor(colors);
//        dis.setVisible(true);
        Register register = new Register();
        register.setVisible(true);
    }
}
