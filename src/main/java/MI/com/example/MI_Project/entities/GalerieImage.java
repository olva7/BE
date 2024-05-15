package MI.com.example.MI_Project.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.nio.ByteBuffer;
import java.util.UUID;
@Getter
@Setter
@Table("image_data")
public class GalerieImage {
    @PrimaryKey
    private UUID id;
    @Column("image_data")
    private ByteBuffer imageData;
    private String tag;  // Optional: For storing image tags
    @Column("estate_id")
    private Integer estateId;



}
