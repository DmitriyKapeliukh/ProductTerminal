package test.java.ProductTerminalTest;

import main.java.ProductTerminal.Products;
import main.java.ProductTerminal.Terminal2;
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
        Products testProduct4 = new Products("C", Float.parseFloat("0.75"), Float.parseFloat("0"), 0);

        terminal2.purchase.put("A", testProduct);
        terminal2.purchase.put("B", testProduct2);
        terminal2.purchase.put("C", testProduct3);
        terminal2.purchase.put("D", testProduct4);

        terminal2.discount.put("F", 5);
        terminal2.discount.put("FF", 7);
        terminal2.discount.put("FFF", 10);

        terminal2.scan("A");
        terminal2.scan("B");
        terminal2.scan("C");
        terminal2.scan("D");

        terminal2.scanDiscount("F");

        String list = String.format("%.2f", terminal2.total);

        Assert.assertEquals(list, "6.41");
    }

    @Test
    public void test1(){
        Terminal2 terminal2 = new Terminal2();
        Products testProduct = new Products("A", 1, Float.parseFloat("2.75"), 3);
        Products testProduct2 = new Products("B", Float.parseFloat("3.5"), Float.parseFloat("0"), 0);
        Products testProduct3 = new Products("C", Float.parseFloat("1.5"), Float.parseFloat("5"), 4);
        Products testProduct4 = new Products("C", Float.parseFloat("0.75"), Float.parseFloat("0"), 0);

        terminal2.purchase.put("A", testProduct);
        terminal2.purchase.put("B", testProduct2);
        terminal2.purchase.put("C", testProduct3);
        terminal2.purchase.put("D", testProduct4);

        terminal2.discount.put("F", 5);
        terminal2.discount.put("FF", 7);
        terminal2.discount.put("FFF", 10);

        terminal2.scan("A");
        terminal2.scan("A");
        terminal2.scan("A");
        terminal2.scan("D");

        terminal2.scanDiscount("FF");

        String list = String.format("%.2f", terminal2.total);

        Assert.assertEquals(list, "3.26");
    }

    @Test
    public void test2(){
        Terminal2 terminal2 = new Terminal2();
        Products testProduct = new Products("A", 1, Float.parseFloat("2.75"), 3);
        Products testProduct2 = new Products("B", Float.parseFloat("3.5"), Float.parseFloat("0"), 0);
        Products testProduct3 = new Products("C", Float.parseFloat("1.5"), Float.parseFloat("5"), 4);
        Products testProduct4 = new Products("C", Float.parseFloat("0.75"), Float.parseFloat("0"), 0);

        terminal2.purchase.put("A", testProduct);
        terminal2.purchase.put("B", testProduct2);
        terminal2.purchase.put("C", testProduct3);
        terminal2.purchase.put("D", testProduct4);

        terminal2.discount.put("F", 5);
        terminal2.discount.put("FF", 7);
        terminal2.discount.put("FFF", 10);

        terminal2.scan("C");
        terminal2.scan("C");
        terminal2.scan("A");
        terminal2.scan("A");

        terminal2.scanDiscount("FFF");

        String list = String.format("%.2f", terminal2.total);

        Assert.assertEquals(list, "4.50");
    }
}
