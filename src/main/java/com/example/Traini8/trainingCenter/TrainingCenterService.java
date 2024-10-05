package com.example.Traini8.trainingCenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TrainingCenterService {

    private final TrainingCenterRepository trainingCenterRepository;

    @Autowired
    public TrainingCenterService(TrainingCenterRepository trainingCenterRepository) {
        this.trainingCenterRepository = trainingCenterRepository;
    }

    /**
     * Retrieves all training centers from the database.
     *
     * @return a list of all training centers.
     */
    public List<TrainingCenter> getTrainingCenters(){
        return trainingCenterRepository.findAll();
    }

    /**
     * Saves a new training center to the database.
     *
     * @param trainingCenter the training center to be saved.
     * @return the saved training center.
     */
    public TrainingCenter saveTrainingCenter(TrainingCenter trainingCenter){
        return trainingCenterRepository.save(trainingCenter);
    }

    /**
     * Retrieves training centers by their pin code.
     *
     * @param pinCode the pin code to search for training centers.
     * @return a list of training centers located in the specified pin code.
     */
    public List<TrainingCenter> getTrainingCentersByPinCode(Integer pinCode) {
        return trainingCenterRepository.findByAddress_PinCode(pinCode);
    }

    /**
     * Retrieves training centers by their center code.
     *
     * @param centerCode the center code to search for training centers.
     * @return a list of training centers with the specified center code.
     */
    public List<TrainingCenter> getTrainingCentersByCenterCode(String centerCode) {
        return trainingCenterRepository.findByCenterCode(centerCode);
    }

    /**
     * Retrieves training centers that have a capacity greater than or equal to the specified value.
     *
     * @param capacity the minimum capacity to search for training centers.
     * @return a list of training centers that meet or exceed the specified capacity.
     */
    public List<TrainingCenter> getTrainingCentersByCapacityGreaterThanEqual(Integer capacity) {
        return trainingCenterRepository.findByCapacityGreaterThanEqual(capacity);
    }

    /**
     * Retrieves training centers by their name, ignoring case.
     *
     * @param centerName the center name to search for (case insensitive).
     * @return a list of training centers matching the specified name.
     */
    public List<TrainingCenter> getTrainingCentersByCenterNameIgnoreCase(String centerName) {
        return trainingCenterRepository.findByCenterNameIgnoreCase(centerName);
    }

    /**
     * Retrieves training centers by city or state, ignoring case.
     *
     * @param city the city to search for training centers.
     * @param state the state to search for training centers.
     * @return a list of training centers that match the specified city or state (case insensitive).
     */
    public List<TrainingCenter> getTrainingCentersByCityIgnoreCaseORStateIgnoreCase(String city, String state) {
        return trainingCenterRepository.findByAddress_CityIgnoreCaseOrAddress_StateIgnoreCase(city, state);
    }

    /**
     * Retrieves training centers that offer any of the specified courses.
     *
     * @param courses a list of courses to search for.
     * @return a list of training centers offering at least one of the specified courses.
     */
    public List<TrainingCenter> getTrainingCenterByCoursesOffered(List<String> courses){
        Set<TrainingCenter> trainingCenters = new HashSet<>();

        // Iterate over each course and add matching training centers to the set
        for(String course : courses){
            List<TrainingCenter> centers = trainingCenterRepository.findByCoursesOfferedContaining(course);
            trainingCenters.addAll(centers);
        }

        // Convert the set back to a list and return it
        return new ArrayList<>(trainingCenters);
    }
}
