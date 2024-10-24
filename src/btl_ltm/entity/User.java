/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_ltm.entity;

/**
 *
 * @author Admin
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer score;
    private Integer match;

    public User() {}
    
    public User(Integer id, String username, String password, Integer score, Integer match) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.score = score;
        this.match = match;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getMatch() {
        return match;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setMatch(Integer match) {
        this.match = match;
    }
    
    
}
