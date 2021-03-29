package ro.tourism.api.sport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tourism.api.sport.entity.LocalitySport;

import java.util.List;

public interface LocalitySportRepository extends JpaRepository<LocalitySport, Long> {

    void deleteByLocalityIdIn(final List<Long> localitiesIds);
    void deleteByLocalityId(final Long id);
}
