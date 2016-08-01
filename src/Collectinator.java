import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Collectinator<T, A, R> implements Consumer<T>, Supplier<R> {
    private final A container;
    private final BiConsumer<A, T> accumulator;
    private final Function<A, R> finisher;

    public Collectinator(Collector<T, A, R> collector) {
        container = collector.supplier()
                .get();
        accumulator = collector.accumulator();
        finisher = collector.finisher();
    }

    @Override
    public R get() {
        return finisher.apply(container);
    }

    @Override
    public void accept(T element) {
        accumulator.accept(container, element);
    }

}
