/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_ltm.controller;

import btl_ltm.entity.User;
import btl_ltm.entity.UserLogin;
import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author duckii
 */
public class ClientController {

    private Socket mySocket;
    private String serverHost = "localhost";
    private int serverPort = 8888;

    public ClientController() {

    }

    public Socket openConnection() {
        try {
            mySocket = new Socket(serverHost, serverPort);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return mySocket;
    }

    public boolean sendDataLogin(UserLogin user) {
        try {

            ObjectOutputStream oos
                    = new ObjectOutputStream(mySocket.getOutputStream());
            oos.writeObject("login");
            oos.writeObject(user);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean sendDataRegister(UserLogin user) {
        try {

            ObjectOutputStream oos
                    = new ObjectOutputStream(mySocket.getOutputStream());
            oos.writeObject("register");
            oos.flush();
            oos.writeObject(user);
            oos.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }
    
    public boolean sendMessageGetRanks(){
        try {
            ObjectOutputStream oos
                    = new ObjectOutputStream(mySocket.getOutputStream());
            oos.writeObject("getRanks");
            oos.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }
    
    public List<User> receiveListRanks(){
        try {
            ObjectInputStream ois
                    = new ObjectInputStream(mySocket.getInputStream());
            Object o = ois.readObject();
            List<User> res = (List<User>) o;
            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public User receiveDataAuth() {
        try {
            ObjectInputStream ois
                    = new ObjectInputStream(mySocket.getInputStream());
            Object o = ois.readObject();
            User user = (User) o;
            System.out.println(user);
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public void sendFindingGame() {
        try {
            ObjectOutputStream oos
                    = new ObjectOutputStream(mySocket.getOutputStream());
            oos.writeObject("findGame");
            oos.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public CompletableFuture<String> findGameAsync() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
                while (true) {
                    if (ois.available() > 0) {
                        try {
                            Object obj = ois.readObject(); // Chờ đến khi có đối tượng từ server
                            if (obj instanceof String) {
                                String message = (String) obj;
                                System.out.println("Tìm được trận: " + message);
                                return message; // Trả về thông tin trận đấu khi tìm được
                            }
                        } catch (ClassNotFoundException e) {
                            System.err.println("Không tìm thấy lớp của đối tượng được nhận.");
                            e.printStackTrace();
                        } catch (EOFException e) {
                            System.err.println("Kết nối bị đóng bởi server.");
                            break; // Thoát vòng lặp nếu server đóng kết nối
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Lỗi khi tạo ObjectInputStream.");
                e.printStackTrace();
            }
            return null; // Trả về null nếu không có trận nào
        });
    }

    public boolean closeConnection() {
        try {
            mySocket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }
}
