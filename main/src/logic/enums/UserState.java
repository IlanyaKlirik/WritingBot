package logic.enums;

import logic.handlers.PhrasesHandler;

public enum UserState {
    START(PhrasesHandler.getStartHelp()),
    DIALOG(PhrasesHandler.getDialogHelp()),
    STAT(PhrasesHandler.getStatHelp()),
    CHECK(null),
    POEM(PhrasesHandler.getPoemHelp()),
    PROSE(PhrasesHandler.getProseHelp()),
    DICT(PhrasesHandler.getDictHelp()),
    EXIT(null);

    private String description;

    UserState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}