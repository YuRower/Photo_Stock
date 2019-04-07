package service.bean;

import java.util.logging.Logger;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

import repository.ProfileRepository;

@Stateless
public class UpdateProfileRatingBean {

    @Inject
    private Logger logger;

    @Inject
    private ProfileRepository profileRepository;

    @Schedule(hour = "0", minute = "0", second = "0", persistent = false)
    public void updateProfileRating() {
        profileRepository.updateRating();
        logger.info("Successful updated profile rating");
    }
}