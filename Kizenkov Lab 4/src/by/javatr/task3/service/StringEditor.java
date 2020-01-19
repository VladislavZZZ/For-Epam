package by.javatr.task3.service;

import by.javatr.console.ConsoleReader;
import by.javatr.task3.dao.MessageDAO;
import by.javatr.task3.dao.exception.DAOException;
import by.javatr.task3.dao.factory.DAOFactory;
import by.javatr.task3.service.exception.ErrorDataConnectionException;
import by.javatr.task3.service.exception.InvalidOrdinaryNumberException;
import by.javatr.task3.service.validation.StringMethodsValidator;



public class StringEditor {
    private static final String DEFAULT="Hello, somebody";
    private static final char O='o';
    private static final char A='a';
    private static final char P='p';
    private static final String FIND_REG_EXP="pa";
    private static final String TO_REPLACE="po";
    private static final String SPACE=" ";
    private String string;

    @Override
    public String toString() {
        return string;
    }

    public StringEditor() {
        this.string = DEFAULT;
    }

    public void fillFromFile(String filePath) throws ErrorDataConnectionException {
        DAOFactory factory=DAOFactory.getInstance();
        MessageDAO message=factory.getFileSimpleArrayDAO();
        try {
           string= message.readMessage(filePath);
        }catch (DAOException ex){
            throw new ErrorDataConnectionException("Error to connect with file");
        }
    }

    public void fillFromConsole(){
        ConsoleReader consoleReader=new ConsoleReader();
        string=consoleReader.readString();
    }

    public void replaceSymbol(char symbol,int number,boolean isRegExp) throws InvalidOrdinaryNumberException {
        if(!StringMethodsValidator.isValidNumber(number))
            throw new InvalidOrdinaryNumberException("Invalid number");
        if (isRegExp) replaceSymbolRegExp(symbol, number);
        else replaceSymbol(symbol, number);
    }

    public void fixText(boolean isRegExp){
        if (isRegExp) fixTextRegExp();
        else fixText();
    }

    public void changeSubstringToAnother(int length, String newSubstring,boolean isRegExp)
            throws InvalidOrdinaryNumberException{
        if (!StringMethodsValidator.isValidNumber(length))throw new InvalidOrdinaryNumberException("incorrect length");
        if(!isRegExp) changeSubstringToAnotherRegExp(length,newSubstring);
        else changeSubstringToAnother(length,newSubstring);
    }

    public void eraseAllNonWordSymbols(boolean isRegExp){
        if (isRegExp) eraseAllNonWordSymbols();
        else eraseAllNonWordSymbolsRegExp();
    }

    public void eraseAllWordsStartsWithConsonant(int length,boolean isRegExp){

    }

    private void replaceSymbol(char symbol,int number){
        StringBuilder sb=new StringBuilder(string.length());
        int count=0;
        for (int i=0;i<string.length();i++){
            if (string.charAt(i)!=' '){
                count++;
                if (count==number){
                    sb.append(symbol);
                } else {
                    sb.append(string.charAt(i));
                }
            }else{
                sb.append(string.charAt(i));
                count=0;
            }
        }
        string=sb.toString();
    }

    private void replaceSymbolRegExp(char symbol, int number){
        String[] words=string.split(SPACE);
        StringBuilder sb=new StringBuilder(string.length());
        for (String word: words){
            if (word.length()<=number){
                word=word.replace(word.charAt(number-1),symbol);
            }
            sb.append(word).append(SPACE);
        }
        string=sb.toString();
    }

    private void fixText(){
        StringBuilder sb=new StringBuilder(string.length());
        for (int i=0;i<string.length()-1;i++){
            if (string.charAt(i)==P && string.charAt(i+1)==A){
                sb.append(O);
            }else sb.append(string.charAt(i));
        }
        string=sb.toString();
    }

    private void fixTextRegExp(){
        string=string.replaceAll(FIND_REG_EXP,TO_REPLACE);
    }

    private void changeSubstringToAnother(int length,String newSubstring){
        StringBuilder sb=new StringBuilder();
        int begin=0,count=0;
        for (int i=0;i<string.length();i++){
            if (string.charAt(i)!=' ' || string.charAt(i)!='.' || string.charAt(i)!=',' ||string.charAt(i)!='!' ||
                    string.charAt(i)!='?'){
                count++;
                if (count==1){
                    begin=i;
                }
            }else{
                if (count==length){
                    sb.append(newSubstring);
                    begin=i;
                }
                for (int j=begin;j<=i;j++){
                    sb.append(string.charAt(i));
                }
                count=0;
            }
        }
        string=sb.toString();
    }

    private void changeSubstringToAnotherRegExp(int length,String newSubstring){
        string=string.replaceAll(" \\w{"+length+"} ",newSubstring);
    }

    private void eraseAllNonWordSymbols(){
        char[] str=string.toCharArray();
        StringBuilder sb=new StringBuilder();
        boolean isWhitespace=false;
        for (char symbol:str){
            if (Character.isLetter(symbol)||Character.isWhitespace(symbol)){
                if (Character.isWhitespace(symbol)){
                  if (!isWhitespace){
                      sb.append(symbol);
                      isWhitespace=true;
                  }
                }else{
                    sb.append(symbol);
                    isWhitespace=false;
                }
            }
        }
       string=sb.toString();
    }

    private void eraseAllNonWordSymbolsRegExp(){
        string=string.replaceAll("(?u)[^\\pL ]"," ");
    }

    private void eraseAllWordsStartsWithConsonant(int length){
        StringBuilder sb=new StringBuilder();
        boolean isBeginOfWord=false;
        int begin=0;
        int count=0;
        for (int i=0;i<string.length();i++){
            if (string.charAt(i)!=' ' || string.charAt(i)!='.' || string.charAt(i)!=',' ||string.charAt(i)!='!' ||
                    string.charAt(i)!='?'){
                if (isConsonant(string.charAt(i)) && count==0){
                    begin=i;
                    isBeginOfWord=true;
                }
                if(isBeginOfWord) {

                    count++;
                }
            }else{
                if (count==length){
                    begin=i;
                }
                for (int j=begin;j<=i;j++){
                    sb.append(string.charAt(i));
                }
                count=0;
            }
        }
    }

    private void eraseAllWordsStartsWithConsonantRegExp(int length){
        string=string.replaceAll(" [^aouiye]\\w{"+(length-1)+"} "," ");
    }

    private boolean isConsonant(char symbol){
        switch (symbol){
            case 'a':
            case 'o':
            case 'u':
            case 'e':
            case 'y':
            case 'i':
                return true;
            default:
                return false;
        }
    }

}
