package individual.mystic.generator.repository;

import individual.mystic.generator.pojo.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskTypeRepository extends JpaRepository<TaskType, UUID> {
}
