package org.tinyj.lava;

/**
 * A function maps its argument to a result.
 * <p>
 * This is the exception declaring version of {@link java.util.function.Function}
 * <p>
 * While not strictly required it usually is expected that subsequent
 * invocations with the same argument yield equal results.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedApply}.
 *
 * @param <X> the function's argument type
 * @param <R> the function's result type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface LavaFunction<X, R, E extends Exception> {

  /**
   * Apply the function to an argument
   *
   * @param x argument to map
   * @return the function's result
   */
  R checkedApply(X x) throws E;

  /**
   * Safely casts between different {@link LavaFunction} parametrization
   *
   * @param <X> accepted argument type
   * @param <R> required result type
   * @param <E> required exception limit
   * @param function function to adopt
   * @return {@code function} casted to the compatible parametrization {@link LavaFunction}{@code <X, R, E>}
   */
  @SuppressWarnings("unchecked")
  static <X, R, E extends Exception>
  LavaFunction<X, R, E> castDown(LavaFunction<? super X, ? extends R, ? extends E> function) {
    return (LavaFunction<X, R, E>) function;
  }
}
