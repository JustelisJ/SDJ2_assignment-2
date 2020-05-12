package Server.utility;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {

    private ArrayList<String> q;

    @Before
    public void setup()
    {
        q = new ArrayList<>();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addToSpecificIndex()
    {
        q.add(1, "1");
        assertEquals(q.get(0), null);
    }

    @Test
    public void addWhenEmpty()
    {
        q.add("1");
        assertEquals(q.get(0), "1");
    }

    @Test (expected = IllegalStateException.class)
    public void addWhenFull()
    {
        for(int i = 0; i < 101; i++)
        {
            q.add(i + "");
        }
        assertEquals(q.get(101), "101");
    }

    @Test
    public void addNull()
    {
        q.add(null);
        assertEquals(q.get(0), null);
    }

    @Test
    public void setSpecificValue()
    {
        q.add("1");
        q.set(0, "2");
        assertEquals(q.get(0), "2");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void setSpecificValueWhenOutOfBounds()
    {
        q.add("1");
        q.set(1, "2");
    }

    @Test
    public void getValue()
    {
        q.add("1");
        assertEquals(q.get(0), "1");
    }

    @Test (expected = IllegalStateException.class)
    public void getValueWhenOutOfBounds()
    {
        q.add("1");
        q.get(1);
    }

    @Test
    public void removeIndex()
    {
        q.add("1");
        assertEquals(q.remove(0), "1");
    }

    @Test
    public void removeIndexFromArrayListReducesArray()
    {
        q.add("1");
        q.remove(0);
        assertEquals(q.size(), 0);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void removeIndexFromArrayListWhenOutOfBounds()
    {
        q.remove(0);
    }

    @Test
    public void removeElement()
    {
        q.add("1");
        q.add("2");
        q.remove("2");
        assertEquals(q.size(), 1);
    }

    @Test (expected = IllegalStateException.class)
    public void removeElementWhenNonExistant()
    {
        q.add("1");
        q.remove("2");
    }

    @Test
    public void indexOf()
    {
        q.add("1");
        q.add("2");
        q.add("3");
        assertEquals(q.indexOf("2"), 1);
    }

    @Test
    public void indexOfWhenNonExistant()
    {
        q.add("1");
        q.add("2");
        q.add("3");
        assertEquals(q.indexOf("4"), -1);
    }

    @Test
    public void containsElement()
    {
        q.add("1");
        assertTrue(q.contains("1"));
    }

    @Test
    public void doesNotContainsElement()
    {
        q.add("1");
        assertFalse(q.contains("2"));
    }

    @Test
    public void isEmpty()
    {
        assertTrue(q.isEmpty());
    }

    @Test
    public void isNotEmpty()
    {
        q.add("1");
        assertFalse(q.isEmpty());
    }

    @Test
    public void isFull()
    {
        for(int i = 0; i < 100; i++)
        {
            q.add(i + "");
        }
        assertTrue(q.isFull());
    }

    @Test
    public void isNotFull()
    {
        q.add("1");
        assertTrue(q.isFull()); //An ArrayList is a dynamic array, its always full
    }

    @Test
    public void sizeCall()
    {
        q.add("1");
        q.add("1");
        assertEquals(q.size(), 2);
    }

    @Test
    public void toStringCall()
    {
        q.add("1");
        q.add("2");
        assertEquals(q.toString(), "{1, 2}");
    }
}