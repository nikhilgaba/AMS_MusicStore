import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
public class Functions {
	
	public static List<Item> shoppingcart=new ArrayList<Item>();
	public static double totalprice=0;
	public static String customerLogin=null;
	
	public static Connection createConnection()
	{
		Connection con;
		String connectionUrl = "jdbc:odbc:myDSN";
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}catch(ClassNotFoundException ce)
			{
				System.out.println("\n\nNo JDBC-ODBC bridge; exit now.\n\n");
				 return null;
			}
		
		try
		{
			con = DriverManager.getConnection(connectionUrl,"","");
		}catch (SQLException se)
			{
				System.out.println("\n\nNo proper DSN; exit now.\n\n");
				return null;
			}
		
		return con;
	}
	
	@SuppressWarnings("deprecation")
	public static int createOrder(String cid, String cardnum, String expirydate)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		int userreceipt=0;
		ResultSet rs;
		SimpleDateFormat myFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date today=new Date();
		Date expectedDelivery=new Date();
		String todaysdate=myFormat.format(today);
		String expectedDate=null;
		String query= "SELECT receiptId FROM Orders";
		int temp=0;
		int temp1=0;
		double counter=0;
		int numOfOrdersDeliveredADay=5;
		double numDays=0;
		try
		{
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				temp= rs.getInt("receiptId");
			}
			rs.close();
			userreceipt=temp+1;
			
			String secondquery="SELECT receiptId FROM ORDERS WHERE deliveredDate IS NULL";
			pstmt=con.prepareStatement(secondquery);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				temp1= rs.getInt("receiptId");
				counter=counter+1;
			}
			System.out.println(counter);
			rs.close();
			
			numDays=Math.ceil((counter/numOfOrdersDeliveredADay)+1);
			expectedDelivery.setDate((int) (today.getDate()+numDays));
			expectedDate=myFormat.format(expectedDelivery);
			
			String thirdquery="INSERT INTO Orders (receiptId,date,cid,card#,expiryDate,expectedDate) VALUES ("+userreceipt+",'"+todaysdate+"','"+cid+"','"+cardnum+"','"+expirydate+"','"+expectedDate+"')";
			System.out.println(secondquery);
			pstmt=con.prepareStatement(thirdquery);
			pstmt.executeUpdate();
			
			return userreceipt;
		}catch (SQLException se)
		{
			System.out.println("\nSQL Exception occured, the state : "+
							se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
			return -1;
		}
		
	}
	
	public static String getExpectedDate(int receiptid)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		String result=null;
		ResultSet rs;
		String query= "SELECT expectedDate FROM Orders WHERE receiptId="+receiptid;
		
		try
		{
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				result= rs.getString("expectedDate");
			}
			
			return result;
			
		}catch (SQLException se)
		{
			System.out.println("\nSQL Exception occured, the state : "+
							se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
			return null;
		}
		
	}
	
	public static void addPurchaseItem(int receipt, String upc, int quantity)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		String query= "INSERT INTO PurchaseItem VALUES ("+receipt+","+upc+","+quantity+")";
		
		try
		{
			pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();

		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return;
			}
	}
	
	public static int checkCredentials(String cid, String password)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs;
		String credentialcheck= "SELECT cid FROM Customer WHERE cid ='"+cid+"' AND password='"+password+"'";
		String temp="";
		
		try
		{
			pstmt = con.prepareStatement(credentialcheck);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				temp= rs.getString("cid");
			}
			
			if (temp.equals(""))
			{
				return 0;
			}
			else if (temp.equals(cid))
			{
				return 1;
			}

		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return -1;
			}
		return -1;
	}
	
	public static void decrementItemQuantity(Item shoppingcartitem)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		String upc=shoppingcartitem.getUpc();
		System.out.println(shoppingcartitem.getStock());
		System.out.println(shoppingcartitem.getQuantitySold());
		int newstock=shoppingcartitem.getStock()-shoppingcartitem.getQuantitySold();
		String query="UPDATE Item SET stock="+newstock+" WHERE upc="+upc;
		
		try
		{
			pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();

		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return;
			}
	}
	
	public static List<Item> getSearchResultsCategory(String category)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs;
		List<Item> searchResults=new ArrayList<Item>();
		String query="SELECT upc,title,price,stock FROM Item WHERE category LIKE'%"+category+"%'";
		
		try
		{
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String upc= rs.getString("upc");
				if (upc.equals(""))
				{
					return searchResults;
				}
				String title=rs.getString("title");
				Double price=rs.getDouble("price");
				int stock=rs.getInt("stock");
				Item object=new Item();
				object.setUpc(upc);
				object.setTitle(title);
				object.setPrice(price);
				object.setStock(stock);
				searchResults.add(object);
			}
			
			return searchResults;
			

		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return null;
			}
	}
	
	public static List<Item> getSearchResultsTitle(String titleSearch)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs;
		List<Item> searchResults=new ArrayList<Item>();
		String query="SELECT upc,title,price,stock FROM Item WHERE title LIKE'%"+titleSearch+"%'";
		
		try
		{
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String upc= rs.getString("upc");
				if (upc.equals(""))
				{
					return searchResults;
				}
				String title=rs.getString("title");
				Double price=rs.getDouble("price");
				int stock=rs.getInt("stock");
				Item object=new Item();
				object.setUpc(upc);
				object.setTitle(title);
				object.setPrice(price);
				object.setStock(stock);
				searchResults.add(object);
			}
			
			return searchResults;
			

		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return null;
			}
	}
	
	public static List<Item> getSearchResultsLeadSinger(String singer)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs;
		List<Item> searchResults=new ArrayList<Item>();
		String query="SELECT Item.upc, title, price, stock FROM Item JOIN LeadSinger a ON Item.upc=a.upc WHERE name LIKE'%"+singer+"%'";
		
		try
		{
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String upc= rs.getString("upc");
				if (upc.equals(""))
				{
					return searchResults;
				}
				String title=rs.getString("title");
				Double price=rs.getDouble("price");
				int stock=rs.getInt("stock");
				Item object=new Item();
				object.setUpc(upc);
				object.setTitle(title);
				object.setPrice(price);
				object.setStock(stock);
				searchResults.add(object);
			}
			
			return searchResults;
			

		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return null;
			}
	}
	
	public static List<Item> getSearchResultsAllFields(String category, String titleSearch, String leadsinger)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs;
		List<Item> searchResults=new ArrayList<Item>();
		String query="SELECT Item.upc, title, price, stock FROM Item JOIN LeadSinger a ON Item.upc=a.upc WHERE name LIKE '%"+leadsinger+"%' AND title LIKE '%"+titleSearch+"%' AND category LIKE '%"+category+"%'";
		
		try
		{
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String upc= rs.getString("upc");
				if (upc.equals(""))
				{
					return searchResults;
				}
				String title=rs.getString("title");
				Double price=rs.getDouble("price");
				int stock=rs.getInt("stock");
				Item object=new Item();
				object.setUpc(upc);
				object.setTitle(title);
				object.setPrice(price);
				object.setStock(stock);
				searchResults.add(object);
			}
			
			return searchResults;
			

		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return null;
			}
	}
	
	public static Item getItem(int upcSearch, int qty)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs;
		Item object=new Item();
		String query="SELECT upc, title, price, stock FROM Item WHERE upc="+upcSearch;
		
		try
		{
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String upc= rs.getString("upc");
				if (upc.equals(""))
				{
					return null;
				}
				String title=rs.getString("title");
				Double price=rs.getDouble("price");
				int stock=rs.getInt("stock");
				object.setUpc(upc);
				object.setTitle(title);
				object.setPrice(price);
				object.setStock(stock);
				object.setQuantitySold(qty);
			}
			
			return object;
			

		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return null;
			}
	}
	
	public static int checkStock(int upc, int qty)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs;
		int stock=0;
		String query="SELECT stock FROM Item WHERE upc="+upc;
		
		try
		{
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				stock= rs.getInt("stock");
			}
			
			if (stock>=qty)
			{
				return 1;
			}
			
			else
			{
				return 0;
			}
			
			

		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return -1;
			}
		
	}
	
	public static int checkDateRangeReturn (int receiptid)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs;
		String date= "SELECT date FROM Orders WHERE receiptID ="+receiptid;
		String sysdate=null;
		try
		{
			pstmt = con.prepareStatement(date);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				sysdate= rs.getString("date");
			}
			SimpleDateFormat myFormat=new SimpleDateFormat("yyyy-MM-dd");
			Date today=new Date();
			String todaystring=myFormat.format(today);
			long milliseconds=1296000000;
			try
			{
				Date sqldate=myFormat.parse(sysdate);
				Date todaydate=myFormat.parse(todaystring);
				long deltatime=todaydate.getTime()-sqldate.getTime();
				if (deltatime>milliseconds)
				{
					return 0;
				}
				else
				{
					return 1;
				}
			} catch (ParseException e){
				e.printStackTrace();
			}
				

			
		}catch (SQLException se)
		{
			System.out.println("\nSQL Exception occured, the state : "+
							se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
			return -1;
		}
		
		return -1;
	}
	
	public static int checkqtyReturn (int upc, int receiptid, int qty)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs;
		String qtycheck= "SELECT quantity FROM PurchaseItem WHERE receiptID ="+receiptid+" AND upc="+upc+" AND quantity>="+qty;
		String temp="";
		
		try
		{
			pstmt = con.prepareStatement(qtycheck);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				temp= rs.getString("quantity");
			}
			
			if (temp.equals(""))
			{
				return 0;
			}
			else
			{
				return 1;
			}

		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return -1;
			}
	}
	
	public static int checkUPCReturn(int upc, int receiptid)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs;
		String upccheck= "SELECT upc FROM PurchaseItem WHERE receiptID ="+receiptid+" AND upc="+upc;
		String temp="";
		
		try
		{
			pstmt = con.prepareStatement(upccheck);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				temp= rs.getString("upc");
			}
			
			if (temp.equals(""))
			{
				return 0;
			}
			else
			{
				return 1;
			}

		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return -1;
			}
	}
	
	public static int checkReceiptIDReturn(int receiptid)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs;
		String receiptCheck= "SELECT receiptID FROM Orders WHERE receiptID ="+receiptid;
		String temp="";
		
		try
		{
			pstmt = con.prepareStatement(receiptCheck);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				temp= rs.getString("receiptID");
			}
			
			if (temp.equals(""))
			{
				return 0;
			}
			else
			{
				return 1;
			}

		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return -1;
			}
		
		
	}
	
	public static int checkUsername(String cid)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs;
		String userCheck= "SELECT cid FROM Customer WHERE cid = '"+ cid +"'";
		String temp="";
		
		try
		{
			pstmt = con.prepareStatement(userCheck);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				temp= rs.getString("cid");
			}
			
			if (temp.equals(""))
			{
				return 1;
			}
			else
			{
				return 0;
			}

		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return -1;
			}
	}
	
	public static void customerReg(String name, String cid, String password, String address, String phone)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		try
		{
			
			String registerUser = "INSERT INTO Customer VALUES ('" + cid + "', '" +  password + "', '" + name + "', '" +  address + "', '" + phone + "');";
			pstmt=con.prepareStatement(registerUser);
			pstmt.executeUpdate();
			con.close();

		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return;
			}
	}
	
/*	public static void customerOnlineOrder()
	{
		Connection con=createConnection();
		
		try
		{
			
			//DO WORK HERE

		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return;
			}
	}
	
	public static void clerkReturn()
	{
		Connection con=createConnection();
		
		try
		{
			
			//DO WORK HERE

		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return;
			}
	}*/
	
	public static int managerAddItems(int upc, int stock, double price)
	{
		Connection con=createConnection();
		int totalstock=0;
		
		try
		{
			ResultSet rs;
			String statement="SELECT stock FROM Item WHERE upc="+upc;
			PreparedStatement pstmt1 = con.prepareStatement(statement);
			rs = pstmt1.executeQuery();
		
			while (rs.next()) {
				totalstock= rs.getInt("stock");
			}
			rs.close();
			
			  String queryAdd = "update Item set stock = ?, price = ? where upc = ?";
		      PreparedStatement pStmt = con.prepareStatement(queryAdd);
		      pStmt.setInt(1,totalstock+stock); // parameter 1, stock number changes
		      pStmt.setDouble(2,price); //parameter 2, so does price is specified
		      pStmt.setInt(3,upc); // parameter 3, based on upc number 
		 
		      // execute the java PreparedStatement
		      int test=pStmt.executeUpdate();
		       
		      if (test==0)
		    	{
		    	  con.close();
		    	  return 0;
		    	}
		      else
		      {
		    	  con.close();
		    	  return 1;
		      }

		

			
		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return -1;
			}
	}

public static int managerAddItems(int upc, int stock)
{
	Connection con=createConnection();
	int totalstock=0;
	
	try
	{
		ResultSet rs;
		String statement="SELECT stock FROM Item WHERE upc="+upc;
		PreparedStatement pstmt1 = con.prepareStatement(statement);
		rs = pstmt1.executeQuery();
	
		while (rs.next()) {
			totalstock= rs.getInt("stock");
		}
		rs.close();
		
		String queryAdd = "update Item set stock = ? where upc = ?";
	      PreparedStatement pStmt = con.prepareStatement(queryAdd);
	      pStmt.setInt(1,totalstock+stock); // parameter 1, stock number changes
	      //pStmt.setDouble(2,price); //parameter 2, so does price is specified
	      pStmt.setInt(2,upc); // parameter 3, based on upc number 
	 
	      // execute the java PreparedStatement
	      int test=pStmt.executeUpdate();
	      if (test==0)
	    	{
	    	  con.close();
	    	  return 0;
	    	}
	      else
	      {
	    	  con.close();
	    	  return 1;
	      }
	       

	

		
	}catch (SQLException se)
		{
			System.out.println("\nSQL Exception occured, the state : "+
							se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
			return -1;
		}
}
	
	public static List<List<Item>> managerDailyReport(String date)
	{
		Connection con=createConnection();
		//date format 2015-03-11
		String upc;
		int quantity;
		HashMap<String, Integer> totalquantity = new HashMap<String, Integer>();
		List<Item> totalquantitylist=new ArrayList<Item>();
		PreparedStatement pstmt = null;
		ResultSet rs;
		String fstatement="SELECT receiptId FROM [c354g07A].[dbo].[Orders] WHERE date='"+date+"'";
		String sSQL= "SELECT upc, quantity FROM [c354g07A].[dbo].[PurchaseItem] JOIN ("+fstatement+") a ON [c354g07A].[dbo].[PurchaseItem].receiptId=a.receiptId";
		String sSQL2="SELECT title, company, stock, category, price FROM [c354g07A].[dbo].[Item] WHERE upc=";
		
		try
		{
			
			pstmt = con.prepareStatement(sSQL);
			rs = pstmt.executeQuery();
		
			
			while (rs.next()) {
				upc= rs.getString("upc");
				totalquantity.put(upc,0);
			}
			rs.close();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				upc= rs.getString("upc");
				quantity=rs.getInt("quantity");
				totalquantity.put(upc,totalquantity.get(upc)+quantity);
			}
			rs.close();
			for(String upcKey: totalquantity.keySet() )
			{
				totalquantitylist.add(new Item(upcKey,totalquantity.get(upcKey)));
			}
			Collections.sort(totalquantitylist);
			for (int i=0; i<totalquantitylist.size(); i++)
			{
				 String tempupc=totalquantitylist.get(i).getUpc();
				 String sSQL3=sSQL2+tempupc;
				 pstmt = con.prepareStatement(sSQL3);
				 rs = pstmt.executeQuery();
				 while (rs.next()) {
						totalquantitylist.get(i).setTitle(rs.getString("title"));
						totalquantitylist.get(i).setCompany(rs.getString("company"));
						totalquantitylist.get(i).setStock(rs.getInt("stock"));
						totalquantitylist.get(i).setCategory(rs.getString("category"));
						totalquantitylist.get(i).setPrice(rs.getDouble("price"));
					}
				 rs.close();
			}
			con.close();
			List<Item> RockList=new ArrayList<Item>();
			List<Item> PopList=new ArrayList<Item>();
			List<Item> RapList=new ArrayList<Item>();
			List<Item> CountryList=new ArrayList<Item>();
			List<Item> ClassicalList=new ArrayList<Item>();
			List<Item> NewAgeList=new ArrayList<Item>();
			List<Item> InstrumentalList=new ArrayList<Item>();
			for (int i=0; i<totalquantitylist.size();i++)
			{
				if (totalquantitylist.get(i).getCategory().equals("Rock"))
				{
					RockList.add(totalquantitylist.get(i));
				}
				
				else if (totalquantitylist.get(i).getCategory().equals("Pop"))
				{
					PopList.add(totalquantitylist.get(i));
				}
				
				else if (totalquantitylist.get(i).getCategory().equals("Rap"))
				{
					RapList.add(totalquantitylist.get(i));
				}
				
				else if (totalquantitylist.get(i).getCategory().equals("Country"))
				{
					CountryList.add(totalquantitylist.get(i));
				}
				
				else if (totalquantitylist.get(i).getCategory().equals("Classical"))
				{
					ClassicalList.add(totalquantitylist.get(i));
				}
				
				else if (totalquantitylist.get(i).getCategory().equals("New Age"))
				{
					NewAgeList.add(totalquantitylist.get(i));
				}
				
				else if (totalquantitylist.get(i).getCategory().equals("Instrumental"))
				{
					InstrumentalList.add(totalquantitylist.get(i));
				}
			}
			List<List<Item>> returnList=new ArrayList<List<Item>>();
			returnList.add(RockList);
			returnList.add(PopList);
			returnList.add(RapList);
			returnList.add(CountryList);
			returnList.add(ClassicalList);
			returnList.add(NewAgeList);
			returnList.add(InstrumentalList);
			return returnList;

		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return null;
			}
	}
	
	
	public static List<Item> managerTopSellingItems(String date)
	{
		Connection con=createConnection();
		//date format 2015-03-11
		String upc;
		int quantity;
		HashMap<String, Integer> totalquantity = new HashMap<String, Integer>();
		List<Item> totalquantitylist=new ArrayList<Item>();
		PreparedStatement pstmt = null;
		ResultSet rs;
		String fstatement="SELECT receiptId FROM [c354g07A].[dbo].[Orders] WHERE date='"+date+"'";
		String sSQL= "SELECT upc, quantity FROM [c354g07A].[dbo].[PurchaseItem] JOIN ("+fstatement+") a ON [c354g07A].[dbo].[PurchaseItem].receiptId=a.receiptId";
		String sSQL2="SELECT title, company, stock FROM [c354g07A].[dbo].[Item] WHERE upc=";
		
		try
		{
			
			pstmt = con.prepareStatement(sSQL);
			rs = pstmt.executeQuery();
		
			
			while (rs.next()) {
				upc= rs.getString("upc");
				totalquantity.put(upc,0);
			}
			rs.close();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				upc= rs.getString("upc");
				quantity=rs.getInt("quantity");
				totalquantity.put(upc,totalquantity.get(upc)+quantity);
			}
			rs.close();
			for(String upcKey: totalquantity.keySet() )
			{
				totalquantitylist.add(new Item(upcKey,totalquantity.get(upcKey)));
			}
			Collections.sort(totalquantitylist);
			for (int i=0; i<totalquantitylist.size(); i++)
			{
				 String tempupc=totalquantitylist.get(i).getUpc();
				 String sSQL3=sSQL2+tempupc;
				 pstmt = con.prepareStatement(sSQL3);
				 rs = pstmt.executeQuery();
				 while (rs.next()) {
						totalquantitylist.get(i).setTitle(rs.getString("title"));
						totalquantitylist.get(i).setCompany(rs.getString("company"));
						totalquantitylist.get(i).setStock(rs.getInt("stock"));
					}
				 rs.close();
			}
			con.close();
			return totalquantitylist;

		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return null;
			}
	}
	
	public static int managerProcessDelivery(int receipt, String date)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		String temp="";
		ResultSet rs;
		String query1="SELECT receiptId FROM Orders WHERE receiptId="+receipt;
		String query2= "UPDATE Orders SET deliveredDate='"+date+"' WHERE receiptId="+receipt;

		
		try
		{
			pstmt = con.prepareStatement(query1);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				temp= rs.getString("receiptId");
			}
			rs.close();
			if (temp.equals(""))
			{
				return 0;
			}
			else
			{
				pstmt = con.prepareStatement(query2);
				pstmt.executeUpdate();
				return 1;
			}
			

	
		

		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return -1;
			}
	}
	
	public static int createReturn(int receipt)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs;
		SimpleDateFormat myFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date today=new Date();
		int temp=0;
		int userretid=0;
		String todaysdate=myFormat.format(today);
		String query= "SELECT retid FROM Returns";
		
		try
		{
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				temp= rs.getInt("retid");
			}
			rs.close();
			userretid=temp+1;
			
			String secondquery="INSERT INTO Returns VALUES ("+userretid+",'"+todaysdate+"',"+receipt+")";
			pstmt=con.prepareStatement(secondquery);
			pstmt.executeUpdate();
			
			return userretid;
		}catch (SQLException se)
		{
			System.out.println("\nSQL Exception occured, the state : "+
							se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
			return -1;
		}
	}
	
	public static void createReturnItem(int retid, int upc, int quantity)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		
		String query= "INSERT INTO ReturnItem VALUES ("+retid+","+upc+","+quantity+")";
		
		try
		{
			pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();
			
		}catch (SQLException se)
		{
			System.out.println("\nSQL Exception occured, the state : "+
							se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
			return;
		}
	}
	
	public static void decrementQuantityPurchaseItem(int receiptid, int quantityreturned, int upc)
	{
		Connection con=createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs;
		int quantitybought=0;
		int newquantity=0;
		String query="SELECT quantity FROM PurchaseItem WHERE receiptId="+receiptid+" AND upc="+upc;
		
		try
		{
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				quantitybought= rs.getInt("quantity");
			}
			rs.close();
			newquantity=quantitybought-quantityreturned;
			
			
			String secondquery="UPDATE PurchaseItem SET quantity="+newquantity+" WHERE receiptId="+receiptid+" AND upc="+upc;
			pstmt=con.prepareStatement(secondquery);
			pstmt.executeUpdate();
			
		}catch (SQLException se)
		{
			System.out.println("\nSQL Exception occured, the state : "+
							se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
			return;
		}
	}

}
