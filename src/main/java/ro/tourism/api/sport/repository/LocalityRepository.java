package ro.tourism.api.sport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tourism.api.sport.entity.Locality;

import java.util.List;

public interface LocalityRepository extends JpaRepository<Locality, Long> {
    List<Locality> findByRegionId(final Long regionId);
}
