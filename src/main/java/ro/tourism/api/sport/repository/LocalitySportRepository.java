package ro.tourism.api.sport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tourism.api.sport.entity.LocalitySport;

import java.util.List;
import java.util.Optional;

public interface LocalitySportRepository extends JpaRepository<LocalitySport, Long> {

    void deleteByLocalityIdIn(final List<Long> localitiesIds);

    void deleteByLocalityId(final Long id);

    void deleteBySportId(final Long id);

    List<LocalitySport> findByOrderById();

    Optional<LocalitySport> findById(final Long id);

}
