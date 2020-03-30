package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	//ESSE THROWS ParseException É USADO PARA TRATAR O ERRO NO METODO PARSEEXCEPTION, CHAMADO PELO MAIN
	public static void main(String[]args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		/*TESTE SE A DATA NÃO É DEPOIS DO CHEK-IN COMANDO after USADO EM DATAS*/
		/*A CONDIÇÃO ESTA FALANDO SE CHECKOUT NÃO FOR DEPOIS DE CHEKIN*/
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservetion: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			
			/*ESTA TESTANDO SE A DATA FOR ANTES DA DATA ATUAL APRESENTARA ERRO. USADANDO O COMANDO .before*/
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation date of update must be future dates");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {	
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservetion: " + reservation);
			}		
		}
		sc.close();
	}
}
