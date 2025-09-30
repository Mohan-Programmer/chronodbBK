package chronodb.chrono.services;

import chronodb.chrono.models.Record;
import chronodb.chrono.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RecordService {

    private final RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    // Create a new record
    public Record createRecord(Record record) {
        record.setCreatedAt(LocalDateTime.now());
        record.setUpdatedAt(LocalDateTime.now());
        return recordRepository.save(record);
    }

    // Update existing record
    public Optional<Record> updateRecord(Long id, String newData, String updatedBy) {
        Optional<Record> optionalRecord = recordRepository.findById(id);
        if (optionalRecord.isPresent()) {
            Record record = optionalRecord.get();
            record.setData(newData);
            record.setUpdatedBy(updatedBy);
            record.setUpdatedAt(LocalDateTime.now());
            recordRepository.save(record);
        }
        return optionalRecord;
    }

    // Get all records in a repository
    public List<Record> getRecordsByRepository(Long repositoryId) {
        return recordRepository.findByRepositoryId(repositoryId);
    }

    // Get a single record
    public Optional<Record> getRecord(Long id) {
        return recordRepository.findById(id);
    }

    // Delete a record
    public boolean deleteRecord(Long id) {
        if (recordRepository.existsById(id)) {
            recordRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
