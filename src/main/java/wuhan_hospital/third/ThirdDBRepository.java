
package wuhan_hospital.third;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Entity Type, ID Type> 
public interface ThirdDBRepository extends JpaRepository<Third, Long> {
	
}