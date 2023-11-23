package co.edu.escuelaing.cvds.lab7.service;
import co.edu.escuelaing.cvds.lab7.model.Menu;
import co.edu.escuelaing.cvds.lab7.model.Ticket;
import co.edu.escuelaing.cvds.lab7.repository.MenuRepository;
import co.edu.escuelaing.cvds.lab7.repository.TicketRepository;
import co.edu.escuelaing.cvds.lab7.service.TicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class TicketServiceTest {

    @InjectMocks
    private TicketService ticketService;

    @Mock
    private TicketRepository ticketRepository;

    @Test
    public void testRealizarPedido() {
        // Simulamos un nombre de plato para el pedido
        String nombrePlato = "Plato1";

        // Simulamos la creación de un nuevo ticket en la base de datos
        Ticket ticketMock = new Ticket();
        ticketMock.setId(1); // Simulamos que el ticket se guarda con un ID específico
        when(ticketRepository.save(any(Ticket.class))).thenReturn(ticketMock);

        // Ejecutamos el método que realiza el pedido y guarda el ticket
        Integer idTicket = ticketService.realizarPedido(nombrePlato);

        // Verificamos que se haya creado el ticket y se haya guardado en la base de datos
        assertNotNull(idTicket);
        assertEquals(1, idTicket.intValue());

        // Verificamos que el método save del repositorio se haya llamado correctamente
        verify(ticketRepository, times(2)).save(any(Ticket.class));
    }
}
