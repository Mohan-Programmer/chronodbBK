package chronodb.chrono.services;

import java.util.List;

import org.springframework.stereotype.Service;

import chronodb.chrono.models.VersionHistory;
import chronodb.chrono.repository.VersionHistoryRepository;

@Service
public class VersionHistoryService {

    private final VersionHistoryRepository repository;

    public VersionHistoryService(VersionHistoryRepository versionHistoryRepository)
    {
        this.repository=versionHistoryRepository;
    }
    


    public List<VersionHistory> getByRecordId(Long recordId) {
        return repository.findByRecordId(recordId);
    }

    public List<VersionHistory> getByRepositoryId(Long repositoryId) {
        return repository.findByRepositoryId(repositoryId);
    }

    public List<VersionHistory> getAll() {
        return repository.findAll();
    }



}
