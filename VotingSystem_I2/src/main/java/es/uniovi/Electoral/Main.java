package es.uniovi.electoral;

import java.io.PrintWriter;
import java.security.InvalidParameterException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import es.uniovi.electoral.model.Configuration;
import es.uniovi.electoral.model.Option;
import es.uniovi.electoral.model.PollingStation;

public class Main {

	private static Scanner scnr = null;
	private static PrintWriter prnt = null;
	
	private static List<Option> options;
	private static List<PollingStation> stations ;
	private static String type = "";
	private static Configuration conf;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		run(new Scanner(System.in), new PrintWriter(System.out));
	}

	public static void run(Scanner scanner, PrintWriter out) {
		options = new ArrayList<Option>();
		stations = new ArrayList<PollingStation>();
		scnr = scanner;
		prnt = out;
		print("Welcome to the Electoral Process Management\n\n"
				+ "Please select an electoral option:" + "\n\t1- Referendum"
				+ "\n\t2- Election");
		Integer option = null;

		while (option == null) {
			try {
				option = Integer
						.parseInt(process("Introduce an option number"));
			} catch (Exception e) {
				print("Invalid data, please try again");
				option = null;
			}
		}
		try {
			options(option);
			stations();
			configuration();
			new CreateR().create(conf, options, stations);
		} catch (Exception e) {
			print("Invalid data or format, exiting manager");
		} finally {
			print("Thank you for using our electoral system manager");
		}
	}

	private static void print(String printString) {
		prnt.println(printString);
		System.out.println(printString);			
	}

	@SuppressWarnings("deprecation")
	private static void configuration() {
		String name = process("Name your elections");
		String date = process("Opening date of elections (dd/mm/yyyy):");
		String time = process("Time of opening (hh:mm):");
		String[] temp = date.split("/");
		String[] temp2 = time.split(":");
		Timestamp start = new Timestamp(Integer.parseInt(temp[2]) - 1900,
				Integer.parseInt(temp[1]) -1, Integer.parseInt(temp[0]),
				Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1]), 0, 0);
		date = process("Closing date of elections (dd/mm/yyyy):");
		time = process("Time of closing (hh:mm):");
		temp = date.split("/");
		temp2 = time.split(":");
		Timestamp end = new Timestamp(Integer.parseInt(temp[2]) -1900,
				Integer.parseInt(temp[1]) - 1, Integer.parseInt(temp[0]),
				Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1]), 0, 0);

		String comments = process("Additional comments:");

		conf = new Configuration(name, start, end, type, comments);

		print("Configuration completed");
	}

	private static void stations() {
		print("Please fill out the information of the polling stations");
		boolean more = true;
		while (more) {
			stations.add(new PollingStation(Long.parseLong(process("Code:")),
					process("Province:"), process("City:"),
					process("District:"), process("Country:")));
			if (process("Exit polling station adding?(Y/N)").equalsIgnoreCase("y"))
				more = false;
		}
		print("Polling stations completed");
		
	}

	private static String process(String text) {
		return process(text, scnr, prnt);
	}

	public static String process(String text, Scanner input, PrintWriter out) {
		print(text);
		String temp = input.nextLine();
		return temp;
	}

	private static void options(int option) throws Exception {
		switch (option) {
		case 1:
			options.add(new Option(1, "Agree", ""));
			options.add(new Option(2, "Disagree", ""));
			type = "Referendum";
			break;
		case 2:
			boolean more = true;
			int i = 1;
			while (more) {
				options.add(new Option(i, process("Name:"),
						process("Comments:")));
				i++;
				more = process("Add a new voting option? (Y/N)").equalsIgnoreCase("y");
			}
			type = "Elections";
			break;
		default:
			throw new InvalidParameterException();
		}
		print("Voting options completed");
	}
}
