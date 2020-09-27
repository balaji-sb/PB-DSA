package hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PBHashMapTest {

    @Test
    public void hashMapPutTest() {
        PBHashMap<String, String> pbHashMap = new PBHashMap<>();
        pbHashMap.put("fname", "Balaji");
        pbHashMap.put("lname", "SB");
        pbHashMap.put("occup", "SDE");
        assertEquals("Balaji", pbHashMap.get("fname"));
        assertEquals("SB", pbHashMap.get("lname"));
        assertEquals("SDE", pbHashMap.get("occup"));
    }

    @Test
    public void examplePutTest() {
        PBHashMap<String, String> pbHashMap = new PBHashMap<>();
        pbHashMap.put("John Smith", "521-1234");
        pbHashMap.put("Lisa Smith", "521-8976");
        pbHashMap.put("Sam Doe", "521-5030");
        pbHashMap.put("Sandra Dee", "521-9655");
        pbHashMap.put("Ted Baker", "418-4165");
        assertEquals("521-1234", pbHashMap.get("John Smith"));
        assertEquals("521-8976", pbHashMap.get("Lisa Smith"));
        assertEquals("521-5030", pbHashMap.get("Sam Doe"));
        assertEquals("521-9655", pbHashMap.get("Sandra Dee"));
        assertEquals("418-4165", pbHashMap.get("Ted Baker"));
    }

    @Test
    public void hashMapPutNumberTest() {
        PBHashMap<String, Integer> pbHashMap = new PBHashMap<>();
        pbHashMap.put("fname", 1);
        pbHashMap.put("lname", 3);
        pbHashMap.put("occup", 4);
        assertEquals(1, pbHashMap.get("fname"));
        assertEquals(3, pbHashMap.get("lname"));
        assertEquals(4, pbHashMap.get("occup"));
        assertEquals(3, pbHashMap.size());
    }

    @Test
    public void removeFromHashMap(){
        PBHashMap<String, Integer> pbHashMap = new PBHashMap<>();
        pbHashMap.put("fname", 1);
        pbHashMap.put("mname", 2);
        pbHashMap.put("lname", 3);
        assertEquals(3, pbHashMap.size());
        pbHashMap.remove("mname");
        assertEquals(2, pbHashMap.size());
        assertEquals(1, pbHashMap.get("fname"));
        assertNull(pbHashMap.get("mname"));
        assertEquals(3, pbHashMap.get("lname"));
    }

}