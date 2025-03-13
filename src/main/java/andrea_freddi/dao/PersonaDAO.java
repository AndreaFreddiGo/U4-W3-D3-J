package andrea_freddi.dao;

import andrea_freddi.entities.Persona;
import andrea_freddi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonaDAO {
    private final EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(persona);
        transaction.commit();
        System.out.println("Persona " + persona.getNome() + " " + persona.getCognome() + " correttamente salvata nel database");
    }

    public Persona findById(String id) {
        Persona personaTrovata = entityManager.find(Persona.class, UUID.fromString(id));
        if (personaTrovata == null) throw new NotFoundException(id);
        else {
            return personaTrovata;
        }
    }
}
