package service.logs;

import java.util.ArrayList;

public class Logger implements LoggerService
{
    private final ArrayList<String> loggedActions = new ArrayList<>();

    @Override
    public void registerAction(String action)
    {
        loggedActions.add(action);
    }

    @Override
    public void showActions()
    {
        System.out.println("Actions: " + loggedActions);
    }
}
