package sample;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controlador {

	@FXML
	Label logo;

	@FXML
	Pane spinner;

	@FXML
	AnchorPane PanePrinc;

	@FXML
	Label labelsaludo;

	@FXML
	Label labelnombre;

	public void showHome() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Principal.class.getResource("menu.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage homeStage = new Stage();
			homeStage.setTitle("Main Menu");
			Scene scene = new Scene(page);
			homeStage.setScene(scene);
			homeStage.setMaximized(true);
			homeStage.show();
			System.out.println("second stage ok");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("second stage ko");
		}
	}

	public void initialize() {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.1), logo);
		translateTransition.setByY(700);
		translateTransition.play();

		TranslateTransition translateTransition0 = new TranslateTransition(Duration.seconds(0.1), labelnombre);
		translateTransition0.setByY(700);
		translateTransition0.play();

		TranslateTransition translateTransition00 = new TranslateTransition(Duration.seconds(0.1), labelsaludo);
		translateTransition00.setByY(700);
		translateTransition00.play();

		translateTransition.setOnFinished(event -> {

			TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(1), logo);
			translateTransition1.setByY(-700);

			translateTransition1.play();

			translateTransition1.setOnFinished(event1 -> {

				labelnombre.setVisible(true);

				TranslateTransition translateTransition11 = new TranslateTransition(Duration.seconds(1), labelnombre);
				translateTransition11.setByY(-700);
				translateTransition11.play();

				translateTransition11.setOnFinished(event2 -> {

					labelsaludo.setVisible(true);
					TranslateTransition translateTransition111 = new TranslateTransition(Duration.seconds(1),
							labelsaludo);
					translateTransition111.setByY(-700);
					translateTransition111.play();

					translateTransition111.setOnFinished(event3 -> {
						spinner.setVisible(true);

						FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), spinner);
						fadeTransition.setFromValue(0);
						fadeTransition.setToValue(1);
						fadeTransition.play();

						fadeTransition.setOnFinished(event4 -> {

							FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(2), PanePrinc);
							fadeTransition1.setFromValue(1);
							fadeTransition1.setToValue(0.1);
							fadeTransition1.play();

							fadeTransition1.setOnFinished(event5 -> {
								Stage thisStage = (Stage) PanePrinc.getScene().getWindow();
								thisStage.close();
								showHome();
								System.out.println("------- splash screen is closed --------");
							});

						});

					});

				});
			});

		});

	}

}
