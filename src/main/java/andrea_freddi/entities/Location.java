package andrea_freddi.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue
    @Column(name = "location_id", nullable = false)
    private UUID id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "città", nullable = false)
    private String città;

    @OneToMany(mappedBy = "location")
    private List<Evento> evento = new ArrayList<>();

    public Location() {
    }

    public Location(String città, String nome) {
        this.città = città;
        this.nome = nome;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    public Evento getEvento() {
        return (Evento) evento;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Location{" +
                "città='" + città + '\'' +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", evento=" + evento +
                '}';
    }
}
