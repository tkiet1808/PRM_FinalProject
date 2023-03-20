package Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostList {
    private UUID id;
    private String name;
    private String image;
    private String description;
    private String category_name;
    private BigDecimal price;
    private List<Tag> tags;
}
