
public class Item implements Comparable<Item> {
	
	private String upc;
	private String title;
	private String type;
	private String category;
	private String company;
	private int year;
	private double price;
	private int stock;
	private int quantitySold;

	
	public Item()
	{
		
	}
	
	public Item(String upc,int quantitySold)
	{
		this.upc=upc;
		this.quantitySold=quantitySold;
	}
	
	
	public String getUpc() {
		return upc;
	}



	public void setUpc(String upc) {
		this.upc = upc;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getQuantitySold() {
		return quantitySold;
	}



	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public int compareTo(Item anotherInstance) {
		return anotherInstance.getQuantitySold()-this.quantitySold;
	}
	
	public String toString()
	{
		return "upc "+this.getUpc()+", quantity "+this.getQuantitySold()+",title "+this.getTitle()+",company"+this.getCompany()+",stock"+this.getStock();
	}
	

}
