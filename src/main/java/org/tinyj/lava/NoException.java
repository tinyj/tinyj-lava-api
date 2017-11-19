package org.tinyj.lava;

/**
 * Marker class to declare that a function does not throw any {@link Exception}.
 * <p>
 * It may still throw other {@link Throwable} types like {@link Error}s, e.g.
 * {@link AssertionError} or {@link OutOfMemoryError}
 * <p>
 * Using this class in a {@code throws}-clause does not keep unchecked exceptions
 * from being thrown from from that method. It obliges to the implementation
 * of that method to ensure no exception passes.
 */
public final class NoException extends RuntimeException {

  private NoException() {
    assert false : "NoException is a marker class, it may not be instantiated.";
  }
}
