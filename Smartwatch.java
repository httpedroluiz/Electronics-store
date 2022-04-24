package lojaeletronicos;

public class Smartwatch extends Produtos {
    private static final long serialVersionUID = 1L;
    private String pulseira;

    public Smartwatch(String marca, String modelo, int tela, String pulseira) {
	super(marca, modelo, tela);
	this.categoria = "Smartwatch";
	this.pulseira = pulseira;
    }
	
    @Override
    public String toString() {
        return  "\n======" + getCategoria() + "======" + 
                "\nMarca: " + getMarca() + 
                "\nModelo: " + getModelo() + 
                "\nTela: " + getTela() + "mm" +
                "\nPulseira: " + getPulseira() +
                "\n" + funcionalidades();

    }       
    
    @Override
    public String funcionalidades() {
    	return  "Funções do " + getCategoria() + ":" +
                "\n- Mostrar as horas" +
                "\n- Notificações" +
                "\n- Troca suas músicas" +
                "\n- Alarme" + 
                "\n- Clima/Tempo";
    }
    
    public String getPulseira() {
        return pulseira;
    }
}