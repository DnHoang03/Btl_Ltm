/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_ltm.controller;

import btl_ltm.entity.Room;
import btl_ltm.entity.User;
import btl_ltm.entity.UserLogin;
import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public Socket getMySocket() {
        return mySocket;
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
            oos.close();
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
            ois.close();
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
    
    
    public Integer receiveFindGame() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
        Integer result = null;
        try {
            while (result == null) {
                try {
                    Object data = ois.readObject();
                    if (data instanceof Integer) {
                        result = (Integer) data;
                    } else {
                        throw new IOException("Expected Integer but received " + data.getClass().getName());
                    } // Đọc trực tiếp đối tượng từ luồng
                } catch (EOFException e ) {
                    // Nếu chưa có dữ liệu, tiếp tục chờ
                    Thread.sleep(100); // Chờ một khoảng thời gian ngắn trước khi thử lại
                }
            }
        } catch (InterruptedException | IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    
    
    
    public void sendEndGame(Room room) {
        try {
            ObjectOutputStream oos
                    = new ObjectOutputStream(mySocket.getOutputStream());
            oos.writeObject("endGame");
            oos.flush();
            oos.writeObject(room);
            oos.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public Room receiveEndGame() throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
        Room result = null;
        try {
            while (result == null) {
                try {
                    result = (Room) ois.readObject();
                } catch (EOFException e ) {
                    // Nếu chưa có dữ liệu, tiếp tục chờ
                    Thread.sleep(100); // Chờ một khoảng thời gian ngắn trước khi thử lại
                }
            }
        } catch (InterruptedException | IOException ex) {
            ex.printStackTrace();
        }
        
        return result;
//        while (true) {
//            if (ois.available() > 0) {
//                try {
//                    Object obj = ois.readObject(); // Chờ đến khi có đối tượng được gửi từ server
//                    if (obj instanceof Room) {
//                        Room message = (Room) obj;
//                        return message;
//                    }
//                }  catch (ClassNotFoundException e) {
//                        System.err.println("Không tìm thấy lớp của đối tượng được nhận.");
//                        e.printStackTrace();
//                }
//            }
//
//        }
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
