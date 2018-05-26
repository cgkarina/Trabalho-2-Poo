package testeTeste;
import java.util.Scanner;

public class Caixa {
	


	public static void main(String[] args) {
		
		  Bandeja b100 = new Bandeja(100, 700);
		  Bandeja b50 = new Bandeja(50, 750);
		  Bandeja b20 = new Bandeja(20,1800);
		  Bandeja b10 = new Bandeja (10,2000);
		  
		  ATM atm = new ATM ("CX306","Rua: Avenida Paulista","2000","São Paulo",
		  "São Paulo",b100, b50, b20, b10);
		  
		  int vSacar10,vSacar20,vSacar50,vSacar100;
		  int resultado=0;
		  int opcao=-1;
		  int valorDeSaque=0;
		  int bdjSel;
		  
		  painel(atm);
		  
		  opcoes();
		  
		  Scanner scanner = new Scanner(System.in);
		  opcao = scanner.nextInt();
		  
		  while(opcao!=0) {
		  
			  
			  if(opcao==1) {
				  
				  //sempre antes de sacar
				  vSacar10 = atm.getBandeja10().getQuantidade();
				  vSacar20 = atm.getBandeja20().getQuantidade();
				  vSacar50 = atm.getBandeja50().getQuantidade();
				  vSacar100 = atm.getBandeja100().getQuantidade();
				  
				  System.out.print("Qual o valor do saque? R$:");
				  valorDeSaque = scanner.nextInt();
				  
				  resultado = atm.sacar(valorDeSaque);
				  
				  if(resultado == -1) {
					  System.out.println("Não é possível efetuar o saque, valor indisponivel");
				  }else {
					  //melhorar descrição do print
					  System.out.println("Descrição do saque\n");
					  if(vSacar100!=atm.getBandeja100().getQuantidade()) {
						  System.out.println("Valor R$100 - Quantidade de Notas: "+(vSacar100 - atm.getBandeja100().getQuantidade()) );
					  }
					  if(vSacar50!=atm.getBandeja50().getQuantidade()) {
						  System.out.println("Valor R$50 - Quantidade de Notas: "+(vSacar50 - atm.getBandeja50().getQuantidade()) );
					  }
					  if(vSacar20!=atm.getBandeja20().getQuantidade()) {
						  System.out.println("Valor R$20 - Quantidade de Notas: "+(vSacar20 - atm.getBandeja20().getQuantidade()) );
					  }
					  if(vSacar10!=atm.getBandeja10().getQuantidade()) {
						  System.out.println("Valor R$10 - Quantidade de Notas: "+(vSacar10 - atm.getBandeja10().getQuantidade()) );
					  }
					  
				  }
				  
			  }else if(opcao==2) {
				  System.out.println("Valor Total do Caixa Eletronico R$"+atm.saldoATM());
				  
			  }else if(opcao==3) {
				 				 
					  System.out.println("Valor total da Bandeja 100: "+atm.saldoBandeja(atm.getBandeja100()));
				  	  System.out.println("Valor total da Bandeja 50: "+atm.saldoBandeja(atm.getBandeja50()));
				      System.out.println("Valor total da Bandeja 20: "+atm.saldoBandeja(atm.getBandeja20()));
				  	  System.out.println("Valor total da Bandeja 10: "+atm.saldoBandeja(atm.getBandeja10()));
				  }
				
			   else {
				  System.out.println("Opcao Invalida");
			  }
			  
			  opcoes();
			  //scan para pegar a opção digitada
			  opcao = scanner.nextInt();
			  
			  }
			  

			  
			  
		  }
		  
	  
		
	
	
	 public static void painel (ATM atm)
		{
		
		 System.out.println("**********************************************************");
		System.out.println("Código do Caixa: "+atm.getCod());
		System.out.println("Endereço: "+atm.getLog()+" - "+atm.getNum());
		System.out.println("Cidade:"+atm.getCid()+" - Estado: "+atm.getUf());
		System.out.println("**********************************************************");	
	}
	 
	 
	 public static void opcoes() {
		 System.out.println("**********************************************************");
		 System.out.println("Digite 1 para sacar: \n");
		 System.out.println("Digite 2 para ver o saldo do Caixa:\n");
		 System.out.println("Digite 3 para ver o saldo das Bandejas:\n");
		 System.out.println("Digite 0 para sair: \n");
		 System.out.println("**********************************************************");
	 }
}
