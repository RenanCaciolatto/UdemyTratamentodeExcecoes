package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	public int numeroQuarto;
	public Date checkin;
	public Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}
	
	public Reservation(int numeroQuarto, Date checkin, Date checkout) throws DomainException {
		if (!checkout.after(checkin)) {
			throw new DomainException("A data de checkout deve ser posterior a de checkin...");
		}		
		this.numeroQuarto = numeroQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}
	
	public long duracao() {
		long dif = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
		
	}
	
	public void atualizarDatas(Date checkin, Date checkout) throws DomainException {
		Date agora = new Date();
		if(checkin.before(agora) || checkout.before(agora)) {
			throw new DomainException("A data de CheckIn ou CheckOut estão desatualizadas...");
		}
		if (!checkout.after(checkin)) {
			throw new DomainException("A data de checkout deve ser posterior a de checkin...");
		}		
		this.checkin = checkin;
		this.checkout = checkout;	
	}
	
	@Override
	public String toString() {
		return "Quarto: "
				+numeroQuarto
				+", checkin:  "
				+sdf.format(checkin)
				+", checkout: "
				+sdf.format(checkout)
				+"duracao: " + duracao()
				+" noites";
	}
}
