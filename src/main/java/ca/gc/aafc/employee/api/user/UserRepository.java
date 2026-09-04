package ca.gc.aafc.employee.api.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	@EntityGraph(attributePaths = "roles")
	Optional<User> findByUsername(String username);
}
