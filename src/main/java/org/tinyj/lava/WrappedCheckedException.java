package org.tinyj.lava;

/**
 * Unchecked exception wrapping a checked exception.
 */
public final class WrappedCheckedException extends RuntimeException {

  /**
   * (#WrappedCheckedException) cannot be instantiated directly. Use
   * `wrapCheckedException(Exception)` instead.
   *
   * @param e the wrapped checked exception
   */
  private WrappedCheckedException(Exception e) { super(assertCheckedException(e)); }

  /**
   * @param e [`Exception`](https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html) to wrap
   * @return `e` if `e` is `null` or a [`Exception`](https://docs.oracle.com/javase/8/docs/api/java/lang/RuntimeException.html),
   * a (#WrappedCheckedException) wrapping `e` otherwise
   */
  public static RuntimeException wrapCheckedException(Exception e) {
    return e == null || e instanceof RuntimeException ? (RuntimeException) e
                                                      : new WrappedCheckedException(e);
  }

  /**
   * Execute `task`, wrap and rethrow any checked exception raised during
   * execution.
   *
   * @param task (#LavaRunnable) to execute
   * @throws RuntimeException Checked exception raised during `task.checkedRun()`
   * will be wrapped in a (#WrappedCheckedException)
   */
  public static void wrapCheckedException(LavaRunnable<?> task) {
    try {
      task.checkedRun();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new WrappedCheckedException(e);
    }
  }

  /**
   * Execute `task`, wrap and rethrow any checked exception raised during
   * execution. The result of `task.checkedGet()} is passed to the caller.
   *
   * @param task (#LavaSupplier) to execute
   * @return Value returned by `task.checkedGet()`
   * @throws RuntimeException checked exception raised during `task.checkedGet()`
   * will be wrapped in a (#WrappedCheckedException)
   */
  public static <R> R wrapCheckedException(LavaSupplier<R, ?> task) {
    try {
      return task.checkedGet();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new WrappedCheckedException(e);
    }
  }

  /**
   * Raise `e`. If `e` is a checked exception a (#WrappedCheckedException)
   * wrapping `e` is raised instead.
   */
  public static <R> R raiseUnchecked(Exception e) {
    throw wrapCheckedException(e);
  }

  private static Exception assertCheckedException(Exception cause) {
    assert cause != null && !(cause instanceof RuntimeException);
    return cause;
  }
}
