package lojaeletronicos;

public class Notebook extends Produtos {
    private static final long serialVersionUID = 1L;
    private String processador;
    private int memoriaRam;
    private String disco;

    public Notebook(String marca, String modelo, int tela, String processador, int memoriaRam, String disco) {
            super(marca, modelo, tela);
            this.categoria = "Notebook";
            this.processador = processador;
            this.memoriaRam = memoriaRam;
            this.disco = disco;
    }
	
    @Override
    public String toString() {
    return  "\n=======" + getCategoria() + "=======" + 
            "\nMarca: " + getMarca() + 
            "\nModelo: " + getModelo() + 
            "\nTela: " + getTela() + " polegadas" +
            "\nMemória Interna: " + getDisco() +
            "\nProcessador: " + getProcessador() +
            "\nMemória RAM: " + getMemoriaRam() + "GB" +
            "\n" + funcionalidades();
    }
    
    @Override
    public String funcionalidades() {
    	return  "Funções do " + getCategoria() + ":" +
                "\n- Pacote Office" +
                "\n- Acesso a Internet" + 
                "\n- Games";
    } 
    
    public String getProcessador() {
        return processador;
    }

    public int getMemoriaRam() {
        return memoriaRam;
    }

    public String getDisco() {
        return disco;
    }
}
