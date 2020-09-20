package pl.firmy90.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class FormDTO {
    private String donationZipCode;
    private String donationStreet;
    private String donationCity;
    private Integer donationQuantity;
    private String donationPickUpComment;
    private LocalDate donationPickUpDate;
    private LocalTime donationPickUpTime;

}
