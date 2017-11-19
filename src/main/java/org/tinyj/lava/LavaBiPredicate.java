package org.tinyj.lava;

/**
 * A special kind of bi-function mapping its arguments to a {@code boolean} result.
 * <p>
 * This is the exception declaring version of {@link java.util.function.BiPredicate}
 * <p>
 * While not strictly required it usually is expected that subsequent
 * invocations with the same argument yield equal results.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedTest}.
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
   * Safely casts between different {@link LavaBiPredicate}parametrization
   *
   * @param <X> first accepted argument type
   * @param <Y> second accepted argument type
   * @param <E> required exception limit
   * @param biPredicate bi-predicate to adopt
   * @return {@code biPredicate} casted to the compatible parametrization {@link LavaBiPredicate}{@code <X, E>}
   */
  @SuppressWarnings("unchecked")
  static <X, Y, E extends Exception>
  LavaBiPredicate<X, Y, E> castDown(LavaBiPredicate<? super X, ? super Y, ? extends E> biPredicate) {
    return (LavaBiPredicate<X, Y, E>) biPredicate;
  }
}
