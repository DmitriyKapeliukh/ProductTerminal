package ProductTerminal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.Buffer;
import java.util.ArrayList;

/*
A $1.00 each or 3 for $2.75
B $3.50
C $1.50 or $5 for a four pack
D $0.75
F - discount card (F -5%, FF -7%, FFF -10%) *\

/**
 * Created by Dmytro_Kapeliukh on 3/28/2017.
 */
public class ProductTerminal {
    private static String exit = "EXIT";
    private static int productA = 0;
    private static int productB = 0;
    private static int productC = 0;
    private static int productD = 0;
    private static int discount = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();
        while (true){
            String product = reader.readLine();
            product = product.toUpperCase();
            if (product.equals(exit)){
                System.out.println("Good bye");
                break;
            }
            list.add(product);
        }

        String str = "";
        for (String s : list){
            str += s;
        }

        productList(str);
    }

    public static String productList(String s){

        char[] productList = s.toCharArray();

        for (int i = 0; i < productList.length; i++){

            if (productList[i] == 'A'){
                productA++;
            }
            if (productList[i] == 'B'){
                productB++;
            }
            if (productList[i] == 'C'){
                productC++;
            }
            if (productList[i] == 'D'){
                productD++;
            }
            if (productList[i] == 'F'){
                discount++;
            }
        }

        int restA = productA % 3;
        int restC = productC % 4;

        double totalA = ((productA - restA)/3)*2.75 + restA;
        double totalB = productB * 3.5;
        double totalC = ((productC - restC)/4)*5 + restC * 1.5;
        double totalD = productD * 0.75;

        double totalResult = totalA + totalB + totalC + totalD;

        double discountPercentage = getDiscountPercentage(discount);

        double totalResultWithDiscount = totalResult*discountPercentage;

        totalResultWithDiscount = BigDecimal.valueOf(totalResultWithDiscount).setScale(2, RoundingMode.HALF_UP).doubleValue();

        String result = Double.toString(totalResultWithDiscount);
        System.out.println(totalResultWithDiscount);

        return result;
    }

    public static double getDiscountPercentage(int discount){
        switch (discount){
            case 0: // No discount
                return 1;
            case 1: //F -%
                return 0.95;
            case 2: //FF -7%
                return 0.93;
            case 3: //FFF -10%
                default:
                    return 0.9;
        }
    }
}
