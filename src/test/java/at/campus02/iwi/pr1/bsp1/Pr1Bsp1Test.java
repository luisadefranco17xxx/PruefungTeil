package at.campus02.iwi.pr1.bsp1;

import static org.junit.Assert.*;

import jdk.jfr.StackTrace;
import org.junit.Before;
import org.junit.Test;

public class Pr1Bsp1Test {

    private double[] WEIGHTS;

    @Before
    public void setup(){
        WEIGHTS = ZooData.ANIMAL_WEIGHTS;
    }

    @Test
    public void testAmount() {
        assertEquals(200, Zoo.tierAnzahl(WEIGHTS));
    }

    @Test
    public void testElephants() {
        assertEquals(13, Zoo.elefanten(WEIGHTS));
    }

    @Test
    public void testAvgWeight() {
        double w = Zoo.mittleresGewicht(WEIGHTS);
        assertEquals(w, 81.49125466607, 0.00000000001);
    }

    @Test
    public void testCosts() {
        double c = Zoo.futterKosten(WEIGHTS);
        assertEquals(c, 1407.3, 0.1);
    }

    @Test
    public void testProblemCase() {
        assertTrue(Zoo.problemFallVorhanden(WEIGHTS));
    }

    @Test
    public void testProblemIndex() {
        assertEquals(62, Zoo.problemFallIndex(WEIGHTS,0));
        assertEquals(-1, Zoo.problemFallIndex(WEIGHTS,63));
        assertEquals(-1, Zoo.problemFallIndex(WEIGHTS,140));
        assertEquals(62, Zoo.problemFallIndex(WEIGHTS,46));
    }

    @Test
    public void testContainer() {
        assertEquals(5, Zoo.tiereImContainer(WEIGHTS,0));
        assertEquals(5, Zoo.tiereImContainer(WEIGHTS,63));
        assertEquals(4, Zoo.tiereImContainer(WEIGHTS,140));
        assertEquals(4, Zoo.tiereImContainer(WEIGHTS,190));

    }
}
