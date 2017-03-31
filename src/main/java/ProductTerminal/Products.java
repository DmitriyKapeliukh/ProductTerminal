package main.java.ProductTerminal;

/**
 * Created by Dmytro_Kapeliukh on 3/30/2017.
 */
public class Products {
    private String itemCode;
    private float priceSingle, priceOption;
    private int qtyOption, count;

    public Products(String itemCode, float priceSingle, float priceOption, int qtyOption){
        this.itemCode = itemCode;
        this.priceSingle = priceSingle;
        this.priceOption = priceOption;
        this.qtyOption = qtyOption;
        this.count = 0;
    }

    public float getPriceSingle() {
        return this.priceSingle;
    }


    public float getPriceOption() {
        return this.priceOption;
    }

    public int getQtyOption() {
        return this.qtyOption;
    }

    public int getCount() {
        return this.count;
    }

    public void updateCount(boolean withReset) {
        if (withReset) {
            this.count = 0;
        } else {
            this.count++;
        }
    }
}
