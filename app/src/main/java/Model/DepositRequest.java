package Model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class DepositRequest {
    private UUID id;

    private Timestamp created;

    private Timestamp updated;

    private BigDecimal amount;

    private int status;

//    private User userId;


    public DepositRequest() {
    }

    public DepositRequest(UUID id, Timestamp created, Timestamp updated, BigDecimal amount, int status) {
        this.id = id;
        this.created = created;
        this.updated = updated;
        this.amount = amount;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
