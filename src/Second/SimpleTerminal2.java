package Second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

/**
 * Created by Dmytro_Kapeliukh on 3/30/2017.
 */
public class SimpleTerminal2 {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        Terminal2 terminal2 = new Terminal2();
        terminal2.loadPrices();
        System.out.println("Scan your products");

        boolean endScan = false;
        while (!endScan) {
            String purchaseItem = reader.next();
            if (purchaseItem.equals("*")) {
                endScan = true;
            } else {
                terminal2.scan(purchaseItem);
            }
        }
        reader.close();

        System.out.printf("Your purchase bill is: $%.2f.", terminal2.total);

    }
}
