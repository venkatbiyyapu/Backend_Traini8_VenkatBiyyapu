package com.example.Traini8.trainingCenter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingCenterRepository  extends JpaRepository<TrainingCenter, Long > {
    // Query to find training centers by pincode
    List<TrainingCenter> findByAddress_PinCode(Integer pinCode);
    // Query to find training centers by centercode
    List<TrainingCenter> findByCenterCode(String centerCode);
    // Query to find training centers by capacity greater than a capacity value
    List<TrainingCenter> findByCapacityGreaterThanEqual(Integer capacity);
    // Query to find training centers by center name ignoring the case
    List<TrainingCenter> findByCenterNameIgnoreCase(String centerName);
    // Query to find training centers by city or state ignoring the case
    List<TrainingCenter> findByAddress_CityIgnoreCaseOrAddress_StateIgnoreCase(String city, String state);
    // Query to find training centers by a single course
    List<TrainingCenter> findByCoursesOfferedContaining(String course);

}
