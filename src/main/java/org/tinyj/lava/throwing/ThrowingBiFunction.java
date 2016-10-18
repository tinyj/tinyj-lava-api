package org.tinyj.lava.throwing;

/**
 * <p>
 * A bi-function maps its two argument to a result.
 * </p><p>
 * While not strictly required it usually is expected that subsequent
 * invocations with the same arguments yield equal results.
 * </p><p>
 * This is a functional interface whose functional method is {@link #apply(X, Y)}.
 * </p>
 *
 * @param <X> the bi-function's first argument type
 * @param <Y> the bi-function's second argument type
 * @param <R> the bi-function's result type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface ThrowingBiFunction<X, Y, R, E extends Exception> {

    /**
     * Apply the function to arguments
     *
     * @param x first argument to map
     * @param y second argument to map
     * @return the function's result
     */
  R apply(X x, Y y) throws E;

    /**
     * Safely casts between different {@link ThrowingBiFunction} parametrization
     *
     * @param <X> first accepted argument type
     * @param <Y> second accepted argument type
     * @param <R> required result type
     * @param <E> required exception limit
     * @param biFunction bi-function to adopt
     * @return {@code biFunction} casted to the compatible parametrization {@link ThrowingBiFunction}{@code <X, Y, R, E>}
     */
  @SuppressWarnings("unchecked")
  static <X, Y, R, E extends Exception>
  ThrowingBiFunction<X, Y, R, E> castDown(ThrowingBiFunction<? super X, ? super Y, ? extends R, ? extends E> biFunction) {
      return (ThrowingBiFunction<X, Y, R, E>) biFunction;
  }
}
