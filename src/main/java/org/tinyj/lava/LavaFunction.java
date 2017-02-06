package org.tinyj.lava;

/**
 * A function maps its argument to a result. This is the exception declaring version of
 * Java's [`Function`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)
 *
 * While not strictly required it usually is expected that subsequent
 * invocations with the same argument yield equal results.
 *
 * This is a functional interface whose functional method is `checkedApply(X)`.
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
   * Safely casts between different (#LavaFunction) parametrization
   *
   * @param <X> accepted argument type
   * @param <R> required result type
   * @param <E> required exception limit
   * @param function function to adopt
   * @return `function` casted to the compatible parametrization (#LavaFunction)`<X, R, E>`
   */
  @SuppressWarnings("unchecked")
  static <X, R, E extends Exception>
  LavaFunction<X, R, E> castDown(LavaFunction<? super X, ? extends R, ? extends E> function) {
    return (LavaFunction<X, R, E>) function;
  }
}
