package co.edu.escuelaing.cvds.lab7.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import co.edu.escuelaing.cvds.lab7.model.User;
import co.edu.escuelaing.cvds.lab7.repository.UserRepository;
import co.edu.escuelaing.cvds.lab7.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testFindUserByUsername() {
        // Simulamos algunos usuarios en el repositorio
        User user3 = new User("juan.jc", "demo", "juan@demo.jc.com");
        List<User> userList = Arrays.asList(user3);

        // Configuramos el comportamiento del repositorio para retornar la lista simulada
        when(userRepository.findByUsername(anyString())).thenReturn(userList);

        // Probamos la función findUserByUsername
        User foundUser = userService.findUserByUsername("juan.jc");

        // Verificamos que se haya encontrado el usuario correctamente
        assertNotNull(foundUser);
        assertEquals("juan.jc", foundUser.getUsername());
        assertEquals("demo", foundUser.getPassword());
        assertEquals("juan@demo.jc.com", foundUser.getEmail());

        // Verificamos que el método findByUsername del repositorio se haya llamado correctamente
        verify(userRepository, times(2)).findByUsername("juan.jc");
    }

    // Puedes agregar más pruebas según sea necesario
}
