package Model;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    private UUID id;

    private String name;

    private String image;

    private String description;
    private String categoryName;
    private Timestamp created;
    private Timestamp updated;
    private BigDecimal price;
    private BigDecimal paid;
    private int status;


}