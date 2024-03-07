package extra;

import java.util.Arrays;

public class ExtraEntryPoint {

	public static void main(String[] args) {
		// buy 3 get 4th free (4th have to least priced)
		System.out.println(totalPrice(2, 3, 4, 5, 10, 48, 7, 8, 18));

//		SELCT * from ta where (select m from table1);

		// System.out.println(totalPrice(1, 2, 3, 4, 5, 6, 7, 8));
		// System.out.println(totalPrice(5, 1, 3, 4, 2, 6, 7, 8));
		// 1, 2, 3, 4
		// 5, 6, 7, 8

		// 5, 1, 3, 4 --
		// 2, 6, 7, 8 --
	}

	private static int totalPrice(int... prices) {
		// sort order in des order
		System.out.println(Arrays.toString(prices));
		int totalCartPrice = 0;
		for (int productID = 1; productID <= prices.length; productID++) {
			// System.out.println(productID - 1 + " | " + prices[productID - 1]);
			if (productID % 4 == 0) { // 0,1,2,3,
				// get the ID of the product with least price...
				// 0,1,2,3
				int minPrice = Math.min(
						Math.min(Math.min(prices[productID - 1], prices[productID - 2]), prices[productID - 3]),
						prices[productID - 4]);
				System.out.println("minPrice: " + minPrice);
				totalCartPrice -= minPrice;
			}
			totalCartPrice += prices[productID - 1];
		}
		return totalCartPrice;
	}
}

class Product {
	private int productID;
	private int productPrice;
	private boolean isFree;
	private String productDetails;

	private FeedBacks feedBacks;

	Product() {
		super();
	}

	Product(int id, int productPrice, boolean isFree, String productDetails) {
		super();
		this.productID = id;
		this.productDetails = productDetails;
		this.productPrice = productPrice;
		this.isFree = isFree;
	}
}

class FeedBacks {
	FeedBacks() {
		super();
	}
}