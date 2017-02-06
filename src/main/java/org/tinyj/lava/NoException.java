package org.tinyj.lava;

/**
 * Marker class to declare that a function does not throw any [`Exception`](https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html).
 * It may still throw other [Throwable](https://docs.oracle.com/javase/8/docs/api/java/lang/Throwable.html) types
 * like [Error](https://docs.oracle.com/javase/8/docs/api/java/lang/Error.html)s,
 * e.g. [AssertionError](https://docs.oracle.com/javase/8/docs/api/java/lang/AssertionError.html)
 * or [OutOfMemoryError](https://docs.oracle.com/javase/8/docs/api/java/lang/OutOfMemoryError.html)
 *
 * Using this class in a `throws`-clause does not keep unchecked exceptions
 * from being thrown from from that method. It obliges to the implementation
 * of that method to ensure no exception passes.
 */
public final class NoException extends RuntimeException {

  private NoException() {
    throw new AssertionError("NoException is a marker class, it may not be instantiated.");
  }
}
