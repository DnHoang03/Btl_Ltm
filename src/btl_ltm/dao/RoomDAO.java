/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_ltm.dao;

import btl_ltm.entity.Room;
import btl_ltm.mapper.RoomMapper;
import java.util.List;

/**
 *
 * @author Admin
 */
public class RoomDAO extends DbContext<Room>{
    
    public Room getRoomById(int id) {
        try{
            String query = "SELECT * FROM room WHERE id = ? LIMIT 1";
            List<Room> rooms = query(query, new RoomMapper(), id);

            return rooms == null ? null : rooms.get(0);
        }
        catch(Exception ex){
            return null;
        }
    }
    
    public int insertRoom() {
        try {
            String query = "INSERT INTO room(enable) value(1) ";
            return insert(query);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void updateRoom(int id, String username, int score) {
        try {
            String query = "UPDATE room " +
                    "SET winner = ? AND best_score = ?" +
                    "WHERE id = ?";
            update(query, username, score, id);
        } catch (Exception e) {
            throw e;
        }
    }
}
