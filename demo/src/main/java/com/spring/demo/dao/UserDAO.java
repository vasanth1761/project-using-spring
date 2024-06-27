package com.spring.demo.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.demo.model.UserDetails;
@Repository
public interface UserDAO {
	
	void insert(UserDetails user) throws ClassNotFoundException, SQLException;
	
	public List<UserDetails>get()throws ClassNotFoundException, SQLException;
	
	public void delete(int id);
	
	public void update(UserDetails update);
	
	public List<UserDetails> search(String name);
}
