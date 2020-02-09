package wuhan_hospital.first;

import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class FirstDB {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	FirstDBRepository firstDBRepository;
	
	public void insert_info(First first) throws Exception {
		
		try (Connection connection = dataSource.getConnection()) {
			System.out.println(dataSource.getClass());
			System.out.println(connection.getMetaData().getDriverName());
			System.out.println(connection.getMetaData().getURL());
			System.out.println(connection.getMetaData().getUserName());

			
			First new_first = firstDBRepository.save(first);
		}
	}
}