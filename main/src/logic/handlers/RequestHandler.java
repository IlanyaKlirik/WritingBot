//TODO: написать обработчик запросов
// здесь основная работа и обращение либо к апи спеллера, либо к апи словаря
//либо просто к модулю подсчета слов, символов и авторских страниц

package logic.handlers;

import logic.User;
import logic.enums.UserState;
import logic.interfaces.Processor;

import java.util.ArrayList;
import java.util.List;

public class RequestHandler{

    public List<String> getAnswer(Processor processor, User user){
        List<String> answer = new ArrayList<>(processor.requestProcessing(user));

        if (answer.isEmpty()) {
            if (user.getState() == UserState.START) {
                user.setState(UserState.EXIT);
            }
            answer.add(PhrasesHandler.getUnknownPhrase());
        }

        return answer;
    }
}