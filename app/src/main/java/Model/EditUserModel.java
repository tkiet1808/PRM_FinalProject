package Model;

import java.util.UUID;

import lombok.Data;

@Data
public class EditUserModel {
    private UUID id;
    private String name;
    private String avatar;
    private String phone;
    private String email;
    private String address;
}
