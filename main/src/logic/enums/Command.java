package logic.enums;

import logic.User;
import logic.handlers.PhrasesHandler;
import logic.interfaces.Processor;

import java.util.ArrayList;
import java.util.List;

public enum Command implements Processor{
    START (PhrasesHandler.getStartCommand()) {
        @Override
        public List<String> requestProcessing(User user) {
            List<String> answer = new ArrayList<>();

            user.setState(UserState.DIALOG);

            answer.add(PhrasesHandler.getStartPhrase());
            return answer;
        }
    },
    HELP (PhrasesHandler.getHelpCommand()) {
        @Override
        public List<String> requestProcessing(User user) {
            List<String> answer = new ArrayList<>();

            answer.add(user.getState().getDescription());

            return answer;
        }
    },
    EXIT (PhrasesHandler.getExitCommand()) {
        @Override
        public List<String> requestProcessing(User user) {
            List<String> answer = new ArrayList<>();

            if (user.getState() == UserState.DIALOG) {
                user.setState(UserState.EXIT);

                answer.add(PhrasesHandler.getEndPhrase());
            }
            else if (user.getState() == UserState.STAT) {
                user.setState(UserState.DIALOG);

                answer.add(PhrasesHandler.getEndStatPhrase());
            }
            else if (user.getState() == UserState.DICT) {
                user.setState(UserState.DIALOG);

                answer.add(PhrasesHandler.getEndDictPhrase());
            }
            else if (user.getState() == UserState.POEM | user.getState() == UserState.PROSE) {
                user.setState(UserState.STAT);

                answer.add(PhrasesHandler.getEndProsePoemPhrase());
            }

            return answer;
        }
    },
    STAT (PhrasesHandler.getStatCommand()) {
        @Override
        public List<String> requestProcessing(User user) {
            List<String> answer = new ArrayList<>();

            user.setState(UserState.STAT);

            answer.add(PhrasesHandler.getStartStatPhrase());
            return answer;
        }
    },

    POEM (PhrasesHandler.getPoemCommand()) {
        @Override
        public List<String> requestProcessing(User user) {
            List<String> answer = new ArrayList<>();

            user.setState(UserState.POEM);

            answer.add(PhrasesHandler.getStartPoemPhrase());
            return answer;
        }
    },
    PROSE (PhrasesHandler.getProseCommand()) {
        @Override
        public List<String> requestProcessing(User user) {
            List<String> answer = new ArrayList<>();

            user.setState(UserState.PROSE);

            answer.add(PhrasesHandler.getStartProsePhrase());
            return answer;
        }
    },
    DICT (PhrasesHandler.getDictCommand()) {
        @Override
        public List<String> requestProcessing(User user) {
            List<String> answer = new ArrayList<>();

            user.setState(UserState.DICT);

            answer.add(PhrasesHandler.getStartDictPhrase());
            return answer;
        }
    },
    END_DIALOG (PhrasesHandler.getEndDialogCommand()) {
        @Override
        public List<String> requestProcessing(User user) {
            List<String> answer = new ArrayList<>();

            user.setState(UserState.EXIT);
            answer.add(PhrasesHandler.getEndPhrase());
            return answer;
        }
    };

    private final String name;

    Command(String name) {
        this.name = name;
    }

    public static Command valueByString(String value){
        value = value.toLowerCase();
        for (Command command : Command.values()) {
            if (value.equalsIgnoreCase(command.toString().toLowerCase())) {
                return command;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public abstract List<String> requestProcessing(User user);
}