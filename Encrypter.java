/**
 * The Encrypter class provides methods to encrypt text using a displacement-based algorithm.
 * This class takes a StringBuilder containing the original text, applies a specified displacement
 * to each character, and generates the corresponding encrypted text.
 */
public class Encrypter {

    /**
     * Encrypts the given text using a displacement algorithm and writes the encrypted text to a file.
     */
    public void encrypt() {
        AlphabetIndices alphabet = new AlphabetIndices();
        CryptoFileManager file = new CryptoFileManager();
        StringBuilder text = file.getFileText();

        StringBuilder cryptoText = new StringBuilder(); // Encrypted text
        char[] textToCrypt = text.toString().toCharArray();

        int bias = 33;                                  // Magic number for displacement

        // Apply displacement to each character
        for (int i = 0; i < textToCrypt.length; i++) {
            if (!AlphabetIndices.isCharacterValid(textToCrypt[i])) {
                continue;
            }
            int indexOfSymbol = alphabet.findCharacterIndex(textToCrypt[i]);
            int displasment = indexOfSymbol + bias;
            if (displasment >= AlphabetIndices.russianAlphabet.length) {
                cryptoText.append(AlphabetIndices.russianAlphabet[displasment -
                        AlphabetIndices.russianAlphabet.length]);
            } else {
                cryptoText.append(AlphabetIndices.russianAlphabet[displasment]);
            }
        }
        // Write the encrypted text to a file
        file.writeInCryptoFile(cryptoText);
    }
}