package wuhan_hospital.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDBRepository extends JpaRepository <User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.user_id = ?1 AND u.user_pw = ?2")
	User findByUserIdANDUserPw(String username, String password);
}
