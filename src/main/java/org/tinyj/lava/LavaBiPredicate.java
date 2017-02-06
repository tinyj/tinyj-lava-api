package org.tinyj.lava;

/**
 * A special kind of bi-function mapping its arguments to a `boolean` result.
 * This is the exception declaring version of
 * Java's [`BiPredicate`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiPredicate.html)
 *
 * While not strictly required it usually is expected that subsequent
 * invocations with the same argument yield equal results.
 *
 * This is a functional interface whose functional method is `checkedTest(X, Y)`.
 *
 * @param <X> the function's argument type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface LavaBiPredicate<X, Y, E extends Exception> {

  /**
   * Test if the arguments matche the predicate
   *
   * @param x first argument to the match
   * @param y second argument to the match
   * @return {@code true} if {@code x} matches, {@code false} otherwise
   */
  boolean checkedTest(X x, Y y) throws E;

  /**
   * Safely casts between different (#LavaBiPredicate)parametrization
   *
   * @param <X> first accepted argument type
   * @param <Y> second accepted argument type
   * @param <E> required exception limit
   * @param biPredicate bi-predicate to adopt
   * @return `biPredicate` casted to the compatible parametrization (#LavaBiPredicate)`<X, E>`
   */
  @SuppressWarnings("unchecked")
  static <X, Y, E extends Exception>
  LavaBiPredicate<X, Y, E> castDown(LavaBiPredicate<? super X, ? super Y, ? extends E> biPredicate) {
    return (LavaBiPredicate<X, Y, E>) biPredicate;
  }
}
