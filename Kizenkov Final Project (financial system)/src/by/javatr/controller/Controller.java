package by.javatr.controller;

import by.javatr.controller.command.Command;
import by.javatr.controller.exception.*;
import by.javatr.resourse.TextConstants;

public class Controller {
    private final CommandProvider provider = new CommandProvider();

    public String execute(String request){
        String response;
        Command command;
        String commandName;

        char paramDelimiter = ' ';
        commandName = request.substring(0, request.indexOf(paramDelimiter));
        command = provider.getCommand(commandName);
        try {
            response = command.execute(request);
        } catch (SignUpControllerException e) {
            response = TextConstants.RESPONSE_SIGN_UP_FAIL;
        }catch (LogInControllerException e) {
            response = TextConstants.RESPONSE_LOG_IN_FAIL;
        }catch (DeleteUserControllerException e) {
            response = TextConstants.RESPONSE_DELETE_USER_FAIL;
        }catch (ChangeGainControllerException e) {
            response = TextConstants.RESPONSE_CHANGE_GAIN_FAIL;
        }catch (ChangeSpendControllerException e) {
            response = TextConstants.RESPONSE_CHANGE_SPEND_FAIL;
        } catch (WrongRequestControllerException e) {
            response = TextConstants.RESPONSE_WRONG_REQUEST;
        } catch (Exception e) {
            response = TextConstants.RESPONSE_OPERATION_FAIL;
        }
        return response;
    }
}
