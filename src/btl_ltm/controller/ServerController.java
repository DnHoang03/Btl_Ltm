/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_ltm.controller;

import btl_ltm.dao.UserDAO;
import btl_ltm.entity.User;
import btl_ltm.entity.UserLogin;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author duckii
 */
public class ServerController {

    private ServerSocket myServer;
    private int serverPort = 8888;
    private UserDAO userDao;

    public ServerController() {
        userDao = new UserDAO();
        openServer(serverPort);
        while (true) {
            listenning();
        }
    }

    private void listenning() {
        try {
            Socket clientSocket = myServer.accept();
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());

            String eventName = (String) ois.readObject();
            Object o = ois.readObject();

            switch (eventName) {
                case "login":
                    handleEventLogin(o, oos);
                    break;
                case "register":
                    handleEventRegister(o, oos);
                    break;
            }

            if (o instanceof User) {
                User user = (User) o;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleEventLogin(Object o, ObjectOutputStream oos) throws IOException {
        UserLogin user = (UserLogin) o;
        User result = userDao.getUserByUserNamePassword(user.getUser(), user.getPassword());
        System.out.println(result == null ? "ok" : "fail");
        oos.writeObject(result == null ? "ok" : "fail");
        oos.flush();
    }

    private void handleEventRegister(Object o, ObjectOutputStream oos) throws IOException {
        UserLogin user = (UserLogin) o;
        User result = userDao.getUserByUserNamePassword(user.getUser(), user.getPassword());
        if (result == null) {
            oos.writeObject("fail");
            System.out.println( "fail");
            oos.flush();
        } else {
            userDao.InsertUser(user.getUser(), user.getPassword());
            System.out.println("ok");
            oos.writeObject("ok");
            oos.flush();
        }
    }

    private void openServer(int portNumber) {
        try {
            myServer = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
