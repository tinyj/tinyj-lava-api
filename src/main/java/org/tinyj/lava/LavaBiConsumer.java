package org.tinyj.lava;

/**
 * An operation on two input values.
 * <p>
 * This is the exception declaring version of {@link java.util.function.BiConsumer}
 * <p>
 * Usually invoking a bi-consumer results in side effects. Subsequent
 * invocations may or may not result in further side effects.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedAccept}.
 *
 * @param <X> first consumed value type
 * @param <Y> second consumed value type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface LavaBiConsumer<X, Y, E extends Exception> {

  /**
   * Perform operation on inputs.
   *
   * @param x first consumed value
   * @param y second consumed value
   */
  void checkedAccept(X x, Y y) throws E;

  /**
   * Safely casts between different {@link LavaBiConsumer} parametrization
   *
   * @param <X> first accepted input type
   * @param <Y> second accepted input type
   * @param <E> required exception limit
   * @param biConsumer bi-consumer to adopt
   * @return {@code biConsumer} casted to the compatible parametrization {@link LavaBiConsumer}{@code <X, Y, E>}
   */
  @SuppressWarnings("unchecked")
  static <X, Y, E extends Exception>
  LavaBiConsumer<X, Y, E> castDown(LavaBiConsumer<? super X, ? super Y, ? extends E> biConsumer) {
    return (LavaBiConsumer<X, Y, E>) biConsumer;
  }
}
