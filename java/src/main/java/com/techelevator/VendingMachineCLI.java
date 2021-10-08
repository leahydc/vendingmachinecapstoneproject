package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VendingMachineCLI {

	public static VendingMachine vm = new VendingMachine();


	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String ONE_DOLLAR = "$1";
	private static final String TWO_DOLLARS = "$2";
	private static final String FIVE_DOLLARS = "$5";
	private static final String TEN_DOLLARS = "$10";

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

				vm.printInventory();
			}
			else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				activeMenu = PURCHASE_MENU_OPTIONS;
				vm.printBalanceInDollars();
			}
			else if (choice.equals(MAIN_MENU_OPTION_EXIT)){

				System.out.println("Umbrella Corp thanks you for stopping by!");
				runVendingMachine = false;
			}
			else if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)){

				activeMenu = DOLLAR_INPUT_VALUES;
				String choiceDollar = (String) menu.getChoiceFromOptions(activeMenu);

				if (choiceDollar.equals(ONE_DOLLAR)) {
					vm.feedMoney(1);
					vm.printBalanceInDollars();
					vmLog.log(getDateForLog(), "FEED MONEY: /", ONE_DOLLAR + ".00 /$", vm.getBalanceInDollars());
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
			else if(choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {

				vm.printInventory();
				activeMenu = ITEM_KEYS;
				String choiceItem = (String) menu.getChoiceFromOptions(activeMenu, false);

				if (choiceItem == null) {

					System.out.println("Sorry, this is not a valid selection!");
					activeMenu = PURCHASE_MENU_OPTIONS;

				} else {

					if (choiceItem.equals(ITEM_KEYS[POSITION_ONE])) {
						vm.purchase("A1");
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if (choiceItem.equals(ITEM_KEYS[POSITION_TWO])) {
						vm.purchase("A2");
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if (choiceItem.equals(ITEM_KEYS[POSITION_THREE])) {
						vm.purchase("A3");
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if (choiceItem.equals(ITEM_KEYS[POSITION_FOUR])) {
						vm.purchase("A4");
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if (choiceItem.equals(ITEM_KEYS[POSITION_FIVE])) {
						vm.purchase("B1");
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if (choiceItem.equals(ITEM_KEYS[POSITION_SIX])) {
						vm.purchase("B2");
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if (choiceItem.equals(ITEM_KEYS[POSITION_SEVEN])) {
						vm.purchase("B3");
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if (choiceItem.equals(ITEM_KEYS[POSITION_EIGHT])) {
						vm.purchase("B4");
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if (choiceItem.equals(ITEM_KEYS[POSITION_NINE])) {
						vm.purchase("C1");
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if (choiceItem.equals(ITEM_KEYS[POSITION_TEN])) {
						vm.purchase("C2");
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if (choiceItem.equals(ITEM_KEYS[POSITION_ELEVEN])) {
						vm.purchase("C3");
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if (choiceItem.equals(ITEM_KEYS[POSITION_TWELVE])) {
						vm.purchase("C4");
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if (choiceItem.equals(ITEM_KEYS[POSITION_THIRTEEN])) {
						vm.purchase("D1");
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if (choiceItem.equals(ITEM_KEYS[POSITION_FOURTEEN])) {
						vm.purchase("D2");
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if (choiceItem.equals(ITEM_KEYS[POSITION_FIFTEEN])) {
						vm.purchase("D3");
						activeMenu = PURCHASE_MENU_OPTIONS;
					}
					if (choiceItem.equals(ITEM_KEYS[POSITION_SIXTEEN])) {
						vm.purchase("D4");
						activeMenu = PURCHASE_MENU_OPTIONS;
					}

				}
			}
			else if(choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)){

				vm.vendingCoinBox.giveChange();
				activeMenu = MAIN_MENU_OPTIONS;
			}
		}
	}

	private static String getDateForLog() {
		String result = "";
		LocalDateTime dateObj = LocalDateTime.now();
		DateTimeFormatter formatObject = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
		String formattedDate = dateObj.format(formatObject);


		result = String.format(formattedDate);
		return result;
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}