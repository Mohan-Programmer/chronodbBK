package chronodb.chrono.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="system_setting")
public class SystemSetting {

    @Id
    private String id;                 // Unique ID

    private String settingName;        // Name of the setting (e.g., "backupEnabled")
    private String settingValue;       // Value of the setting (true/false, number, string)
    private String description;        // Description for admins
    private LocalDateTime updatedAt;   // When last updated
    private String updatedBy;          // Admin user who updated it
}
