package com.dronalia.dao;

import java.sql.*;
import java.util.*;

import com.dronalia.dto.*;
import com.dronalia.enumClass.*;


public class SkinDao {

	/*
	 * Llista tots els clients de la base de dades
	 * 
	 */

	public List<Skin> skinList() {
		String SQL_SELECT = "SELECT * " + " FROM skin";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Skin skin = null;
		List<Skin> skins_list = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int skin_id = rs.getInt("skin_id");
				String str_skin_type = rs.getString("skin_type");
				SkinTypeEnum enum_skin_type = SkinTypeEnum.valueOf(str_skin_type);
				String skin_cover = rs.getString("skin_cover");
				double skin_price = rs.getDouble("skin_price");
				String skin_description = rs.getString("skin_description");				

				skin = new Skin(skin_id, enum_skin_type, skin_cover, skin_price, skin_description);
				skins_list.add(skin);
			}
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return skins_list;
	}

	/*
	 * Recupera un client a la base de dades segons el seu ID
	 * 
	 */
	
	public Skin findById(Skin skin) {
		String SQL_SELECT_BY_ID = "SELECT * "
				+ " FROM skin WHERE skin_id= ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, skin.getId());
			rs = stmt.executeQuery();
			rs.absolute(1);
			
			int skin_id = rs.getInt("skin_id");
			String str_skin_type = rs.getString("skin_type");
			SkinTypeEnum enum_skin_type = SkinTypeEnum.valueOf(str_skin_type);
			String skin_cover = rs.getString("skin_cover");
			double skin_price = rs.getDouble("skin_price");
			String skin_description = rs.getString("skin_description");				

			skin.setType(enum_skin_type);
			skin.setCover(skin_cover);
			skin.setPrice(skin_price);
			skin.setDescription(skin_description);

		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return skin;
	}

	/*
	 * Crea un client a la base de dades
	 * 
	 */
	
	public int create(Skin skin) {
		String SQL_INSERT = "INSERT INTO skin(skin_id, skin_type, skin_cover, skin_price, skin_description) "
				+ " VALUES(?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setInt(1, skin.getId());
			stmt.setString(2, String.valueOf(skin.getType()));
			stmt.setString(3, skin.getCover());
			stmt.setDouble(4, skin.getPrice());
			stmt.setString(5, skin.getDescription());
			System.out.println(skin.toString());
			rows = stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return rows;
	}

	/*
	 * Modifica un client de la base de dades
	 * 
	 */
	//FIXME
	public int update(Skin skin) {
		String SQL_UPDATE = "UPDATE skin "
				+ " SET skin_type=?, skin_cover=?, skin_price=?, skin_description=? WHERE skin_id=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			int i = 1;
			
			stmt.setString(i++, String.valueOf(skin.getType()));
			stmt.setString(i++, skin.getCover());
			stmt.setDouble(i++, skin.getPrice());
			stmt.setString(i++, skin.getDescription());
			stmt.setInt(i++, skin.getId());

			rows = stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return rows;
	}

	/*
	 * Esborra un client de la base de dades
	 * 
	 *///FIXME
	public int delete(Skin skin) {
		String SQL_DELETE = "DELETE FROM skin WHERE skin_id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, skin.getId());
			rows = stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return rows;
	}

}
