package pl.polsl.rtc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.rtc.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    void deleteUserByUsername(String username);

}
