package chronodb.chrono.services;

import chronodb.chrono.models.Record;
import chronodb.chrono.models.Repository;
import chronodb.chrono.repository.RecordRepository;
import chronodb.chrono.repository.RepositoryRepo;
import chronodb.chrono.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecordService {

    private final RecordRepository recordRepository;
    private final RepositoryRepo repositoryRepo;

    public RecordService(RecordRepository recordRepository, RepositoryRepo repositoryRepo) {
        this.recordRepository = recordRepository;
        this.repositoryRepo = repositoryRepo;
    }

    // CREATE record
    public Record createRecord(Long repositoryId, String data, String createdBy) {
        Repository repo = repositoryRepo.findById(repositoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Repository not found with id " + repositoryId));

        Record record = new Record();
        record.setRepository(repo);
        record.setData(data);
        record.setCreatedBy(createdBy);
        record.setUpdatedBy(createdBy);
        record.setCreatedAt(LocalDateTime.now());
        record.setUpdatedAt(LocalDateTime.now());

        return recordRepository.save(record);
    }

    // UPDATE record
    public Record updateRecord(Long id, String newData, String updatedBy) {
        Record record = recordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found with id " + id));
        record.setData(newData);
        record.setUpdatedBy(updatedBy);
        record.setUpdatedAt(LocalDateTime.now());
        return recordRepository.save(record);
    }

    // GET all records in a repository
    public List<Record> getRecordsByRepository(Long repositoryId) {
        return recordRepository.findByRepository_Id(repositoryId);
    }

    // GET single record
    public Record getRecord(Long id) {
        return recordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found with id " + id));
    }

    // DELETE record
    public void deleteRecord(Long id) {
        if (!recordRepository.existsById(id)) {
            throw new ResourceNotFoundException("Record not found with id " + id);
        }
        recordRepository.deleteById(id);
    }
}
