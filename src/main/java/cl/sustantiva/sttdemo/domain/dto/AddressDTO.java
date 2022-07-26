package cl.sustantiva.sttdemo.domain.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private Integer addressId;
    private String address;
    private String address2;
    private String district;
    private CityDTO cityDTO;
    private String postalCode;
    private String phone;
}
