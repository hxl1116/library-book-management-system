package Responses;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public abstract class LibraryResponse implements Serializable {
    // YYYY/MM/DD format
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    // HH:MM:SS
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

    protected LibraryResponse() {

    }
}
