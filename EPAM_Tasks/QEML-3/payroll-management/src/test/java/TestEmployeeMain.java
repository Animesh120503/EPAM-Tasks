import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEmployeeMain {
    @Test
    public void testPrint(){
        assertEquals("Hello World", print());
    }
    
    public String print(){
        return "Hello World";
    }
}
