import java.io.*;

abstract class Task implements Serializable {
    protected String name;
    protected String status;

    public Task(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public abstract int estimateDuration();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}