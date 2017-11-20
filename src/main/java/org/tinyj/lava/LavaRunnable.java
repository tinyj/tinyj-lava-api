package org.tinyj.lava;

/**
 * A runnable task.
 * <p>
 * This is the exception declaring version of Java's {@link java.lang.Runnable}
 * <p>
 * Usually invoking a runnable results in side effects. Subsequent
 * invocations may or may not result in further side effects.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedRun}.
 *
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface LavaRunnable<E extends Exception> {

  /**
   * Execute the task.
   */
  void checkedRun() throws E;

  /**
   * Safely casts between different {@link LavaRunnable} parametrization
   *
   * @param <E> required exception limit
   * @param runnable runnable to adopt
   * @return {@code runnable} casted to the compatible parametrization {@link LavaRunnable}{@code <E>}
   */
  @SuppressWarnings("unchecked")
  static <E extends Exception>
  LavaRunnable<E> castDown(LavaRunnable<? extends E> runnable) {
    return (LavaRunnable<E>) runnable;
  }
}
