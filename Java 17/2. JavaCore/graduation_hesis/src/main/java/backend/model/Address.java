package backend.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Address {
    private String city;
    private String district;
    private String street;
    private String detail;
}
