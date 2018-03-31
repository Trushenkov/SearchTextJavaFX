package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Класс, в котором с помощью JavaFX реализован ввод текста для поиска, выбор стартового
 * каталога для поиска, и запуск поиска текста в текствовых файлах файловой системы.
 *
 * @author Трушенков Дмитрий 15ИТ18
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
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
