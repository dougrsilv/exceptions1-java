package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	//COLOCANDO COMO ESTATICO POR QUE N�O QUERO MAIS DE UMA FORMATA��O DE DATA PARA OS OBJETO DA CLASSE
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) /*throws DomainException*/{
		
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		//METODO getTime() TRAS O DIA EM MILESEGUNDOS
		long diff = checkOut.getTime() - checkIn.getTime();
		//CLASSE TimeUnit � UM ENUMS QUE CONVERTE MILESEGUNSO EM DIAS;
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) /*throws DomainException*/ {
		Date now = new Date();
		/*ESTA TESTANDO SE A DATA FOR ANTES DA DATA ATUAL APRESENTARA ERRO USADANDO O COMANDO before*/
		if(checkIn.before(now) || checkOut.before(now)) {
			//EXCEPTION UTILIZADO PARA TRATAR ARGUMENTOS INVALIDOS NAS VARIAVEIS
			throw new DomainException("Reservation date of update must be future dates");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}

}
