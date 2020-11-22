package dad.javafxml.enviaremail;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

	private EnviaremailController controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		controller=new EnviaremailController();
		
		Scene scene= new Scene(controller.getView(), 800, 400);
		
		primaryStage.setTitle("Enviar email");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);

	}
}
