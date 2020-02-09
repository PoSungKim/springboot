package wuhan_hospital.second;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import javax.sql.DataSource;

@Component
public class SecondDB {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	SecondDBRepository secondDBRepository;
	
	public void insert_info(Second second) throws Exception {
		
		try (Connection connection = dataSource.getConnection()) {
			System.out.println(dataSource.getClass());
			System.out.println(connection.getMetaData().getDriverName());
			System.out.println(connection.getMetaData().getURL());
			System.out.println(connection.getMetaData().getUserName());

			
			Second new_second = secondDBRepository.save(second);
		}
				
	}
}
