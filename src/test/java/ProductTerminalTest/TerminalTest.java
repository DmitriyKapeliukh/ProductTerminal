package test.java.ProductTerminalTest;

import main.java.ProductTerminal.Products;
import main.java.ProductTerminal.Terminal;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Dmytro_Kapeliukh on 3/30/2017.
 */
public class TerminalTest {
    @Test
    public void testABCDproducts() {
        Terminal terminal = new Terminal();
        terminal.loadProducts("A", 1, Float.parseFloat("2.75"), 3);
        terminal.loadProducts("B", Float.parseFloat("3.5"), Float.parseFloat("0"), 0);
        terminal.loadProducts("C", Float.parseFloat("1.5"), Float.parseFloat("5"), 4);
        terminal.loadProducts("D", Float.parseFloat("0.75"), Float.parseFloat("0"), 0);

        terminal.loadDiscount("F", 5);
        terminal.loadDiscount("FF", 7);
        terminal.loadDiscount("FFF", 10);

        terminal.scan("A");
        terminal.scan("B");
        terminal.scan("C");
        terminal.scan("D");

        terminal.scanDiscount("F");

        String totalPrice = String.format("%.2f", terminal.getTotalprice());

        Assert.assertEquals(totalPrice, "6.41");
    }

    @Test
    public void testAAADproducts(){
        Terminal terminal = new Terminal();
        terminal.loadProducts("A", 1, Float.parseFloat("2.75"), 3);
        terminal.loadProducts("B", Float.parseFloat("3.5"), Float.parseFloat("0"), 0);
        terminal.loadProducts("C", Float.parseFloat("1.5"), Float.parseFloat("5"), 4);
        terminal.loadProducts("D", Float.parseFloat("0.75"), Float.parseFloat("0"), 0);

        terminal.loadDiscount("F", 5);
        terminal.loadDiscount("FF", 7);
        terminal.loadDiscount("FFF", 10);

        terminal.scan("A");
        terminal.scan("A");
        terminal.scan("A");
        terminal.scan("D");

        terminal.scanDiscount("FF");

        String totalPrice = String.format("%.2f", terminal.getTotalprice());

        Assert.assertEquals(totalPrice, "3.26");
    }

    @Test
    public void testCCAAproducts(){
        Terminal terminal = new Terminal();
        terminal.loadProducts("A", 1, Float.parseFloat("2.75"), 3);
        terminal.loadProducts("B", Float.parseFloat("3.5"), Float.parseFloat("0"), 0);
        terminal.loadProducts("C", Float.parseFloat("1.5"), Float.parseFloat("5"), 4);
        terminal.loadProducts("D", Float.parseFloat("0.75"), Float.parseFloat("0"), 0);

        terminal.loadDiscount("F", 5);
        terminal.loadDiscount("FF", 7);
        terminal.loadDiscount("FFF", 10);

        terminal.scan("C");
        terminal.scan("C");
        terminal.scan("A");
        terminal.scan("A");

        terminal.scanDiscount("FFF");

        String totalPrice = String.format("%.2f", terminal.getTotalprice());

        Assert.assertEquals(totalPrice, "4.50");
    }
}
