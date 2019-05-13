package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		System.out.println("Numero do Quarto: ");
		int numQuart = sc.nextInt();
		System.out.println("Data de entrada (dd/MM/yyyy): ");
		Date dtEntrada = sdf.parse(sc.next());
		System.out.println("Data de Saida (dd/MM/yyyy): ");
		Date dtSaida = sdf.parse(sc.next());
		if (!dtSaida.after(dtEntrada)) {	//After testa se uma data é posterior a outra
			System.out.println("Data inválida. A Data de saída deve ser posterior a data de entrada: ");
		}
		
		else {
			Reserva res = new Reserva(numQuart, dtEntrada, dtSaida);
			System.out.println(res);
			
			System.out.println();
			System.out.println("entre com os dados para atualização: ");
			System.out.println("Data de entrada (dd/MM/yyyy): ");
			dtEntrada = sdf.parse(sc.next());
			System.out.println("Data de Saida (dd/MM/yyyy): ");
			dtSaida = sdf.parse(sc.next());
			
			
			Date agora = new Date();
			if(dtEntrada.before(agora) || dtSaida.before(agora)) { //Before analisa se a data é anterior à data informada
				System.out.println("Erro. As Datas informadas para reservas devem ser futuras! ");
				
				
			}
			
			
			res.atualizaDatas(dtEntrada, dtSaida);
			System.out.println(res);
			
		}
		
		sc.close();
		

	}

}
