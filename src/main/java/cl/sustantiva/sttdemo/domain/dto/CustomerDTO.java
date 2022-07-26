package cl.sustantiva.sttdemo.domain.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private Integer customerId;
    private StoreDTO storeDTO;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDTO addressDTO;
    private Boolean active;
}
