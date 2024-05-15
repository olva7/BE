package MI.com.example.MI_Project.entities;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.nio.ByteBuffer;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;
@Setter
@Getter

@NoArgsConstructor
@Table("demande_image")
public class DemandeImage {
    @PrimaryKey
    private UUID idImage;

    @Column(name = "imageData")
    private ByteBuffer imageData;

    @Column(name = "uploadDate")
    private Instant uploadDate;

    @Column(name = "tags")
    private Set<String> tags;


}
