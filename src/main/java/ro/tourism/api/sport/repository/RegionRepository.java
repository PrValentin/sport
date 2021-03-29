package ro.tourism.api.sport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tourism.api.sport.entity.Region;

import java.util.List;
import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Long> {

    List<Region> findByOrderById();
    Optional<Region> findById(final Long id);
    Optional<Region> findByName(final String name);
    List<Region> findByCountryId(final Long id);
    void deleteByCountryId(final Long countryId);
}
