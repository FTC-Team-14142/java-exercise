import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class TimeProcessor {

    protected List<Updatable> updatables = new ArrayList<>();
    protected long time = 0;

    public void sleep(long millis) throws InterruptedException {

        this.time += millis;
        Instant now = this.getInstant();
        this.updatables.forEach(updatable -> updatable.update(now));
        Thread.sleep(millis);
    }

    public long getTime() {

        return this.time;
    }

    public Instant getInstant() {

        return Instant.ofEpochMilli(this.time);
    }

    public void addUpdatable(Updatable updatable) {

        this.updatables.add(updatable);
    }
}
