package com.example.Traini8.trainingCenter;

import java.util.*;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(path = "api/v1/training-centers")
public class TrainingCenterController {

    private final TrainingCenterService trainingCenterService;

    @Autowired
    public TrainingCenterController(TrainingCenterService trainingCenterService) {
        this.trainingCenterService = trainingCenterService;
    }

    // Endpoint to get a list of all training centers
    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getTrainingCenters(){
        List<TrainingCenter> trainingCenters = trainingCenterService.getTrainingCenters();
        return ResponseEntity.ok(trainingCenters);
    }

    // Endpoint to create a new training center
    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter){
        TrainingCenter trainingCenter1 = trainingCenterService.saveTrainingCenter(trainingCenter);
        return new ResponseEntity<>(trainingCenter1,HttpStatus.CREATED);
    }

    // Endpoint to get training centers by pin code
    @GetMapping(path = "/by-pincode")
    public ResponseEntity<List<TrainingCenter>> getTrainingCentersByPinCode(@RequestParam Integer pinCode){
        List<TrainingCenter> trainingCenters = trainingCenterService.getTrainingCentersByPinCode(pinCode);
        return ResponseEntity.ok(trainingCenters);
    }

    // Endpoint to get training centers by pin code
    @GetMapping(path = "/by-centercode")
    public ResponseEntity<List<TrainingCenter>> getTrainingCentersByCenterCode(@RequestParam String centerCode){
        List<TrainingCenter> trainingCenters = trainingCenterService.getTrainingCentersByCenterCode(centerCode);
        return ResponseEntity.ok(trainingCenters);
    }

    // Endpoint to get training centers with a capacity greater than or equal to the specified value
    @GetMapping(path = "/by-capacity")
    public ResponseEntity<List<TrainingCenter>> getTrainingCentersByCapacityGreaterThanEqual(@RequestParam Integer capacity){
        List<TrainingCenter> trainingCenters = trainingCenterService.getTrainingCentersByCapacityGreaterThanEqual(capacity);
        return ResponseEntity.ok(trainingCenters);
    }

    // Endpoint to get training centers by center name (case-insensitive)
    @GetMapping(path = "/by-centername")
    public ResponseEntity<List<TrainingCenter>> getTrainingCentersByCenterNameIgnoreCase(@RequestParam String centerName){
        List<TrainingCenter> trainingCenters = trainingCenterService.getTrainingCentersByCenterNameIgnoreCase(centerName);
        return ResponseEntity.ok(trainingCenters);
    }

    // Endpoint to get training centers by city or state (case-insensitive)
    @GetMapping(path = "/by-cityorstate")
    public ResponseEntity<List<TrainingCenter>> getTrainingCentersByCityIgnoreCaseORStateIgnoreCase(
            @RequestParam(required = false) String city , @RequestParam(required = false) String state){
        List<TrainingCenter> trainingCenters = trainingCenterService.getTrainingCentersByCityIgnoreCaseORStateIgnoreCase(city,state);
        return ResponseEntity.ok(trainingCenters);
    }

    // Endpoint to get training centers based on the courses offered
    @GetMapping(path = "/by-courses")
    public ResponseEntity<List<TrainingCenter>> getTrainingCentersByCoursesOffered(
            @RequestParam List<String> courses ){
        List<TrainingCenter> trainingCenters = trainingCenterService.getTrainingCenterByCoursesOffered(courses);
        return ResponseEntity.ok(trainingCenters);
    }



}
