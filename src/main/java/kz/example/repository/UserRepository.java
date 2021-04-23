package kz.example.repository;

import kz.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query(value = "SELECT * FROM i_user u Where u.name=?1 and u.password=?2", nativeQuery = true)
    User findUser(String name, String password);

}
