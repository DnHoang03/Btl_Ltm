/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_ltm.view;

/**
 *
 * @author Admin
 */
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedPanelExample extends JFrame {

    public RoundedPanelExample() {
        setTitle("Rounded Panel Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Tạo một JPanel có viền tròn
        RoundedPanel roundedPanel = new RoundedPanel(50); // Bán kính góc tròn là 30
        roundedPanel.setPreferredSize(new Dimension(200, 150));
        roundedPanel.setBackground(Color.LIGHT_GRAY); // Màu nền của panel

        // Thêm RoundedPanel vào JFrame
        add(roundedPanel);
    }

    // Lớp JPanel với viền tròn
    class RoundedPanel extends JPanel {
        private int cornerRadius;

        public RoundedPanel(int cornerRadius) {
            this.cornerRadius = cornerRadius;
            setOpaque(false); // Đặt panel trong suốt
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Tăng cường độ mượt mà
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Tạo hình dạng tròn
            Shape roundRect = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
            
            // Vẽ nền
            g2d.setColor(getBackground());
            g2d.fill(roundRect);

            // Vẽ viền
            g2d.setColor(Color.BLACK); // Màu viền
            g2d.draw(roundRect);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 150);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RoundedPanelExample frame = new RoundedPanelExample();
            frame.setVisible(true);
        });
    }
}