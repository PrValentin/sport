package ro.tourism.api.sport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tourism.api.sport.entity.Locality;

import java.util.List;
import java.util.Optional;

public interface LocalityRepository extends JpaRepository<Locality, Long> {
    List<Locality> findByRegionId(final Long regionId);
    List<Locality> findByOrderById();
    Optional<Locality> findByName(final String name);
    Optional<Locality> findById(final Long id);
    List<Locality> findByRegionIdIn(final List<Long> localitiesIds);
    void deleteByRegionIdIn(final List<Long> regionsIds);
}
