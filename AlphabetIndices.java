/**
 * The AlphabetIndices class provides methods to work with the Russian alphabet indices.
 * It contains a static array representing the Russian alphabet and methods to find the index
 * of a character in the alphabet and to check if a character is valid in the alphabet.
 */
public class AlphabetIndices {

    // Static array representing the Russian alphabet and special symbols
    static char[] russianAlphabet = {
            'А', 'Б', 'В', '.', 'Г', 'Д', 'Е', 'Ё', ',', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М',
            'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', ' ', 'Ч', 'Ш', 'Щ', 'Ъ',
            'Ы', 'Ь', '"', 'Э', 'Ю', ':', 'Я', 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', '-', 'р', 'с',  '!', 'т', 'у', 'ф', 'х',
            'ц', 'ч', 'ш', '?', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'
    };

    /**
     * Finds the index of the given character in the Russian alphabet array.
     *
     * @param ch The character to find the index of.
     * @return The index of the character in the alphabet, or -1 if not found.
     */
    public int findCharacterIndex(char ch) {
        for (int i = 0; i < russianAlphabet.length; i++) {
            if (ch == russianAlphabet[i]) {
                return i;
            }
        }
        return -1; // Символ не найден
    }

    /**
     * Checks if the given character is valid in the Russian alphabet.
     *
     * @param ch The character to check.
     * @return True if the character is valid in the alphabet, false otherwise.
     */
    public static boolean isCharacterValid(char ch) {
        for (char validCh : russianAlphabet) {
            if (ch == validCh) {
                return true;
            }
        }
        return false;
    }
}