package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Класс, в котором начинается работа программы и запускается метод start
 * для запуска главного окна программы на JavaFX.
 *
 * @author Трушенков Дмитрий 15ИТ18
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Поиск текста в текстовых файлах файловой системы");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 360, 315));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
