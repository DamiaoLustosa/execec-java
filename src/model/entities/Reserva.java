package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exececoes.ExcecaoDominio;

public class Reserva {
	private Integer numQuarto;
	private Date dtEntrada;
	private Date dtSaida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	//Declarado como static para que não seja criado um simpledate sempre que
																				//A classe reserva seja instanciada
	
	public Reserva(Integer numQuarto, Date dtEntrada, Date dtSaida) throws ExcecaoDominio { //Propagando a exceção no construtor
		if (!dtSaida.after(dtEntrada)) {	//After testa se uma data é posterior a outra
			throw new ExcecaoDominio ("Data inválida. A Data de saída deve ser posterior a data de entrada: "); //Tratando a exceção para argumentos inválidos
		}
		
		this.numQuarto = numQuarto;
		this.dtEntrada = dtEntrada;
		this.dtSaida = dtSaida;
	}

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getDtEntrada() {
		return dtEntrada;
	}


	public Date getDtSaida() {
		return dtSaida;
	}
	
	public long duracao() {
		
		long diferenca = dtSaida.getTime() - dtEntrada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);	
	}
	
	public void atualizaDatas (Date dtEntra, Date dtSaida) throws ExcecaoDominio {
		
		Date agora = new Date();
		if(dtEntrada.before(agora) || dtSaida.before(agora)) { //Before analisa se a data é anterior à data informada
			throw new ExcecaoDominio ("Erro. As Datas informadas para reservas devem ser futuras! ");	//Tratando a exceção para argumentos inválidos
		}
		
		if (!dtSaida.after(dtEntrada)) {	//After testa se uma data é posterior a outra
			throw new ExcecaoDominio ("Data inválida. A Data de saída deve ser posterior a data de entrada: "); //Tratando a exceção para argumentos inválidos
		}
		this.dtEntrada = dtEntra;
		this.dtSaida = dtSaida;

	}

	@Override
	public String toString() {		//toString é sempre um método sobreposto
		return "Reserva: Núemro do quarto " 
				+ numQuarto
				+ ", Data de Entrada: "
				+ sdf.format(dtEntrada)
				+ ", Data de Saida: "
				+ sdf.format(dtSaida)
				+ ", Duração: "
				+ duracao()
				+ " Noites!";
	}
	
	

	
	
	
	
	
	
	
	
	

}
