/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_ltm.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Admin
 */
public class PopupUtil {
    public static void showTemporaryPopup(JFrame parent, String message, int duration) {
        // Hiện thông báo popup
        JDialog dialog = new JDialog(parent, "Popup", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.add(new JLabel(message, SwingConstants.CENTER));
        dialog.setSize(200, 100);
        dialog.setLocationRelativeTo(parent); // Đặt dialog ở giữa frame cha
        dialog.setVisible(true);

        // Tạo một Timer để tự động đóng popup sau 'duration' milliseconds
        Timer timer = new Timer(duration, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Đóng dialog
            }
        });
        timer.setRepeats(false); // Chỉ chạy một lần
        timer.start(); // Bắt đầu Timer
    }
}
