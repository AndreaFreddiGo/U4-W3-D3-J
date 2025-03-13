package andrea_freddi.entities;

import andrea_freddi.enums.Stato;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue
    @Column(name = "partecipazione_id", nullable = false)
    private UUID id;
    @Column(name = "stato", nullable = false)
    private Stato stato;

    @OneToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    public Partecipazione() {
    }

    public Partecipazione(Stato stato, Evento evento, Persona persona) {
        this.stato = stato;
    }

    public UUID getId() {
        return id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                ", id=" + id +
                ", stato=" + stato +
                '}';
    }
}
