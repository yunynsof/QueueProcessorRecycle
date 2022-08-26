/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.com.tigo.queue.context;

/**
 * AppCommand Enum class for QueueProcessor Listener.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-25-2022 12:04:05 PM 2022
 */
public enum AppCommand {
    
    /** The start. */
    START("START"),
    
    /** The shutdown. */
    SHUTDOWN("SHUTDOWN");

    /** The value. */
    private final String value;

    /**
     * Instantiates a new app command.
     *
     * @param value the value
     */
    private AppCommand(String value) {
        this.value = value;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return value;
    }

    /**
     * Parses the.
     *
     * @param state the state
     * @return the app command
     */
    public static AppCommand parse(String state) {
        state = state.trim().toLowerCase();
        if(state.equals(START.toString().toLowerCase())) {
            return START;
        }else if (state.equals(SHUTDOWN.toString().toLowerCase())) {
            return SHUTDOWN;
        }else {
            return START;
        }
    }
}
