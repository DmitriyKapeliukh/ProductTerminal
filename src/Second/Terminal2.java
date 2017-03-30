package Second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmytro_Kapeliukh on 3/30/2017.
 */
public class Terminal2 {
    float total = 0.00f;
    Map<String, Products> purchase = new HashMap<>();

    public void loadPrices() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("How much product do you have?");
        int str = Integer.parseInt(reader.readLine());
        System.out.println("Please provide product parameters:\nProduct code, product price, special price of quantity, quantity for special price\nEach parameter in new line ");
        for (int i = 0; i < str; i++){
            String[] productDescription = new String[4];
            for (int k = 0; k < productDescription.length; k++) {
                productDescription[k] = reader.readLine();
            }

            try {
                Products products = new Products(productDescription[0],
                        Float.parseFloat(productDescription[1]),
                        Float.parseFloat(productDescription[2]),
                        Integer.parseInt(productDescription[3]));

                purchase.put(productDescription[0], products);
                System.out.println("Done");
            }
            catch (NumberFormatException e){
                System.out.println("Invalid parameter.");
            }

        }
    }

    public void scan(String item){
        total += this.updatePrice(purchase, item);
        System.out.printf("Item added. Current bill is: $%.2f. Please, scan the next item.\n(* to finish your purchase)\n", total);
    }

    private float updatePrice(Map<String, Products> purchase, String item){
        if (purchase.get(item).getQtyOption() - purchase.get(item).getCount() > 1){
            purchase.get(item).updateCount(false);
            return purchase.get(item).getPriceSingle();
        }
        else {
            if (purchase.get(item).getQtyOption() - purchase.get(item).getCount() == 1){
                float correction = purchase.get(item).getPriceOption() - purchase.get(item).getCount() * purchase.get(item).getPriceSingle();
                purchase.get(item).updateCount(true);
                return correction;
            }
            else {
                return purchase.get(item).getPriceSingle();
            }
        }
    }
}
