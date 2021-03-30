package ro.tourism.api.sport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tourism.api.sport.entity.Sport;

import java.util.List;
import java.util.Optional;

public interface SportRepository extends JpaRepository<Sport, Long> {

    List<Sport> findByOrderById();

    Optional<Sport> findById(final Long id);

    Optional<Sport> findByNameIgnoreCase(final String name);

}
