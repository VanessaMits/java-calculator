package LogicTest;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.example.Logic.Operation;
import org.example.Models.Polynomial;


public class OperationTest {

    @Test
    public void testAdd() {
        // Definirea polinoamelor
        Polynomial poly1 = new Polynomial();
        poly1.addTerm(2, 3.0); // 3x^2
        poly1.addTerm(1, 2.0); // 2x
        Polynomial poly2 = new Polynomial();
        poly2.addTerm(2, 4.0); // 4x^2
        poly2.addTerm(1, 1.0); // 1x

        // Rezultatul corect al adunării
        Polynomial expectedResult = new Polynomial();
        expectedResult.addTerm(2, 7.0); // 7x^2
        expectedResult.addTerm(1, 3.0); // 3x

        // Apelarea metodei de adunare și compararea cu rezultatul corect
        Operation operation = new Operation();
        Polynomial result = operation.add(poly1, poly2);
        assertEquals(expectedResult.toString(), result.toString());
    }

    @Test
    public void testSubtract() {
        // Definirea polinoamelor
        Polynomial poly1 = new Polynomial();
        poly1.addTerm(2, 3.0); // 3x^2
        poly1.addTerm(1, 2.0); // 2x
        Polynomial poly2 = new Polynomial();
        poly2.addTerm(2, 1.0); // 1x^2
        poly2.addTerm(1, 1.0); // 1x

        // Rezultatul corect al scăderii
        Polynomial expectedResult = new Polynomial();
        expectedResult.addTerm(2, 2.0); // 2x^2
        expectedResult.addTerm(1, 1.0); // 1x

        // Apelarea metodei de scădere și compararea cu rezultatul corect
        Operation operation = new Operation();
        Polynomial result = operation.subtract(poly1, poly2);
        assertEquals(expectedResult.toString(), result.toString());
    }
}
