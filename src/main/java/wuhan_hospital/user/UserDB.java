package wuhan_hospital.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class UserDB {
//public class UserDB implements ApplicationRunner{
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	UserDBRepository userDBRepository;
	
	//@Override
	public void insert_user(User user) throws Exception {
	//public void run(ApplicationArguments args) throws Exception {
		try (Connection connection = dataSource.getConnection()) {
			System.out.println(dataSource.getClass());
			System.out.println(connection.getMetaData().getDriverName());
			System.out.println(connection.getMetaData().getURL());
			System.out.println(connection.getMetaData().getUserName());

			//Statement statement = connection.createStatement();
			//String sql = "CREATE TABLE USER(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
			//statement.executeUpdate(sql);
			
			/*
			User user = new User();
			user.setUsername("Po Sung");
			user.setPassword("poroy");
			*/
			
			User new_user = userDBRepository.save(user);
			

			
			//jdbc:h2:mem:testdb
			//connection.close();
		
			
			//jdbcTemplate.execute("CREATE TABLE USER(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id));");
		}
		
		//jdbcTemplate.execute("INSERT INTO USER VALUES (4, 'PoSung');");
		
	}
}