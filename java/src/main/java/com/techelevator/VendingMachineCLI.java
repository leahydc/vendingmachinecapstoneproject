package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {
//Main Menu Display Options
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
//Display Menu
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	//Arrays of menus for different screens
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,MAIN_MENU_OPTION_EXIT };
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT,PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		String [] activeMenu =  MAIN_MENU_OPTIONS;
		VendingMachine vm = new VendingMachine();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(activeMenu);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				vm.printInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				activeMenu = PURCHASE_MENU_OPTIONS;
			}else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
				//Close coinbox
				System.out.println("Thanks for stopping by");
				System.exit(1);
			}else if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)){
				//Add to coin box method

			}else if(choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)){
				//Enter map key for inventory
			}else if(choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)){
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
