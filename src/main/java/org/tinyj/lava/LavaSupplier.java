package org.tinyj.lava;

/**
 * A supplier of values. This is the exception declaring version of
 * Java's [`Supplier`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html)
 *
 * There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 *
 * This is a functional interface whose functional method is `checkedGet()`.
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
   * Safely casts between different (#LavaSupplier) parametrization
   *
   * @param <R> required result type
   * @param <E> required exception limit
   * @param supplier supplier to adopt
   * @return `supplier` casted to the compatible parametrization (#LavaSupplier)`<R, E>`
   */
  @SuppressWarnings("unchecked")
  static <R, E extends Exception>
  LavaSupplier<R, E> castDown(LavaSupplier<? extends R, ? extends E> supplier) {
    return (LavaSupplier<R, E>) supplier;
  }
}
