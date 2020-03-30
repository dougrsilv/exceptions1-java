package model.exception;

//RutimeException = O com pilador n�o te obriga a tratar o erros;
//EXCEPTION = O COMPILADOR TE OBRIGA A TRATAR TODOS AS EXCE��ES DENTRO DO BLOCO TRY CATCH

public class DomainException extends RuntimeException /*Exception*/{
	//CRIA UMA VERS�O PARA A NOSSA EXCE��O;
	private static final long serialVersionUID = 1L;
	//CRIA UMA MENSAGEM PARA A SUPERCLASSE, PERMITE PASSA UMA MENSAGEM PARA O CONTRUTOR PRICIPAL PASSANDO NOVAS MENSAGENS
	public DomainException(String msg) {
		super(msg);
	}
	
	

}

