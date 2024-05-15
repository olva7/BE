package MI.com.example.MI_Project.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.nio.ByteBuffer;
import java.util.Date;
import java.util.UUID;
@Setter
@Getter

@NoArgsConstructor
@Table("estate_images")
public class EstateImage {
    @PrimaryKeyClass
    public static class EstateImageKey {

        @PrimaryKeyColumn(name = "idestate", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
        private Integer idEstate;

        @PrimaryKeyColumn(name = "year_month", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
        private String yearMonth;

        @PrimaryKeyColumn(name = "image_id", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
        private UUID imageId;

        public EstateImageKey(Integer idEstate, String yearMonth, UUID imageId) {
            this.idEstate = idEstate;
            this.yearMonth = yearMonth;
            this.imageId = imageId;
        }


        // Getters and Setters omitted for brevity
    }

    @PrimaryKey
    private EstateImageKey key;

    @Column("image_data")
    private ByteBuffer imageData;

    @Column("date_upload")
    @CassandraType(type = CassandraType.Name.TIMESTAMP)
    private Date dateUpload;

    public EstateImage(EstateImageKey key, ByteBuffer imageData, Date dateUpload) {
        this.key = key;
        this.imageData = imageData;
        this.dateUpload = dateUpload;
    }

}
