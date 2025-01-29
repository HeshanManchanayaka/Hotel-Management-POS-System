package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Room {
    private String number;
    private String type;
    private double pricePerNight;
    private String availabilityStatus;

}
