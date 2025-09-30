package chronodb.chrono.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="api_key")
public class ApiKey {
    @Id
    private String id;                 // Unique ID
    
    private String userId;             // Owner of the key
    private String apiKey;             // The actual key (random string/UUID)
    private String description;        // For identifying the key purpose
    private LocalDateTime createdAt;   // When the key was issued
    private LocalDateTime expiresAt;   // Optional expiration date
    private boolean active;            // Key enabled/disabled
}
