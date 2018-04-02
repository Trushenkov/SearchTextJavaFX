package sample;

import java.io.File;
import java.util.ArrayList;

/**
 * Класс для поиска текстовых файлов и запуска потоков для поиска текста в найденных текстовых файлах.
 *
 * @author Трушенков Дмитрий 15ИТ18
 */
public class FindTxtFiles {

    /**
     * Метод для поиска текстовых файлов в файловой системе и
     * запуска потока для поиска заданного текста в найденных файлах.
     *
     * @param pathDirectory     путь начальной директории
     * @param messageForSearch  текст для поиска
     * @return arrayList        arrayList, содержащий потоки для поиска текста в файлах txt
     */
    public static ArrayList findFiles(File pathDirectory, String messageForSearch) {
        ArrayList<SearchTextAndWrite> arrayList = new ArrayList<>();
        try {
            File[] files = pathDirectory.listFiles();
            assert files != null;
            for (File file : files) {
                if (file.isFile() && file.getName().matches(".*\\.txt$")) {

                    arrayList.add(new SearchTextAndWrite(file, messageForSearch));
                    arrayList.get(arrayList.size() - 1).start();

                } else if (file.isDirectory()) {
                    findFiles(file, messageForSearch);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

}
