package chronodb.chrono.repository;

import chronodb.chrono.models.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {
    // Fetch all records for a repository by repository ID
    List<Record> findByRepository_Id(Long repositoryId);
}
