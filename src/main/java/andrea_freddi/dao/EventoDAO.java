package andrea_freddi.dao;

import andrea_freddi.entities.Evento;
import andrea_freddi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(evento);
        transaction.commit();
        System.out.println("Evento " + evento.getTitolo() + " correttamente salvato nel database");
    }

    public Evento findById(long id) {
        Evento eventoTrovato = entityManager.find(Evento.class, id);
        if (eventoTrovato == null) throw new NotFoundException(id);
        else {
            return eventoTrovato;
        }
    }

    public void delete(long id) {
        Evento eventoTrovato = this.findById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(eventoTrovato);
        transaction.commit();
        System.out.println("Evento " + eventoTrovato.getTitolo() + " correttamente cancellato nel database");
    }
}
