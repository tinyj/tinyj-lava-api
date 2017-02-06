package org.tinyj.lava;

/**
 * A special kind of function mapping its argument to
 * a {@code boolean} result.
 * This is the exception declaring version of
 * Java's [`Predicate`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html)
 *
 * While not strictly required it usually is expected that subsequent
 * invocations with the same argument yield equal results.
 *
 * This is a functional interface whose functional method is {@link #checkedTest(X)}.
 *
 * @param <X> the function's argument type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface LavaPredicate<X, E extends Exception> {

  /**
   * Test if the argument matches the predicate
   *
   * @param x argument to the match
   * @return {@code true} if {@code x} matches, {@code false} otherwise
   */
  boolean checkedTest(X x) throws E;

  /**
   * Safely casts between different (#LavaPredicate) parametrization
   *
   * @param <X> accepted argument type
   * @param <E> required exception limit
   * @param predicate predicate to adopt
   * @return `predicate` casted to the compatible parametrization (#LavaPredicate)`<X, E>`
   */
  @SuppressWarnings("unchecked")
  static <X, E extends Exception>
  LavaPredicate<X, E> castDown(LavaPredicate<? super X, ? extends E> predicate) {
    return (LavaPredicate<X, E>) predicate;
  }
}
