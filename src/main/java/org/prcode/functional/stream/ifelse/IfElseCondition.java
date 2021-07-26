package org.prcode.functional.stream.ifelse;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author kangd001
 * @date 2021/7/14 20:50
 */
public class IfElseCondition<T> {

    private final T value;
    /**
     * 判断是否有条件命中，如果无命中，otherwise 兜底方法才会执行。
     */
    private boolean hit = false;

    private IfElseCondition(T value) {
        this.value = Objects.requireNonNull(value);
    }

    /**
     * 提供静态方法便于生成对象
     * @param item 需要判断的对象
     */
    public static <T> IfElseCondition<T> of(T item) {
        return new IfElseCondition<>(item);
    }

    public IfElseCondition<T> ifTrue(Predicate<T> predicate, Consumer<T> ifConsumer) {
        if (predicate.test(value)) {
            hit = true;
            ifConsumer.accept(value);
        }
        return this;
    }

    public IfElseCondition<T> elsif(Predicate<T> predicate, Consumer<T> ifConsumer) {
        if (!hit && predicate.test(value)) {
            hit = true;
            ifConsumer.accept(value);
        }
        return this;
    }

    public void otherwise(Consumer<T> elseConsumer) {
        if (!hit) {
            elseConsumer.accept(value);
        }
    }

    public void ifOrOtherwise(Predicate<T> predicate, Consumer<T> ifConsumer, Consumer<T> elseConsumer) {
        if (predicate.test(value)) {
            ifConsumer.accept(value);
        } else {
            elseConsumer.accept(value);
        }
    }

    public T getValue() {
        return value;
    }
}
