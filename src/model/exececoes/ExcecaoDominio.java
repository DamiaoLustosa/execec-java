package model.exececoes;

//Classe para personalisar uma excecão
public class ExcecaoDominio extends Exception { //Excecoes que herdam da classe RuntimeException não são obrgadas a serem tratadas pelo compilador

	private static final long serialVersionUID = 1L; //Declarando um número de versão para classe serializavel
	
	public ExcecaoDominio (String msg) {	//Contrutor passando uma String
		super(msg);
	}
	
	
	
	
	

}
