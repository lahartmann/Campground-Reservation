package com.techelevator;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class CampgroundMenu {
	

//		private PrintWriter out;
//		private Scanner in;
//
//		public CampgroundMenu(InputStream input, OutputStream output) {
//			this.out = new PrintWriter(output);
//			this.in = new Scanner(input);
//		}
//
//		public static String getChoiceFromOptions(String[] parkNames) {
//			String choice = null;
//			while(choice == null) {
//				displayMenuOptions(parkNames);
//				choice = getChoiceFromUserInput(parkNames);
//			}
//			return choice;
//		}
//
//		private String getChoiceFromUserInput(String [] options) {
//			Object choice = null;
//			String userInput = in.nextLine();
//			try {
//				int selectedOption = Integer.valueOf(userInput);
//				if(selectedOption <= options.length) {
//					choice = options[selectedOption - 1];
//				}
//			} catch(NumberFormatException e) {
//				// eat the exception, an error message will be displayed below since choice will be null
//			}
//			if(choice == null) {
//				out.println("\n*** "+userInput+" is not a valid option ***\n");
//			}
//			return choice;
//		}
//
//		private void displayMenuOptions(String options) {
//			out.println();
//			for(int i = 0; i < options.length; i++) {
//				int optionNum = i+1;
//				out.println(optionNum+") "+options[i]);
//			}
//			out.print("\nPlease choose an option >>> ");
//			out.flush();
//		}
	}



