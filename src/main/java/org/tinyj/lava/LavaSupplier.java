package org.tinyj.lava;

/**
 * A supplier of values.
 * <p>
 * This is the exception declaring version of {@link java.util.function.Supplier}
 * <p>
 * There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedGet}.
 *
 * @param <R> type of supplied values
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface LavaSupplier<R, E extends Exception> {

  /**
   * Produce a value.
   *
   * @return a value
   */
  R checkedGet() throws E;

  /**
   * Safely casts between different {@link LavaSupplier} parametrization
   *
   * @param <R> required result type
   * @param <E> required exception limit
   * @param supplier supplier to adopt
   * @return {@code supplier} casted to the compatible parametrization {@link LavaSupplier}{@code <R, E>}
   */
  @SuppressWarnings("unchecked")
  static <R, E extends Exception>
  LavaSupplier<R, E> castDown(LavaSupplier<? extends R, ? extends E> supplier) {
    return (LavaSupplier<R, E>) supplier;
  }
}
