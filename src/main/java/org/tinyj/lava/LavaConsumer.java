package org.tinyj.lava;

/**
 * An operation on an input value.
 * <p>
 * This is the exception declaring version of {@link java.util.function.Consumer}
 * <p>
 * Usually invoking a consumer results in side effects. Subsequent
 * invocations may or may not result in further side effects.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedAccept}.
 *
 * @param <X> consumed value type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface LavaConsumer<X, E extends Exception> {

  /**
   * Perform operation on input.
   *
   * @param x consumed value
   */
  void checkedAccept(X x) throws E;

  /**
   * Safely casts between different {@link LavaConsumer} parametrization
   *
   * @param <X> accepted input type
   * @param <E> required exception limit
   * @param consumer consumer to adopt
   * @return {@code consumer} casted to the compatible parametrization {@link LavaConsumer}{@code <X, E>}
   */
  @SuppressWarnings("unchecked")
  static <X, E extends Exception>
  LavaConsumer<X, E> castDown(LavaConsumer<? super X, ? extends E> consumer) {
    return (LavaConsumer<X, E>) consumer;
  }
}
