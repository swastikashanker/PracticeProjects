package com.globallogic.controller;

import com.globallogic.model.Tutorial;
import com.globallogic.model.TutorialRequest;
import com.globallogic.service.TutorialService;
import com.globallogic.utils.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutorial")
public class TutorialController {

    @Autowired
    private TutorialService tutorialService;

    /*
        Add Tutorial Details
     */

    @PostMapping(value = "/add")
    public ResponseEntity<Tutorial> addTutorialDetails (@RequestBody Tutorial tutorial){
        return new ResponseEntity<>(tutorialService.addTutorialDetails(tutorial), HttpStatus.CREATED);
    }

    @GetMapping(value="/fetchAllDetails")
    public ResponseEntity<List<Tutorial>> fetchAllTutorialDetails() {
        return new ResponseEntity<>(tutorialService.fetchAllTutorialDetails(), HttpStatus.OK);
    }
    @GetMapping("/fetchDetailsById")
    public ResponseEntity<Tutorial> fetchTutorialDetailsById(@RequestParam long  id) {
        return new ResponseEntity<>(tutorialService.retrieveTutorialDetailsById(id), HttpStatus.OK);
    }
    @GetMapping(value="/fetchAllDetailsByTitle")
    public ResponseEntity<List<Tutorial>> findAllPublishedTutorialsByTitle(@RequestParam String title) {
        return new ResponseEntity<>(tutorialService.findAllPublishedTutorialsByTitle(title), HttpStatus.OK);
    }

    @GetMapping(value="/fetchAllDetailsByStatus")
    public ResponseEntity<List<Tutorial>> findAllPublishedTutorialsByPublishedStatus(@RequestParam String publishedStatus) {
        return new ResponseEntity<>(tutorialService.findAllPublishedTutorialsByPublishedStatus(publishedStatus), HttpStatus.OK);
    }

    /**
     * To Update the tutorial details
     */
    @PutMapping("/update")
    public ResponseEntity<Tutorial> updateTutorialDetailsById(@RequestParam long id, @RequestBody TutorialRequest tutorialRequest) {

        return new ResponseEntity<>(tutorialService.updateTutorialDetailsById(id, tutorialRequest), HttpStatus.OK);
    }

    /**
     * To Delete the tutorial details  from database
     */
    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteTutorialDetailsById(@RequestParam long  id) {

        tutorialService.deleteTutorialDetailsById(id);
        return new ResponseEntity<>(AppConstant.DELETE_MESSAGE, HttpStatus.OK);
    }

    /**
     * To Delete All the Tutorial Details  from database
     */
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAllTutorialDetails() {
        tutorialService.deleteAllTutorialRecords();
        return new ResponseEntity<>(AppConstant.DELETE_MESSAGE, HttpStatus.OK);
    }

}
