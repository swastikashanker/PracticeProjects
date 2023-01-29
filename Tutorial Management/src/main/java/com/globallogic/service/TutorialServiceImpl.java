package com.globallogic.service;

import com.globallogic.exception.TutorialAlreadyExist;
import com.globallogic.exception.TutorialNotFoundException;
import com.globallogic.model.Tutorial;
import com.globallogic.model.TutorialRequest;
import com.globallogic.repository.TutorialRepository;
import com.globallogic.utils.AppConstant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialServiceImpl implements TutorialService {

    Log log = LogFactory.getLog(TutorialServiceImpl.class);
    @Autowired
    private TutorialRepository tutorialRepository;

    public TutorialServiceImpl(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    @Override
    public Tutorial addTutorialDetails(Tutorial tutorial) {
        if(tutorialRepository.findById(tutorial.getId()).isPresent()) {
            throw new TutorialAlreadyExist(AppConstant.TUTORIAL_ALREADY_EXISTS);
        }
        log.info(" Tutorial Details  Registratered successfully");
        tutorial = tutorialRepository.save(tutorial);
        return tutorial;
    }

    @Override
    public List<Tutorial> fetchAllTutorialDetails() {
        log.info("Fetch All the tutorial details from tutorial table");
        List<Tutorial> tutorials = tutorialRepository.findAll();
        if(tutorials.isEmpty()) {
            log.warn("No tutorial are available in database, please register first");
            throw new TutorialNotFoundException(AppConstant.TUTORIAL_NOT_FOUND_MESSAGE);
        }
        return  tutorials;
    }

    @Override
    public Tutorial retrieveTutorialDetailsById(long id) {
        log.info(" Getting tutorial details by tutorial id ");
        Tutorial tutorial = tutorialRepository.findById(id)
                .orElseThrow(() ->
                        {
                            log.warn("Tutorial Id is not found in DB");
                            return new TutorialNotFoundException(AppConstant.TUTORIAL_NOT_FOUND_MESSAGE + id );
                        }
                );
        log.info("Got tutorial details successfully");
        return tutorial;
    }

    @Override
    public Tutorial updateTutorialDetailsById(long id, TutorialRequest tutorialRequest) {
        Tutorial tutorial = new Tutorial();
        tutorial = tutorialRepository.findById(id).orElseThrow(() ->
                {
                    log.warn("Tutorial Id is not found in DB");
                    return new TutorialNotFoundException(AppConstant.TUTORIAL_NOT_FOUND_MESSAGE + id );
                }
        );
        log.info("updated details are");
        tutorial.setId(id);
        tutorial.setTitle(tutorialRequest.getTitle());
        tutorial.setDescription(tutorialRequest.getDescription());
        tutorial.setPublishedStatus(tutorialRequest.getPublishedStatus());
        tutorialRepository.save(tutorial);
        return tutorial;
    }

    @Override
    public List<Tutorial> findAllPublishedTutorialsByPublishedStatus(String published_status) {
        log.info(" Getting tutorial details by tutorial id ");
        List<Tutorial> tutorialList = tutorialRepository.findByPublishedStatus(published_status);
        if(tutorialList.isEmpty()) {
            log.warn("Id is not found in DB");
            throw new TutorialNotFoundException(AppConstant.TUTORIAL_NOT_FOUND_MESSAGE + published_status);
        }
        log.info("Got tutorial details successfully");
        return tutorialList;
    }

    @Override
    public List<Tutorial> findAllPublishedTutorialsByTitle(String title) {
        log.info(" Getting tutorial details by tutorial title ");
        List<Tutorial> tutorialList = tutorialRepository.findByTitle(title);
        if(tutorialList.isEmpty()) {
            log.warn("Email Id is not found in DB");
            throw new TutorialNotFoundException(AppConstant.TUTORIAL_NOT_FOUND_MESSAGE + title);
        }
        log.info("Got tutorial details successfully");
        return tutorialList;
    }

    @Override
    public void deleteTutorialDetailsById(long id) {
        log.info("Getting tutorial details by tutorial id");
        Tutorial tutorial = tutorialRepository.findById(id)
                .orElseThrow(() -> new TutorialNotFoundException(AppConstant.TUTORIAL_NOT_FOUND_MESSAGE + id));
        log.info("Delete Tutorial Details Successfully");
        tutorialRepository.delete(tutorial);
    }

    @Override
    public void deleteAllTutorialRecords() {
        log.info("Delete All Tutorial Details Successfully");
        tutorialRepository.deleteAll();
    }
}
