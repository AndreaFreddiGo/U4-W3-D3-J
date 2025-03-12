package andrea_freddi;

import andrea_freddi.dao.EventoDAO;
import andrea_freddi.entities.Evento;
import andrea_freddi.enums.TipoEvento;
import andrea_freddi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-S3-D2-J");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        EventoDAO eventoDAO = new EventoDAO(em);

        Evento evento1 = new Evento(LocalDate.of(2025, 12, 31), "Festa di fine anno", 100, TipoEvento.PUBBLICO, "Festa di fine anno");
        Evento evento2 = new Evento(LocalDate.of(2025, 8, 15), "Ferragosto", 10, TipoEvento.PUBBLICO, "Ferragosto");
        Evento evento3 = new Evento(LocalDate.of(2025, 12, 25), "Natale", 8, TipoEvento.PRIVATO, "Natale");
        Evento evento4 = new Evento(LocalDate.of(2025, 5, 18), "Compleanno", 20, TipoEvento.PRIVATO, "Compleanno");
        Evento evento5 = new Evento(LocalDate.of(2025, 4, 25), "Festa della liberazione", 50, TipoEvento.PUBBLICO, "Festa della liberazione");

//        eventoDAO.save(evento1);
//        eventoDAO.save(evento2);
//        eventoDAO.save(evento3);
//        eventoDAO.save(evento4);
//        eventoDAO.save(evento5);


        try {
            Evento eventoDalDB = eventoDAO.findById(2);
            System.out.println(eventoDalDB);

            eventoDAO.delete(1);

        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

        em.close();
        emf.close();
    }
}
