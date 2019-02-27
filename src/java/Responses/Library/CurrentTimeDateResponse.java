package java.Responses.Library;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class CurrentTimeDateResponse {
    // YYYY/MM/DD format
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    // HH:MM:SS
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

    private Date date;
    private Date time;

    public CurrentTimeDateResponse(Date date, Date time) {
        this.date = date;
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public Date getTime() {
        return time;
    }

    // TODO - create response format
    public String toString() {
        return "";
    }
}
