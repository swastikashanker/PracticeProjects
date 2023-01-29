package example.service;

import example.exception.TutorialFoundException;
import example.models.Tutorial;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TutorialService {


    Tutorial saveTutorial(Tutorial tutorial)throws TutorialFoundException;

    public List<Tutorial> getAllTutorials();
    public Tutorial getTutorialById (int id);
    public String deleteById(int id);
    String updateTutorialDetailsById(int id, Tutorial tutorial);


           String deleteAllTutorialRecords();
    List<Tutorial> findAllPublishedTutorialsByPublishedStatus(String publishedStatus);
//    List<Tutorial> findAllPublishedTutorialsByTitle(String title);
}
