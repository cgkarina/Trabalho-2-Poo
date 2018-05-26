package testeTeste;

public class ATM {

	private String cod;
	private String log; 
	private String num;
	private String cid; 
	private String uf; 
	private Bandeja b100;
	private Bandeja b50;
	private Bandeja b20;
	private Bandeja b10;
	
	
	public ATM(String cod, String log, String num, String cid, String uf, Bandeja b100,
			Bandeja b50, Bandeja b20, Bandeja b10) 
	{
		
		this.cod = cod;
		this.log = log;
		this.num = num;
		this.cid = cid;
		this.uf = uf;
		this.b100 = b100;
		this.b50 = b50;
		this.b20 = b20;
		this.b10 = b10;
	
	}
		
	  
	public String getCod(){
		return cod;
    }

	public String getLog() {
		return log;
	}

    public String getNum() {
       	return num;
    }
        
    public String getCid() {
       	return cid;
    }
        
    public String getUf() {
       	return uf;
    }

            
	public Bandeja getBandeja100() {
		return b100;
	}
	
	public Bandeja getBandeja50() {
		return b50;
	}
	
	public Bandeja getBandeja20() {
		return b20;
	}
	
	public Bandeja getBandeja10() {
		return b10;
	}

	public void setBandeja100(Bandeja b100) {
		this.b100 = b100;
	}
	
	public void setBandeja50(Bandeja b50) {
		this.b50 = b50;
	}
	public void setBandeja20(Bandeja b20) {
		this.b20 = b20;
	}
	public void setBandeja10(Bandeja b10) {
		this.b10 = b10;
	}
	
	public double saldoATM () {
		Double qtd = saldoBandeja(this.b100)+saldoBandeja(this.b50)+saldoBandeja(this.b20)+saldoBandeja(this.b10);
		return qtd;
	}
	
	public double saldoBandeja(Bandeja b) {
		
		Double qtdBaneja = (b.getQuantidade() * b.getValorFace());
		
		return qtdBaneja;
	}
	
	
	public int sacar(int valorDeSaque) {
		
		int resultado=0;

		if(valorDeSaque%this.getBandeja100().getValorFace()!=0) {
			if(valorDeSaque%this.getBandeja50().getValorFace()!=0 ) {
				if(valorDeSaque%this.getBandeja20().getValorFace()!=0 ) {
					if(valorDeSaque%this.getBandeja10().getValorFace()!=0 ) {
						return resultado = -1;
					}
				}
			}
		}
		
		
		while(valorDeSaque>=this.getBandeja100().getValorFace()) {
			if(valorDeSaque < this.saldoBandeja(this.b100)){
				valorDeSaque = (int) (valorDeSaque - this.getBandeja100().getValorFace());
				this.getBandeja100().setQuantidade((this.getBandeja100().getQuantidade())-1);
			}
		}
		while(valorDeSaque>=this.getBandeja50().getValorFace()) {
			if(valorDeSaque < this.saldoBandeja(this.b50)){
				valorDeSaque = (int) (valorDeSaque - this.getBandeja50().getValorFace());
				this.getBandeja50().setQuantidade((this.getBandeja50().getQuantidade())-1);
			}
		}
		while(valorDeSaque>=this.getBandeja20().getValorFace()) {
			if(valorDeSaque < this.saldoBandeja(this.b20)){
				valorDeSaque = (int) (valorDeSaque - this.getBandeja20().getValorFace());
				this.getBandeja20().setQuantidade((this.getBandeja20().getQuantidade())-1);
			}
		}
		while(valorDeSaque>=this.getBandeja10().getValorFace()) {
			if(valorDeSaque < this.saldoBandeja(this.b10)){
				valorDeSaque = (int) (valorDeSaque - this.getBandeja10().getValorFace());
				this.getBandeja10().setQuantidade((this.getBandeja10().getQuantidade())-1);
			}
		}
		
		return resultado;
		
	}
		
}

