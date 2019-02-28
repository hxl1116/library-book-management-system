package Responses.Library;

import java.util.Date;

/**
 *
 */
public class CurrentTimeDateResponse {
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
