package almostLikeASql359;

import java.util.Date;

/**
 * Created by DIMA on 13.07.2018.
 */
public class LogEntry {
    private Date created;
    private String login;
    private String url;

    public LogEntry(Date created, String login, String url) {
        this.created = created;
        this.login = login;
        this.url = url;
    }

    public Date getCreated() {        return created;    }
    public String getLogin() {        return login;    }
    public String getUrl() {        return url;    }


}
