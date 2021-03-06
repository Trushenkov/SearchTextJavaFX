package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Потоковый класс для поиска заданного текста в найденных с помощью
 * шаблона регулярного выражения файлах файловой системы, начиная с указанной директории.
 *
 * @author Трушенков Дмитрий 15ИТ18
 */
public class SearchTextAndWrite extends Thread {

    private File file;

    private String message;

    private static volatile BufferedWriter result;

    private static ArrayList<SearchTextAndWrite> arrayListOfThreads;

    SearchTextAndWrite(File file, String message) {
        this.file = file;
        this.message = message;
    }

    /**
     * Метод для записи информации о найденном тексте в текстовый файл.
     * Информация записывается в виде:
     * 1. путь к файлу; 2.сообщение, которое нужно было найти; 3. номер строки, в которой найдено сообщение.
     *
     * @param str информация, которую нужно записать в текстовый файл
     */
    private synchronized void writeFoundedMessage(String str) {
        try {
            result.write(str + "\n");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void run() {

        String string;
        Pattern searchStr = Pattern.compile(message);
        Matcher mSearchStr;

        try (BufferedReader inFile = new BufferedReader(new FileReader(file))) {
            for (int i = 1; (string = inFile.readLine()) != null; i++) {

                mSearchStr = searchStr.matcher(string);

                if (mSearchStr.find()) {
                    writeFoundedMessage("Path: " + file.getPath() + "; Message for search: " + mSearchStr.group() +
                            "; Line : " + i);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для начала поиска текстовых файлов, а также для вызова метода для ожидания
     * завершения потоков поиска текста в текстовом файле.
     *
     * @param path    путь начальной директории
     * @param message сообщение для поиска
     */
    public static void main(File path, String message) throws IOException {

        result = new BufferedWriter(new FileWriter("src\\sample\\result.txt"));

        arrayListOfThreads = FindTxtFiles.findFiles(path,message);

        waitForDieThreads(arrayListOfThreads);

        result.close();

    }

    /**
     * Метод для ожидания, пока потоки, которые ищут сообщение в текстовых файлах, завершат свое выполнение.
     *
     * @param searchMessagesList arraylist, содерщащий потоки для поиска текста в текстовых файлах
     */
    private static void waitForDieThreads(ArrayList<SearchTextAndWrite> searchMessagesList) {
        try {
            for (SearchTextAndWrite thread : searchMessagesList) {
                if (thread.isAlive()) {
                    thread.join();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
