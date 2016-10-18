package org.tinyj.lava.throwing;

/**
 * <p>
 * A special kind of function mapping its argument to
 * a {@code boolean} results.
 * </p><p>
 * While not strictly required it usually is expected that subsequent
 * invocations with the same argument yield equal results.
 * </p><p>
 * This is a functional interface whose functional method is {@link #test(X)}.
 * </p>
 *
 * @param <X> the function's argument type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface ThrowingPredicate<X, E extends Exception> {

  /**
   * Test if the argument matches the predicate
   *
   * @param x argument to the match
   * @return {@code true} if {@code x} matches, {@code false} otherwise
   */
  boolean test(X x) throws E;

  /**
   * Safely casts between different {@link ThrowingPredicate} parametrization
   *
   * @param <X> accepted argument type
   * @param <E> required exception limit
   * @param predicate predicate to adopt
   * @return {@code predicate} casted to the compatible parametrization {@link ThrowingPredicate}{@code <X, E>}
   */
  @SuppressWarnings("unchecked")
  static <X, E extends Exception>
  ThrowingPredicate<X, E> castDown(ThrowingPredicate<? super X, ? extends E> predicate) {
    return (ThrowingPredicate<X, E>) predicate;
  }
}
