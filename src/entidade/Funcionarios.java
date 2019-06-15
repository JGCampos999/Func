package entidade;

import java.util.Date;

public class Funcionarios {
	private String matricula;
	private String primeiroNome;
	private String ultimoNome;
	private String email;
	private Date dataNascimento;
	private String cargo;
	private String matriculaGerente;
	
	public void setMatricula(String matricula){
		this.matricula = matricula;
	}
	
	public String getMatricula(){
		return matricula;
	}
	
	public void setPrimeiroNome(String primeiroNome){
		this.primeiroNome = primeiroNome;
	}
	
	public String getPrimeiroNome(){
		return primeiroNome;
	}
	
	public void setUltimoNome(String ultimoNome){
		this.ultimoNome = ultimoNome;
	}
	
	public String getUltimoNome(){
		return ultimoNome;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setDataNascimento(Date dataNascimento){
		this.dataNascimento = dataNascimento;
	}
	
	public Date getDataNascimento(){
		return dataNascimento;
	}
	
	public void setCargo(String cargo){
		this.cargo = cargo;
	}
	
	public String getCargo(){
		return cargo;
	}
	
	public void setMatriculaGerente(String matriculaGerente){
		this.matriculaGerente = matriculaGerente;
	}
	
	public String getMatriculaGerente(){
		return matriculaGerente;
	}
}