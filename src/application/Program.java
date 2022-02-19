package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Room number: ");
			int number = sc.nextInt();
			System.out.println("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservetion = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservetion: " + reservetion);

			System.out.println();
			System.out.println("Enter date to update the reservetion:");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reservetion.updateDates(checkIn, checkOut);
			System.out.println("Reservetion: " + reservetion);
		} catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		 catch(DomainException e) {
			System.out.println("Error in reservetion: " + e.getMessage());
		 }

		 catch(RuntimeException e) {
			System.out.println("Unexpected error");
		 }

		sc.close();
	}

}
