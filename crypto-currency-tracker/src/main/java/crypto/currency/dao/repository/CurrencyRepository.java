package crypto.currency.dao.repository;

import crypto.currency.dao.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Integer> {

    Optional<CurrencyEntity> findBySymbol(String symbol);
}
