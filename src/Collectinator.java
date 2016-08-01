import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;

public class Collectinator<T, A, R> {
    private final A container;
    private final BiConsumer<A, T> accumulator;
    private final Function<A, R> finisher;

    public Collectinator(Collector<T, A, R> collector) {
        container = collector.supplier()
                .get();
        accumulator = collector.accumulator();
        finisher = collector.finisher();
    }
}
