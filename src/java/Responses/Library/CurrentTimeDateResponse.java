package Responses.Library;

import Responses.LibraryResponse;

import java.util.Date;

/**
 *
 */
public class CurrentTimeDateResponse extends LibraryResponse {
    private String date;
    private String time;

    public CurrentTimeDateResponse(String date, String time) {
        this.date = date;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    // TODO - create response format
    public String toString() {
        return String.format("datetime,%s,%s", date, time);
    }
}
