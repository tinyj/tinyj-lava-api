package org.tinyj.lava.throwing;

/**
 * <p>
 * A special kind of bi-function mapping its arguments to
 * a {@code boolean} results.
 * </p><p>
 * While not strictly required it usually is expected that subsequent
 * invocations with the same argument yield equal results.
 * </p><p>
 * This is a functional interface whose functional method is {@link #test(X, Y)}.
 * </p>
 *
 * @param <X> the function's argument type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface ThrowingBiPredicate<X, Y, E extends Exception> {

  /**
   * Test if the arguments matche the predicate
   *
   * @param x first argument to the match
   * @param y second argument to the match
   * @return {@code true} if {@code x} matches, {@code false} otherwise
   */
  boolean test(X x, Y y) throws E;

  /**
   * Safely casts between different {@link ThrowingBiPredicate} parametrization
   *
   * @param <X> first accepted argument type
   * @param <Y> second accepted argument type
   * @param <E> required exception limit
   * @param biPredicate bi-predicate to adopt
   * @return {@code biPredicate} casted to the compatible parametrization {@link ThrowingBiPredicate}{@code <X, E>}
   */
  @SuppressWarnings("unchecked")
  static <X, Y, E extends Exception>
  ThrowingBiPredicate<X, Y, E> castDown(ThrowingBiPredicate<? super X, ? super Y, ? extends E> biPredicate) {
    return (ThrowingBiPredicate<X, Y, E>) biPredicate;
  }
}
