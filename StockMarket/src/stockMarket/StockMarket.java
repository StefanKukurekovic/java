package stockMarket;

import stockMarket.Stock;
import stockMarket.StockList;

public class StockMarket {

	// 7pts
	// The main function should execute all the other implemented functions and display the results in the console.
	// Add the code as instructed by the comments in the function.
	public static void main(String[] args) {
		StockList stockList = new StockList();

		
		System.out.println("***Empty stock list***");
		
		// use the displayAllStocks function here	
		
		System.out.println();

		
		
		System.out.println("***Display first stock from the list***");
		
		// use the addDemodata function to add some stocks to stockList
		// use the displayStock function to display the first element of the stockList
		
		System.out.println();
		

		
		System.out.println("***Stock list with demo data***");
		
		// display the complete stockList with the displayAllStocks function
		
		System.out.println();
		

		
		System.out.println("***Stock list doesn't contain duplicate entry***");
		
		// try to add a duplicate stock (a stock with the name of an already existing stock in the list) to the stockList,
		// display all stocks with the displayAllStocks function it should not contain the duplicate stock.

		System.out.println();
		


		System.out.println("***Sorted by Change***");
		
		// use the sortStocksByChange function followed by the displayAllStocks function

		System.out.println();

		
		
		System.out.println("***Only up trending stocks***");
		
		//display all stocks that are returned by the filterStocks function
		
		System.out.println();
		
		

		System.out.println("***Removed 3 stocks***");
		
		// remove the movie at index position 4
		// remove the movie at index position 1
		// remove the movie at index position 0
		// try to remove an invalid index
		// use the displayAllStocks function
		
	}

	// 5pts
	// Display following attributes well formatted in one line:
	// the stock name, 
	// the price of the third day in previous3Days,
	// the difference between the third and the second day in previous3Days 
	// and the relative change in percent between the third and the second day in previous3Day
	public static void displayStock(Stock stock) {
		
	}	

	// 8pts
	// Display a header line (Name, Price, Diff, Change),
	// followed by a separator line (-----------),
	// followed by all stocks in the list
	// If the list has no entries output a message that there are no entries instead.
	// Hint: use the displayStock method.
	public static void displayAllStocks(StockList list) {
		
	}

	// 8pts
	// Add a stock to the list.
	// Prevent duplicate entries in the list by rejecting stocks
	// that have the same name as an already existing stock.
	// If the list does not have enough space for the new stock
	// the capacity of the StockList should be increased before the new stock is added.
	// The function should return true if the stock was added successfully and false otherwise.
	public static boolean addStock(StockList list, Stock stock) {

		return false;
	}
	
	// 5pts
	// Create a new Stock with name and previous3Days
	// and use the above addStock() method to add the new Stock to the list.
	// The function should return true if the stock was added successfully and false otherwise.
	public static boolean addStock(StockList list, String name, double[] previous3Days) {

		return false;
	}

	// 6pts
	// Remove a stock from the StockList at the specified index.
	// Check if the index is a valid index to prevent exceptions.
	// If the index is invalid just do nothing.
	public static void removeStock(StockList list, int idx) {

	}

	// 8pts
	// Sort stocks in the StockList by relative change.
	public static void sortStocksByChange(StockList list) {

	}

	// 7pts
	// Create a new StockList and add all stocks from the original List that are upwards trending.
	// A stock is only upwards trending if every consecutive day in the previous3Days is bigger then the previous one.
	// The new StockList should be returned.
	public static StockList filterStocks(StockList list) {

		
		return null;
	}
	
	
	
	
	// ***** Pre-existing addDemodata function *****
	// Adds 5 demo stocks to the StockList. 
	// The addStock() functions have to be implemented for this function to work.
	public static void addDemodata(StockList list) {
		addStock(list, "Apple", new double[] { 293.7, 300.4, 298.6 });
		addStock(list, "Tesla", new double[] { 418.3, 430.3, 447 });
		addStock(list, "Amazon", new double[] { 1898, 1872.9, 1847.8 });
		addStock(list, "Facebook", new double[] { 204.4, 205.3, 209.8 });
		addStock(list, "Netflix", new double[] { 323.6, 323.3, 329.8 });
	}

}
