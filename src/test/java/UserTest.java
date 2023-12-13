import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
@RunWith(MockitoJUnitRunner.class)
public class UserTest {

    private User user;
    private LocalDate dateNaissance = LocalDate.now().minusYears(20);
    private LocalDate date = LocalDate.now();
    private ArrayList<Items> tableau = new ArrayList<>();
    private EmailSenderService emailSenderService;
    private ToDoList toDoList = new ToDoList(tableau, emailSenderService);

    @Before
    public void setup(){
        this.emailSenderService = mock(EmailSenderService.class);
        this.user = new User("tberdrin@gmail.com", "tristan","berdrin","S0uffronss", dateNaissance, date, toDoList);
    }
    @Test
    public void testUserNominal() {

        assertTrue(user.isValid());
    }

    @Test
    public void testUserEmail() {
        user.setEmail("");
        assertFalse(user.isValid());
    }

    @Test
    public void testUserEmailInvalide() {
        user.setEmail("Email-invalide");
        assertFalse(user.isValid());
    }

    @Test
    public void testUserVide() {
        user.setNom("");
        user.setPrenom("");
        assertFalse(user.isValid());
    }

    @Test
    public void testAgeIncorrect() {
        user.setDateNaissance(LocalDate.now().minusYears(12));

        assertFalse(user.isValid());
    }
    @Test
    public void testMotDePasseTropCourt(){
        user.setMotDePasse("S0uffro");
        assertFalse(user.isValid());
    }
    @Test
    public void testMotDePasseTropLong(){
        user.setMotDePasse("S0uffrooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooons");
        assertFalse(user.isValid());
    }
    @Test
    public void testUserMotDePasseSansMaj(){
        user.setMotDePasse("s0uffronss");
        assertFalse(user.isValid());
    }
    @Test
    public void testUserMotDePasseSansMin(){
        user.setMotDePasse("S0UFFRONS");
        assertFalse(user.isValid());
    }
    @Test
    public void testUserMotDePasseSansChiffres(){
        user.setMotDePasse("Souffronss");
        assertFalse(user.isValid());
    }
}





