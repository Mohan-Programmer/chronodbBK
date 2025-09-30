package chronodb.chrono.controller;

import chronodb.chrono.models.Record;
import chronodb.chrono.services.RecordService;
import chronodb.chrono.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
public class RecordController {

    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    // CREATE a record
    @PostMapping
    public ResponseEntity<Record> createRecord(@RequestParam Long repositoryId,
                                               @RequestParam String createdBy,
                                               @RequestBody String data) {
        Record created = recordService.createRecord(repositoryId, data, createdBy);
        return ResponseEntity.ok(created);
    }

    // UPDATE a record
    @PutMapping("/{id}")
    public ResponseEntity<Record> updateRecord(@PathVariable Long id,
                                               @RequestParam String updatedBy,
                                               @RequestBody String newData) {
        try {
            Record updated = recordService.updateRecord(id, newData, updatedBy);
            return ResponseEntity.ok(updated);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // GET all records for a repository
    @GetMapping("/repository/{repositoryId}")
    public List<Record> getRecordsByRepository(@PathVariable Long repositoryId) {
        return recordService.getRecordsByRepository(repositoryId);
    }

    // GET a single record
    @GetMapping("/{id}")
    public ResponseEntity<Record> getRecord(@PathVariable Long id) {
        try {
            Record record = recordService.getRecord(id);
            return ResponseEntity.ok(record);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE a record
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable Long id) {
        try {
            recordService.deleteRecord(id);
            return ResponseEntity.ok("Record deleted successfully");
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
