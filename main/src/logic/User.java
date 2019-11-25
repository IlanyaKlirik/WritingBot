package logic;

import logic.enums.UserState;

public class User {
    private UserState state;
    private Long id;

    public static final Long defaultId = 1L;

    public User(Long id) {
        state = UserState.START;
        this.id = id;
    }

    public User() {
        state = UserState.START;
        id = defaultId;
    }

    public Long getId() {
        return id;
    }

    public UserState getState(){
        return state;
    }

    public void setState(UserState userState){
        state = userState;
    }
}
