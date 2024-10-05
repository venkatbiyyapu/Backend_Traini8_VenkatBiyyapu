package com.example.Traini8.trainingCenter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Embeddable
public class Address {

    @NotNull
    private String detailedAddress;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @NotNull
    @Pattern(regexp = "^[0-9]{6}$", message = "PinCode must be exactly 6 digits")
    private Integer pinCode;

    // Setters and Getter Methods for Address Fields
    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }


}
