package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {
	// ESSE THROWS ParseException É USADO PARA TRATAR O ERRO NO METODO
	// PARSEEXCEPTION, CHAMADO PELO MAIN
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {

			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			/* TESTE SE A DATA NÃO É DEPOIS DO CHEK-IN COMANDO after USADO EM DATAS */
			/* A CONDIÇÃO ESTA FALANDO SE CHECKOUT NÃO FOR DEPOIS DE CHEKIN */
			// if (!checkOut.after(checkIn)) {
			// System.out.println("Error in reservation: Check-out date must be after
			// check-in date");
			// }
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservetion: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservetion: " + reservation);
		} 
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Unexpected error ");
		}

		sc.close();
	}
}
