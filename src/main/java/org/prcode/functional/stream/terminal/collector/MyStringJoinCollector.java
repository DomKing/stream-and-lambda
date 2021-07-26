package org.prcode.functional.stream.terminal.collector;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * @author kangd001
 * @date 2021/7/20 21:39
 */
public class MyStringJoinCollector implements Collector<String, StringBuffer, String> {
    private final String delimiter;
    private final String prefix;
    private final String suffix;

    public MyStringJoinCollector(String delimiter, String prefix, String suffix) {
        this.delimiter = delimiter == null ? "" : delimiter;
        this.prefix = prefix == null ? "" : prefix;
        this.suffix = suffix == null ? "" : suffix;
    }

    @Override
    public Supplier<StringBuffer> supplier() {
        return StringBuffer::new;
    }

    @Override
    public BiConsumer<StringBuffer, String> accumulator() {
        return (sb, s) -> sb.append(s).append(delimiter);
    }

    @Override
    public BinaryOperator<StringBuffer> combiner() {
        return StringBuffer::append;
    }

    @Override
    public Function<StringBuffer, String> finisher() {
        return sb -> {
            String tmp = sb.toString();
            int dl = delimiter.length();
            tmp = tmp.length() >= dl ? tmp.substring(0, tmp.length() - dl) : tmp;
            return prefix + tmp + suffix;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("this", "is", "myStringJoinCollector");
        String collect = stream.collect(new MyStringJoinCollector(",", "[", "]"));
        System.out.println(collect);
    }
}
