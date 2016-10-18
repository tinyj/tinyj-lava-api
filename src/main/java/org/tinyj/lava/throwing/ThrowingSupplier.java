package org.tinyj.lava.throwing;

/**
 * <p>
 * A supplier of values.
 * </p><p>
 * There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 * </p><p>
 * This is a functional interface whose functional method is {@link #get()}.
 * </p>
 *
 * @param <R> type of supplied values
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface ThrowingSupplier<R, E extends Exception> {

  /**
   * Produce a value.
   *
   * @return a value
   */
  R get() throws E;

  /**
   * Safely casts between different {@link ThrowingSupplier} parametrization
   *
   * @param <R> required result type
   * @param <E> required exception limit
   * @param supplier supplier to adopt
   * @return {@code supplier} casted to the compatible parametrization {@link ThrowingSupplier}{@code <R, E>}
   */
  @SuppressWarnings("unchecked")
  static <R, E extends Exception>
  ThrowingSupplier<R, E> castDown(ThrowingSupplier<? extends R, ? extends E> supplier) {
    return (ThrowingSupplier<R, E>) supplier;
  }
}
