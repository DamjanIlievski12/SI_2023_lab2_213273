import org.junit.Test;


import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class SILab2Test {
    @Test
    public void testEveryBranch(){

        //1,2,20
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, Collections.emptyList()));
        assertTrue(ex.getMessage() == "Mandatory information missing!");

        //1->3->4->5->13->14->20
        boolean result = SILab2.function(new User(null, "passw", "damjan@gmailcom"), Collections.emptyList());
        assertFalse(result);

        //1->3->5->6->7->13->15->19->20

        result = SILab2.function(new User("us1", "dada sdad", "us1@gmail.com"), Collections.emptyList());
        assertFalse(result);

        //1->3->5->6->7->8->9->11->12->7->8->9->10->11->7->13->15->16->17->19->20
        ArrayList<User>allUsers = new ArrayList<>();
        allUsers.add(new User("us1", "something2123", "us1frfr@gmail.com"));
        allUsers.add(new User("user2", "something2123", "us1@gmail.com"));
        result=SILab2.function(new User("us1", "dadasdad", "us1@gmail.com"), allUsers);
        assertFalse(result);

        //1->3->5->6->7->13->15->16->17->18->20
        result=SILab2.function(new User("us1", "dada$###sdad", "us1@gmail.com"), Collections.emptyList());
        assertTrue(result);


    }
    @Test
    public void multipleConditionTest(){
    //(user==null || user.getPassword()==null || user.getEmail()==null)
        // T X X, F T X, F F T, F F F

        //TXX
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, new ArrayList<>()));
        assertTrue(ex.getMessage() == "Mandatory information missing!");

        //FTX

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("us1", null, "us1@gmail.com"), new ArrayList<>()));
        assertTrue(ex.getMessage() == "Mandatory information missing!");

        //FFT
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("us1", "something132", null), new ArrayList<>()));
        assertTrue(ex.getMessage() == "Mandatory information missing!");

        // FFF
        boolean result = SILab2.function(new User("us1", "something132", "user@gmai.com"), new ArrayList<>());
        assertFalse(result);



    }


}
