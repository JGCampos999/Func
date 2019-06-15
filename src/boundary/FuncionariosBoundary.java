package boundary;

import java.text.SimpleDateFormat;

import control.FuncionariosControl;
import entidade.Funcionarios;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FuncionariosBoundary extends Application {
	private FuncionariosControl control = new FuncionariosControl();
	private TableView<Funcionarios> tableView = new TableView<>();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Funcionarios f = new Funcionarios();
		BorderPane border = new BorderPane();
		tableView.setStyle(STYLESHEET_MODENA);
		Scene scene = new Scene(border, 850, 300);
		HBox box = new HBox();
		box.setSpacing(10);

		control.ler();
		createTableColumns();
		border.setCenter(tableView);
		BorderPane.setMargin(tableView, new Insets(25, 25, 10, 25));
		BorderPane.setAlignment(tableView, Pos.CENTER);

		stage.resizableProperty().setValue(Boolean.FALSE);
		stage.setScene(scene);
		stage.show();
	}

	private void createTableColumns() {
		tableView.setItems(control.getDataList());
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Funcionarios>() {
			@Override
			public void changed(ObservableValue<? extends Funcionarios> f, Funcionarios f1, Funcionarios f2) {
			}
		});

		TableColumn<Funcionarios, String> matriculaColumn = new TableColumn<>("Matricula");
		matriculaColumn.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getMatricula()));

		TableColumn<Funcionarios, String> pNomeColumn = new TableColumn<>("Primeiro Nome");
		pNomeColumn.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getPrimeiroNome()));

		TableColumn<Funcionarios, String> sNomeColumn = new TableColumn<>("Ultimo Nome");
		sNomeColumn.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getUltimoNome()));

		TableColumn<Funcionarios, String> emailColumn = new TableColumn<>("Email");
		emailColumn.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getEmail()));

		TableColumn<Funcionarios, String> dtNascColumn = new TableColumn<>("Data Nascimento");
		dtNascColumn.setCellValueFactory(
				item -> new ReadOnlyStringWrapper(sdf.format(item.getValue().getDataNascimento())));

		TableColumn<Funcionarios, String> cargoColumn = new TableColumn<>("Cargo");
		cargoColumn.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getCargo()));

		TableColumn<Funcionarios, String> gerenteColumn = new TableColumn<>("Matricula Gerente");
		gerenteColumn.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getMatriculaGerente()));

		tableView.getColumns().addAll(matriculaColumn, pNomeColumn, sNomeColumn, emailColumn, dtNascColumn, cargoColumn,
				gerenteColumn);
	}
}
