package chronodb.chrono.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chronodb.chrono.models.VersionHistory;

import java.util.List;

public interface VersionHistoryRepository extends JpaRepository<VersionHistory, Long> {
    List<VersionHistory> findByRecordId(Long recordId);
    List<VersionHistory> findByRepositoryId(Long repositoryId);
}
