package nextstep.ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import nextstep.ladder.DirectionStrategy;

public class Ladder {

  private static final Random RANDOM = new Random();
  private final List<LadderLine> lines;

  private Ladder(List<LadderLine> lines) {
    this.lines = lines;
  }

  public static Ladder generate(int sizeOfPerson, int height, DirectionStrategy directionStrategy) {
    List<LadderLine> lines = Stream.generate(() -> LadderLine.generate(sizeOfPerson, directionStrategy))
        .limit(height).collect(Collectors.toList());
    return new Ladder(lines);
  }

  public static Ladder generate(int sizeOfPerson, int height) {
    return Ladder.generate(sizeOfPerson, height, () -> RANDOM.nextBoolean());
  }

  public List<LadderLine> getLines() {
    return lines;
  }

  public int move(int start) {
    int position = start;
    for (LadderLine line : lines) {
      position = line.move(position);
    }
    return position;
  }
}
