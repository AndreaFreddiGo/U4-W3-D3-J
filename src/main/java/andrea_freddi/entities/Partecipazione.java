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
    @Column(name = "evento_id", nullable = false)
    private UUID idEvento;
    @Column(name = "persona_id", nullable = false)
    private UUID idPersona;
    @Column(name = "stato", nullable = false)
    private Stato stato;

    public Partecipazione() {
    }

    public Partecipazione(UUID idEvento, UUID idPersona, Stato stato) {
        this.idEvento = idEvento;
        this.idPersona = idPersona;
        this.stato = stato;
    }

    public UUID getId() {
        return id;
    }

    public UUID getIdEvento() {
        return idEvento;
    }

    public UUID getIdPersona() {
        return idPersona;
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
                "id=" + id +
                ", idEvento=" + idEvento +
                ", idUtente=" + idPersona +
                ", stato=" + stato +
                '}';
    }
}
