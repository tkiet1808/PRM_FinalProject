package Model;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private int id;
    private String name;
    private String description;
    private int status;
    private BigDecimal fee;
//    private List<Post> posts;
}
