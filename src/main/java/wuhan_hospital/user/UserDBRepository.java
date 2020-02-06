package wuhan_hospital.user;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Entity Type, ID Type> 
public interface UserDBRepository extends JpaRepository<User, Long> {
	
}