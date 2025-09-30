package chronodb.chrono.dto;

import java.time.LocalDateTime;

public class RecordDTO {
    private Long id;
    private Long repositoryId;
    private String data;
    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;

    public RecordDTO(Long id, Long repositoryId, String data, String createdBy, LocalDateTime createdAt,
                     String updatedBy, LocalDateTime updatedAt) {
        this.id = id;
        this.repositoryId = repositoryId;
        this.data = data;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
    }

    // Getters and setters
    public Long getId() { return id; }
    public Long getRepositoryId() { return repositoryId; }
    public String getData() { return data; }
    public String getCreatedBy() { return createdBy; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public String getUpdatedBy() { return updatedBy; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
