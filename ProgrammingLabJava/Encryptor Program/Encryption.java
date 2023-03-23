/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 2
*/

import java.util.ArrayList;

class Encryption
{
    ArrayList<Character> symbols = new ArrayList<Character>();
    ArrayList<Character> alphabets = new ArrayList<Character>();
    public Encryption(){
        symbols.add('!');
        symbols.add('@');
        symbols.add('#');
        symbols.add('$');
        symbols.add('^');
        symbols.add('&');
        symbols.add('*');
        symbols.add('(');
        symbols.add(')');
        symbols.add('_');
        symbols.add('-');
        symbols.add('+');
        symbols.add('=');
        symbols.add('?');
        symbols.add(',');
        symbols.add('{');
        symbols.add('}');
        symbols.add('[');
        symbols.add(']');
        symbols.add('/');
        symbols.add('|');
        symbols.add(';');
        symbols.add(':');
        symbols.add('.');
        symbols.add('<');
        symbols.add('>');
        for(char letter='a';letter<='z';letter++)
        {
            alphabets.add(letter);
        }
    }

    public char return_alphabet(int index){
        return alphabets.get(index);
    }

    public int return_alphabet_index(char letter){
        return alphabets.indexOf(letter);
    }
    public int return_symbol_index(char letter){
        return symbols.indexOf(letter);
    }

    public char return_symbol(int index){
        return symbols.get(index);
    }

    public String encrypt_message(String message){
        String encrypted;
        message = message.toLowerCase();
        char[] charArray = message.toCharArray();
        int[] index = new int[charArray.length];
        char[] en = new char[charArray.length];

        for (char c : charArray) {
            if (!alphabets.contains(c)) {

                return "Invalid character detected";

            } else {
                for (int j = 0; j < charArray.length; j++) {
                    index[j] = return_alphabet_index(charArray[j]);
                    en[j] = return_symbol(index[j]);
                }
                encrypted = new String(en);
                return "Encrypted message: " + encrypted;
            }
        }
        return "Error";
    }
    public String decrypt_message(String message){
        String decrypted;
        message = message.toLowerCase();
        char[] charArray = message.toCharArray();
        int[] index = new int[charArray.length];
        char[] de = new char[charArray.length];

        for (char c : charArray) {
            if (!symbols.contains(c)) {

                return "Invalid character detected";

            } else {
                for (int j = 0; j < charArray.length; j++) {
                    index[j] = return_symbol_index(charArray[j]);
                    de[j] = return_alphabet(index[j]);
                }
                decrypted = new String(de);
                return "Decrypted message: " + decrypted;
            }
        }
        return "Error";
    }
}