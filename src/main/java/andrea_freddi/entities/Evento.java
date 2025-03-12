package andrea_freddi.entities;

import andrea_freddi.enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue
    @Column(name = "evento_id", nullable = false)
    private UUID id;
    @Column(name = "titolo", nullable = false)
    private String titolo;
    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "tipo_evento", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    @Column(name = "numero_massimo_partecipanti")
    private int numeroMassimoPartecipanti;

    public Evento() {
    }

    public Evento(LocalDate dateEvento, String descrizione, int numeroMassimoPartecipanti, TipoEvento tipoEvento, String titolo) {
        this.dataEvento = dateEvento;
        this.descrizione = descrizione;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.tipoEvento = tipoEvento;
        this.titolo = titolo;
    }

    public LocalDate getDateEvento() {
        return dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public UUID getId() {
        return id;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public String getTitolo() {
        return titolo;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "dateEvento=" + dataEvento +
                ", id=" + id +
                ", titolo='" + titolo + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}
