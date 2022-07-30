package cl.sustantiva.sttdemo.domain.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StaffDTO {
    private int staffId;
    private String firstName;
    private String lastName;
    private int addressId;
    private AddressDTO address;
    private String email;
    private int storeId;
    private StoreDTO store;
    private boolean active;
    private String username;
    private String password;
}
