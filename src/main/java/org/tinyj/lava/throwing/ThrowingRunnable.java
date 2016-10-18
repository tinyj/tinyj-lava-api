package org.tinyj.lava.throwing;

/**
 * <p>
 * A runnable task.
 * </p><p>
 * Usually invoking a runnable results in side effects. Subsequent
 * invocations may or may not result in further side effects.
 * </p><p>
 * This is a functional interface whose functional method is {@link #run()}.
 * </p>
 *
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface ThrowingRunnable<E extends Exception> {

  /**
   * Execute the task.
   */
  void run() throws E;

  /**
   * Safely casts between different {@link ThrowingRunnable} parametrization
   *
   * @param <E> required exception limit
   * @param runnable runnable to adopt
   * @return {@code runnable} casted to the compatible parametrization {@link ThrowingRunnable}{@code <E>}
   */
  @SuppressWarnings("unchecked")
  static <E extends Exception>
  ThrowingRunnable<E> castDown(ThrowingRunnable<? extends E> runnable) {
    return (ThrowingRunnable<E>) runnable;
  }
}
