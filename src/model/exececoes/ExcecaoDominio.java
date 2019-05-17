package model.exececoes;

//Classe para personalisar uma excec�o
public class ExcecaoDominio extends Exception { //Excecoes que herdam da classe RuntimeException n�o s�o obrgadas a serem tratadas pelo compilador

	private static final long serialVersionUID = 1L; //Declarando um n�mero de vers�o para classe serializavel
	
	public ExcecaoDominio (String msg) {	//Contrutor passando uma String
		super(msg);
	}
	
	
	
	
	

}
