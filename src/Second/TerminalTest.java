package Second;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Dmytro_Kapeliukh on 3/30/2017.
 */
public class TerminalTest {
    @Test
    public void test() {
        Terminal2 terminal2 = new Terminal2();
        Products testProduct = new Products("A", 1, Float.parseFloat("2.75"), 3);
        Products testProduct2 = new Products("B", Float.parseFloat("3.5"), Float.parseFloat("0"), 0);
        Products testProduct3 = new Products("C", Float.parseFloat("1.5"), Float.parseFloat("5"), 4);

        terminal2.purchase.put("A", testProduct);
        terminal2.purchase.put("B", testProduct2);
        terminal2.purchase.put("C", testProduct3);

        terminal2.scan("A");
        terminal2.scan("B");
        terminal2.scan("C");

        System.out.printf("Your purchase bill is: $%.2f.", terminal2.total);
    }
}
