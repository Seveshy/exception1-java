package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room number: ");
		int number = sc.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error");
		} else {
			Reservation reservetion = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservetion: " + reservetion);

			System.out.println();
			System.out.println("Enter date to update the reservetion:");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reservetion.updateDates(checkIn, checkOut);
			System.out.println("Reservetion " + reservetion);

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservetion: Reservetion dates for update most be future:");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservetion: Check-out date must be after check-in date:");

			} else {
				reservetion.updateDates(checkIn, checkOut);
				System.out.println("Reservetion: " + reservetion);
			}

		}

		sc.close();
	}

}
