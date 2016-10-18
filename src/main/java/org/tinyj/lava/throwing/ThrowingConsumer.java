package org.tinyj.lava.throwing;

/**
 * <p>
 * An operation on an input value.
 * </p><p>
 * Usually invoking a consumer results in side effects. Subsequent
 * invocations may or may not result in further side effects.
 * </p><p>
 * This is a functional interface whose functional method is {@link #accept(X)}.
 * </p>
 *
 * @param <X> consumed value type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface ThrowingConsumer<X, E extends Exception> {

  /**
   * Perform operation on input.
   *
   * @param x consumed value
   */
  void accept(X x) throws E;

  /**
   * Safely casts between different {@link ThrowingConsumer} parametrization
   *
   * @param <X> accepted input type
   * @param <E> required exception limit
   * @param consumer consumer to adopt
   * @return {@code consumer} casted to the compatible parametrization {@link ThrowingConsumer}{@code <X, E>}
   */
  @SuppressWarnings("unchecked")
  static <X, E extends Exception>
  ThrowingConsumer<X, E> castDown(ThrowingConsumer<? super X, ? extends E> consumer) {
    return (ThrowingConsumer<X, E>) consumer;
  }
}
