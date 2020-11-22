package dad.javafxml.enviaremail;

import java.io.IOException;


import java.net.URL;
import java.util.ResourceBundle;
import org.apache.commons.mail.EmailException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EnviaremailController implements Initializable{

	//model
	private EnviaremailModel model= new EnviaremailModel();
	
	//vista
	 	@FXML
	    private GridPane Gridp;

	    @FXML
	    private TextField Destinatario;

	    @FXML
	    private TextField Asunto;

	    @FXML
	    private HBox Hboxcc;

	    @FXML
	    private TextField Correo;

	    @FXML
	    private TextField Contraseña;

	    @FXML
	    private HBox Hbserv;

	    @FXML
	    private TextField Ipservidor;

	    @FXML
	    private TextField Puerto;

	    @FXML
	    private VBox VBbut;

	    @FXML
	    private Button Benviar;

	    @FXML
	    private Button Bvaciar;

	    @FXML
	    private Button Bcerrar;

	    @FXML
	    private TextArea Mensaje;

	    @FXML
	    private CheckBox conexionSSL;
	    
	    
	    public EnviaremailController() throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlT/View.fxml"));
			loader.setController(this);
			loader.load();
		}
	    @Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}

		public GridPane getView() {
			return Gridp;
		}

	    @FXML
	    private void ActBcerrar(ActionEvent event) {
	    	Platform.exit();
	    }

	    @FXML
	    private void ActBenviar(ActionEvent event) throws EmailException{
	    	model.getEmail().setHostName(Ipservidor.getText());
	    	model.getEmail().setSmtpPort(Integer.parseInt(Puerto.getText()));
	    	model.getEmail().setAuthentication(Correo.getText(), Contraseña.getText());
	    	model.getEmail().setSSLOnConnect(conexionSSL.isSelected());
	    	model.getEmail().setFrom(Correo.getText());
	    	model.getEmail().setSubject(Asunto.getText());
	    	model.getEmail().setMsg(Mensaje.getText());
	    	model.getEmail().addTo(Destinatario.getText());
	    	model.getEmail().send();
	    	
	    }
	    @FXML
	    private void ActBvaciar(ActionEvent event) {
	    	Ipservidor.clear();
	    	Puerto.clear();
	    	Correo.clear();
	    	Contraseña.clear();
	    	conexionSSL.setSelected(false);
	    	Destinatario.clear();
	    	Asunto.clear();
	    	Mensaje.clear();
	    }

	}

