package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservas;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero quarto: ");
		int numero = sc.nextInt();
		System.out.print("Check-in data (dd/MM/yyyy): ");
		Date checkIn =  sdf.parse(sc.next());
		System.out.print("Check-out data (dd/MM/yyyy): ");
		Date checkOut =  sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("erro na reserva: Data de check-out deve ser posterior à data de check-in ");
		}
		else {
			Reservas reserva = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reserva" + reserva);
			
			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva: ");
			System.out.print("Check-in data (dd/MM/yyyy)");
			checkIn =  sdf.parse(sc.next());
			System.out.print("Check-out data (dd/MM/yyyy)");
			checkOut =  sdf.parse(sc.next());
			
	
							
			String error = reserva.atualizacaoData(checkIn, checkOut);
			if(error != null) {
				System.out.println("Erro em reserva: " + error);
		}
		else {
				System.out.println("Reserva: " + reserva);
		
		}	
		
		sc.close();
	}

}
}
