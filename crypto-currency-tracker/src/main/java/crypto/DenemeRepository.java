package crypto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DenemeRepository extends JpaRepository<DenemeEntity, Integer> {
    DenemeEntity findByData(Integer data);
}
