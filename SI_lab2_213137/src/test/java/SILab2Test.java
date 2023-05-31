import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void everyBranchTest() {
        RuntimeException ex;
        User user1 = new User("jovan.stojanovski55@gmail.com", "pikachu2", "jovan.stojanovski55@gmail.com");
        User user2 = new User("zokizoran", "pikachu2", "zokevsi@zoran.com");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        User secondCase = new User("jovan.stojanovski55@gmail.com", "damik32$", "jovan.stojanovski55@gmail.com");
        assertFalse(SILab2.function(secondCase, users));

        User thirdCase = new User("jovan", "jovan123", "jovankoki.com");
        assertFalse(SILab2.function(thirdCase, users));

        User forthCase = new User("jovanzoPDs", "koi sdak", "jovan.s@hotmail.com");
        assertFalse(SILab2.function(forthCase, users));
    }

    @Test
    void multipleConditionsTest(){
//        if (user==null || user.getPassword()==null || user.getEmail()==null){ //2
//            throw new RuntimeException("Mandatory information missing!"); //3
//        }
        /*

        null|X|X
        nonNull|null|X
        nonNull|nonNull|nonNull
        nonNull|nonNull|null

         */

        RuntimeException rx;
        User user = new User("zori", null, "zori@gmail.com");
        User user1 = new User("bobi", "asdkds", "bobi@.com");
        User user2 = new User("goki", "ddsada", null);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);

        rx = assertThrows(RuntimeException.class, () -> SILab2.function(null, users));
        assertTrue(rx.getMessage().contains("Mandatory information missing!"));

        rx = assertThrows(RuntimeException.class, () -> SILab2.function(user, users));
        assertTrue(rx.getMessage().contains("Mandatory information missing!"));

        rx = assertThrows(RuntimeException.class, () -> SILab2.function(user2, users));
        assertTrue(rx.getMessage().contains("Mandatory information missing!"));

        assertFalse(SILab2.function(user1, users));
    }
}