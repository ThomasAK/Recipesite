package banana.repository;

import banana.entity.BananaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BananaDataRepository extends JpaRepository<BananaData,Integer> {
}
