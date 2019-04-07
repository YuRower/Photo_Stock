package repository.jpa;

import java.util.List;

import javax.enterprise.context.Dependent;

import repository.PhotoRepository;
import ua.univer.photostock.model.domain.Photo;

@Dependent
public class PhotoRepositoryImpl extends AbstractJPARepository<Photo, Long>
        implements PhotoRepository {

    @Override
    protected Class<Photo> getEntityClass() {
        return Photo.class;
    }

    @Override
    public List<Photo> findProfilePhotosLatestFirst(Long profileId, int offset,
            int limit) {
        return em.createNamedQuery(
                "SELECT ph FROM Photo ph WHERE ph.profile.id=:profileId ORDER BY ph.id DESC")
                .setParameter("profileId", profileId).setFirstResult(offset)
                .setMaxResults(limit).getResultList();
    }

    @Override
    public int countProfilePhotos(Long profileId) {
        Object count = em.createNamedQuery(
                "SELECT COUNT(ph) FROM Photo ph WHERE ph.profile.id=:profileId")
                .setParameter("profileId", profileId).getSingleResult();
        return ((Number) count).intValue();
    }

    @Override
    public List<Photo> findAllOrderByViewsDesc(int offset, int limit) {
        return em.createNamedQuery(
                "SELECT e FROM Photo e JOIN FETCH e.profile ORDER BY e.views DESC")
                .setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    @Override
    public List<Photo> findAllOrderByAuthorRatingDesc(int offset, int limit) {
        return em.createNamedQuery(
                "SELECT e FROM Photo e JOIN FETCH e.profile p ORDER BY p.rating DESC, e.views DESC")
                .setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    @Override
    public long countAll() {
        Object count = em.createNamedQuery("SELECT COUNT(ph) FROM Photo ph")
                .getSingleResult();
        return ((Number) count).intValue();
    }

}