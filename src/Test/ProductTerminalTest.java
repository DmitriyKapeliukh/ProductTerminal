package Test;


import ProductTerminal.ProductTerminal;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Dmytro_Kapeliukh on 3/28/2017.
 */
public class ProductTerminalTest {

    @Test
    public void Test(){
        ProductTerminal terminal = new ProductTerminal();
        String list = terminal.productList("ABCDABA");
        Assert.assertEquals(list, "12.0");
    }

    @Test
    public void Test1(){
        ProductTerminal terminal = new ProductTerminal();
        String list = terminal.productList("AAAAAAAA");
        Assert.assertEquals(list, "7.5");
    }

    @Test
    public void Test2(){
        ProductTerminal terminal = new ProductTerminal();
        String list = terminal.productList("ABFFCD");
        Assert.assertEquals(list, "6.28");
    }

}
