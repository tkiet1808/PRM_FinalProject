package Model;

import java.math.BigDecimal;
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
public class Post {
    private UUID id;
    private String name;
    private String image;
    private String description;
    private Long created;
    private Long updated;
    private BigDecimal price;
    private BigDecimal paid;
    private int status;
    private Category category;
    private User user;
    private List<Wish> wishlist;
    private List<Tag> tags;
}
