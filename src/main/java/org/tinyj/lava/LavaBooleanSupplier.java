package org.tinyj.lava;

/**
 * A supplier of {@code boolean} values.
 * <p>
 * This is the exception declaring version of {@link java.util.function.BooleanSupplier}
 * <p>
 * There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedGetAsBoolean}.
 *
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface LavaBooleanSupplier<E extends Exception> {

  /**
   * Produce a value.
   *
   * @return a value
   */
  boolean checkedGetAsBoolean() throws E;

  /**
   * Safely casts between different {@link LavaSupplier} parametrization
   *
   * @param <E> required exception limit
   * @param supplier supplier to adopt
   * @return {@code supplier} casted to the compatible parametrization {@link LavaSupplier}{@code <R, E>}
   */
  @SuppressWarnings("unchecked")
  static <E extends Exception>
  LavaBooleanSupplier<E> castDown(LavaBooleanSupplier<? extends E> supplier) {
    return (LavaBooleanSupplier<E>) supplier;
  }
}
