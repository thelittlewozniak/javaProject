package be.nathanPire.dao;

import java.sql.Connection;
import java.util.List;

import be.nathanPire.pojo.Game;

public class DaoGame extends DAO {

	public DaoGame(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
