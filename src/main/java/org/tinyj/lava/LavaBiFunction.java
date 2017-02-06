package org.tinyj.lava;

/**
 * A bi-function maps its two argument to a result. This is the exception declaring version of
 * Java's [`BiFunction`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html)
 *
 * While not strictly required it usually is expected that subsequent
 * invocations with the same arguments yield equal results.
 *
 * This is a functional interface whose functional method is `checkedApply(X, Y)`.
 *
 * @param <X> the bi-function's first argument type
 * @param <Y> the bi-function's second argument type
 * @param <R> the bi-function's result type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface LavaBiFunction<X, Y, R, E extends Exception> {

  /**
   * Apply the function to arguments
   *
   * @param x first argument to map
   * @param y second argument to map
   * @return the function's result
   */
  R checkedApply(X x, Y y) throws E;

  /**
   * Safely casts between different (#LavaBiFunction) parametrization
   *
   * @param <X> first accepted argument type
   * @param <Y> second accepted argument type
   * @param <R> required result type
   * @param <E> required exception limit
   * @param biFunction bi-function to adopt
   * @return `biFunction` casted to the compatible parametrization (#LavaBiFunction)`<X, Y, R, E>`
   */
  @SuppressWarnings("unchecked")
  static <X, Y, R, E extends Exception>
  LavaBiFunction<X, Y, R, E> castDown(LavaBiFunction<? super X, ? super Y, ? extends R, ? extends E> biFunction) {
    return (LavaBiFunction<X, Y, R, E>) biFunction;
  }
}
