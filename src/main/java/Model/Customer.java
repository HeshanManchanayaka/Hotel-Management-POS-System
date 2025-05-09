package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private int id;
    private String name;
    private String contactNo;
    private int loyaltyPoints;

}
