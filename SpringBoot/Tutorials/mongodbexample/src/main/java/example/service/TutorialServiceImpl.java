package example.service;

import example.exception.TutorialFoundException;
import example.models.Tutorial;
import example.repo.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TutorialServiceImpl implements TutorialService{

    @Autowired
    TutorialRepository tutorialRepository;

    @Override
    public Tutorial saveTutorial(Tutorial tutorial)throws TutorialFoundException {

        Tutorial newTut = tutorialRepository.findById(tutorial.getId());
        if (newTut != null) {


            throw new TutorialFoundException("Tutorial already present with " + tutorial.getId());
        } else {


            newTut= tutorialRepository.save(tutorial);
        }
        return newTut;
    }

    @Override
    public List<Tutorial> getAllTutorials() {
        List<Tutorial> list = (List<Tutorial>) this.tutorialRepository.findAll();
        return list;
    }

    @Override
    public Tutorial getTutorialById(int id) {
        return tutorialRepository.findById(id);
    }

    @Override
    public String deleteById(int id) {
        tutorialRepository.deleteById(id);
        return id+" deleted";
    }

    @Override
    public String updateTutorialDetailsById(int id, Tutorial tutorial) {
        Tutorial tutorial1= tutorialRepository.findById(id);

        if (tutorial1 == null){
            return "The tutorial does not exist"+id;
        }
        tutorial1.setId(id);
        tutorial1.setTitle(tutorial.getDescription());
        tutorial1.setDescription(tutorial.getDescription());
        tutorial1.setPublishedStatus(tutorial1.getPublishedStatus());

       tutorialRepository.save(tutorial1);

        return "Tutorial updated";
    }

    @Override
    public String deleteAllTutorialRecords() {

        tutorialRepository.deleteAll();
        return "All records deleted";
    }

    @Override
    public List<Tutorial> findAllPublishedTutorialsByPublishedStatus(String publishedStatus) {

        List<Tutorial> tutorialList = tutorialRepository.findByPublishedStatus(publishedStatus);

        return tutorialList;
    }
//
//    @Override
//    public List<Tutorial> findAllPublishedTutorialsByTitle(String title) {
//        return null;
//    }
}
