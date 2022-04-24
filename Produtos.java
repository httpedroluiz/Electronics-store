package lojaeletronicos;

import java.io.Serializable;

public abstract class Produtos implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String categoria;
    protected String marca;
    protected String modelo;
        protected int tela;

    public Produtos(String marca, String modelo, int tela) {
            this.marca = marca;
            this.modelo = modelo;
            this.tela = tela;
    }
     
    public abstract String funcionalidades();

    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public int getTela() {
        return tela;
    }

    
    
    
}
	