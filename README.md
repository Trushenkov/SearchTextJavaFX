# Поиск текста в текстовых файлах файловой системы

## Реализован 3 этап программы с графическим интерфейсом:

1. Ввод текста, который нужно найти.
2. Выбор начального каталога для поиска.
3. Поиск текстовых файлов в файловой системы согласно регулярному выражению, начиная с заданного каталога.
4. Запуск метода для поиска введенного сообщения в найденных текстовых файлах файловой системы.
5. Информирование пользователя о выполнении операции.
6. Запись результатов работы программы (путь к файлу, исходный текст, номер строки) в результирующий текстовый файл.<br><br>
![Screenshot](https://github.com/Trushenkov/SearchTextJavaFX/blob/master/src/sample/image.PNG)<br>
## Репозиторий содержит:
### <a href="https://github.com/Trushenkov/SearchTextJavaFX/blob/master/src/sample/sample.fxml">sample.fxml</a>
Файл разметки для определения пользовательского интерфейса приложения JavaFX. <br>
### <a href="https://github.com/Trushenkov/SearchTextJavaFX/blob/master/src/sample/Controller.java"> Controller.java </a> 
Класс, в котором обрабатываются события взаимодействия пользователя и интерфейса программы <br>
### <a href="https://github.com/Trushenkov/SearchTextJavaFX/blob/master/src/sample/Main.java"> Main.java </a> 
Главный класс для запуска программы.
### <a href="https://github.com/Trushenkov/SearchTextJavaFX/blob/master/src/sample/SearchFilesAndText.java"> SearchFilesAndText.java </a>
Потоковый класс для поиска текстовых файлов, начиная с указанной директории, используя регулярное выражение. Также в этом классе реализован поиск заданного текста в найденных текстовых файлах и запись информации в результирующий файл.<br>
### <a href="https://github.com/Trushenkov/SearchTextJavaFX/blob/master/src/sample/result.txt"> result.txt </a>
Результирующий файл. Хранит информацию о найденном тексте в виде:
1. путь к файлу,в котором найден текст; 2.исходный текст для поиска; 3. номер строки, в которой он найден.
