package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exececoes.ExcecaoDominio;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

		try {
			
		System.out.println("Numero do Quarto: ");
		int numQuart = sc.nextInt();
		System.out.println("Data de entrada (dd/MM/yyyy): ");
		Date dtEntrada = sdf.parse(sc.next());
		System.out.println("Data de Saida (dd/MM/yyyy): ");
		Date dtSaida = sdf.parse(sc.next());

		Reserva res = new Reserva(numQuart, dtEntrada, dtSaida);
		System.out.println(res);

		System.out.println();
		System.out.println("entre com os dados para atualização: ");
		System.out.println("Data de entrada (dd/MM/yyyy): ");
		dtEntrada = sdf.parse(sc.next());
		System.out.println("Data de Saida (dd/MM/yyyy): ");
		dtSaida = sdf.parse(sc.next());

		res.atualizaDatas(dtEntrada, dtSaida);

		System.out.println(res);
		}
		catch (ParseException e) {
			System.out.println ("Formato de data inválido!");
		}
		
		catch (ExcecaoDominio e) {	//Tratando a exceção com a classe personalisada
			System.out.println("Erro na reserva" + e.getMessage()); //o getMessage recupera a mensagem passada no comando throw da classe reserva
		}
		

		sc.close();

	}

}
