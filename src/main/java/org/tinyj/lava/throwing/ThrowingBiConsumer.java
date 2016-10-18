package org.tinyj.lava.throwing;

/**
 * <p>
 * An operation on two input values.
 * </p><p>
 * Usually invoking a bi-consumer results in side effects. Subsequent
 * invocations may or may not result in further side effects.
 * </p><p>
 * This is a functional interface whose functional method is {@link #accept(X, Y)}.
 * </p>
 *
 * @param <X> first consumed value type
 * @param <Y> second consumed value type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface ThrowingBiConsumer<X, Y, E extends Exception> {

    /**
     * Perform operation on inputs.
     *
     * @param x first consumed value
     * @param y second consumed value
     */
  void accept(X x, Y y) throws E;

    /**
     * Safely casts between different {@link ThrowingBiConsumer} parametrization
     *
     * @param <X> first accepted input type
     * @param <Y> second accepted input type
     * @param <E> required exception limit
     * @param biConsumer bi-consumer to adopt
     * @return {@code biConsumer} casted to the compatible parametrization {@link ThrowingBiConsumer}{@code <X, Y, E>}
     */
  @SuppressWarnings("unchecked")
  static <X, Y, E extends Exception>
  ThrowingBiConsumer<X, Y, E> castDown(ThrowingBiConsumer<? super X, ? super Y, ? extends E> biConsumer) {
      return (ThrowingBiConsumer<X, Y, E>) biConsumer;
  }
}
