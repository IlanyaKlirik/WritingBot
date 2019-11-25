package logic.interfaces;

import logic.User;

import java.util.List;

public interface Output {
    void sendMessage(List<String> messages, User user);
}
