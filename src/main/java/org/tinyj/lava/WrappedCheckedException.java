package org.tinyj.lava;

/**
 * Unchecked exception wrapping a checked exception.
 */
public final class WrappedCheckedException extends RuntimeException {

  /**
   * {@link WrappedCheckedException} cannot be instantiated directly. Use
   * {@code wrapCheckedException(Exception)} instead.
   *
   * @param e the wrapped checked exception
   */
  private WrappedCheckedException(Exception e) { super(assertCheckedException(e)); }

  /**
   * @param e {@link Exception} to wrap
   * @return {@code e} if {@code e} is {@code null} or a {@link RuntimeException},
   *     a {@link WrappedCheckedException} wrapping {@code e} otherwise
   */
  public static RuntimeException wrapCheckedException(Exception e) {
    return e == null || e instanceof RuntimeException ? (RuntimeException) e
                                                      : new WrappedCheckedException(e);
  }

  /**
   * @param e {@link Exception} to unwrap
   * @return {@code e} if {@code e} is not a {@link WrappedCheckedException} or
   *     {@code e.getCause()} otherwise
   */
  public static Exception unwrapCheckedException(Exception e) {
    return e instanceof WrappedCheckedException ? (Exception) e.getCause() : e;
  }

  /**
   * Execute {@code task}, wrap and rethrow any checked exception raised during
   * execution.
   *
   * @param task {@link LavaRunnable} to execute
   * @throws RuntimeException Checked exception raised during {@code task.checkedRun()}
   *     will be wrapped in a {@link WrappedCheckedException}
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
   * Execute {@code task}, wrap and rethrow any checked exception raised during
   * execution. The result of {@code task.checkedGet()} is passed to the caller.
   *
   * @param task {@link LavaSupplier} to execute
   * @return Value returned by {@code task.checkedGet()}
   * @throws RuntimeException checked exception raised during {@code task.checkedGet()}
   *     will be wrapped in a {@link WrappedCheckedException}
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
   * Raise {@code e}. If {@code e} is a checked exception a {@link WrappedCheckedException}
   * wrapping {@code e} is raised instead.
   */
  public static <R> R raiseUnchecked(Exception e) {
    throw wrapCheckedException(e);
  }

  /**
   * Raise {@code e} if {@code e} is a unchecked exception or an instance of {@code limit}.
   * Otherwise raise a {@link WrappedCheckedException} wrapping {@code e} instead.
   */
  public static <E extends Exception> void raiseCheckedLimit(Exception e, Class<? extends E> limit) throws E {
    if (limit.isInstance(e)) {
      throw limit.cast(e);
    } else throw wrapCheckedException(e);
  }

  private static Exception assertCheckedException(Exception cause) {
    assert cause != null && !(cause instanceof RuntimeException);
    return cause;
  }
}
