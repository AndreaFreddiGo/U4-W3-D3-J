package andrea_freddi.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("Evento con id " + id + " non trovato");
    }
}
