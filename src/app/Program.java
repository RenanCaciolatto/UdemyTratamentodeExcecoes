package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Numero do quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.print("Data de Check-In: (dd/mm/yyyy) ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data de Check-Out: (dd/mm/yyyy) ");
			Date checkOut = sdf.parse(sc.next());
		 
			Reservation reserva = new Reservation(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println("\nEntre com os dados para atualizar sua reserva: ");
			System.out.print("Data de Check-In: (dd/mm/yyyy) ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de Check-Out: (dd/mm/yyyy) ");
			checkOut = sdf.parse(sc.next());
			
			reserva.atualizarDatas(checkIn, checkOut);
			System.out.println("Reserva: "+reserva);	
		}
		catch(ParseException e) {
			System.out.println("Formato de data inválido!");
		}
		catch(DomainException e) {
			System.out.println("Erro ao reservar: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado...");
		}
		finally {
			sc.close();
		}
	}
}
