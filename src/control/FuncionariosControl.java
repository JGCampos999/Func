package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidade.Funcionarios;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FuncionariosControl {
	private List<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
	private ObservableList<Funcionarios> dataList = FXCollections.observableArrayList();

	public void ler() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		BufferedReader leitor = null;
		try {
			String linha;
			leitor = new BufferedReader(new FileReader("C:/TEMP/FUNC.csv"));
			linha = leitor.readLine();
			while (linha != null) {
				if (linha.contains("Matricula")) {
					linha = leitor.readLine();
				} else {
					try {
						Funcionarios f = new Funcionarios();
						String valores[] = linha.split(";");
						f.setMatricula(valores[0]);
						String nomes[] = valores[1].split(" ");
						f.setPrimeiroNome(nomes[0]);
						f.setUltimoNome(nomes[1]);
						f.setEmail(valores[2]);
						Date data = sdf.parse(valores[3]);
						f.setDataNascimento(data);
						f.setCargo(valores[4]);
						f.setMatriculaGerente(valores[5]);
						funcionarios.add(f);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					linha = leitor.readLine();
				}
			}
			dataList.addAll(funcionarios);
			leitor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ObservableList<Funcionarios> getDataList() {
		return dataList;
	}

	public void setDataList(ObservableList<Funcionarios> dataList) {
		this.dataList = dataList;
	}
}