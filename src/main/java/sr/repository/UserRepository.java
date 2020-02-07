package sr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sr.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
