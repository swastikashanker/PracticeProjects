package example.controller;


import example.exception.TutorialFoundException;
import example.models.Tutorial;
import example.repo.TutorialRepository;
import example.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TutorialController {

    @Autowired
    TutorialService tutorialService;

    @Autowired
    TutorialRepository tutorialRepository;

    @PostMapping("/tutorials")
    public ResponseEntity<String> addUser(@RequestBody Tutorial tutorial) {
        try {
            tutorialService.saveTutorial(tutorial);

            return new ResponseEntity<>("Tutorial added !!", HttpStatus.OK);
        } catch (TutorialFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.OK);
        }
    }



    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getTutorials() {
        List<Tutorial> list = tutorialService.getAllTutorials();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);

    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable int id) {



        Tutorial tutorial = tutorialService.getTutorialById(id);

        return ResponseEntity.status(HttpStatus.OK).body(tutorial);

    }


    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        tutorialService.deleteById(id);
        return "Tutorial with id; " + id + " deleted successfully!!";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") int id,@RequestBody Tutorial tutorial ) {
        tutorialService.updateTutorialDetailsById(id, tutorial);
        return ResponseEntity.status(HttpStatus.OK).body("Tutorial with id; " + id + " updated successfully!!");

    }

    @GetMapping(value="/fetchAllDetailsByStatus/{publishedStatus}")
    public ResponseEntity<List<Tutorial>> findAllPublishedTutorialsByPublishedStatus(@PathVariable("publishedStatus") String publishedStatus) {
        return new ResponseEntity<>(tutorialService.findAllPublishedTutorialsByPublishedStatus(publishedStatus), HttpStatus.OK);
    }


    @DeleteMapping("tutorial/delete")
    public String deleteAllTutorialDetails() {
        tutorialService.deleteAllTutorialRecords();
        return "Deleted all records";
    }

}
