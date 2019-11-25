package logic;

import logic.enums.Command;
import logic.handlers.RequestHandler;
import logic.interfaces.Input;
import logic.interfaces.Output;
import logic.interfaces.Processor;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainLoop {

    private RequestHandler requestHandler;

    public MainLoop() {
        requestHandler = new RequestHandler();
    }

    public void startLoop(Input input, Output output) throws InterruptedException {
        Map<Long, User> users = new HashMap<Long, User>();

        while(true){
            Thread.sleep(10);

            Request request = input.getRequest();
            if (request == null) {
                continue;
            }

            Long id = request.getUserId();

            User user = null;

            if (users.containsKey(id)){
                user = users.get(id);
            }
            else{
                user = new User(id);
                users.put(id, user);
            }

            Command command = Command.valueByString(request.getUsersRequest());
            Processor processor = (command == null ? new RequestProcessor(request.getUsersRequest()) : command);

            List<String> messages = requestHandler.getAnswer(processor, user);
            output.sendMessage(messages, user);
        }
    }
}
