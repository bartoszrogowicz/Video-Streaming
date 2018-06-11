package pl.polsl.rtc.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.polsl.rtc.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    void deleteUserByUsername(String username);

    void deleteUserById(long id);

    User findUserByUsername(String username);

    @Query(value = "SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.username = :username")
    boolean existByEmail(@Param("username") String username);
}
