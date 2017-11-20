package org.tinyj.lava;

/**
 * A supplier of {@code boolean} values.
 * <p>
 * There is no requirement that a new or distinct result be returned each
 * time the condition is checked.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedTest()}.
 *
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface LavaCondition<E extends Exception> {

  /**
   * Produce a value.
   *
   * @return a value
   */
  boolean checkedTest() throws E;

  /**
   * Safely casts between different {@link LavaCondition} parametrization
   *
   * @param <E> required exception limit
   * @param condition supplier to adopt
   * @return {@code condition} casted to the compatible parametrization {@link LavaCondition}{@code <R, E>}
   */
  @SuppressWarnings("unchecked")
  static <E extends Exception>
  LavaCondition<E> castDown(LavaCondition<? extends E> condition) {
    return (LavaCondition<E>) condition;
  }
}
