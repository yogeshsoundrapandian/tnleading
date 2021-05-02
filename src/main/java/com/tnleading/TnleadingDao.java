package com.tnleading;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Component
public class TnleadingDao {

private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public TnleadingDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
public List<TnleadingPojo> getData() {
		
		String query = "SELECT * FROM tnresult";
		
		List<TnleadingPojo> list = jdbcTemplate.query(
				query, 
				new RowMapper<TnleadingPojo>() {
		            public TnleadingPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	TnleadingPojo pojo = new TnleadingPojo();
		            	pojo.setLeading(rs.getInt(1));
		            	pojo.setDmk_plus(rs.getInt(2));
		            	pojo.setAdmk_plus(rs.getInt(3));
		            	pojo.setMnm_plus(rs.getInt(4));
		            	pojo.setAmmk_plus(rs.getInt(5));
		            	pojo.setNtk(rs.getInt(6));
		                return pojo;
		            }
				});
		
		return list;
	}
}
