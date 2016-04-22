package es.uniovi.asw;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import org.junit.Test;

import es.uniovi.electoral.Main;

public class ElectoralTest {

	@Test
	public void testWrongOption() {
		String input = "3";
		StringWriter output = new StringWriter();

		Main.run(new Scanner(input), new PrintWriter(output));
		assertFalse(output.toString().contains("Voting options complete"));
		assertTrue(output.toString().contains(
				"Invalid data or format, exiting manager"));
	}

	@Test
	public void testWrongStationCode() {
		String input = "1";
		StringWriter output = new StringWriter();

		Main.run(new Scanner(input), new PrintWriter(output));
		assertTrue(output.toString().contains("polling stations"));
		assertFalse(output.toString().contains("configuration"));
		assertTrue(output.toString().contains(
				"Invalid data or format, exiting manager"));
	}

	@Test
	public void testWrongDateFormat() {
		String input = "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "y\n"
				+ "1\n" + "18 de mayo\n 2:20" + "";
		StringWriter output = new StringWriter();

		Main.run(new Scanner(input), new PrintWriter(output));
		assertTrue(output.toString().contains("Voting options completed"));
		assertTrue(output.toString().contains("Polling stations completed"));
		assertFalse(output.toString().contains("Configuration completed"));
		assertTrue(output.toString().contains(
				"Invalid data or format, exiting manager"));
	}

	@Test
	public void testWrongTimeFormat() {
		String input = "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "y\n"
				+ "1\n" + "18/2/2017\n a las 2" + "";
		StringWriter output = new StringWriter();

		Main.run(new Scanner(input), new PrintWriter(output));
		assertTrue(output.toString().contains("Voting options completed"));
		assertTrue(output.toString().contains("Polling stations completed"));
		assertFalse(output.toString().contains("Configuration completed"));
		assertTrue(output.toString().contains(
				"Invalid data or format, exiting manager"));
	}

	@Test
	public void testCorrect() {
		String input = "2\n" + "Santi\n" + "good\n" + "y\n" + "Andrei\n"
				+ "bad\n" + "n\n" + "555\n" + "Asturias\n" + "Oviedo\n"
				+ "Parque de San Francisco\n" + "España\n" + "y\n"
				+ "Test Elections\n" + "2/12/2015\n" + "12:40\n" + "2/1/2016\n"
				+ "12:40\n" + "no comments\n";
		StringWriter output = new StringWriter();

		Main.run(new Scanner(input), new PrintWriter(output));
		assertTrue(output.toString().contains("Voting options completed"));
		assertTrue(output.toString().contains("Polling stations completed"));
		assertTrue(output.toString().contains("Configuration completed"));
		assertFalse(output.toString().contains(
				"Invalid data or format, exiting manager"));
	}
}
