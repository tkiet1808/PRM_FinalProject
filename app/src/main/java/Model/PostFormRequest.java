package Model;

import java.math.BigDecimal;
import java.util.ArrayList;
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
public class PostFormRequest {
    private String name;
    private String image;
    private String description;
    private BigDecimal price;
    private int category_id;
    private String user_id;
    private String id;
    private List<Tag> tag = new ArrayList<Tag>();
}
