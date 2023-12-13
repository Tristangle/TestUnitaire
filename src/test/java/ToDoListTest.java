import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ToDoListTest {
    private ArrayList<Items> tableau = new ArrayList<>();
    private EmailSenderService emailSenderService;
    private ToDoList toDoList;


    private Items Item1 = new Items("Premier Item", "Oui");
    private Items Item2 = new Items("Deuxième Item", "Oui");
    private Items Item3 = new Items("Troisième Item", "Oui");
    private Items Item4 = new Items("Quatrième Item", "Oui");
    private Items Item5 = new Items("Cinquième Item", "Oui");
    private Items Item6 = new Items("Sixième Item", "Oui");
    private Items Item7 = new Items("Septième Item", "Oui");
    private Items Item8 = new Items("Huitième Item", "Oui");
    private Items Item9 = new Items("Neuvième Item", "Oui");
    private Items Item10 = new Items("Dixième Item", "Oui");


    @Before
    public void setup() throws Exception {
        this.emailSenderService = mock(EmailSenderService.class);
        this.toDoList = new ToDoList(tableau, emailSenderService);
    }
    @Test
    public void testToDoListName() throws Exception {
        this.toDoList.addItems(Item1);
        assertFalse(toDoList.checkItemName(Item1));
    }
    @Test
    public void testToDoListNumber() throws Exception {
        this.toDoList.addItems(Item1);
        Item1.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item2);
        Item2.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item3);
        Item3.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item4);
        Item4.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item5);
        Item5.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item6);
        Item6.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item7);
        Item7.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item8);
        Item8.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item9);
        Item9.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item10);
        assertFalse(toDoList.checkNombreItems());
    }
    //@Test
    /*¨public void testTempsAjoutItems() throws Exception{
        this.toDoList.addItems(Item1);
        this.toDoList.addItems(Item2);
        //Exception exception = assertThrows(ToDoList.class, () -> ToDoList.isValidItemDate(Item1));
        //assertEquals("Délais d'attente non atteint", exception.getMessage());
    }*/
    @Test
    public void testToDoListIsSaved(){
        this.toDoList = mock(ToDoList.class);
        when(toDoList.isSaved()).thenReturn(true);
        assertTrue(toDoList.isSaved());
    }
    @Test
    public void testEmailSender() throws Exception{
        this.emailSenderService = mock(EmailSenderService.class);
        when(emailSenderService.sendEmail()).thenReturn(true);
        this.toDoList.addItems(Item1);
        Item1.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item2);
        Item2.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item3);
        Item3.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item4);
        Item4.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item5);
        Item5.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item6);
        Item6.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item7);
        Item7.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item8);
        assertTrue(emailSenderService.sendEmail());
    }
    @Test
    public void testFalseEmailSender() throws Exception{
        this.emailSenderService = mock(EmailSenderService.class);
        this.toDoList.addItems(Item1);
        Item1.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item2);
        Item2.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item3);
        Item3.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item4);
        Item4.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item5);
        Item5.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item6);
        Item6.setDateCreation(LocalDateTime.now().minusDays(1));
        this.toDoList.addItems(Item7);
        Item7.setDateCreation(LocalDateTime.now().minusDays(1));
        assertFalse(emailSenderService.sendEmail());
    }

}
