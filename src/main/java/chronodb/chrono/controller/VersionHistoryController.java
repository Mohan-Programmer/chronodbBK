package chronodb.chrono.controller;


import org.springframework.web.bind.annotation.*;

import chronodb.chrono.models.VersionHistory;
import chronodb.chrono.services.VersionHistoryService;

import java.util.List;

@RestController
@RequestMapping("/version-history")
public class VersionHistoryController {

    private final VersionHistoryService service;

    public VersionHistoryController(VersionHistoryService service) {
        this.service = service;
    }

    // Get all version history
    @GetMapping
    public List<VersionHistory> getAll() {
        return service.getAll();
    }

    // Get version history by recordId
    @GetMapping("/record/{recordId}")
    public List<VersionHistory> getByRecord(@PathVariable Long recordId) {
        return service.getByRecordId(recordId);
    }

    // Get version history by repositoryId
    @GetMapping("/repository/{repositoryId}")
    public List<VersionHistory> getByRepository(@PathVariable Long repositoryId) {
        return service.getByRepositoryId(repositoryId);
    }
}
