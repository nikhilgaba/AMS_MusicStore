import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

import javax.swing.JTable;


@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	
	//Clerk Return Declaration
	private JTextField txtReceiptId;
	private JTextField txtUpc;
	private JTextField txtQty;
	private JTextField txtEnterUpc;
	private JTextField txtEnterQty;
	private JTextField txtEnterPrice;
	private JButton btnBackClerk;
	
	//Manager Screen Declaration
	private JButton btnBackManager;
	
	//Sherlock's Login Screen Declaration
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnBackLogin;
	
	//Sherlock's Registration Screen Declaration
	private JTextField textFieldRegistration;
	private JPasswordField passwordFieldRegistration;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnBackRegistration;
	
	//Sherlock's Transaction Screen Declaration
	private JTextField textFieldShopping;
	private JTextField textFieldShopping1;
	private JTextField textFieldShopping2;
	private JButton btnBackTransaction;
	
	//Customer Shopping Screen Declaration
	private JTextField txtShopping;
	private JTextField txtShopping_1;
	private JTextField txtShopping_2;
	private JButton btnBackShopping;
	
	//Manager Sales Report Declaration
	private JTextField txtFieldSalesReport;
	private JButton btnBackSalesReport;
	
	//Manager Top Selling Item Declaration
	private JTextField TopSellingItemDate;
	private JTextField TopSellingItemItemsSold;
	private JButton btnBackTopSellingItem;
	
	//Manager Process Delivery Declaration
	private JTextField ProcessDeliveryNewDate;
	private JTextField ProcessDeliveryReceiptID;
	private JButton btnBackProcessDelivery;
	
	//Manager Add Item Declaration
	private JButton btnBackAddItem;
	
	//Shopping Cart Declaration
	private JButton btnBackShoppingCart;
	
	//Customer Search Result Declaration
	private JButton btnBackCustomerSearch;
	private JTextField txtEnterUpcShopping;
	private JTextField txtEnterQtyShopping;
	
	//Top Selling Item Result Declaration
	private JButton btnBackTopSellingItemResult;
	
	//Sales Report Result Declaration
	private JButton btnBackSalesReportResult;
	JTable tableSalesReportResult;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel MainScreen = new JPanel();
		MainScreen.setBounds(0, 0, 450, 300);
		contentPane.add(MainScreen);
		MainScreen.setLayout(null);
		
		final JPanel ClerkReturnPanel = new JPanel();
		ClerkReturnPanel.setBounds(0, 0, 450, 300);
		//contentPane.add(ClerkReturnPanel);
		ClerkReturnPanel.setLayout(null);
		ClerkReturnPanel.setVisible(false);
		
		final JPanel ManagerAddItemPane = new JPanel();
		ManagerAddItemPane.setBounds(0, 0, 450, 300);
		//contentPane.add(ManagerAddItemPane);
		ManagerAddItemPane.setLayout(null);
		ClerkReturnPanel.setVisible(false);
		
		final JPanel ManagerMainPanel = new JPanel();
		ManagerMainPanel.setBounds(0, 0, 450, 300);
		//contentPane.add(ManagerMainPanel);
		ManagerMainPanel.setLayout(null);
		ManagerMainPanel.setVisible(false);
		
		final JPanel CustomerLoginPanel = new JPanel();
		CustomerLoginPanel.setBounds(0, 0, 450, 300);
		//contentPane.add(CustomerLoginPanel);
		CustomerLoginPanel.setLayout(null);
		CustomerLoginPanel.setVisible(false);
		
		final JPanel CustomerRegistrationPanel = new JPanel();
		CustomerRegistrationPanel.setBounds(0, 0, 450, 300);
		//contentPane.add(CustomerRegistrationPanel);
		CustomerRegistrationPanel.setLayout(null);
		CustomerRegistrationPanel.setVisible(false);
		
		final JPanel CustomerShoppingPanel = new JPanel();
		CustomerShoppingPanel.setBounds(0, 0, 450, 300);
		//contentPane.add(CustomerRegistrationPanel);
		CustomerShoppingPanel.setLayout(null);
		CustomerShoppingPanel.setVisible(false);
		
		final JPanel CustomerTransactionPanel = new JPanel();
		CustomerTransactionPanel.setBounds(0, 0, 450, 300);
		//contentPane.add(CustomerRegistrationPanel);
		CustomerTransactionPanel.setLayout(null);
		CustomerTransactionPanel.setVisible(false);
		
		final JPanel ShoppingCartPanel = new JPanel();
		ShoppingCartPanel.setBounds(0, 0, 868, 514);
		//contentPane.add(CustomerRegistrationPanel);
		ShoppingCartPanel.setLayout(null);
		ShoppingCartPanel.setVisible(false);
		
		final JPanel ManagerSalesReportPanel = new JPanel();
		ManagerSalesReportPanel.setBounds(0, 0, 450, 300);
		//contentPane.add(ManagerSalesReportPanel);
		ManagerSalesReportPanel.setLayout(null);
		ManagerSalesReportPanel.setVisible(false);
		
		final JPanel ManagerSalesReportResultPanel = new JPanel();
		ManagerSalesReportResultPanel.setBounds(0, 0, 450, 300);
		//contentPane.add(ManagerSalesReportResultPanel);
		ManagerSalesReportResultPanel.setLayout(new BorderLayout());
		ManagerSalesReportResultPanel.setVisible(false);
		
		final JPanel ManagerTopSellingItemPanel = new JPanel();
		ManagerTopSellingItemPanel.setBounds(0, 0, 450, 300);
		//contentPane.add(ManagerTopSellingItemPanel);
		ManagerTopSellingItemPanel.setLayout(null);
		ManagerTopSellingItemPanel.setVisible(false);

		final JPanel ManagerTopSellingItemResultPanel = new JPanel();
		ManagerTopSellingItemResultPanel.setBounds(0, 0, 450, 300);
		//contentPane.add(ManagerTopSellingItemPanel);
		ManagerTopSellingItemResultPanel.setLayout(new BorderLayout());
		ManagerTopSellingItemResultPanel.setVisible(false);
		
		final JPanel CustomerSearchResultPanel = new JPanel();
		CustomerSearchResultPanel.setBounds(0, 0, 450, 300);
		//contentPane.add(CustomerSearchResultPanel);
		CustomerSearchResultPanel.setLayout(null);
		CustomerSearchResultPanel.setVisible(false);
		
		final JPanel ManagerProcessDeliveryPanel = new JPanel();
		ManagerProcessDeliveryPanel.setBounds(0, 0, 450, 300);
		//contentPane.add(ManagerProcessDeliveryPanel);
		ManagerProcessDeliveryPanel.setLayout(null);
		ManagerProcessDeliveryPanel.setVisible(false);
		
		final JPanel SalesReportResultTablePanel = new JPanel();
		SalesReportResultTablePanel.setBounds(0, 0, 450, 300);
		SalesReportResultTablePanel.setLayout(null);
		SalesReportResultTablePanel.setVisible(false);
		
		/**
		 * UI IMPLEMENTATION ON THE BOTTOM
		 */
		//UI For Main Screen
		JButton btnClerk = new JButton("Clerk");
		btnClerk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(ClerkReturnPanel);
				ClerkReturnPanel.setVisible(true);
				MainScreen.setVisible(false);
			}
		});
		btnClerk.setBounds(21, 106, 89, 23);
		MainScreen.add(btnClerk);

		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(CustomerLoginPanel);
				CustomerLoginPanel.setVisible(true);
				MainScreen.setVisible(false);
			}
		});
		btnCustomer.setBounds(150, 106, 125, 23);
		MainScreen.add(btnCustomer);
		
		JButton btnManager = new JButton("Manager");
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(ManagerMainPanel);
				ManagerMainPanel.setVisible(true);
				MainScreen.setVisible(false);

			}
		});
		btnManager.setBounds(322, 106, 89, 23);
		MainScreen.add(btnManager);
		
		//UI For ClerkReturnPanel
		JLabel receiptIDLabel = new JLabel("Receipt ID: ");
		receiptIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiptIDLabel.setBounds(0, 39, 86, 20);
		ClerkReturnPanel.add(receiptIDLabel);
		
		txtReceiptId = new JTextField();
		//txtReceiptId.setText("Receipt ID");
		txtReceiptId.setBounds(80, 39, 86, 20);
		ClerkReturnPanel.add(txtReceiptId);
		txtReceiptId.setColumns(10);
		
		JLabel UPCLabel = new JLabel("UPC: ");
		UPCLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UPCLabel.setBounds(0, 98, 86, 20);
		ClerkReturnPanel.add(UPCLabel);
		
		txtUpc = new JTextField();
		//txtUpc.setText("UPC");
		txtUpc.setColumns(10);
		txtUpc.setBounds(80, 98, 86, 20);
		ClerkReturnPanel.add(txtUpc);
		
		JLabel QtyLabel = new JLabel("Qty: ");
		QtyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		QtyLabel.setBounds(0, 157, 86, 20);
		ClerkReturnPanel.add(QtyLabel);
		
		txtQty = new JTextField();
		//txtQty.setText("Qty");
		txtQty.setColumns(10);
		txtQty.setBounds(80, 157, 86, 20);
		ClerkReturnPanel.add(txtQty);
		
		//final JTextPane textPaneCheck = new JTextPane();
		//textPaneCheck.setBounds(64, 202, 400, 20);
		//ClerkReturnPanel.add(textPaneCheck);
		
		JButton btnCheck = new JButton("Return");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Modify to get database info
				String receiptid=txtReceiptId.getText();
				String UPC=txtUpc.getText();
				String Qty=txtQty.getText();
				int returnid=0;
				if(receiptid.equals("") || UPC.equals("")|| Qty.equals(""))
				{
					JOptionPane.showMessageDialog(ClerkReturnPanel, "Please Enter in All Fields");
				}
				else
				{
					try{
						int receiptidint=Integer.parseInt(receiptid);
						int UPCint=Integer.parseInt(UPC);
						int Qtyint=Integer.parseInt(Qty);
						if (receiptidint<=0 || UPCint<=0 || Qtyint<=0)
						{
							JOptionPane.showMessageDialog(ClerkReturnPanel, "Please Enter Positive Integer for All Fields");
						}
						else
						{
							int test=Functions.checkReceiptIDReturn(receiptidint);
							if (test==0)
							{
								JOptionPane.showMessageDialog(ClerkReturnPanel, "ReceiptID Does Not Exist");
							
							}
							else if (test==1)
							{
								int test1=Functions.checkUPCReturn(UPCint, receiptidint);
								if (test1==0)
								{
									JOptionPane.showMessageDialog(ClerkReturnPanel, "UPC Does Not Exist with Corresponding ReceiptID");
									
								}
								else if (test1==1)
								{
									int test2=Functions.checkqtyReturn(UPCint, receiptidint, Qtyint);
									if (test2==0)
									{
										JOptionPane.showMessageDialog(ClerkReturnPanel, "Enter Smaller Quantity to Return, Or Items Have Been Returned Before");
									
									}
									else if (test2==1)
									{
										int test3=Functions.checkDateRangeReturn(receiptidint);
										if (test3==0)
										{
											JOptionPane.showMessageDialog(ClerkReturnPanel, "It has been over 15 days, cannot return item");
										}
										else if (test3==1)
										{
											returnid=Functions.createReturn(receiptidint);
											Functions.createReturnItem(returnid, UPCint, Qtyint);
											Functions.managerAddItems(UPCint, Qtyint);
											Functions.decrementQuantityPurchaseItem(receiptidint, Qtyint, UPCint);
											JOptionPane.showMessageDialog(ClerkReturnPanel, "Your Credit Card has been Refunded");
										}
									}
								}
							}
						}
							
					}catch(NumberFormatException se)
					{
						JOptionPane.showMessageDialog(ClerkReturnPanel, "Please Enter Positive Integer for All Fields");
	
					}
				}
		}});
		btnCheck.setBounds(252, 97, 89, 23);
		ClerkReturnPanel.add(btnCheck);
		
		btnBackClerk = new JButton("Back");
		btnBackClerk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClerkReturnPanel.setVisible(false);
				MainScreen.setVisible(true);
			}
		});
		btnBackClerk.setBounds(25, 277, 89, 23);
		ClerkReturnPanel.add(btnBackClerk);
		
		//UI For ManagerMainPanel
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(ManagerAddItemPane);
				ManagerAddItemPane.setVisible(true);
				ManagerMainPanel.setVisible(false);
			}
		});
		btnAddItem.setBounds(64, 71, 128, 23);
		ManagerMainPanel.add(btnAddItem);
		
		JButton btnSalesReport = new JButton("Sales Report");
		btnSalesReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(ManagerSalesReportPanel);
				ManagerSalesReportPanel.setVisible(true);
				ManagerMainPanel.setVisible(false);
			}
		});
		btnSalesReport.setBounds(64, 165, 128, 23);
		ManagerMainPanel.add(btnSalesReport);
		
		JButton btnTopSellingItem = new JButton("Top Selling Item");
		btnTopSellingItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(ManagerTopSellingItemPanel);
				ManagerTopSellingItemPanel.setVisible(true);
				ManagerMainPanel.setVisible(false);
			}
		});
		btnTopSellingItem.setBounds(215, 165, 138, 23);
		ManagerMainPanel.add(btnTopSellingItem);
		
		JButton btnProcessDelivery = new JButton("Process Delivery");
		btnProcessDelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(ManagerProcessDeliveryPanel);
				ManagerProcessDeliveryPanel.setVisible(true);
				ManagerMainPanel.setVisible(false);
			}
		});
		btnProcessDelivery.setBounds(215, 71, 138, 23);
		ManagerMainPanel.add(btnProcessDelivery);
		//ManagerMainPanel.setVisible(false);
		
		btnBackManager = new JButton("Back");
		btnBackManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagerMainPanel.setVisible(false);
				MainScreen.setVisible(true);
			}
		});
		btnBackManager.setBounds(25, 277, 89, 23);
		ManagerMainPanel.add(btnBackManager);
		
		//Manager Add Item Pane UI Component
		txtEnterUpc = new JTextField();
		txtEnterUpc.setText("Enter UPC:");
		txtEnterUpc.setBounds(64, 31, 86, 20);
		ManagerAddItemPane.add(txtEnterUpc);
		
		JLabel upcLabel = new JLabel("UPC: ");
		upcLabel.setHorizontalAlignment(SwingConstants.CENTER);
		upcLabel.setBounds(5, 31, 86, 20);
		ManagerAddItemPane.add(upcLabel);
		
		txtEnterQty = new JTextField();
		txtEnterQty.setText("Enter Qty:");
		txtEnterQty.setColumns(10);
		txtEnterQty.setBounds(64, 83, 86, 20);
		ManagerAddItemPane.add(txtEnterQty);
		
		JLabel qtyLabel = new JLabel("Qty: ");
		qtyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		qtyLabel.setBounds(5, 83, 86, 20);
		ManagerAddItemPane.add(qtyLabel);
		
		txtEnterPrice = new JTextField();
		txtEnterPrice.setText("Enter Price ($):");
		txtEnterPrice.setColumns(10);
		txtEnterPrice.setBounds(64, 143, 86, 20);
		ManagerAddItemPane.add(txtEnterPrice);
		
		JLabel priceLabel = new JLabel("Price: ");
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setBounds(5, 143, 76, 20);
		ManagerAddItemPane.add(priceLabel);
		
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String UPCVal = txtEnterUpc.getText();
				
					String QtyVal = txtEnterQty.getText();
					int UPCValInt=Integer.parseInt(UPCVal);
					int QtyValInt=Integer.parseInt(QtyVal);
					if (QtyValInt<1)
					{
						JOptionPane.showMessageDialog(ManagerAddItemPane, "Please Enter Positive Quantity");
						return;
					}
					String PriceVal = txtEnterPrice.getText();
					double PriceValD=Double.parseDouble(PriceVal);
					if (PriceValD>0)
					{
						int test=Functions.managerAddItems(UPCValInt, QtyValInt, PriceValD);
						if (test==0)
						{
							JOptionPane.showMessageDialog(ManagerAddItemPane, "UPC not in System");
						}
						else
						{
							JOptionPane.showMessageDialog(ManagerAddItemPane, "Succesfully Added!");
						}
					}
					else
					{
						int test=Functions.managerAddItems(UPCValInt, QtyValInt);
						if (test==0)
						{
							JOptionPane.showMessageDialog(ManagerAddItemPane, "UPC not in System");
						}
						else
						{
							JOptionPane.showMessageDialog(ManagerAddItemPane, "Succesfully Added!");
						}
					
					}
					

				}catch(NumberFormatException se)
				{
					JOptionPane.showMessageDialog(ManagerAddItemPane, "Please Enter a Positive integer for UPC, Positive integer for Quantity, and decimal for Price");
					
				}
				
				//DecimalFormat df = new DecimalFormat("0.00");
				//df.setMaximumFractionDigits(2);
				
				//String price = df.format(PriceVal);
				//Store these 3 UPCVal, QtyVal, and price into the database.
			}
		});
		btnApply.setBounds(252, 82, 89, 23);
		ManagerAddItemPane.add(btnApply);
		
		btnBackAddItem = new JButton("Back");
		btnBackAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagerAddItemPane.setVisible(false);
				ManagerMainPanel.setVisible(true);
			}
		});
		btnBackAddItem.setBounds(25, 277, 89, 23);
		ManagerAddItemPane.add(btnBackAddItem);

		//Sherlock's Customer Login Implementation UI
		textField = new JTextField();
		textField.setBounds(194, 84, 108, 20);
		CustomerLoginPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblCid = new JLabel("CID :");
		lblCid.setHorizontalAlignment(SwingConstants.CENTER);
		lblCid.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCid.setBounds(117, 87, 46, 14);
		CustomerLoginPanel.add(lblCid);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(194, 125, 108, 20);
		CustomerLoginPanel.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(117, 125, 80, 14);
		CustomerLoginPanel.add(lblPassword);
		
		JButton btnLogin = new JButton("Log-In");
		btnLogin.setBounds(262, 176, 89, 23);
		// -------------------------- NEED TO CHECK FOR LOGIN CREDENTIAL ------------------------------
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cid=textField.getText();
                char[] password=passwordField.getPassword();
                String passwordString=new String(password);
                if (cid.equals("") || passwordString.equals(""))
                {
                    JOptionPane.showMessageDialog(CustomerLoginPanel, "Please Enter in All Fields");
                }
                else
                {
                    int test=Functions.checkCredentials(cid, passwordString);
                    if (test==0)
                    {
                        JOptionPane.showMessageDialog(CustomerLoginPanel, "Incorrect Credentials, Please Click Register or Try Again");
                    }
                    else if (test==1)
                    {
                        Functions.customerLogin=cid;
                    	contentPane.add(CustomerShoppingPanel);
                        CustomerShoppingPanel.setVisible(true);
                        CustomerLoginPanel.setVisible(false);
                        MainScreen.setVisible(false);
                    }
 
                }
			}
		});
		CustomerLoginPanel.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(CustomerRegistrationPanel);
				CustomerRegistrationPanel.setVisible(true);
				CustomerLoginPanel.setVisible(false);
				MainScreen.setVisible(false);
			}
		});
		btnRegister.setBounds(119, 176, 89, 23);
		CustomerLoginPanel.add(btnRegister);
		
		btnBackLogin = new JButton("Back");
		btnBackLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerLoginPanel.setVisible(false);
				MainScreen.setVisible(true);
			}
		});
		btnBackLogin.setBounds(25, 277, 89, 23);
		CustomerLoginPanel.add(btnBackLogin);
		
		//Customer Registration UI
		textFieldRegistration = new JTextField();
		textFieldRegistration.setBounds(174, 47, 149, 20);
		CustomerRegistrationPanel.add(textFieldRegistration);
		textFieldRegistration.setColumns(10);
		
		JLabel lblCid1 = new JLabel("CID :");
		lblCid1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCid1.setBounds(93, 50, 71, 14);
		CustomerRegistrationPanel.add(lblCid1);
		
		JLabel lblPassword1 = new JLabel("Password :");
		lblPassword1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword1.setBounds(93, 81, 71, 14);
		CustomerRegistrationPanel.add(lblPassword1);
		
		passwordFieldRegistration = new JPasswordField();
		passwordFieldRegistration.setBounds(174, 78, 149, 17);
		CustomerRegistrationPanel.add(passwordFieldRegistration);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(93, 117, 71, 14);
		CustomerRegistrationPanel.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(174, 114, 149, 20);
		CustomerRegistrationPanel.add(textField_1);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setBounds(93, 156, 71, 14);
		CustomerRegistrationPanel.add(lblAddress);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(174,156,149,40);
		CustomerRegistrationPanel.add(textField_2);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setBounds(93, 200, 71, 14);
		CustomerRegistrationPanel.add(lblPhone);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(174, 200, 149, 20);
		CustomerRegistrationPanel.add(textField_3);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(263, 235, 89, 23);
		CustomerRegistrationPanel.add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String cid = textFieldRegistration.getText();
				char[] password=passwordFieldRegistration.getPassword();
				String passwordString=new String(password);
				String name=textField_1.getText();
				String address=textField_2.getText();
				String phone=textField_3.getText();
				if(cid.equals("") || passwordString.equals("")|| name.equals("")||address.equals("")||phone.equals(""))
				{
					JOptionPane.showMessageDialog(CustomerRegistrationPanel, "Please Enter in All Fields");
				}
				else
				{
					int test=Functions.checkUsername(cid);
					if (test==1)
					{
						Functions.customerReg(name, cid, passwordString, address, phone);
						JOptionPane.showMessageDialog(CustomerRegistrationPanel, "Registered, Please Click Back Button To Go To Login Screen");
						return;
					}
					else if (test==0)
					{
						JOptionPane.showMessageDialog(CustomerRegistrationPanel, "Username Already Taken, Use Another");
						return;
					}
				}
			}
		});
		
		btnBackRegistration = new JButton("Back");
		btnBackRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerRegistrationPanel.setVisible(false);
				CustomerLoginPanel.setVisible(true);
			}
		});
		btnBackRegistration.setBounds(25, 277, 89, 23);
		CustomerRegistrationPanel.add(btnBackRegistration);
		
		//Customer Transaction UI Implementation
		JLabel label = new JLabel("Credit Card # :");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(25, 84, 107, 14);
		CustomerTransactionPanel.add(label);
		
		textFieldShopping = new JTextField();
		textFieldShopping.setColumns(10);
		textFieldShopping.setBounds(142, 81, 253, 20);
		CustomerTransactionPanel.add(textFieldShopping);
		
		JLabel label_1 = new JLabel("Expiry Date :");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(43, 134, 75, 14);
		CustomerTransactionPanel.add(label_1);
		
		textFieldShopping1 = new JTextField();
		textFieldShopping1.setColumns(10);
		textFieldShopping1.setBounds(142, 131, 86, 20);
		CustomerTransactionPanel.add(textFieldShopping1);
		
		textFieldShopping2 = new JTextField();
		textFieldShopping2.setColumns(10);
		textFieldShopping2.setBounds(261, 131, 86, 20);
		CustomerTransactionPanel.add(textFieldShopping2);
		
		JLabel label_2 = new JLabel("MM");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(152, 152, 68, 14);
		CustomerTransactionPanel.add(label_2);
		
		JLabel label_3 = new JLabel("YY");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(271, 152, 68, 14);
		CustomerTransactionPanel.add(label_3);
		
		JButton buttonSubmit = new JButton("Submit");
		buttonSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DecimalFormat df = new DecimalFormat("#.00");
				String creditcard=textFieldShopping.getText();
				String mm=textFieldShopping1.getText();
				String yy=textFieldShopping2.getText();
				int receipt=0;
				if (creditcard.equals("") || mm.equals("") || yy.equals(""))
				{
					JOptionPane.showMessageDialog(CustomerTransactionPanel, "Please Enter All Fields");
				}
				else
				{
					String mmyy=mm+"/"+yy;
					receipt=Functions.createOrder(Functions.customerLogin, creditcard, mmyy);
					for (int i=0; i<Functions.shoppingcart.size();i++)
					{
						Functions.addPurchaseItem(receipt, Functions.shoppingcart.get(i).getUpc(), Functions.shoppingcart.get(i).getQuantitySold());
						Functions.decrementItemQuantity(Functions.shoppingcart.get(i));
					}
					System.out.println(Functions.totalprice);
					System.out.println(df.format(Functions.totalprice));
					JOptionPane.showMessageDialog(CustomerTransactionPanel, "You were charged "+df.format(Functions.totalprice)+". Your Receipt# is "+receipt+". Expected delivery date is "+Functions.getExpectedDate(receipt));
					Functions.customerLogin=null;
					Functions.totalprice=0;
					Functions.shoppingcart.clear();
				}
				
			}
		});
		buttonSubmit.setBounds(306, 198, 89, 23);
		CustomerTransactionPanel.add(buttonSubmit);
		
		btnBackTransaction = new JButton("Back");
		btnBackTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerTransactionPanel.setVisible(false);
				CustomerShoppingPanel.setVisible(true);
			}
		});
		btnBackTransaction.setBounds(25, 277, 89, 23);
		CustomerTransactionPanel.add(btnBackTransaction);
		
		//Customer Shopping UI Implementation
		txtShopping = new JTextField();
		txtShopping.setColumns(10);
		txtShopping.setBounds(141, 88, 240, 20);
		CustomerShoppingPanel.add(txtShopping);
		
		JLabel labelShopping_Category = new JLabel("Category :");
		labelShopping_Category.setHorizontalAlignment(SwingConstants.CENTER);
		labelShopping_Category.setBounds(63, 91, 68, 14);
		CustomerShoppingPanel.add(labelShopping_Category);
		
		txtShopping_1 = new JTextField();
		txtShopping_1.setColumns(10);
		txtShopping_1.setBounds(141, 119, 240, 20);
		CustomerShoppingPanel.add(txtShopping_1);
		
		txtShopping_2 = new JTextField();
		txtShopping_2.setColumns(10);
		txtShopping_2.setBounds(141, 150, 240, 20);
		CustomerShoppingPanel.add(txtShopping_2);
		
		JLabel labelShopping_Title = new JLabel("Title :");
		labelShopping_Title.setHorizontalAlignment(SwingConstants.CENTER);
		labelShopping_Title.setBounds(63, 122, 68, 14);
		CustomerShoppingPanel.add(labelShopping_Title);
		
		JLabel labelShopping_LeadSinger = new JLabel("Lead Singer :");
		labelShopping_LeadSinger.setHorizontalAlignment(SwingConstants.CENTER);
		labelShopping_LeadSinger.setBounds(63, 153, 68, 14);
		CustomerShoppingPanel.add(labelShopping_LeadSinger);
		
		//JTextArea textArea = new JTextArea();
		//textArea.setBounds(108, 181, 23, 22);
		//CustomerShoppingPanel.add(textArea);
		
		//Shopping Cart UI Implementation
		final JTextArea textArea1 = new JTextArea();
		textArea1.setBounds(10, 37, 430, 223);
		ShoppingCartPanel.add(textArea1);
		
		final JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(310, 271, 130, 22);
		ShoppingCartPanel.add(textArea_2);
		
		JButton buttonCart = new JButton("Cart");
		buttonCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DecimalFormat df = new DecimalFormat("#.00");
				if (Functions.shoppingcart.size()==0)
				{
					JOptionPane.showMessageDialog(CustomerShoppingPanel, "Shopping Cart Empty");
				}
				else
				{
					Functions.totalprice=0;
					textArea1.setText("");
					textArea1.append("upc\ttitle\t\tprice\tqty\n");
					for (int i=0;i<Functions.shoppingcart.size();i++)
					{
						textArea1.append(Functions.shoppingcart.get(i).getUpc()+"\t"+Functions.shoppingcart.get(i).getTitle()+"\t\t"+Functions.shoppingcart.get(i).getPrice()+"\t"+Functions.shoppingcart.get(i).getQuantitySold()+"\n");
						Functions.totalprice=Functions.totalprice+((Functions.shoppingcart.get(i).getPrice())*(Functions.shoppingcart.get(i).getQuantitySold()));
					}
					textArea_2.setText(df.format(Functions.totalprice));
					contentPane.add(ShoppingCartPanel);
					ShoppingCartPanel.setVisible(true);
					CustomerShoppingPanel.setVisible(false);
				}

	
			}
		});
		buttonCart.setBounds(130, 181, 68, 23);
		CustomerShoppingPanel.add(buttonCart);
		
		//Customer Search Result Implementation
		final JTextArea searchResultTxtArea = new JTextArea();
		searchResultTxtArea.setBounds(5, 5, 430, 250);
		CustomerSearchResultPanel.add(searchResultTxtArea);
		
		txtEnterUpcShopping = new JTextField();
		txtEnterUpcShopping.setText("Enter UPC:");
		txtEnterUpcShopping.setBounds(135, 266, 86, 20);
		CustomerSearchResultPanel.add(txtEnterUpcShopping);
		
		txtEnterQtyShopping = new JTextField();
		txtEnterQtyShopping.setText("Enter QTY:");
		txtEnterQtyShopping.setBounds(225, 266, 86, 20);
		CustomerSearchResultPanel.add(txtEnterQtyShopping);
		
		
		JButton buttonSearch = new JButton("Search");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchResultTxtArea.setText(null);
				String category=txtShopping.getText();
				String title=txtShopping_1.getText();
				String leadsinger=txtShopping_2.getText();
				if (category.equals("") && title.equals("") && leadsinger.equals(""))
				{
					JOptionPane.showMessageDialog(CustomerShoppingPanel, "Please Enter One Field, or All Fields");
				}
				else
				{
					if (!category.equals("") && title.equals("") && leadsinger.equals(""))
					{
						List<Item> results=Functions.getSearchResultsCategory(category);
						if (results.size()==0)
						{
							JOptionPane.showMessageDialog(CustomerShoppingPanel, "No Items Match This Category");
						}
						else
						{
							searchResultTxtArea.append("upc\ttitle\t\tprice\tstock\n");
							for (int i=0; i<results.size();i++)
							{
								searchResultTxtArea.append(results.get(i).getUpc()+"\t"+results.get(i).getTitle()+"\t\t"+results.get(i).getPrice()+"\t"+results.get(i).getStock()+"\n");
							}
							contentPane.add(CustomerSearchResultPanel);
							CustomerSearchResultPanel.setVisible(true);
							CustomerShoppingPanel.setVisible(false);
						}
					}
					else if (category.equals("") && !title.equals("") && leadsinger.equals(""))
					{
						List<Item> results=Functions.getSearchResultsTitle(title);
						if (results.size()==0)
						{
							JOptionPane.showMessageDialog(CustomerShoppingPanel, "No Items Match This Title");
						}
						else
						{
							searchResultTxtArea.append("upc\ttitle\t\tprice\tstock\n");
							for (int i=0; i<results.size();i++)
							{
								searchResultTxtArea.append(results.get(i).getUpc()+"\t"+results.get(i).getTitle()+"\t\t"+results.get(i).getPrice()+"\t"+results.get(i).getStock()+"\n");
							}
							contentPane.add(CustomerSearchResultPanel);
							CustomerSearchResultPanel.setVisible(true);
							CustomerShoppingPanel.setVisible(false);
						}
					}
					else if (category.equals("") && title.equals("") && !leadsinger.equals(""))
					{
						List<Item> results=Functions.getSearchResultsLeadSinger(leadsinger);
						if (results.size()==0)
						{
							JOptionPane.showMessageDialog(CustomerShoppingPanel, "No Items Match This Singer");
						}
						else
						{
							searchResultTxtArea.append("upc\ttitle\t\tprice\tstock\n");
							for (int i=0; i<results.size();i++)
							{
								searchResultTxtArea.append(results.get(i).getUpc()+"\t"+results.get(i).getTitle()+"\t\t"+results.get(i).getPrice()+"\t"+results.get(i).getStock()+"\n");
							}
							contentPane.add(CustomerSearchResultPanel);
							CustomerSearchResultPanel.setVisible(true);
							CustomerShoppingPanel.setVisible(false);
						}
					}
					else if (!category.equals("") && !title.equals("") && !leadsinger.equals(""))
					{
						List<Item> results=Functions.getSearchResultsAllFields(category, title, leadsinger);
						if (results.size()==0)
						{
							JOptionPane.showMessageDialog(CustomerShoppingPanel, "No Items Match These Fields");
						}
						else
						{
							searchResultTxtArea.append("upc\ttitle\t\tprice\tstock\n");
							for (int i=0; i<results.size();i++)
							{
								searchResultTxtArea.append(results.get(i).getUpc()+"\t"+results.get(i).getTitle()+"\t\t"+results.get(i).getPrice()+"\t"+results.get(i).getStock()+"\n");
							}
							contentPane.add(CustomerSearchResultPanel);
							CustomerSearchResultPanel.setVisible(true);
							CustomerShoppingPanel.setVisible(false);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(CustomerShoppingPanel, "Please Enter One Field, or All Fields");
					}
				}

			}
		});
		buttonSearch.setBounds(292, 181, 89, 23);
		CustomerShoppingPanel.add(buttonSearch);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String upc=txtEnterUpcShopping.getText();
				String qty=txtEnterQtyShopping.getText();
				int upcInt=-1;
				int qtyInt=-1;
				try{
					 upcInt=Integer.parseInt(upc);
					 qtyInt=Integer.parseInt(qty);
					 if (upcInt<=0 || qtyInt<=0)
					 {
						 JOptionPane.showMessageDialog(CustomerSearchResultPanel, "Please Enter Positive Integer for UPC and Quantity");
					 }
					 else
					 {
						 int test=Functions.checkStock(upcInt, qtyInt);
						 if (test==1)
						 {
							 Item objectoAdd=Functions.getItem(upcInt,qtyInt);
							 if (objectoAdd==null)
							 {
								 JOptionPane.showMessageDialog(CustomerSearchResultPanel, "UPC not in database");
							 }
							 else
							 {
								 Functions.shoppingcart.add(objectoAdd);
								 JOptionPane.showMessageDialog(CustomerSearchResultPanel, "Item added to Cart");
							 }
						 }
						 else if (test==0)
						 {
							 JOptionPane.showMessageDialog(CustomerSearchResultPanel, "Please Enter Smaller Quantity, Stock not Sufficient to Fit Needs"); 
						 }
					 }
				}catch(NumberFormatException se)
				{
					JOptionPane.showMessageDialog(CustomerSearchResultPanel, "Please Enter Positive Integer for UPC and Quantity");
					
				}
			}
		});
		btnNewButton.setBounds(335, 266, 89, 23);
		CustomerSearchResultPanel.add(btnNewButton);
		
		/*JButton buttonCheckOut = new JButton("Check Out");
		buttonCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Functions.shoppingcart.size()==0)
				{
					JOptionPane.showMessageDialog(CustomerShoppingPanel, "Cart is Empty, Cannot Checkout");
				}
				else
				{
					contentPane.add(CustomerTransactionPanel);
					CustomerTransactionPanel.setVisible(true);
					CustomerShoppingPanel.setVisible(false);
				}

			}
		});
		buttonCheckOut.setBounds(165, 181, 115, 23);
		CustomerShoppingPanel.add(buttonCheckOut);*/
		
		btnBackShopping = new JButton("Back");
		btnBackShopping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerShoppingPanel.setVisible(false);
				CustomerLoginPanel.setVisible(true);
			}
		});
		btnBackShopping.setBounds(25, 277, 89, 23);
		CustomerShoppingPanel.add(btnBackShopping);
		
		
		
		JLabel lblShoppingCartList = new JLabel("Shopping Cart List");
		lblShoppingCartList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShoppingCartList.setBounds(10, 12, 217, 22);
		ShoppingCartPanel.add(lblShoppingCartList);
		

		
		JLabel lblTotal = new JLabel("Total :");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setBounds(254, 276, 46, 14);
		ShoppingCartPanel.add(lblTotal);
		
		JButton btnCheckOut2 = new JButton("Check Out");
		btnCheckOut2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(CustomerTransactionPanel);
				CustomerTransactionPanel.setVisible(true);
				ShoppingCartPanel.setVisible(false);
			}
		});
		btnCheckOut2.setBounds(130, 271, 115, 23);
		ShoppingCartPanel.add(btnCheckOut2);
		
		btnBackShoppingCart = new JButton("Back");
		btnBackShoppingCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShoppingCartPanel.setVisible(false);
				CustomerShoppingPanel.setVisible(true);
			}
		});
		btnBackShoppingCart.setBounds(25, 271, 89, 23);
		ShoppingCartPanel.add(btnBackShoppingCart);
		
		//Manager Sales Report UI Implementation
		JLabel lblNewLabel = new JLabel("Sales Report");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(35, 23, 130, 53);
		ManagerSalesReportPanel.add(lblNewLabel);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(129, 142, 100, 14);
		ManagerSalesReportPanel.add(lblDate);
		
		txtFieldSalesReport = new JTextField();
		txtFieldSalesReport.setBounds(168, 139, 149, 20);
		ManagerSalesReportPanel.add(txtFieldSalesReport);
		txtFieldSalesReport.setColumns(10);
		txtFieldSalesReport.setText("\"YYYY-MM-DD\"");
		JButton btnSubmit1 = new JButton("Submit");
		btnSubmit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createSalesResultTable(ManagerSalesReportPanel, ManagerSalesReportResultPanel);

			}
		});
		btnSubmit1.setBounds(297, 214, 89, 23);
		ManagerSalesReportPanel.add(btnSubmit1);
		
		btnBackSalesReport = new JButton("Back");
		btnBackSalesReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagerSalesReportPanel.setVisible(false);
				ManagerMainPanel.setVisible(true);
			}
		});
		btnBackSalesReport.setBounds(25, 277, 89, 23);
		ManagerSalesReportPanel.add(btnBackSalesReport);
	
		
		
		//Manager Sales Report Result UI Implementation
		//JTextArea ReportResultsTextArea = new JTextArea();
		//ReportResultsTextArea.setBounds(10, 50, 430, 239);
		//ManagerSalesReportResultPanel.add(ReportResultsTextArea);
		
		//JLabel lblSalesReportResults = new JLabel("Sales Report Results");
		//lblSalesReportResults.setFont(new Font("Tahoma", Font.PLAIN, 16));
		//lblSalesReportResults.setBounds(10, 11, 185, 28);
		//ManagerSalesReportResultPanel.add(lblSalesReportResults);
		
		//Manager Top Selling Item UI Implementation
		JLabel lblDate1 = new JLabel("Date:");
		lblDate1.setBounds(132, 105, 46, 14);
		ManagerTopSellingItemPanel.add(lblDate1);
		
		TopSellingItemDate = new JTextField();
		TopSellingItemDate.setBounds(166, 102, 153, 20);
		ManagerTopSellingItemPanel.add(TopSellingItemDate);
		TopSellingItemDate.setColumns(10);
		TopSellingItemDate.setText("\"YYYY-MM-DD\"");
		
		JLabel lblTopItem = new JLabel("Top # item sold:");
		lblTopItem.setBounds(121, 151, 97, 14);
		ManagerTopSellingItemPanel.add(lblTopItem);
		
		TopSellingItemItemsSold = new JTextField();
		TopSellingItemItemsSold.setBounds(211, 148, 108, 20);
		ManagerTopSellingItemPanel.add(TopSellingItemItemsSold);
		TopSellingItemItemsSold.setColumns(10);
		
		JButton btnTopSellingItemsSubmit = new JButton("Submit");
		btnTopSellingItemsSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				createTopSellingItemTable(ManagerTopSellingItemPanel, ManagerTopSellingItemResultPanel);
					 
					 //String header1=String.format("%20s%20s%20s%20s\n", "title","company","stock","sold");
					//TopSellingItemResultsTextArea.append(header1);
					/*for (int i=0;i<TopSellingItemItemsSoldInt;i++)
					{
						String body=String.format("%20s%20s%20s%20s\n",solution.get(i).getTitle(),solution.get(i).getCompany(),solution.get(i).getStock(),solution.get(i).getQuantitySold());
						System.out.println(body);
						TopSellingItemResultsTextArea.append(body);
					}*/
				// System.out.println(TopSellingItemItemsSoldInt);
				 //String header="title\t\tcompany\t\tstock\t\tcopies sold\n";
				 //String header1=String.format("%-30s%-30s%-30s%s\n", "title","company","stock","sold");
				 //System.out.print(header1);

				 }
			
		});
		btnTopSellingItemsSubmit.setBounds(273, 207, 89, 23);
		ManagerTopSellingItemPanel.add(btnTopSellingItemsSubmit);
		
		btnBackTopSellingItem = new JButton("Back");
		btnBackTopSellingItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagerTopSellingItemPanel.setVisible(false);
				ManagerMainPanel.setVisible(true);
			}
		});
		btnBackTopSellingItem.setBounds(25, 277, 89, 23);
		ManagerTopSellingItemPanel.add(btnBackTopSellingItem);
		
		btnBackTopSellingItemResult = new JButton("Back");
		btnBackTopSellingItemResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagerTopSellingItemResultPanel.setVisible(false);
				ManagerTopSellingItemPanel.setVisible(true);
			}
		});
		btnBackTopSellingItemResult.setBounds(25, 277, 89, 23);
		ManagerTopSellingItemResultPanel.add(btnBackTopSellingItemResult);
		
		//Manager Top Selling Item Result UI Implementation
		
		//JTextArea TopSellingItemResultsTextArea = new JTextArea();
		//TopSellingItemResultsTextArea.setBounds(10, 42, 430, 247);
		//ManagerTopSellingItemResultPanel.add(TopSellingItemResultsTextArea);
		
		//JLabel label1 = new JLabel("Results");
		//label1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		//label1.setBounds(22, 11, 131, 28);
		//ManagerTopSellingItemResultPanel.add(label1);
		
	
		
		//Manager Process Delivery Implementation

		
		//JTextArea txtAreaProcessDelivery = new JTextArea();
		//txtAreaProcessDelivery.setBounds(10, 11, 430, 101);
		//ManagerProcessDeliveryPanel.add(txtAreaProcessDelivery);
		
		ProcessDeliveryNewDate = new JTextField();
		ProcessDeliveryNewDate.setBounds(151, 187, 184, 20);
		ManagerProcessDeliveryPanel.add(ProcessDeliveryNewDate);
		ProcessDeliveryNewDate.setColumns(10);
		ProcessDeliveryNewDate.setText("\"YYYY-MM-DD\"");
		
		ProcessDeliveryReceiptID = new JTextField();
		ProcessDeliveryReceiptID.setBounds(151, 149, 184, 20);
		ManagerProcessDeliveryPanel.add(ProcessDeliveryReceiptID);
		ProcessDeliveryReceiptID.setColumns(10);
		
		JLabel lblProcessDeliveryReceiptid = new JLabel("ReceiptID :");
		lblProcessDeliveryReceiptid.setHorizontalAlignment(SwingConstants.CENTER);
		lblProcessDeliveryReceiptid.setBounds(41, 152, 89, 14);
		ManagerProcessDeliveryPanel.add(lblProcessDeliveryReceiptid);
		
		JLabel lblProcessDeliveryNewDeliveryDate = new JLabel("Delivery Date :");
		lblProcessDeliveryNewDeliveryDate.setBounds(41, 190, 121, 14);
		ManagerProcessDeliveryPanel.add(lblProcessDeliveryNewDeliveryDate);
		
		btnBackProcessDelivery = new JButton("Back");
		btnBackProcessDelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagerProcessDeliveryPanel.setVisible(false);
				ManagerMainPanel.setVisible(true);
			}
		});
		btnBackProcessDelivery.setBounds(25, 277, 89, 23);
		ManagerProcessDeliveryPanel.add(btnBackProcessDelivery);
		
		btnBackCustomerSearch = new JButton("Back");
		btnBackCustomerSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerSearchResultPanel.setVisible(false);
				CustomerShoppingPanel.setVisible(true);
			}
		});
		btnBackCustomerSearch.setBounds(25, 277, 89, 23);
		CustomerSearchResultPanel.add(btnBackCustomerSearch);
		
		btnBackSalesReportResult = new JButton("Back");
		btnBackSalesReportResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagerSalesReportResultPanel.setVisible(false);
				ManagerSalesReportPanel.setVisible(true);
				ManagerSalesReportResultPanel.removeAll();
			}
		});
		btnBackSalesReportResult.setBounds(25, 277, 89, 23);
		ManagerSalesReportResultPanel.add(btnBackSalesReportResult);
		
		JButton btnSubmitProcessDelivery = new JButton("Submit");
		btnSubmitProcessDelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String date=ProcessDeliveryNewDate.getText();
				String receiptid=ProcessDeliveryReceiptID.getText();
				if (date.equals("") || receiptid.equals(""))
				{
					JOptionPane.showMessageDialog(ManagerProcessDeliveryPanel, "Please Enter All Fields");
				}
				else if (date.charAt(4)!='-' && date.charAt(7)!='-')
				 {
					 JOptionPane.showMessageDialog(ManagerProcessDeliveryPanel, "Please Enter date in Format YYYY-MM-DD");
				 }
				else
				{
					try{
						int receiptidInt=Integer.parseInt(receiptid);
						int test=Functions.managerProcessDelivery(receiptidInt, date);
						if (test==0)
						{
							JOptionPane.showMessageDialog(ManagerProcessDeliveryPanel, "ReceiptID not in Database");
						}
						else if (test==1)
						{
							JOptionPane.showMessageDialog(ManagerProcessDeliveryPanel, "Delivery Date Succesufully Updated");
						}
						

					}catch(NumberFormatException se)
					{
						JOptionPane.showMessageDialog(ManagerProcessDeliveryPanel, "Please Enter a Positive integer for ReceiptID");
						
					}
				}
				
				
			}
		});
		btnSubmitProcessDelivery.setBounds(320, 241, 89, 23);
		ManagerProcessDeliveryPanel.add(btnSubmitProcessDelivery);
		
	}
	
	public void createSalesResultTable(final JPanel ManagerSalesReportPanel, final JPanel ManagerSalesReportResultPanel)
	{
		String dateString=txtFieldSalesReport.getText();
		 
		 if (dateString.charAt(4)!='-' && dateString.charAt(7)!='-')
		 {
			 JOptionPane.showMessageDialog(ManagerSalesReportPanel, "Please Enter date in Format YYYY-MM-DD");
		 }
		 else
		 {
			 List<List<Item>> solution=Functions.managerDailyReport(dateString);
			 int size=0;
			 int numofTotal=0;
			 for (int i=0;i<7;i++)
			 {
				 size=size+solution.get(i).size();
				 if (solution.get(i).size()>0)
				 {
					 numofTotal++;
				 }
			 }
			 if(size==0)
			 {
				 JOptionPane.showMessageDialog(ManagerSalesReportPanel,"No Items Sold On This Date");
				 return;
			 }
			 else
			 {

				 System.out.println(size);
				 System.out.println(numofTotal);
				 contentPane.add(ManagerSalesReportResultPanel);
				 ManagerSalesReportResultPanel.setVisible(true);
				 ManagerSalesReportPanel.setVisible(false);
				 String[] columnNames = {"UPC",
	                        "Category",
	                        "Unit Price",
	                        "Units",
	                        "Total Value"};
				 System.out.println(size+numofTotal+2);
				 String[][] data = new String[size+numofTotal+2][5];
				 int table_index=0;
				 int totalunits=0;
				 double totalpricefinal=0;
				 for (int i=0;i<7;i++)
				 {
					 if (solution.get(i).size()>0)
					 {
						 System.out.println(solution.get(i).size());
						 int j=0;
						 int units=0;
						 double totalprice=0;
						 while (j<solution.get(i).size())
						 {
							 data[table_index][0]=solution.get(i).get(j).getUpc();
							 data[table_index][1]=solution.get(i).get(j).getCategory();
							 data[table_index][2]=Double.toString(solution.get(i).get(j).getPrice());
							 data[table_index][3]=Integer.toString(solution.get(i).get(j).getQuantitySold());
							 double tprice=(solution.get(i).get(j).getPrice())*(solution.get(i).get(j).getQuantitySold());
							 data[table_index][4]=Double.toString(tprice);
							 totalprice=totalprice+tprice;
							 units=units+(solution.get(i).get(j).getQuantitySold());
							 
							 j++;
							 table_index++;
							 
						 }
						 data[table_index][1]="Total";
						 data[table_index][3]=Integer.toString(units);
						 data[table_index][4]=Double.toString(totalprice);
						 totalunits=totalunits+units;
						 totalpricefinal=totalpricefinal+totalprice;
						 table_index++;
					 }
				 }
				 data[table_index][0]="";
				 data[table_index][1]="";
				 data[table_index][2]="";
				 data[table_index][3]="";
				 data[table_index][4]="";
				 data[table_index+1][1]="Total Sales";
				 data[table_index+1][3]=Integer.toString(totalunits);
				 data[table_index+1][4]=Double.toString(totalpricefinal);
				 tableSalesReportResult = new JTable(data,columnNames);
				 //tableSalesReportResult.setLayout(null);
				 JScrollPane tableContainer=new JScrollPane(tableSalesReportResult);
				 ManagerSalesReportResultPanel.add(tableContainer,BorderLayout.CENTER);
				 //System.out.println(data[0][0]);
			 }
		 }
	}
	
	public void createTopSellingItemTable(JPanel ManagerTopSellingItemPanel, JPanel ManagerTopSellingItemResultPanel)
	{
		int TopSellingItemItemsSoldInt=0;
		try{
			 TopSellingItemItemsSoldInt=Integer.parseInt(TopSellingItemItemsSold.getText());
		}catch(NumberFormatException se)
		{
			JOptionPane.showMessageDialog(ManagerTopSellingItemPanel, "Please Enter Positive Integer");
			
		}

		 String dateString=TopSellingItemDate.getText();
		 
		 if (dateString.charAt(4)!='-' && dateString.charAt(7)!='-')
		 {
			 JOptionPane.showMessageDialog(ManagerTopSellingItemPanel, "Please Enter date in Format YYYY-MM-DD");
		 }
		 else
		 {
			 List<Item> solution=Functions.managerTopSellingItems(dateString);
			if(TopSellingItemItemsSoldInt>solution.size())
			 {
				 JOptionPane.showMessageDialog(ManagerTopSellingItemPanel,TopSellingItemItemsSoldInt+" unique items haven't been sold today, please enter smaller quantity. Or no items have been sold on this date");
				 return;
			 }
			 contentPane.add(ManagerTopSellingItemResultPanel);
			 ManagerTopSellingItemResultPanel.setVisible(true);
			 ManagerTopSellingItemPanel.setVisible(false);
			//JTextArea TopSellingItemResultsTextArea = new JTextArea();
			//TopSellingItemResultsTextArea.setEditable(false);
			//TopSellingItemResultsTextArea.setBounds(10, 42, 430, 247);
			//ManagerTopSellingItemResultPanel.add(TopSellingItemResultsTextArea);
			 String[] columnNames = {"Title",
                        "Company",
                        "Avail Stock",
                        "Qty Sold"};
			 String[][] data = new String[TopSellingItemItemsSoldInt][4];
			 for (int i=0; i<TopSellingItemItemsSoldInt;i++)
			 {
				 data[i][0]=solution.get(i).getTitle();
			 }
			 for (int i=0; i<TopSellingItemItemsSoldInt;i++)
			 {
				 data[i][1]=solution.get(i).getCompany();
			 }
			 for (int i=0; i<TopSellingItemItemsSoldInt;i++)
			 {
				 data[i][2]=Integer.toString(solution.get(i).getStock());
			 }
			 for (int i=0; i<TopSellingItemItemsSoldInt;i++)
			 {
				 data[i][3]=Integer.toString(solution.get(i).getQuantitySold());
			 }
			 JTable table=new JTable(data,columnNames);
			 table.setBounds(5, 5, 425, 250);
			 JScrollPane tableContainer=new JScrollPane(table);
			 ManagerTopSellingItemResultPanel.add(tableContainer,BorderLayout.CENTER);
		 }
	}
}
