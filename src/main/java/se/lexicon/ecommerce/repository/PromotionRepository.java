package se.lexicon.ecommerce.repository;

import se.lexicon.ecommerce.model.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    // 1. Find a promotion using the promo code
    Optional <Promotion> findByCode(String code);

    // 2. Find promotions that are active on a given date.
    List<Promotion> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate date1, LocalDate date2);

}