package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Data de Check-In: (dd/mm/yyyy) ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de Check-Out: (dd/mm/yyyy) ");
		Date checkOut = sdf.parse(sc.next());
		 
		if(!checkOut.after(checkIn)) {
			System.out.println("A data de checkout deve ser posterior a de checkin...");
		}
		else {
			Reservation reserva = new Reservation(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println("\nEntre com os dados para atualizar sua reserva: ");
			System.out.print("Data de Check-In: (dd/mm/yyyy) ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de Check-Out: (dd/mm/yyyy) ");
			checkOut = sdf.parse(sc.next());
			
			String erro = reserva.atualizarDatas(checkIn, checkOut);
			if(erro != null) {
				System.out.println("Erro ao reservar: "+erro);
			}
			else {
				System.out.println("Reserva: "+reserva);
			}
		}
		
		sc.close();
	}
}
