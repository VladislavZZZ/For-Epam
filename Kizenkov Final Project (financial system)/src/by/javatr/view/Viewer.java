package by.javatr.view;

import by.javatr.controller.Controller;
import by.javatr.resourse.TextConstants;
import by.javatr.view.console.ConsoleReader;
import by.javatr.view.console.exception.NoInputInLineException;
import by.javatr.view.console.exception.NoNumberInLineException;

public class Viewer {
    private Controller controller=new Controller();
    private String userInfo = null;
    private boolean isRunning = true;

    private String authorize() {
        ConsoleReader consoleReader = ConsoleReader.getInstance();
        System.out.println(TextConstants.MENU_SIGN_UP);
        System.out.println(TextConstants.MENU_LOG_IN);
        System.out.println(TextConstants.MENU_OUTER_EXIT);
        try {
            int answer = consoleReader.scanInt(System.in);
            switch (answer) {
                case 1: {
                    String request = TextConstants.REQUEST_SIGN_UP + " " + formUserInfo();
                    return callController(request);
                }
                case 2: {
                    String request = TextConstants.REQUEST_LOG_IN + " " + formUserInfo();
                    String response = callController(request);
                    if (response.contains(TextConstants.RESPONSE_USER_INFO)) {
                        this.userInfo = response.substring(response.indexOf('(') + 1, response.indexOf(')'));
                        return response.substring(0, response.indexOf('\n'));
                    }
                    return response;
                }
                case 3:
                    isRunning = false;
                    return TextConstants.MENU_FAREWELL;
                default:
                    return TextConstants.MENU_INVALID_INPUT;
            }
        } catch (NoNumberInLineException | NoInputInLineException e) {
            return TextConstants.MENU_INVALID_INPUT;
        }
    }

    private String callController(String request) {
        return controller.execute(request);
    }


    private String formUserInfo() throws NoInputInLineException {
        ConsoleReader scanner =ConsoleReader.getInstance();
        System.out.println(TextConstants.MENU_ENTER_LOGIN);
        String id = scanner.scanLine(System.in);
        System.out.println(TextConstants.MENU_ENTER_PASSWORD);
        String password = scanner.scanLine(System.in);
        return id + " " + password;
    }

    private String workWithAccount() {
        ConsoleReader scanner = ConsoleReader.getInstance();
        while (true) {
            System.out.println(TextConstants.MENU_CHANGE_GAIN);
            System.out.println(TextConstants.MENU_CHANGE_SPEND);
            System.out.println(TextConstants.MENU_SIGN_OUT);
            System.out.println(TextConstants.MENU_DELETE_ACCOUNT);
            System.out.println(TextConstants.MENU_INNER_EXIT);
            try {
                int answer = scanner.scanInt(System.in);
                switch (answer) {
                    case 2: {
                        System.out.println(TextConstants.MENU_NEW_GAIN);
                        double newIncome = scanner.scanDouble(System.in);
                        String request = TextConstants.REQUEST_CHANGE_GAIN + " " + userInfo + " " + newIncome;
                        return callController(request);
                    }
                    case 3: {
                        System.out.println(TextConstants.MENU_NEW_SPEND);
                        double newExpenses = scanner.scanDouble(System.in);
                        String request = TextConstants.REQUEST_CHANGE_SPEND + " " + userInfo + " " + newExpenses;
                        return callController(request);
                    }
                    case 5: {
                        String request = TextConstants.REQUEST_DELETE_USER + " " + userInfo + " " + formUserInfo();
                        String response = callController(request);
                        int spaceIndex = response.indexOf(' ');
                        if (response.substring(0, spaceIndex).equals(TextConstants.RESPONSE_OK)) {
                            userInfo = null;
                            return response.substring(spaceIndex + 1);
                        }
                        return response;
                    }
                    case 6:
                        isRunning = false;
                        return TextConstants.MENU_FAREWELL;
                    default:
                        System.out.println(TextConstants.MENU_INVALID_INPUT);
                        break;
                }
            } catch (NoNumberInLineException | NoInputInLineException e) {
                System.out.println(TextConstants.MENU_INVALID_INPUT);
            }
        }

    }

    public void start() {
        while (isRunning) {
            System.out.println(authorize());
            while (userInfo != null && isRunning) {
                System.out.println(workWithAccount());
            }
        }
    }
}
