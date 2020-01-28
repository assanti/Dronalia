package com.dronalia.dao;

import java.sql.*;
import java.util.*;

import com.dronalia.dto.*;
import com.dronalia.enumClass.*;


public class ClientDao {

	/*
	 * Llista tots els clients de la base de dades
	 * 
	 */

	public List<Person> listar() {
		String SQL_SELECT = "SELECT * " + " FROM person";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Person person = null;
		List<Person> persons = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String dni = rs.getString("dni");
				String name = rs.getString("name");
				String surnames = rs.getString("surnames");
				String genre = rs.getString("genre");
				PersonGenreEnum genreEnum = genreEnum.valueOf(genre);
				String phone = rs.getString("phone");
				String email = rs.getString("email");
					
				person = new Person(dni, name, surnames, email , phone,genreEnum);
				
				
			}
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return clients;
	}

	/*
	 * Recupera un client a la base de dades segons el seu ID
	 * 
	 */
	public Person findById(Person person) {
		String SQL_SELECT_BY_ID = "SELECT * "
				+ " FROM person WHERE dni = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, person.getId());
			rs = stmt.executeQuery();
			rs.absolute(1);
			
			String dni = rs.getString("dni");
			String name = rs.getString("name");
			String surnames = rs.getString("surnames");
			String genre = rs.getString("genre");
			PersonGenreEnum genreEnum = genreEnum.valueOf(genre);
			String phone = rs.getString("phone");
			String email = rs.getString("email");

			person.setName(name);
			person.setSurnames(surnames);
			person.setGenre(genre);
			person.setPhone(phone);
			person.setEmail(email);

		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return person;
	}

	/*
	 * Crea un client a la base de dades
	 * 
	 */
	public int create(Person person) {
		String SQL_INSERT = "INSERT INTO client(cli_name, cli_surname, cli_email, cli_phone, cli_balance) "
				+ " VALUES(?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, person.getName());
			stmt.setString(2, person.getSurname());
			stmt.setString(3, person.getEmail());
			stmt.setString(4, person.getPhone());
			stmt.setDouble(5, person.getBalance());
			System.out.println(person.toString());
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
	public int update(Client client) {
		String SQL_UPDATE = "UPDATE client "
				+ " SET cli_name=?, cli_surname=?, cli_email=?, cli_phone=?, cli_balance=? WHERE cli_id=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			int i = 1;
			stmt.setString(i++, client.getName());
			stmt.setString(i++, client.getSurname());
			stmt.setString(i++, client.getEmail());
			stmt.setString(i++, client.getPhone());
			stmt.setDouble(i++, client.getBalance());
			stmt.setInt(i++, client.getId());

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
	 */
	public int delete(Client client) {
		String SQL_DELETE = "DELETE FROM client WHERE cli_id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, client.getId());
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
