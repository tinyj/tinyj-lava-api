package org.tinyj.lava.throwing;

/**
 * <p>
 * A function maps its argument to a result.
 * </p><p>
 * While not strictly required it usually is expected that subsequent
 * invocations with the same argument yield equal results.
 * </p><p>
 * This is a functional interface whose functional method is {@link #apply(X)}.
 * </p>
 *
 * @param <X> the function's argument type
 * @param <R> the function's result type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface ThrowingFunction<X, R, E extends Exception> {

    /**
     * Apply the function to an argument
     *
     * @param x argument to map
     * @return the function's result
     */
  R apply(X x) throws E;

    /**
     * Safely casts between different {@link ThrowingFunction} parametrization
     *
     * @param <X> accepted argument type
     * @param <R> required result type
     * @param <E> required exception limit
     * @param function function to adopt
     * @return {@code function} casted to the compatible parametrization {@link ThrowingFunction}{@code <X, R, E>}
     */
  @SuppressWarnings("unchecked")
  static <X, R, E extends Exception>
  ThrowingFunction<X, R, E> castDown(ThrowingFunction<? super X, ? extends R, ? extends E> function) {
      return (ThrowingFunction<X, R, E>) function;
  }
}
