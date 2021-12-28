package individual.mystic.generator.repository;

import individual.mystic.generator.pojo.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
