package individual.mystic.generator.repository;

import individual.mystic.generator.pojo.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkerRepository extends JpaRepository<Worker, UUID> {
}
