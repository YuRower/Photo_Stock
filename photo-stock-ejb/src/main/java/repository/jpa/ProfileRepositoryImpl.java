package repository.jpa;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.Dependent;
import javax.persistence.NoResultException;
import javax.persistence.StoredProcedureQuery;

import repository.ProfileRepository;
import ua.univer.photostock.model.domain.Profile;

@Dependent
public class ProfileRepositoryImpl extends AbstractJPARepository<Profile, Long>
        implements ProfileRepository {

    @Override
    protected Class<Profile> getEntityClass() {
        return Profile.class;
    }

    @Override
    public Optional<Profile> findByUid(String uid) {
        try {
            Profile profile = (Profile) em
                    .createNamedQuery(
                            "SELECT p FROM Profile p WHERE p.uid=:uid")
                    .setParameter("uid", uid).getSingleResult();
            return Optional.of(profile);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Profile> findByEmail(String email) {
        try {
            Profile profile = (Profile) em
                    .createNamedQuery(
                            "SELECT p FROM Profile p WHERE p.email=:email")
                    .setParameter("email", email).getSingleResult();
            return Optional.of(profile);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public void updateRating() {
        StoredProcedureQuery query = em
                .createStoredProcedureQuery("update_rating");
        query.execute();
    }

    @Override
    public List<String> findUids(List<String> uids) {
        return em
                .createNamedQuery(
                        "SELECT p.uid FROM Profile p WHERE p.uid IN :uids")
                .setParameter("uids", uids).getResultList();
    }
}