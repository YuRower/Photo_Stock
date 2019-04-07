package repository;

import java.util.List;
import java.util.Optional;

import ua.univer.photostock.model.domain.Profile;

public interface ProfileRepository extends EntityRepository<Profile, Long> {

    Optional<Profile> findByUid(String uid);

    Optional<Profile> findByEmail(String email);

    void updateRating();

    List<String> findUids(List<String> uids);
}