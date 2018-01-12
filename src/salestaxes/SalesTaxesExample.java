package salestaxes;

import salestaxes.items.Basket;
import salestaxes.services.PrintUtils;
import salestaxes.services.SalesTaxesCalculator;

/*
 * An application that prints out the receipt details for some shopping baskets (produced by InputFactory class).
 */
public class SalesTaxesExample {

	public static void main(String[] args) {		
		InputFactory inputFactory = new InputFactory();
		
		Basket input1 = inputFactory.getBasket1();
		Basket input2 = inputFactory.getBasket2();
		Basket input3 = inputFactory.getBasket3();

		// Print of inputs
		System.out.println("INPUT:\n");
		
		System.out.println("Input 1:");
		PrintUtils.printBasket(input1);

		System.out.println("Input 2:");
		PrintUtils.printBasket(input2);

		System.out.println("Input 3:");
		PrintUtils.printBasket(input3);
		
		// Sales taxes computation
		SalesTaxesCalculator calculator = new SalesTaxesCalculator();

		calculator.computeSalesTaxes(input1);
		calculator.computeSalesTaxes(input2);
		calculator.computeSalesTaxes(input3);
		
		// Print of receipts
		System.out.println("\nOUTPUT:\n");
		
		System.out.println("Output 1:");
		PrintUtils.printReceipt(input1);
		
		System.out.println("Output 2:");
		PrintUtils.printReceipt(input2);
		
		System.out.println("Output 3:");
		PrintUtils.printReceipt(input3);
	}

}
