package main.java.ProductTerminal;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Dmytro_Kapeliukh on 3/30/2017.
 */
public class SimpleTerminal {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        Terminal terminal = new Terminal();
        terminal.loadPrices();
        terminal.setDiscount();
        System.out.println("Scan your products");

        boolean endScan = false;
        while (!endScan) {
            String purchaseItem = reader.next();
            if (purchaseItem.equals("*")) {
                endScan = true;
            } else {
                terminal.scan(purchaseItem);
            }
        }

        System.out.println("Please, use your discount");

        boolean useDiscount = false;
        while (!useDiscount){
            String discount = reader.next();
            if (discount.equals("*")){
                useDiscount = true;
            } else {
                terminal.scanDiscount(discount);
            }
        }
        reader.close();

        System.out.printf("Your purchase bill is: $%.2f.", terminal.getTotalprice());

    }
}
