/**
 * Functional interfaces with checked exceptions.
 * <p>
 * Java's default functional interfaces (i.e. {@link java.util.function.Function}
 * and friends) allow for raising checked exception, which basically denies us
 * from using these neat lambda shorthands for anything that may throw checked
 * exceptions. tinyj-lava-api is a first step to fix that defining equivalent
 * functional interfaces with declared checked exceptions.
 * <p>
 * Additionally tinyj-lava-api defines two exception types. NoException is
 * marker class that allows to declare a method to not to throw any exception at
 * all. {@literal This is not enforced by the compiler though.}
 * <p>
 * {@code WrappedCheckedException} is just for wrapping checked exceptions. While
 * {@code new RuntimeException(e)} achieves the same thing using
 * {@code WrappedCheckedException} allows for clearer communication and makes
 * unwrapping of such exceptions much easier.
 */
module org.tinyj.lava.api {
  exports org.tinyj.lava;
}
