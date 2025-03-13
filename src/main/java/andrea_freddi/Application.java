package andrea_freddi;

import andrea_freddi.dao.EventoDAO;
import andrea_freddi.dao.LocationDAO;
import andrea_freddi.dao.PartecipazioneDAO;
import andrea_freddi.dao.PersonaDAO;
import andrea_freddi.entities.Evento;
import andrea_freddi.entities.Location;
import andrea_freddi.entities.Partecipazione;
import andrea_freddi.entities.Persona;
import andrea_freddi.enums.Sesso;
import andrea_freddi.enums.Stato;
import andrea_freddi.enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D3-J");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        EventoDAO eventoDAO = new EventoDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

        Location location = new Location("Roma", "Circo Massimo");
//      locationDAO.save(location);

        Persona persona = new Persona("Brigo", "Brigo", "brigobrigo@brigo.com", LocalDate.of(1960, 10, 10), Sesso.M);
//      personaDAO.save(persona);

        Location locationDB = locationDAO.findById("5ff651e7-0347-44e6-a350-9d6f15ddbcb1");

        Evento evento1 = new Evento(LocalDate.of(2025, 12, 31), "Festa di fine anno", 100, TipoEvento.PUBBLICO, "Festa di fine anno", locationDB);
//        Evento evento2 = new Evento(LocalDate.of(2025, 8, 15), "Ferragosto", 10, TipoEvento.PUBBLICO, "Ferragosto", locationDB);
//        Evento evento3 = new Evento(LocalDate.of(2025, 12, 25), "Natale", 8, TipoEvento.PRIVATO, "Natale", locationDB);
//        Evento evento4 = new Evento(LocalDate.of(2025, 5, 18), "Compleanno", 20, TipoEvento.PRIVATO, "Compleanno", locationDB);
//        Evento evento5 = new Evento(LocalDate.of(2025, 4, 25), "Festa della liberazione", 50, TipoEvento.PUBBLICO, "Festa della liberazione", locationDB);

//        eventoDAO.save(evento1);
//        eventoDAO.save(evento2);
//        eventoDAO.save(evento3);
//        eventoDAO.save(evento4);
//        eventoDAO.save(evento5);

        Evento eventoDB = eventoDAO.findById("e64a879b-6f56-4ce3-9543-24e5d87b58ae");
        Persona personaDB = personaDAO.findById("49ec7a1b-24e9-408c-8fc8-ff014ddc9be0");

        Partecipazione partecipazione = new Partecipazione(Stato.CONFERMATA, eventoDB, personaDB);
        partecipazioneDAO.save(partecipazione);


//        try {
//            Evento eventoDalDB = eventoDAO.findById(2);
//            System.out.println(eventoDalDB);
//
//            eventoDAO.delete(1);
//
//        } catch (NotFoundException e) {
//            System.out.println(e.getMessage());
//        }

        em.close();
        emf.close();
    }
}
