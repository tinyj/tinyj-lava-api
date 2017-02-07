package org.tinyj.lava;

/**
 * A supplier of `boolean` values. This is the exception declaring version of
 * Java's [`BooleanSupplier`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BooleanSupplier.html)
 *
 * There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 *
 * This is a functional interface whose functional method is `checkedGetAsBoolean()`.
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
   * Safely casts between different (#LavaSupplier) parametrization
   *
   * @param <E> required exception limit
   * @param supplier supplier to adopt
   * @return `supplier` casted to the compatible parametrization (#LavaSupplier)`<R, E>`
   */
  @SuppressWarnings("unchecked")
  static <E extends Exception>
  LavaBooleanSupplier<E> castDown(LavaBooleanSupplier<? extends E> supplier) {
    return (LavaBooleanSupplier<E>) supplier;
  }
}
