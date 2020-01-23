package by.javatr.dao.impl;

import by.javatr.bean.User;
import by.javatr.dao.UserDAO;
import by.javatr.dao.exception.DAOException;
import by.javatr.dao.validation.Validator;
import by.javatr.resourse.TextConstants;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileUserDAO implements UserDAO {
    private File file;
    private static final int NUMBER_OF_TOKENS_IN_LINE = 2;

    public FileUserDAO() {
        file = new File(TextConstants.USER_FILE_NAME);
    }
    @Override
    public void signUp(String login, String password) throws DAOException {
        if (findUser(login) != null) {
            throw new DAOException();
        }
        addUser(login, password);
    }

    @Override
    public User logIn(String login, String password) throws DAOException {
        if(!isValidPassword(login, password)){
            throw new DAOException(TextConstants.INVALID_LOGIN_OR_PASSWORD);
        }
        return findUser(login);
    }

    @Override
    public void deleteUser(String login) throws DAOException {
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

    private User findUser(String login) throws DAOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(TextConstants.SPACE_DELIMITER);
                if(!Validator.getInstance().isValidLine(fields, NUMBER_OF_TOKENS_IN_LINE)){
                    throw new DAOException(TextConstants.READING_ERROR);
                }

                if (login.equals(fields[0])) {
                    User user = new User(login,fields[1]);
                    return user;
                }
            }
            return null;
        } catch (FileNotFoundException e) {
            throw new DAOException(TextConstants.FILE_NOT_FOUND, e);
        } catch (IOException e) {
            throw new DAOException(TextConstants.READING_ERROR, e);
        }
    }

    private void addUser(String login, String password) throws DAOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(login + " " + password + "\n");
        } catch (IOException e) {
            throw new DAOException(TextConstants.WRITING_ERROR, e);
        }
    }

    private boolean isValidPassword(String login, String password) throws DAOException {
        User user = findUser(login);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }
}
