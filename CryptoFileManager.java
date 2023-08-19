import java.io.*;

/**
 * The CryptoFileManager class manages file operations related to encryption and decryption.
 * It provides methods to read file text, write to common files, and write to encrypted files.
 */
public class CryptoFileManager {
    //TODO разобраться с Валерой почему поля fileText и file не определялись (кидали NPE) пока я их не сделал static
    static StringBuilder fileText;

    public StringBuilder getFileText() {
        return fileText;
    }

    public static File file;

    public void setFile(File file) {
        CryptoFileManager.file = file;
    }

    /**
     * Prompts the user to input a file path and reads the content of the file.
     * Handles cases of non-existing files and empty files.
     */
    public void getNewFile() {
        System.out.println("Введите путь к файлу");
        while (file == null) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String filePath = br.readLine();

                File file = new File(filePath);

                if (file.exists()) {
                    try {
                        readFileText(filePath);
                        setFile(file);
                    } catch (EmptyFileException e) {
                        System.out.println("Файл пустой");
                    }
                } else {
                    System.out.println("Файл не существует по указанному пути. \n" +
                            "Попробуйте ввести путь к файлу еще раз.");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //НАМ БЫ ТУТ ЗАКРЫТЬ BR, НО ТОГДА НЕ РАБОТАЕТ ОСТАЛЬНАЯ ЧАСТЬ ПРОГРАММЫ ИБО System.in ПАДАЕТ.
        // Но мы его закрываем сразу в следующем методе
    }

    /**
     * Reads the content of a file specified by the given file path.
     *
     * @param filePath The path of the file to be read.
     * @throws EmptyFileException If the file is empty.
     */
    public void getNewFile(String filePath) {
        while (file == null) {
            System.out.println("Введите путь к файлу");
            File file = new File(filePath);

            if (file.exists()) {
                try {
                    readFileText(filePath);
                    setFile(file);
                } catch (EmptyFileException e) {
                    System.out.println("Файл пустой");
                }
            } else {
                System.out.println("Файл не существует по указанному пути. \n" +
                        "Попробуйте ввести путь к файлу еще раз.");
            }
        }
    }
    //TODO: We should close the BufferedReader here,
    // but then the rest of the program wouldn't work because of issues with System.in.

    /**
     * Reads the content of the file specified by the given file path.
     * If the file is not empty, stores the content in the fileText variable.
     *
     * @param filePath The path of the file to be read.
     * @throws EmptyFileException If the file is empty.
     */
    public void readFileText(String filePath) throws EmptyFileException {
        StringBuilder text = new StringBuilder();
        AlphabetIndices alphabet = new AlphabetIndices();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line);
            }

        } catch (IOException ex) {
            System.out.println("Ошибка при чтении файла: " + ex.getMessage());
            throw new RuntimeException(ex);
        }

        if (text.length() > 0) {
            fileText = text;
        } else {
            throw new EmptyFileException();
        }
    }

    /**
     * Writes the provided text to a common output file or displays it if marker is negative.
     *
     * @param text   The text to be written.
     * @param marker A marker indicating success (positive) or failure (negative).
     */
    public void writeInCommonFile(StringBuilder text, int marker) {
        String outputFile = file.getParent() + "NO MORE SECRETS.txt";
        if (marker > 0) {
            try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
                fileOutputStream.write(text.toString().getBytes());
                System.out.println("Файл расшифрован и находится тут: " + outputFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println(text);
            System.out.println("Не удалось расшифровать файл");
        }
    }

    /**
     * Writes the provided text to a file designated for encrypted content.
     *
     * @param text The text to be written.
     */
    public void writeInCryptoFile(StringBuilder text) {

        String outputFile = file.getParent() + "TOP SECRET.txt";
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            fileOutputStream.write(text.toString().getBytes());
            System.out.println("Файл зашифрован и находится тут: " + outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}