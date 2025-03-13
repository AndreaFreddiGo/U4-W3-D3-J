package andrea_freddi.dao;

import andrea_freddi.entities.Partecipazione;
import andrea_freddi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipazioneDAO {
    private final EntityManager entityManager;

    public PartecipazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(partecipazione);
        transaction.commit();
        System.out.println("Partecipazione correttamente salvata nel database");
    }

    public Partecipazione findById(String id) {
        Partecipazione partecipazioneTrovata = entityManager.find(Partecipazione.class, UUID.fromString(id));
        if (partecipazioneTrovata == null) throw new NotFoundException(id);
        else {
            return partecipazioneTrovata;
        }
    }
}
