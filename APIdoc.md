## org.tinyj.lava

### LavaBiConsumer\<X, Y, E>
_[(src)](src/main/java/org/tinyj/lava/LavaBiConsumer.java)_ |
_(interface)_ |
X: first consumed value type — Y: second consumed value type — E: upper limit of thrown exception types

An operation on two input values. This is the exception declaring version of
 Java's [`BiConsumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html)

 Usually invoking a bi-consumer results in side effects. Subsequent
 invocations may or may not result in further side effects.

 This is a functional interface whose functional method is `checkedAccept(X, Y)`.

**`checkedAccept(X x, Y y)`**  
Perform operation on inputs.

**`castDown(LavaBiConsumer<? super X, ? super Y, ? extends E> biConsumer)`**  
⇒ *`LavaBiConsumer<X, Y, E>`* _(`biConsumer` casted to the compatible parametrization [`LavaBiConsumer`](#lavabiconsumerx-y-e)`<X, Y, E>`)_  
Safely casts between different [`LavaBiConsumer`](#lavabiconsumerx-y-e) parametrization

### LavaBiFunction\<X, Y, R, E>
_[(src)](src/main/java/org/tinyj/lava/LavaBiFunction.java)_ |
_(interface)_ |
X: the bi-function's first argument type — Y: the bi-function's second argument type — R: the bi-function's result type — E: upper limit of thrown exception types

A bi-function maps its two argument to a result. This is the exception declaring version of
 Java's [`BiFunction`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html)

 While not strictly required it usually is expected that subsequent
 invocations with the same arguments yield equal results.

 This is a functional interface whose functional method is `checkedApply(X, Y)`.

**`checkedApply(X x, Y y)`**  
⇒ *`R`* _(the function's result)_  
Apply the function to arguments

**`castDown(LavaBiFunction<? super X, ? super Y, ? extends R, ? extends E> biFunction)`**  
⇒ *`LavaBiFunction<X, Y, R, E>`* _(`biFunction` casted to the compatible parametrization [`LavaBiFunction`](#lavabifunctionx-y-r-e)`<X, Y, R, E>`)_  
Safely casts between different [`LavaBiFunction`](#lavabifunctionx-y-r-e) parametrization

### LavaBiPredicate\<X, Y, E>
_[(src)](src/main/java/org/tinyj/lava/LavaBiPredicate.java)_ |
_(interface)_ |
X: the function's argument type — E: upper limit of thrown exception types

A special kind of bi-function mapping its arguments to a `boolean` result.
 This is the exception declaring version of
 Java's [`BiPredicate`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiPredicate.html)

 While not strictly required it usually is expected that subsequent
 invocations with the same argument yield equal results.

 This is a functional interface whose functional method is `checkedTest(X, Y)`.

**`checkedTest(X x, Y y)`**  
⇒ *`boolean`* _(`true` if `x` matches, `false` otherwise)_  
Test if the arguments matche the predicate

**`castDown(LavaBiPredicate<? super X, ? super Y, ? extends E> biPredicate)`**  
⇒ *`LavaBiPredicate<X, Y, E>`* _(`biPredicate` casted to the compatible parametrization [`LavaBiPredicate`](#lavabipredicatex-y-e)`<X, E>`)_  
Safely casts between different [`LavaBiPredicate`](#lavabipredicatex-y-e)parametrization

### LavaBooleanSupplier\<E>
_[(src)](src/main/java/org/tinyj/lava/LavaBooleanSupplier.java)_ |
_(interface)_ |
E: upper limit of thrown exception types

A supplier of `boolean` values. This is the exception declaring version of
 Java's [`BooleanSupplier`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BooleanSupplier.html)

 There is no requirement that a new or distinct result be returned each
 time the supplier is invoked.

 This is a functional interface whose functional method is `checkedGetAsBoolean()`.

**`checkedGetAsBoolean()`**  
⇒ *`boolean`* _(a value)_  
Produce a value.

**`castDown(LavaBooleanSupplier<? extends E> supplier)`**  
⇒ *`LavaBooleanSupplier<E>`* _(`supplier` casted to the compatible parametrization [`LavaSupplier`](#lavasupplierr-e)`<R, E>`)_  
Safely casts between different [`LavaSupplier`](#lavasupplierr-e) parametrization

### LavaConsumer\<X, E>
_[(src)](src/main/java/org/tinyj/lava/LavaConsumer.java)_ |
_(interface)_ |
X: consumed value type — E: upper limit of thrown exception types

An operation on an input value. This is the exception declaring version of
 Java's [`Consumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)

 Usually invoking a consumer results in side effects. Subsequent
 invocations may or may not result in further side effects.

 This is a functional interface whose functional method is `checkedAccept(X)`.

**`checkedAccept(X x)`**  
Perform operation on input.

**`castDown(LavaConsumer<? super X, ? extends E> consumer)`**  
⇒ *`LavaConsumer<X, E>`* _(`consumer` casted to the compatible parametrization [`LavaConsumer`](#lavaconsumerx-e)`<X, E>`)_  
Safely casts between different [`LavaConsumer`](#lavaconsumerx-e) parametrization

### LavaFunction\<X, R, E>
_[(src)](src/main/java/org/tinyj/lava/LavaFunction.java)_ |
_(interface)_ |
X: the function's argument type — R: the function's result type — E: upper limit of thrown exception types

A function maps its argument to a result. This is the exception declaring version of
 Java's [`Function`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)

 While not strictly required it usually is expected that subsequent
 invocations with the same argument yield equal results.

 This is a functional interface whose functional method is `checkedApply(X)`.

**`checkedApply(X x)`**  
⇒ *`R`* _(the function's result)_  
Apply the function to an argument

**`castDown(LavaFunction<? super X, ? extends R, ? extends E> function)`**  
⇒ *`LavaFunction<X, R, E>`* _(`function` casted to the compatible parametrization [`LavaFunction`](#lavafunctionx-r-e)`<X, R, E>`)_  
Safely casts between different [`LavaFunction`](#lavafunctionx-r-e) parametrization

### LavaPredicate\<X, E>
_[(src)](src/main/java/org/tinyj/lava/LavaPredicate.java)_ |
_(interface)_ |
X: the function's argument type — E: upper limit of thrown exception types

A special kind of function mapping its argument to
 a {@code boolean} result.
 This is the exception declaring version of
 Java's [`Predicate`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html)

 While not strictly required it usually is expected that subsequent
 invocations with the same argument yield equal results.

 This is a functional interface whose functional method is {@link #checkedTest(X)}.

**`checkedTest(X x)`**  
⇒ *`boolean`* _(`true` if `x` matches, `false` otherwise)_  
Test if the argument matches the predicate

**`castDown(LavaPredicate<? super X, ? extends E> predicate)`**  
⇒ *`LavaPredicate<X, E>`* _(`predicate` casted to the compatible parametrization [`LavaPredicate`](#lavapredicatex-e)`<X, E>`)_  
Safely casts between different [`LavaPredicate`](#lavapredicatex-e) parametrization

### LavaRunnable\<E>
_[(src)](src/main/java/org/tinyj/lava/LavaRunnable.java)_ |
_(interface)_ |
E: upper limit of thrown exception types

A runnable task. This is the exception declaring version of
 Java's [`Runnable`](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html)

 Usually invoking a runnable results in side effects. Subsequent
 invocations may or may not result in further side effects.

 This is a functional interface whose functional method is `checkedRun()`.

**`checkedRun()`**  
Execute the task.

**`castDown(LavaRunnable<? extends E> runnable)`**  
⇒ *`LavaRunnable<E>`* _(`runnable` casted to the compatible parametrization [`LavaRunnable`](#lavarunnablee)`<E>`)_  
Safely casts between different [`LavaRunnable`](#lavarunnablee) parametrization

### LavaSupplier\<R, E>
_[(src)](src/main/java/org/tinyj/lava/LavaSupplier.java)_ |
_(interface)_ |
R: type of supplied values — E: upper limit of thrown exception types

A supplier of values. This is the exception declaring version of
 Java's [`Supplier`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html)

 There is no requirement that a new or distinct result be returned each
 time the supplier is invoked.

 This is a functional interface whose functional method is `checkedGet()`.

**`checkedGet()`**  
⇒ *`R`* _(a value)_  
Produce a value.

**`castDown(LavaSupplier<? extends R, ? extends E> supplier)`**  
⇒ *`LavaSupplier<R, E>`* _(`supplier` casted to the compatible parametrization [`LavaSupplier`](#lavasupplierr-e)`<R, E>`)_  
Safely casts between different [`LavaSupplier`](#lavasupplierr-e) parametrization

### NoException
_[(src)](src/main/java/org/tinyj/lava/NoException.java)_  
_extends_ (#RuntimeException)

Marker class to declare that a function does not throw any [`Exception`](https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html).
 It may still throw other [Throwable](https://docs.oracle.com/javase/8/docs/api/java/lang/Throwable.html) types
 like [Error](https://docs.oracle.com/javase/8/docs/api/java/lang/Error.html)s,
 e.g. [AssertionError](https://docs.oracle.com/javase/8/docs/api/java/lang/AssertionError.html)
 or [OutOfMemoryError](https://docs.oracle.com/javase/8/docs/api/java/lang/OutOfMemoryError.html)

 Using this class in a `throws`-clause does not keep unchecked exceptions
 from being thrown from from that method. It obliges to the implementation
 of that method to ensure no exception passes.

### WrappedCheckedException
_[(src)](src/main/java/org/tinyj/lava/WrappedCheckedException.java)_  
_extends_ (#RuntimeException)

Unchecked exception wrapping a checked exception.

**`wrapCheckedException(Exception e)`**  
⇒ *`RuntimeException`* _(`e` if `e` is `null` or a [`RuntimeException`](https://docs.oracle.com/javase/8/docs/api/java/lang/RuntimeException.html),
 a [`WrappedCheckedException`](#wrappedcheckedexception) wrapping `e` otherwise)_  


**`wrapCheckedException(LavaRunnable<?> task)`**  
Execute `task`, wrap and rethrow any checked exception raised during
 execution.

**`wrapCheckedException(LavaSupplier<R, ?> task)`**  
⇒ *`R`* _(Value returned by `task.checkedGet()`)_  
Execute `task`, wrap and rethrow any checked exception raised during
 execution. The result of `task.checkedGet()} is passed to the caller.

**`raiseUnchecked(Exception e)`**  
⇒ *`R`*  
Raise `e`. If `e` is a checked exception a [`WrappedCheckedException`](#wrappedcheckedexception)
 wrapping `e` is raised instead.

