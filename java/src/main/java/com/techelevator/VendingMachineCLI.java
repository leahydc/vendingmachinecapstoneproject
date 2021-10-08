package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;

public class VendingMachineCLI {

	public static VendingMachine vm = new VendingMachine();


	//Main Menu Display Options
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";

	//Display Menu
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	//Feed Money Menu
	private static final String ONE_DOLLAR = "$1";
	private static final String TWO_DOLLARS = "$2";
	private static final String FIVE_DOLLARS = "$5";
	private static final String TEN_DOLLARS = "$10";

	//Item Display Menu

	private static final int POSITION_ONE = 0;
	private static final int POSITION_TWO = 1;
	private static final int POSITION_THREE = 2;
	private static final int POSITION_FOUR = 3;
	private static final int POSITION_FIVE = 4;
	private static final int POSITION_SIX = 5;
	private static final int POSITION_SEVEN = 6;
	private static final int POSITION_EIGHT = 7;
	private static final int POSITION_NINE = 8;
	private static final int POSITION_TEN = 9;
	private static final int POSITION_ELEVEN = 10;
	private static final int POSITION_TWELVE = 11;
	private static final int POSITION_THIRTEEN = 12;
	private static final int POSITION_FOURTEEN = 13;
	private static final int POSITION_FIFTEEN = 14;
	private static final int POSITION_SIXTEEN = 15;


	//Menu Screen Arrays
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,MAIN_MENU_OPTION_EXIT };
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT,PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
	private static final String[] DOLLAR_INPUT_VALUES = { ONE_DOLLAR, TWO_DOLLARS, FIVE_DOLLARS, TEN_DOLLARS};
	private static final String[] ITEM_KEYS = vm.newInventory.keySet().toArray(new String[0]);


	private Menu menu;

	private boolean runVendingMachine = true;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws NumberFormatException{
		File logFile = new File("log.txt");
		boolean loggingEnabled = true;
		Logger vmLog = null;
		try{
			vmLog = new Logger(logFile,true);
		}catch(Exception e){
			loggingEnabled = false;
		}

		String [] activeMenu =  MAIN_MENU_OPTIONS;

		while (runVendingMachine) {
			String choice = (String) menu.getChoiceFromOptions(activeMenu);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				vm.printInventory();
			}
			else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				activeMenu = PURCHASE_MENU_OPTIONS;
				vm.printBalanceInDollars();
			}
			else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
				//Close coinbox
				System.out.println("Thanks for stopping by");
				runVendingMachine = false;
			}
			else if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)){
				//Add to coin box method
				activeMenu = DOLLAR_INPUT_VALUES;
				String choiceDollar = (String) menu.getChoiceFromOptions(activeMenu);

				if (choiceDollar.equals(ONE_DOLLAR)) {
					vm.feedMoney(1);
					vm.printBalanceInDollars();
					activeMenu = PURCHASE_MENU_OPTIONS;
				}
				else if (choiceDollar.equals(TWO_DOLLARS)) {
					vm.feedMoney(2);
					vm.printBalanceInDollars();
					activeMenu = PURCHASE_MENU_OPTIONS;
				}
				else if (choiceDollar.equals(FIVE_DOLLARS)) {
					vm.feedMoney(5);
					vm.printBalanceInDollars();
					activeMenu = PURCHASE_MENU_OPTIONS;
				}
				else if (choiceDollar.equals(TEN_DOLLARS)) {
					vm.feedMoney(10);
					vm.printBalanceInDollars();
					activeMenu = PURCHASE_MENU_OPTIONS;
				}

			}
			else if(choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)){
				//Enter map key for inventory
				vm.printInventory();
				activeMenu = ITEM_KEYS;
				boolean isInputValid = true;
				String choiceItem="";
				if(menu.getChoiceFromOptions(activeMenu) == null){
					activeMenu=PURCHASE_MENU_OPTIONS;
				}else {
					choiceItem = (String) menu.getChoiceFromOptions(activeMenu);
				}
					if(choiceItem.equals(ITEM_KEYS[POSITION_ONE])) {
						if (vm.vendingCoinBox.getBalance() >= vm.newInventory.get("A1").getPrice() && vm.newInventory.get("A1").getCurrentStock()>0) {
							vm.decreaseBalance(vm.newInventory.get("A1").getPrice());
							vm.printBalanceInDollars();
							vm.newInventory.get("A1").vend();
						}else if(vm.newInventory.get("A1").getCurrentStock()<1){
							System.out.println("This item is out of stock");
						}
						else {
							System.out.println("You need to deposit more funds to make that purchase.");
						}
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if(choiceItem.equals(ITEM_KEYS[POSITION_TWO])){
						if (vm.vendingCoinBox.getBalance() >= vm.newInventory.get("A2").getPrice() && vm.newInventory.get("A2").getCurrentStock()>0) {
							vm.decreaseBalance(vm.newInventory.get("A2").getPrice());
							vm.printBalanceInDollars();
							vm.newInventory.get("A2").vend();
						}else if(vm.newInventory.get("A2").getCurrentStock()<1){
							System.out.println("This item is out of stock");
						}
						else {
							System.out.println("You need to deposit more funds to make that purchase.");
						}
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if(choiceItem.equals(ITEM_KEYS[POSITION_THREE])){
						if (vm.vendingCoinBox.getBalance() >= vm.newInventory.get("A3").getPrice() && vm.newInventory.get("A3").getCurrentStock()>0) {
							vm.decreaseBalance(vm.newInventory.get("A3").getPrice());
							vm.printBalanceInDollars();
							vm.newInventory.get("A3").vend();
						}else if(vm.newInventory.get("A3").getCurrentStock()<1){
							System.out.println("This item is out of stock");
						}
						else {
							System.out.println("You need to deposit more funds to make that purchase.");
						}
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if(choiceItem.equals(ITEM_KEYS[POSITION_FOUR])){
						if (vm.vendingCoinBox.getBalance() >= vm.newInventory.get("A4").getPrice() && vm.newInventory.get("A4").getCurrentStock()>0) {
							vm.decreaseBalance(vm.newInventory.get("A4").getPrice());
							vm.printBalanceInDollars();
							vm.newInventory.get("A4").vend();
						}else if(vm.newInventory.get("A4").getCurrentStock()<1){
							System.out.println("This item is out of stock");
						}
						else {
							System.out.println("You need to deposit more funds to make that purchase.");
						}
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if(choiceItem.equals(ITEM_KEYS[POSITION_FIVE])){
						if (vm.vendingCoinBox.getBalance() >= vm.newInventory.get("B1").getPrice() && vm.newInventory.get("B1").getCurrentStock()>0) {
							vm.decreaseBalance(vm.newInventory.get("B1").getPrice());
							vm.printBalanceInDollars();
							vm.newInventory.get("B1").vend();
						}else if(vm.newInventory.get("B1").getCurrentStock()<1){
							System.out.println("This item is out of stock");
						}
						else {
							System.out.println("You need to deposit more funds to make that purchase.");
						}
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if(choiceItem.equals(ITEM_KEYS[POSITION_SIX])){
						if (vm.vendingCoinBox.getBalance() >= vm.newInventory.get("B2").getPrice() && vm.newInventory.get("B2").getCurrentStock()>0) {
							vm.decreaseBalance(vm.newInventory.get("B2").getPrice());
							vm.printBalanceInDollars();
							vm.newInventory.get("B2").vend();
						}else if(vm.newInventory.get("B2").getCurrentStock()<1){
							System.out.println("This item is out of stock");
						}
						else {
							System.out.println("You need to deposit more funds to make that purchase.");
						}
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if(choiceItem.equals(ITEM_KEYS[POSITION_SEVEN])){
						if (vm.vendingCoinBox.getBalance() >= vm.newInventory.get("B3").getPrice() && vm.newInventory.get("B3").getCurrentStock()>0) {
							vm.decreaseBalance(vm.newInventory.get("B3").getPrice());
							vm.printBalanceInDollars();
							vm.newInventory.get("B3").vend();
						}else if(vm.newInventory.get("B3").getCurrentStock()<1){
							System.out.println("This item is out of stock");
						}
						else {
							System.out.println("You need to deposit more funds to make that purchase.");
						}
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if(choiceItem.equals(ITEM_KEYS[POSITION_EIGHT])){
						if (vm.vendingCoinBox.getBalance() >= vm.newInventory.get("B4").getPrice() && vm.newInventory.get("B4").getCurrentStock()>0) {
							vm.decreaseBalance(vm.newInventory.get("B4").getPrice());
							vm.printBalanceInDollars();
							vm.newInventory.get("B4").vend();
						}else if(vm.newInventory.get("B4").getCurrentStock()<1){
							System.out.println("This item is out of stock");
						}
						else {
							System.out.println("You need to deposit more funds to make that purchase.");
						}
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if(choiceItem.equals(ITEM_KEYS[POSITION_NINE])){
						if (vm.vendingCoinBox.getBalance() >= vm.newInventory.get("C1").getPrice() && vm.newInventory.get("C1").getCurrentStock()>0) {
							vm.decreaseBalance(vm.newInventory.get("C1").getPrice());
							vm.printBalanceInDollars();
							vm.newInventory.get("C1").vend();
						}else if(vm.newInventory.get("C1").getCurrentStock()<1){
							System.out.println("This item is out of stock");
						}
						else {
							System.out.println("You need to deposit more funds to make that purchase.");
						}
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if(choiceItem.equals(ITEM_KEYS[POSITION_TEN])){
						if (vm.vendingCoinBox.getBalance() >= vm.newInventory.get("C2").getPrice() && vm.newInventory.get("C2").getCurrentStock()>0) {
							vm.decreaseBalance(vm.newInventory.get("C2").getPrice());
							vm.printBalanceInDollars();
							vm.newInventory.get("C2").vend();
						}else if(vm.newInventory.get("C2").getCurrentStock()<1){
							System.out.println("This item is out of stock");
						}
						else {
							System.out.println("You need to deposit more funds to make that purchase.");
						}
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if(choiceItem.equals(ITEM_KEYS[POSITION_ELEVEN])){
						if (vm.vendingCoinBox.getBalance() >= vm.newInventory.get("C3").getPrice() && vm.newInventory.get("C3").getCurrentStock()>0) {
							vm.decreaseBalance(vm.newInventory.get("C3").getPrice());
							vm.printBalanceInDollars();
							vm.newInventory.get("C3").vend();
						}else if(vm.newInventory.get("C3").getCurrentStock()<1){
							System.out.println("This item is out of stock");
						}
						else {
							System.out.println("You need to deposit more funds to make that purchase.");
						}
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if(choiceItem.equals(ITEM_KEYS[POSITION_TWELVE])){
						if (vm.vendingCoinBox.getBalance() >= vm.newInventory.get("C4").getPrice() && vm.newInventory.get("C4").getCurrentStock()>0) {
							vm.decreaseBalance(vm.newInventory.get("C4").getPrice());
							vm.printBalanceInDollars();
							vm.newInventory.get("C4").vend();
						}else if(vm.newInventory.get("C4").getCurrentStock()<1){
							System.out.println("This item is out of stock");
						}
						else {
							System.out.println("You need to deposit more funds to make that purchase.");
						}
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if(choiceItem.equals(ITEM_KEYS[POSITION_THIRTEEN])){
						if (vm.vendingCoinBox.getBalance() >= vm.newInventory.get("D1").getPrice() && vm.newInventory.get("D1").getCurrentStock()>0) {
							vm.decreaseBalance(vm.newInventory.get("D1").getPrice());
							vm.printBalanceInDollars();
							vm.newInventory.get("D1").vend();
						}else if(vm.newInventory.get("D1").getCurrentStock()<1){
							System.out.println("This item is out of stock");
						}
						else {
							System.out.println("You need to deposit more funds to make that purchase.");
						}
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if(choiceItem.equals(ITEM_KEYS[POSITION_FOURTEEN])){
						if (vm.vendingCoinBox.getBalance() >= vm.newInventory.get("D2").getPrice() && vm.newInventory.get("D2").getCurrentStock()>0) {
							vm.decreaseBalance(vm.newInventory.get("D2").getPrice());
							vm.printBalanceInDollars();
							vm.newInventory.get("D2").vend();
						}else if(vm.newInventory.get("D2").getCurrentStock()<1){
							System.out.println("This item is out of stock");
						}
						else {
							System.out.println("You need to deposit more funds to make that purchase.");
						}
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if(choiceItem.equals(ITEM_KEYS[POSITION_FIFTEEN])){
						if (vm.vendingCoinBox.getBalance() >= vm.newInventory.get("D3").getPrice() && vm.newInventory.get("D3").getCurrentStock()>0) {
							vm.decreaseBalance(vm.newInventory.get("D3").getPrice());
							vm.printBalanceInDollars();
							vm.newInventory.get("D3").vend();
						}else if(vm.newInventory.get("D3").getCurrentStock()<1){
							System.out.println("This item is out of stock");
						}
						else {
							System.out.println("You need to deposit more funds to make that purchase.");
						}
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if(choiceItem.equals(ITEM_KEYS[POSITION_SIXTEEN])){
						if (vm.vendingCoinBox.getBalance() >= vm.newInventory.get("D4").getPrice() && vm.newInventory.get("D4").getCurrentStock()>0) {
							vm.decreaseBalance(vm.newInventory.get("D4").getPrice());
							vm.printBalanceInDollars();
							vm.newInventory.get("D4").vend();
						}else if(vm.newInventory.get("D4").getCurrentStock()<1){
							System.out.println("This item is out of stock");
						}
						else {
							System.out.println("You need to deposit more funds to make that purchase.");
						}
						activeMenu = PURCHASE_MENU_OPTIONS;
					}

				}
			else if(choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)){
				//Close coinbox
				vm.vendingCoinBox.giveChange();
				activeMenu = MAIN_MENU_OPTIONS;
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
