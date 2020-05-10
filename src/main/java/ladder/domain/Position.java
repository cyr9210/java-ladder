package ladder.domain;


public class Position {

    private final int now;

    private Position(int now) {
        this.now = now;
    }

    public static Position of(int now) {
        return new Position(now);
    }

    public Position crossWay(SteerRule steerRule) {
        return Position.of(now + steerRule.getSteer());
    }

    public int getPosition() {
        return now;
    }

    @Override
    public boolean equals(Object obj) {
        return now == ((Position) obj).now;
    }
}