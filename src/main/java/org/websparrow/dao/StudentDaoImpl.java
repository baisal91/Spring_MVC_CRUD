package org.websparrow.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.websparrow.model.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public StudentDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	@Override
	public int create(Student student) {

		String sql = "insert into student1(stu_name,stu_email,stu_course,stu_address,stu_city,stu_subjects) values(?,?,?,?,?,?)";

		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] { student.getName(), student.getEmail(), student.getCourse(), student.getAddress(), student.getCity(), student.getSubjects().toString()});

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Student> read() {
		List<Student> studentList = jdbcTemplate.query("SELECT * FROM STUDENT1", new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();

				student.setId(rs.getInt("stu_id"));
				student.setName(rs.getString("stu_name"));
				student.setEmail(rs.getString("stu_email"));
				student.setCourse(rs.getString("stu_course"));
				student.setAddress(rs.getString("stu_address"));
				student.setCity(rs.getString("stu_city"));
				student.setSubjects(Arrays.asList(rs.getString("stu_subjects").split("\\s*,\\s*")));

				return student;
			}

		});

		return studentList;
	}

	@Override
	public List<Student> findStudentById(int studentId) {

		List<Student> studentList = jdbcTemplate.query("SELECT * FROM STUDENT1 where stu_id=?",
				new Object[] { studentId }, new RowMapper<Student>() {

					@Override
					public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						Student student = new Student();

						student.setId(rs.getInt("stu_id"));
						student.setName(rs.getString("stu_name"));
						student.setEmail(rs.getString("stu_email"));
						student.setCourse(rs.getString("stu_course"));
						student.setAddress(rs.getString("stu_address"));
						student.setCity(rs.getString("stu_city"));
						student.setSubjects(Arrays.asList(rs.getString("stu_subjects").split("\\s*,\\s*")));

						return student;
					}

				});

		return studentList;
	}

	@Override
	public int update(Student student) {
		String sql = "update  student1 set stu_name=?, stu_email=?, stu_course=?, stu_address = ?, stu_city = ?, stu_subjects = ? where stu_id=?";

		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] { student.getName(), student.getEmail(), student.getCourse(), student.getAddress(), student.getCity(), student.getSubjects().toString(), student.getId() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int studentId) {
		String sql = "delete from student1 where stu_id=?";

		try {

			int counter = jdbcTemplate.update(sql, new Object[] { studentId });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
