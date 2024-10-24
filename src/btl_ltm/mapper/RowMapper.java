/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_ltm.mapper;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public interface RowMapper<T> {
	T mapRow(ResultSet rs);
}
