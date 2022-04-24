package lojaeletronicos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MenuLojaEletronicos {

    private ArrayList<Produtos> produtos;

	public MenuLojaEletronicos() {
		this.produtos = new ArrayList<Produtos>();
	}
	public String[] leValores (String [] dadosIn){
		String [] dadosOut = new String [dadosIn.length];

		for (int i = 0; i < dadosIn.length; i++)
			dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

		return dadosOut;
	}

	public Notebook leNotebook (){

		String [] valores = new String [6];
		String [] nomeVal = {"Marca", "Modelo", "Tela", "Processador", "MemoriaRam", "Disco"};
		valores = leValores (nomeVal);

		int memoriaRam = this.retornaInteiro(valores[4]);
                int tela = this.retornaInteiro(valores[2]);


		Notebook notebook = new Notebook (valores[0],valores[1],tela,valores[3],memoriaRam,valores[5]);
		return notebook;
	}

	public Smartphone leSmartphone (){

		String [] valores = new String [4];
		String [] nomeVal = {"Marca", "Modelo", "Tela", "Chips"};
		valores = leValores (nomeVal);

		int chips = this.retornaInteiro(valores[3]);
                int tela = this.retornaInteiro(valores[2]);

		Smartphone smartphone = new Smartphone (valores[0],valores[1],tela,chips);
		return smartphone;
	}
        
        public Smartwatch leSmartwatch (){

		String [] valores = new String [4];
		String [] nomeVal = {"Marca", "Modelo", "Tela", "Pulseira"};
		valores = leValores (nomeVal);

                int tela = this.retornaInteiro(valores[2]);

		Smartwatch smartwatch = new Smartwatch (valores[0],valores[1],tela,valores[3]);
		return smartwatch;
	}

	private boolean intValido(String s) {
		try {
			Integer.parseInt(s); 
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
        
	public int retornaInteiro(String entrada) {
		int numInt;

		while (!this.intValido(entrada)) {
			entrada = JOptionPane.showInputDialog(null, 
                                "                     Valor incorreto!\n\n"+
                                "             Digite um número inteiro");
		}
		return Integer.parseInt(entrada);
	}

	public void salvaProdutos (ArrayList<Produtos> produtos){
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream 
					(new FileOutputStream("C:\\Windows\\Temp\\produtos.dat"));
			for (int i=0; i < produtos.size(); i++)
				outputStream.writeObject(produtos.get(i));
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Não foi possível criar um arquivo");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public ArrayList<Produtos> recuperaProdutos (){
		ArrayList<Produtos> produtosTemp = new ArrayList<Produtos>();

		ObjectInputStream inputStream = null;

		try {	
			inputStream = new ObjectInputStream
					(new FileInputStream("C:\\Windows\\Temp\\produtos.dat"));
			Object obj = null;
			while ((obj = inputStream.readObject()) != null) {
				if (obj instanceof Produtos) {
					produtosTemp.add((Produtos) obj);
				}   
			}          
		} catch (EOFException ex) { 
			System.out.println("Fim de arquivo");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,
                                "===================================           \n" +
                                "       O arquivo com produtos não existe!\n" + 
                                "===================================\n");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally { 
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
			return produtosTemp;
		}
	}

	public void menuLojaEletronicos() {

		String menu = "";
		String entrada;
                int opc1, opc2;

		do {
			menu = "===============================\n" +
                                "           Loja de Eletrônicos | Menu\n" +
                                "===============================\n" +
				"Escolha uma opção:\n" + 
				"1. Cadastrar os produtos\n" +
				"2. Ver a lista de produtos\n" +
				"3. Excluir os produtos\n" +
				"4. Gravar os produtos\n" +
				"5. Recuperar os produtos\n" +
				"9. Sair da Loja";
			entrada = JOptionPane.showInputDialog (menu + "\n\n");
			opc1 = this.retornaInteiro(entrada);				
		
			
			switch (opc1) {
			case 1:// Entrar dados
				menu = "===============================\n" +
                                        "              Cadastro dos produtos\n" +
                                        "===============================\n" +
                                        "Escolha uma opção:\n" +
					"1. Notebook\n" +
					"2. Smartphone\n" +
                                        "3. Smartwatch\n";

				entrada = JOptionPane.showInputDialog (menu + "\n\n");
				opc2 = this.retornaInteiro(entrada);


				switch (opc2) {
				case 1: produtos.add((Produtos)leNotebook());
				break;
				case 2: produtos.add((Produtos)leSmartphone());
				break;
                                case 3: produtos.add((Produtos)leSmartwatch());
				break;
				default: 
					JOptionPane.showMessageDialog(null,
                                                "=================================           \n" +
                                                "         Nenhuma opção foi escolhida!\n" + 
                                                "=================================");
				}

				break;
			case 2: // Exibir dados
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,
                                                "===================================           \n" + 
                                                "     Cadastre um produto na loja primeiro\n" + 
                                                "===================================");
					break;
				}
				String dados = "";
				for (int i=0; i < produtos.size(); i++)	{
					dados += produtos.get(i).toString() + "\n";
				}
				JOptionPane.showMessageDialog(null,dados);
				break;
			case 3: // Limpar Dados
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,
                                                "===================================           \n" + 
                                                "     Cadastre um produto na loja primeiro\n" + 
                                                "===================================");
					break;
				}
				produtos.clear();
				JOptionPane.showMessageDialog(null,
                                        "=======================================           \n" +
                                        "    Os produtos foram excluidos com sucesso!\n" + 
                                        "=======================================\n");
				break;
			case 4: // Grava Dados
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,
                                                "===================================           \n" + 
                                                "     Cadastre um produto na loja primeiro\n" + 
                                                "===================================");
					break;
				}
				salvaProdutos(produtos);
				JOptionPane.showMessageDialog(null,
                                        "=======================================           \n" +
                                        "       Os produtos foram salvos com sucesso!\n" + 
                                        "=======================================           \n");
				break;
			case 5: // Recupera Dados
				produtos = recuperaProdutos();
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,
                                                "===================================           \n" +
                                                "          Nenhum produto para recuperar!\n" + 
                                                "===================================\n");
					break;
				}
				JOptionPane.showMessageDialog(null,
                                        "========================================           \n" +
                                        "  Os produtos foram recuperados com sucesso!\n" + 
                                        "========================================\n");
				break;
			case 9:
				JOptionPane.showMessageDialog(null,
                                        "===================================           \n" + 
                                        "      Fim do aplicativo | Loja de Eletrônicos\n" + 
                                        "===================================");
				break;
			}
		} while (opc1 != 9);
	}


	public static void main (String [] args){

		MenuLojaEletronicos loja = new MenuLojaEletronicos();
		loja.menuLojaEletronicos();

	}
	
}
