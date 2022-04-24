package lojaeletronicos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class LojaEletronicos {
    
	private final ArrayList<Produtos> produtos;
	
	public LojaEletronicos() {
		this.produtos = new ArrayList<>();
	}
	
	public void adicionaProdutos(Produtos eletronico) {
		this.produtos.add(eletronico);
	}

	public void listarProdutos() {
		if(produtos.isEmpty() != false) {
                    System.out.println("Não há nenhum produto disponível.");
                } else {
                    produtos.forEach(eletronico -> {
                        System.out.println(eletronico.toString());
                    });
                    System.out.println(this.produtos.size() + " produtos listados com sucesso!\n");
                }
	}
	
	public void excluirProduto(Produtos eletronico) {
		if (this.produtos.contains(eletronico)) {
			this.produtos.remove(eletronico);
                        System.out.println();
			System.out.println("Produto " + eletronico.getModelo() + "excluido com sucesso!\n");
		}
		else
			System.out.println("Produto inexistente!\n");
	}

	public void excluirProdutos() {
		produtos.clear();
		System.out.println("Produtos excluidos com sucesso!\n");
	}
        @SuppressWarnings("CallToPrintStackTrace")
	public void gravarProdutos()  {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream (new FileOutputStream("C:\\Windows\\Temp\\produtos.dat"));
			for(Produtos eletronico:produtos) {
				outputStream.writeObject(eletronico);
			}
		}catch (FileNotFoundException ex ) {
			ex.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if (outputStream != null ) {
					outputStream.flush();
					outputStream.close();
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	public void recuperarProdutos() {
		ObjectInputStream inputStream = null;
		try {
			inputStream	= new ObjectInputStream (new FileInputStream ("C:\\Windows\\Temp\\produtos.dat"));
			Object obj = null;
			while((obj = inputStream.readObject ()) != null) {
				if (obj instanceof Smartphone)  
					this.produtos.add((Smartphone)obj);
				else if (obj instanceof Smartwatch)  
					this.produtos.add((Smartwatch)obj);
				else if (obj instanceof Notebook)  
					this.produtos.add((Notebook)obj);
			}
		}catch (EOFException ex) {     
			System.out.println ("End of file reached");
		}catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if (inputStream != null ) {
					inputStream.close();
					System.out.println("Produtos recuperados com sucesso!\n");
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		LojaEletronicos iEletronicos = new LojaEletronicos();
		
		Smartphone Xiaomi = new Smartphone("Xiaomi", "POCO M3", 7, 2);
		Smartwatch Amazfit = new Smartwatch("Xiaomi", "Amazfit GTS", 41, "Borracha");
		Notebook Asus = new Notebook("Asus", "Generic Model", 14, "Intel i7", 16, "1 TB" );
		
		iEletronicos.adicionaProdutos(Xiaomi);
		iEletronicos.adicionaProdutos(Amazfit);
		iEletronicos.adicionaProdutos(Asus);
		iEletronicos.listarProdutos();
		iEletronicos.gravarProdutos();
		iEletronicos.listarProdutos();
		iEletronicos.excluirProduto(Amazfit);
		iEletronicos.listarProdutos();
		iEletronicos.excluirProdutos();
		iEletronicos.listarProdutos();
		iEletronicos.recuperarProdutos();
		iEletronicos.listarProdutos();
		
		System.out.println("Obrigado por visitar a nossa loja!");
                System.out.println();
		System.out.println("Fim da execução do programa!");

	}

}
