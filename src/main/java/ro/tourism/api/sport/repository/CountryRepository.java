package ro.tourism.api.sport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tourism.api.sport.entity.Country;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {

   List<Country> findByOrderById();

}
