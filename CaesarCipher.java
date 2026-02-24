/**
 * @(#)CaesarCipher.java
 *
 *
 * @author
 * @version 1.00 2025/2/20
 */


public class CaesarCipher {

	private char[] alphabet;
	private char[] shifted;
	private int shift;

    public CaesarCipher() {
        alphabet = new char[26];
        shifted = new char[26];
        shifter(0);

        for(int i = 0; i < alphabet.length; i++)
        {
            alphabet[i] = "abcdefghijklmnopqrstuvwxyz".charAt(i);
        }
        
        shifted = alphabet;
    }

    public CaesarCipher(int num){
        alphabet = new char[26];
        shifted = new char[26];
        shifter(num);

        for(int i = 0; i < alphabet.length; i++)
        {
            alphabet[i] = "abcdefghijklmnopqrstuvwxyz".charAt(i);
        }


        for(int i = 0; i<alphabet.length; i++)
        {
            shifted[(i + shift) % 26] = alphabet[i];
        }
    }

    public String encrypt(String message){
        String encrypted = "";
        boolean foundIt;

        for(int i = 0; i < message.length(); i++)
        {
            foundIt = false;

            for(int x = 0; x < alphabet.length; x++)
            {
                if(alphabet[x] == message.charAt(i))
                {
                    encrypted += shifted[x];
                    foundIt = true;
                }
            }
            if (!foundIt)
                encrypted += message.charAt(i);
        }

        return "" + encrypted;
    }

    public String decrypt(String message){
         String decrypted = "";
        boolean foundIt;

        for(int i = 0; i < message.length(); i++)
        {
            foundIt = false;

            for(int x = 0; x < shifted.length; x++)
            {
                if(shifted[x] == message.charAt(i))
                {
                    decrypted += alphabet[x];
                    foundIt = true;
                }
            }
            if (!foundIt)
                decrypted += message.charAt(i);
        }
        return "" + decrypted;
    }

    public void shifter(int num){
        shift = num;

        for(int i = 0; i<alphabet.length; i++)
        {
            shifted[(i + shift) % 26] = alphabet[i];
        }
    }



}
