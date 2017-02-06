package org.tinyj.lava;

/**
 * A runnable task. This is the exception declaring version of
 * Java's [`Runnable`](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html)
 *
 * Usually invoking a runnable results in side effects. Subsequent
 * invocations may or may not result in further side effects.
 *
 * This is a functional interface whose functional method is `checkedRun()`.
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
   * Safely casts between different (#LavaRunnable) parametrization
   *
   * @param <E> required exception limit
   * @param runnable runnable to adopt
   * @return `runnable` casted to the compatible parametrization (#LavaRunnable)`<E>`
   */
  @SuppressWarnings("unchecked")
  static <E extends Exception>
  LavaRunnable<E> castDown(LavaRunnable<? extends E> runnable) {
    return (LavaRunnable<E>) runnable;
  }
}
