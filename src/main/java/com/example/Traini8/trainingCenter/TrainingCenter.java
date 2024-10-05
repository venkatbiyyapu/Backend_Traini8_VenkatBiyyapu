package com.example.Traini8.trainingCenter;

import java.time.Instant;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class TrainingCenter {
    /**
     * This field represents the unique identifier for the entity.
     * It is annotated with @Id to indicate that it is the primary key of the entity.
     */
    @Id
    /**
     * This annotation specifies the strategy for generating the primary key value.
     * GenerationType.IDENTITY indicates that the database will automatically generate
     * the primary key value, typically using an auto-increment feature.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=40,message = "Center Name Must Be Less than 40 characters")
    private String centerName;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$" ,message = "Center Code Must be exactly 12 alpha numeric characters.")
    private String centerCode;

    @NotNull
    @Embedded
    private Address address;

    @NotNull
    private Integer capacity;

    @ElementCollection
    private List<String> coursesOffered;

    private Long createdOn;

    @Email(message = "Enter a Valid Email Address")
    private String contactEmail;

    @NotNull
    @Pattern(regexp = "^[0-9]{10}$",message = "Phone number must be exactly 10 digits.")
    private String contactPhone;

    // Setters and Getter Methods for Training Center Fields
    public @NotNull @Size(max = 40, message = "Center Name Must Be Less than 40 characters") String getCenterName() {
        return centerName;
    }

    public void setCenterName(@NotNull @Size(max = 40, message = "Center Name Must Be Less than 40 characters") String centerName) {
        this.centerName = centerName;
    }

    public @NotNull @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center Code Must be exactly 12 alpha numeric characters.") String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(@NotNull @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center Code Must be exactly 12 alpha numeric characters.") String centerCode) {
        this.centerCode = centerCode;
    }

    public @NotNull Address getAddress() {
        return address;
    }

    public void setAddress(@NotNull Address address) {
        this.address = address;
    }

    public @NotNull Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<String> getCoursesOffered() {
        return coursesOffered;
    }

    public void setCoursesOffered(List<String> coursesOffered) {
        this.coursesOffered = coursesOffered;
    }

    public @Email(message = "Enter a Valid Email Address") String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(@Email(message = "Enter a Valid Email Address") String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public @NotNull @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits.") String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(@NotNull @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits.") String contactPhone) {
        this.contactPhone = contactPhone;
    }

    /**
     * This method is annotated with @PrePersist, which indicates that it will be called
     * automatically before the entity is persisted to the database.
     */
    @PrePersist
    public void prePersist() {
        // Instant.now() retrieves the current timestamp, and getEpochSecond() converts it and set the Created On field
        this.createdOn = Instant.now().getEpochSecond();
    }

    public Long getCreatedOn() {
        return createdOn;
    }

    public Long getId() {
        return id;
    }
}
