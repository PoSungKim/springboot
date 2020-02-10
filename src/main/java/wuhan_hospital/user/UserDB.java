package wuhan_hospital.user;

import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;


import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class UserDB {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	UserDBRepository userDBRepository;
	
	
	public void join_user(User user) throws Exception {
		
		try (Connection connection = dataSource.getConnection()) {
			System.out.println(dataSource.getClass());
			System.out.println(connection.getMetaData().getDriverName());
			System.out.println(connection.getMetaData().getURL());
			System.out.println(connection.getMetaData().getUserName());

			
			userDBRepository.save(user);
		}
	}
}