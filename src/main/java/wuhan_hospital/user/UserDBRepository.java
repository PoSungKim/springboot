package wuhan_hospital.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDBRepository extends JpaRepository<User, Long> {
	
}