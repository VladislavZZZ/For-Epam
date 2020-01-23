package by.javatr.dao.impl;

import by.javatr.bean.Financial;
import by.javatr.dao.FinancialDAO;
import by.javatr.dao.exception.DAOException;
import by.javatr.dao.validation.Validator;
import by.javatr.resourse.TextConstants;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileFinancialDAO implements FinancialDAO {
    private File file;
    private static final int NUMBER_OF_TOKENS_IN_LINE = 3;

    public FileFinancialDAO(){
        file = new File(TextConstants.ACCOUNT_FILE_NAME);
    }

    @Override
    public Financial getFinancial(String login) throws DAOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String[] fields;
            while ((line = reader.readLine()) != null) {

                fields = line.split(TextConstants.SPACE_DELIMITER);
                if(!Validator.getInstance().isValidLine(fields, NUMBER_OF_TOKENS_IN_LINE)){
                    throw new DAOException(TextConstants.READING_ERROR);
                }

                if (fields[0].equals(login)) {
                    Financial financial = new Financial();
                    financial.setLogin(fields[0]);
                    financial.setGain(Double.parseDouble(fields[1]));
                    financial.setSpend(Double.parseDouble(fields[2]));
                    return financial;
                }
            }
            throw new DAOException(TextConstants.ID_NOT_FOUND);
        } catch (FileNotFoundException e) {
            throw new DAOException(TextConstants.FILE_NOT_FOUND, e);
        } catch (IOException e) {
            throw new DAOException(TextConstants.READING_ERROR, e);
        } catch (NumberFormatException e) {
            throw new DAOException(TextConstants.INVALID_BALANCE, e);
        }
    }

    @Override
    public void updateFinancial(Financial financial) throws DAOException {
        File newFile = new File(TextConstants.NEW_FILE_DEFAULT_NAME);
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))
        ) {
            String line;
            String[] fields;

            while ((line = reader.readLine()) != null) {
                fields = line.split(TextConstants.SPACE_DELIMITER);
                if(!Validator.getInstance().isValidLine(fields, NUMBER_OF_TOKENS_IN_LINE)){
                    throw new DAOException(TextConstants.READING_ERROR);
                }

                if (fields[0].equals(financial.getLogin())) {
                    line = fields[0] + " " + financial.getGain() +
                            " " + financial.getSpend();
                }
                writer.write(line + '\n');
            }
        } catch (FileNotFoundException e) {
            throw new DAOException(TextConstants.FILE_NOT_FOUND, e);
        } catch (IOException e) {
            throw new DAOException(TextConstants.READING_ERROR, e);
        } catch (NumberFormatException e) {
            throw new DAOException(TextConstants.INVALID_BALANCE, e);
        }
        try {
            Files.copy(newFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new DAOException(TextConstants.READING_ERROR, e);
        }
    }

    @Override
    public void addFinancial(Financial financial) throws DAOException {
        try{
            getFinancial(financial.getLogin());
            throw new DAOException(TextConstants.ACCOUNT_ALREADY_EXISTS);
        } catch (DAOException e){

            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
                writer.write(financial.getLogin() + " " + financial.getGain() +
                        " " + financial.getSpend() + "\n");
            } catch (IOException ex) {
                throw new DAOException(TextConstants.WRITING_ERROR, ex);
            }
        }
    }

    @Override
    public void deleteFinancial(String login) throws DAOException {
        File newFile = new File(TextConstants.NEW_FILE_DEFAULT_NAME);
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))
        ) {
            String line;
            String[] fields;

            while ((line = reader.readLine()) != null) {
                fields = line.split(TextConstants.SPACE_DELIMITER);
                if(!Validator.getInstance().isValidLine(fields, NUMBER_OF_TOKENS_IN_LINE)){
                    throw new DAOException(TextConstants.READING_ERROR);
                }

                if (fields[0].equals(login)) {
                    continue;
                }
                writer.write(line + '\n');
            }
        } catch (FileNotFoundException e) {
            throw new DAOException(TextConstants.FILE_NOT_FOUND, e);
        } catch (IOException e) {
            throw new DAOException(TextConstants.READING_ERROR, e);
        } catch (NumberFormatException e) {
            throw new DAOException(TextConstants.INVALID_BALANCE, e);
        }
        try {
            Files.copy(newFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new DAOException(TextConstants.READING_ERROR, e);
        }
    }
}
