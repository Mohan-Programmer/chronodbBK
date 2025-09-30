package chronodb.chrono.controller;

import chronodb.chrono.models.Record;
import chronodb.chrono.services.RecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/records")
public class RecordController {

    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    public ResponseEntity<Record> createRecord(@RequestBody Record record) {
        Record created = recordService.createRecord(record);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Record> updateRecord(@PathVariable Long id,
                                               @RequestBody Record updatedRecord) {
        Optional<Record> record = recordService.updateRecord(id, updatedRecord.getData(), updatedRecord.getUpdatedBy());
        return record.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/repository/{repositoryId}")
    public List<Record> getRecordsByRepository(@PathVariable Long repositoryId) {
        return recordService.getRecordsByRepository(repositoryId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Record> getRecord(@PathVariable Long id) {
        Optional<Record> record = recordService.getRecord(id);
        return record.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable Long id) {
        boolean deleted = recordService.deleteRecord(id);
        return deleted ? ResponseEntity.ok("Record deleted")
                       : ResponseEntity.notFound().build();
    }
}
