package pl.kobietydokodu.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.kobietydokodu.koty.domain.Kot;

@Repository
public class KotDAOImpl_JDBC implements KotDAO {
	String addCatQuery = "INSERT INTO `koty` (imie,dataUrodzenia,waga,imieOpiekuna) VALUES (?,?,?,?);";
	String getAllCatsQuery = "SELECT * FROM koty;";
	String getCatByIdQuery = "SELECT * FROM koty WHERE id = ?;";

	@Autowired
	private DataSource dataSource;

	public void dodajKota(Kot kot) {
		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(addCatQuery);) {
			ps.setString(1, kot.getImie());
			java.util.Calendar cal = Calendar.getInstance();
			/*
			 * Probably not the best way to convert data form util.Data to Sql
			 * Data, but enough good here
			 */
			cal.setTime(kot.getDataUrodzenia());
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			java.sql.Date sqlDataUrodzenia = new java.sql.Date(cal.getTime().getTime());
			ps.setDate(2, sqlDataUrodzenia);
			ps.setFloat(3, kot.getWaga());
			ps.setString(4, kot.getImieOpiekuna());
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Kot> getKoty() {
		try (Connection conn = dataSource.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(getAllCatsQuery);) {
			List<Kot> koty = new ArrayList<Kot>();
			while (rs.next()) {
				Kot kot = new Kot();
				kot.setId(rs.getInt("id"));
				kot.setImie(rs.getString("imie"));
				kot.setImieOpiekuna(rs.getString("imieOpiekuna"));
				kot.setDataUrodzenia(rs.getDate("dataUrodzenia"));
				kot.setWaga(rs.getFloat("waga"));
				koty.add(kot);

			}
			return koty;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Kot getKotById(Integer id) {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(getCatByIdQuery);) {
			Kot kot = new Kot();
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				kot.setId(rs.getInt("id"));
				kot.setImie(rs.getString("imie"));
				kot.setImieOpiekuna(rs.getString("imieOpiekuna"));
				kot.setDataUrodzenia(rs.getDate("dataUrodzenia"));
				kot.setWaga(rs.getFloat("waga"));
			}
			return kot;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
