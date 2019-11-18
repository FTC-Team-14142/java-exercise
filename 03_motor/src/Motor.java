import java.time.Duration;
import java.time.Instant;

public final class Motor implements Updatable {

    private int speed = 0;
    private long distance = 0;
    private Instant turnedOnInstant;

    @Override
    public void update(Instant now) {

        this.processDistanceDelta(now);
    }

    protected synchronized void processDistanceDelta(Instant now) {

        if(this.speed != 0 && this.turnedOnInstant != null) {

            Duration timeDelta = Duration.between(this.turnedOnInstant, now);
            long distanceDelta = (long) ((double) timeDelta.toNanos() * this.speed / Math.pow(10, 6));

            this.distance += distanceDelta;
        }

        this.turnedOnInstant = now;
    }

    public void on(int speed) {

        this.speed = speed;
    }

    public void off() {

        this.speed = 0;
    }

    public int getSpeed() {

        return speed;
    }

    public long getDistance() {

        return distance;
    }

    public void reset() {

        this.distance = 0;
    }
}
