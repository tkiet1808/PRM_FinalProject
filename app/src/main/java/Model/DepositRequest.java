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
public class DepositRequest {

    private UUID id;
    private UUID user_id;
    private BigDecimal amount;
    private Long created;

    private Long updated;


    private int status;


}
