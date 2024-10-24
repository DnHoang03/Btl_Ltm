/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_ltm.controller;

import btl_ltm.entity.UserLogin;
import java.io.*;
import java.net.Socket;

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
            oos.writeObject(user);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public String receiveData() {
        String result = null;
        try {
            ObjectInputStream ois
                    = new ObjectInputStream(mySocket.getInputStream());
            Object o = ois.readObject();
            if (o instanceof String) {
                result = (String) o;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return result;
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
