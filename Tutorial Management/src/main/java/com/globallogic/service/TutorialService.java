package com.globallogic.service;

import com.globallogic.model.Tutorial;
import com.globallogic.model.TutorialRequest;

import java.util.List;

public interface TutorialService {
    Tutorial addTutorialDetails(Tutorial tutorial) ;
    List<Tutorial> fetchAllTutorialDetails();
    Tutorial retrieveTutorialDetailsById(long id);
    Tutorial updateTutorialDetailsById(long id, TutorialRequest tutorialRequest);
    void deleteTutorialDetailsById(long id);
    void deleteAllTutorialRecords();
    List<Tutorial> findAllPublishedTutorialsByPublishedStatus(String published_status);
    List<Tutorial> findAllPublishedTutorialsByTitle(String title);

}
