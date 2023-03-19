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
public class User {
    private UUID id;
    private String name;
    private String avatar;
    private Long created;
    private Long updated;
    private String phone;
    private String email;
    private String address;
    private String password;
    private BigDecimal balance;
    private String external_login_id;
    private String error;
    private int status;
    private String message;
//    private List<Post> posts;
//    private List<Wish> wishlist;
//    private List<DepositRequest> depositRequests;
}
