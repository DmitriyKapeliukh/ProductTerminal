package main.java.ProductTerminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmytro_Kapeliukh on 3/30/2017.
 */
public class Terminal {
    private float totalprice = 0.00f;
    private Map<String, Products> purchase = new HashMap<>();
    private Map<String, Integer> discount = new HashMap<>();

    public void loadPrices() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("How much product do you have?");
        int str = Integer.parseInt(reader.readLine());
        System.out.println("Please provide product parameters:\nProduct code, product price, special price of quantity, quantity for special price\nEach parameter in new line ");
        for (int i = 0; i < str; i++) {
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
            } catch (NumberFormatException e) {
                System.out.println("Invalid parameter.");
            }
        }
    }

    public void setDiscount() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please configure discount card(s).\nHow much discount cards do you have?");
        int str = Integer.parseInt(reader.readLine());
        System.out.println("Specify parameters.\nWhere:\n-first parameter: code\n-second parameter: discount");
        for (int i = 0; i < str; i++) {
            discount.put(reader.readLine(), Integer.parseInt(reader.readLine()));
        }
    }

    public void scan(final String item) {
        totalprice += this.updatePrice(purchase, item);
        System.out.printf("Item added. Current bill is: $%.2f. Please, scan the next item.\n(* to finish your purchase)\n", totalprice);
    }

    private float updatePrice(Map<String, Products> purchase, String item) throws NullPointerException{

            if (purchase.get(item).getQtyOption() - purchase.get(item).getCount() > 1) {
                purchase.get(item).updateCount(false);
                return purchase.get(item).getPriceSingle();
            } else {
                if (purchase.get(item).getQtyOption() - purchase.get(item).getCount() == 1) {
                    float correction = purchase.get(item).getPriceOption() - purchase.get(item).getCount() * purchase.get(item).getPriceSingle();
                    purchase.get(item).updateCount(true);
                    return correction;
                } else {
                    return purchase.get(item).getPriceSingle();
                }
            }
    }

    public void scanDiscount(final String item){
        int value = (int) discount.get(item);
        updatePriceWithDiscount(value);
        System.out.println("Another discount?\n* to finish your purchases");
    }

    private float updatePriceWithDiscount(final int discount){
        totalprice = totalprice - (totalprice /100*discount);
        return totalprice;
    }

    public void loadProducts(final String item, final float price, final float qtyPrice, final int qty){
        purchase.put(item, new Products(item, price, qtyPrice, qty));
    }
    public void loadDiscount(final String item, final int discountRate){
        discount.put(item, discountRate);
    }

    public float getTotalprice(){
        return this.totalprice;
    }
}
