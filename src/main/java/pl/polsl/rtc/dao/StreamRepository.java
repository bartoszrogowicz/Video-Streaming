package pl.polsl.rtc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.rtc.entity.Stream;

@Repository
public interface StreamRepository extends CrudRepository<Stream, Long> {

}
