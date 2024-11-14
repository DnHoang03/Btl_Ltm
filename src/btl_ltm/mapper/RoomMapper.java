/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_ltm.mapper;

import btl_ltm.entity.Room;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class RoomMapper implements RowMapper<Room>{

    @Override
    public Room mapRow(ResultSet rs) {
        try {
            Room room = new Room();
            room.setId(rs.getInt("id"));
            room.setWinner(rs.getString("winner"));
            room.setBestScore(rs.getInt("best_score"));
            room.setEnable(rs.getInt("enable"));
            room.setTotalCompleted(rs.getInt("total_completed"));
            return room;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } 
    }
    
}
