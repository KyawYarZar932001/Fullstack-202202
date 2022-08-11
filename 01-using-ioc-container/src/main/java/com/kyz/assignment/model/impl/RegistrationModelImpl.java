package com.kyz.assignment.model.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import com.kyz.assignment.domain.OpenClass;
import com.kyz.assignment.domain.Registration;
import com.kyz.assignment.model.RegistrationModel;

public class RegistrationModelImpl implements RegistrationModel{
	
    private static final String SELECT_SQL = """
    		select re.id,re.student,re.phone,re.email,
    		oc.id classId,oc.start_date, oc.teacher
    		from registration re join open_class oc on re.open_class_id = oc.id
    		where oc.id = ?
    		""";
	private static final String INSERT = "insert into registration(open_class_id,student,phone,email)values(?,?,?,?)";
	private DataSource dataSource;

	public RegistrationModelImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<Registration> findByClass(int id) {
		
		var list= new ArrayList<Registration>();
		
		try(var conn = dataSource.getConnection();
				var stmt= conn.prepareStatement(SELECT_SQL)){
			
             stmt.setInt(1, id);
             
             var rs = stmt.executeQuery();
             
             while(rs.next()) {
             	var oc = new OpenClass();
             	oc.setId(rs.getInt("id"));
             	oc.setTeacher(rs.getString("teacher"));
		        oc.setStartDate(rs.getDate("start_date").toLocalDate());
		        
		        var re = new Registration();
		        re.setOpenClass(oc);
		        
		        re.setStudent(rs.getString("student"));
		        re.setPhone(rs.getString("phone"));
 			    re.setEmail(rs.getString("email"));
 			    re.setId(rs.getInt("id"));
 			    list.add(re);
             }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return list;
	}

	@Override
	public void save(Registration re) {

		try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(INSERT)){
			
			stmt.setInt(1, re.getOpenClass().getId());
			stmt.setString(2,re.getStudent());
			stmt.setString(3,re.getPhone());
			stmt.setString(4,re.getEmail());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
}
