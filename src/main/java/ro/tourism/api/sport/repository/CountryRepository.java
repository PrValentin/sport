package ro.tourism.api.sport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tourism.api.sport.entity.Country;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

   List<Country> findByOrderById();

   Optional<Country> findById(final Long id);

}
