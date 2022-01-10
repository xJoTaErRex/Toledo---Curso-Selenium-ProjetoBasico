package br.ce.wcjunior.core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers browser = Browsers.IE;
	
	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.NUVEM;
	
	public static String NOME_CONTA_ALTERADA = "Conta Alterada " + System.nanoTime();
			
    public enum Browsers {
		CHROME,
		FIREFOX,
		IE
	}
    
    public enum TipoExecucao {
		GRID,
		LOCAL,
		NUVEM
	}

}
