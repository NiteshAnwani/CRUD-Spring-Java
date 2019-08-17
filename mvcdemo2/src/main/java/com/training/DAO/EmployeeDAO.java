package com.training.DAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import com.training.DAO.*;
import com.training.beans.Emp;

import java.sql.*;
import java.util.List;

public class EmployeeDAO {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Emp e)
	{
		String sql="insert into emp(name,salary,desigination) values('"+e.getName()+"',"+e.getSalary()+",'"+e.getDesigination()+"')";
		return template.update(sql);
	}
	public int update(Emp e)
	{
		String sql="update emp set name='"+e.getName()+"',salary='"+e.getSalary()+"', desigination='"+e.getDesigination()+"' where id="+e.getId()+"";
		return template.update(sql);
	}
	public List<Emp> queryall()
	{    
		return template.query("select * from emp",new RowMapper<Emp>(){    
	        public Emp mapRow(ResultSet rs, int row) throws SQLException {    
	            Emp e=new Emp();    
	            e.setId(rs.getInt(1));    
	            e.setName(rs.getString(2));    
	            e.setSalary(rs.getInt(3));    
	            e.setDesigination(rs.getString(4));    
	            System.out.println(e.getId() +"  "+e.getName());
	            return e;    
	        }    
	    });
	    
	}   
    public int delete(int id){
    	String sql="delete from emp where id='"+id+"'";
    	return template.update(sql);
    }
    public Emp getEmpByID(int id)
    {
    	try
    	{
    	String sql="select * from emp where id=?";
    	return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class)); 
    	//return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));
    	}catch(Exception e){
    		System.out.println("Exception Catched "+e.toString());
    	}
		return new Emp();
    	
    }
}
