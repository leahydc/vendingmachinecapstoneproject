package com.techelevator;

import com.techelevator.view.Menu;

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

	//Arrays of menus for different screens
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,MAIN_MENU_OPTION_EXIT };
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT,PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
	private static final String[] DOLLAR_INPUT_VALUES = { ONE_DOLLAR, TWO_DOLLARS, FIVE_DOLLARS, TEN_DOLLARS};

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {

		String [] activeMenu =  MAIN_MENU_OPTIONS;

		while (true) {
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
				System.exit(1);
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
			}
			else if(choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)){
				//Close coinbox
				System.out.println("Thanks for stopping by");
				System.exit(1);
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
