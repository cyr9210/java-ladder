package nextstep.ladder.domain;

import static java.util.Collections.unmodifiableList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

  private final List<Result> results;

  private Results(List<Result> results) {
    this.results = results;
  }

  public static Results generate(String[] names) {
    List<Result> results = Arrays.stream(names)
        .map(Result::generate)
        .collect(Collectors.toList());
    return new Results(results);
  }

  public List<Result> getResults() {
    return unmodifiableList(results);
  }

  public int size() {
    return results.size();
  }

  public Result findResult(int index) {
    return results.get(index);
  }
}
