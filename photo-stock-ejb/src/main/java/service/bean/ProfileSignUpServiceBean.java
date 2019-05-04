package service.bean;

import static java.util.concurrent.TimeUnit.MINUTES;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.inject.Inject;

import ua.univer.photostock.service.ProfileService;
import ua.univer.photostock.service.ProfileSignUpService;

@Stateful
@StatefulTimeout(value = 30, unit = MINUTES)
public class ProfileSignUpServiceBean
        implements ProfileSignUpService, Serializable {

    @Inject
    private transient Logger logger;

    @Inject
    private transient ProfileService profileService;

    private Profile profile;

    @Override
    public void createSignUpProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public Profile getCurrentProfile() throws ObjectNotFoundException {
        if (profile == null) {
            throw new ObjectNotFoundException(
                    "Profile not found. Please create profile before use");
        }
        return profile;
    }

    @Override
    @Remove
    public void completeSignUp() {
        profileService.signUp(profile, false);
    }

    @Override
    @Remove
    public void cancel() {
        profile = null;
    }

    @PostConstruct
    private void postConstruct() {
        logger.log(Level.FINE, "Created {0} instance: {1}", new Object[] {
                getClass().getSimpleName(), System.identityHashCode(this) });
    }

    @PreDestroy
    private void preDestroy() {
        logger.log(Level.FINE, "Destroyed {0} instance: {1}", new Object[] {
                getClass().getSimpleName(), System.identityHashCode(this) });
    }

    @PostActivate
    private void postActivate() {
        logger.log(Level.FINE, "Activated {0} instance: {1}", new Object[] {
                getClass().getSimpleName(), System.identityHashCode(this) });
    }

    @PrePassivate
    private void prePassivate() {
        logger.log(Level.FINE, "Passivated {0} instance: {1}", new Object[] {
                getClass().getSimpleName(), System.identityHashCode(this) });
    }
}