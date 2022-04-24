package lojaeletronicos;

public class Smartphone extends Produtos {
    private static final long serialVersionUID = 1L;
    private int chips;

    public Smartphone(String marca, String modelo, int tela, int chips) {
	super(marca, modelo, tela);
	this.categoria = "Smartphone";
	this.chips = chips;
    }
	
    @Override
    public String toString() {
        return  "\n======" + getCategoria() + "======" + 
                "\nMarca: " + getMarca() + 
                "\nModelo: " + getModelo() + 
                "\nTela: " + getTela() + " polegadas" +
                "\nQuantidade de chips: " + getChips()  +
                "\n" + funcionalidades();
    }       
    
    @Override
    public String funcionalidades() {
    	return  "Funções do " + getCategoria() + ":" +
                "\n- Fazer ligações" +
                "\n- Mensagens de Texto" +
                "\n- Ouvir músicas" +
                "\n- Apps e Redes Sociais" + 
                "\n- Games";
    }
    
    public int getChips() {
        return chips;
    }
}
