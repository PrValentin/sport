package ro.tourism.api.sport.filter;

import org.springframework.data.jpa.domain.Specification;
import ro.tourism.api.sport.entity.LocalitySport;
import ro.tourism.api.sport.model.SportsFilterModel;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

public class SportLocalityFilterBuilder {

    private final SportsFilterModel filter;

    private static final String WRONG_DESTINATION_RESOLVED = "wrongDestinationResolved";

    public SportLocalityFilterBuilder(SportsFilterModel filter) {
        this.filter = filter;
    }

    public Specification<LocalitySport> buildFilter() {

        Specification<LocalitySport> localitySportSpecification = null;

        /*if(!StringUtils.isEmpty(filter.getIdSports())) {
            localitySportSpecification = Specification.where(localitySportSpecification.and((filter.getIdSports())));
        }*/

        if (filter.getStartSeason() != null) {
            localitySportSpecification =
                    Specification.where(localitySportSpecification).and(startDateIsBefore(filter.getStartSeason()));
        }

        if (filter.getEndSeason() != null) {
            localitySportSpecification =
                    Specification.where(localitySportSpecification).and(endDateIsAfter(filter.getEndSeason()));
        }

        if (filter.getIdSports() != null) {
            localitySportSpecification =
                    Specification.where(localitySportSpecification).and(localityId(filter.getIdSports()));
        }

        return localitySportSpecification;
    }

    private Specification<LocalitySport> startDateIsBefore(LocalDate startDate) {
        return new Specification<LocalitySport>() {
            @Override
            public Predicate toPredicate(Root<LocalitySport> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.lessThan(root.get("startSeason").as(LocalDate.class), startDate);
            }
        };
    }

    private Specification<LocalitySport> endDateIsAfter(LocalDate endDate) {
        return new Specification<LocalitySport>() {
            @Override
            public Predicate toPredicate(Root<LocalitySport> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThan(root.get("endSeason").as(LocalDate.class), endDate);
            }
        };
    }

    private Specification<LocalitySport> localityId(List<Long> idSports) {
        return new Specification<LocalitySport>() {
            @Override
            public Predicate toPredicate(Root<LocalitySport> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return root.get("sport").get("id").as(Long.class).in(idSports);
            }
        };
    }

}
