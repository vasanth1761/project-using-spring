package com.spring.demo.dao;

import java.sql.SQLException;
import java.util.List;
import com.spring.demo.mapper.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.demo.model.UserDetails;
@Repository
public class UserImpl implements UserDAO {
	
	@Autowired
	 JdbcTemplate jdbcTemplate;
		
	@Override
	public void insert(UserDetails user) throws ClassNotFoundException, SQLException {
    	System.out.println(user.getUserName());
		String query="insert into details(name,email,password)values(?,?,?)";
		Object[]table= {user.getUserName(),user.getEmail(),user.getPassword()};
		jdbcTemplate.update(query, table);
		
		
	}
	public List<UserDetails>get()throws ClassNotFoundException, SQLException{
		String query="select id,name,email,password from details where is_deleted=false ";
		List<UserDetails>user=jdbcTemplate.query(query,new Mapper());
		
		return user;
		
	}
   public void delete(int id) {

   {
	   String delete="update  details set is_deleted =true where id=?";
	   jdbcTemplate.update(delete,id);
	   
   }
   }
   public void update(UserDetails update)
   {
     String query="update details set name=?,password=?,email=?  where id=?";
     Object []table= {update.getUserName(),update.getPassword(),update.getEmail(),update.getId()};
     jdbcTemplate.update(query,table);
   }
   public List<UserDetails> search(String name)
   {
	 String query="select * from details where name LIKE ? OR email LIKE ?";
	 Object [] values = {"%"+name+"%","%"+name+"%"};
     return jdbcTemplate.query(query,new Mapper(),values);
    

}
}
