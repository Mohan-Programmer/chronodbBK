package chronodb.chrono.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name="records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Which repository this record belongs to
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repository_id", nullable = false)
    private Repository repository;

    // Store your record data (JSON, string, or structured text)
    @Column(columnDefinition = "TEXT")
    private String data;

    // Metadata
    private String createdBy;
    private LocalDateTime createdAt = LocalDateTime.now();

    private String updatedBy;
    private LocalDateTime updatedAt = LocalDateTime.now();
}
