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

			String error = reservetion.updateDates(checkIn, checkOut);

			if (error != null) {
			System.out.println("Error in reservetion " + error);

			} else {
				System.out.println("Reservetion: " + reservetion);
			}
		}

		sc.close();
	}

}
