package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.*;

/**
 * Класс, в котором отслеживается взаимодействие пользователя с главным окном программы и обрабатываются события.
 *
 * @author Трушенков Дмитрий 15ИТ18
 */
public class Controller {

    private static String result_file = "src\\sample\\result.txt";

    private static File startDirectory;

    @FXML
    private Label path;

    @FXML
    private TextField inputMessage;

    @FXML
    private Label status;


    /**
     * Обработка события при нажатии кнопки "Start search".
     */
    public void start_search() {
        try {
            SearchFilesAndText.main(startDirectory, String.valueOf(inputMessage.getCharacters()));
        } catch ( IOException e) {
                e.printStackTrace();
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(result_file)))) {

            if (bufferedReader.read() == -1) {
                status.setText("Результирующий файл пуст.\nНичего не найдено.");
            } else {
                status.setText("Поиск выполнен. Откройте result.txt\nПуть: SearchTextInFiles/src/sample/result.txt");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Обработка события при нажатии кнопки "Select start directory".
     */
    public void select_directory() {
        DirectoryChooser directory = new DirectoryChooser();
        directory.setTitle("Select directory for open");
        startDirectory = new File(String.valueOf(directory.showDialog(new Stage())));
        path.setText(startDirectory.getPath());
        if (startDirectory.getPath() != null) {
            status.setText("");
        }
    }

}

