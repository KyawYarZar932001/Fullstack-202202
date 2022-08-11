package com.kyz.assignment.model.impl;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.kyz.assignment.domain.Course;
import com.kyz.assignment.domain.OpenClass;
import com.kyz.assignment.model.OpenClassModel;

public class OpenClassModelImpl implements OpenClassModel {	
    private static final String SELECT_SQL = """
    		select oc.id , oc.start_date  , oc.teacher ,
    		c.id courseId, c.name ,c.duration , c.fees, c.description
    		
    		from open_class oc join course c on oc.course_id= c.id
    		where c.id = ?
    		
    		
    		""";
	private static final String INSERT = "insert into open_class (course_id, start_date ,teacher) values (?,?,?)";
	private static final String SELECT_FINAL = "select id,start_date,teacher FROM open_class WHERE id = ?";
	
	private DataSource dataSource;
    
	public OpenClassModelImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	
	public List<OpenClass> findByCourse(int courseId) {
	    var list= new ArrayList<OpenClass>();	
		try(var conn=dataSource.getConnection();
			var stmt=conn.prepareStatement(SELECT_SQL)){
			
			stmt.setInt(1, courseId);
			var rs= stmt.executeQuery();
			
			while(rs.next()) {
				
				var c = new Course();
				c.setId(rs.getInt("CourseId"));
				c.setName(rs.getString("name"));
				c.setDuration(rs.getInt("duration"));
				c.setFees(rs.getInt("fees"));
			    c.setDescription(rs.getString("duration"));
			    
			    
				var oc = new OpenClass();
				oc.setCourse(c);
				
				
		        oc.setTeacher(rs.getString("teacher"));
		        oc.setId(rs.getInt("id"));
		        oc.setStartDate(rs.getDate("start_date").toLocalDate());
		        list.add(oc);
			}
			
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void create(OpenClass openClass) {
		
		try(var conn= dataSource.getConnection();
				
				var stmt=conn.prepareStatement(INSERT)){
			
			   stmt.setString(1, openClass.getTeacher());
			   stmt.setInt(2, openClass.getCourse().getId());
			   stmt.setDate(3, Date.valueOf(openClass.getStartDate()));
               stmt.executeUpdate();
               
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public OpenClass findById(int id) {
		try(var conn= dataSource.getConnection();
				var stmt = conn.prepareStatement(SELECT_FINAL)){
			stmt.setInt(1, id);
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				OpenClass oc = new OpenClass();
				oc.setTeacher(rs.getString("teacher"));
		        oc.setId(rs.getInt("id"));
		        oc.setStartDate(rs.getDate("start_date").toLocalDate());
		        
		        return oc;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	

}
