package andrea_freddi.dao;

import andrea_freddi.entities.Location;
import andrea_freddi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {
    private final EntityManager entityManager;

    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Location location) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(location);
        transaction.commit();
        System.out.println("Location " + location.getNome() + " correttamente salvata nel database");
    }

    public Location findById(String id) {
        Location locationTrovata = entityManager.find(Location.class, UUID.fromString(id));
        if (locationTrovata == null) throw new NotFoundException(id);
        else {
            return locationTrovata;
        }
    }
}
