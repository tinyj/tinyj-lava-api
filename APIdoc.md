org.tinyj.lava.api
==================

Functional interfaces with checked exceptions.

Java's default functional interfaces (i.e. [`java.util.function.Function`]
and friends) allow for raising checked exception, which basically denies us
from using these neat lambda shorthands for anything that may throw checked
exceptions. tinyj-lava-api is a first step to fix that defining equivalent
functional interfaces with declared checked exceptions.

Additionally tinyj-lava-api defines two exception types. NoException is
marker class that allows to declare a method to not to throw any exception at
all. _This is not enforced by the compiler though._

`WrappedCheckedException` is just for wrapping checked exceptions. While
`new RuntimeException(e)` achieves the same thing using
`WrappedCheckedException` allows for clearer communication and makes
unwrapping of such exceptions much easier.


## org.tinyj.lava

### LavaBiConsumer<X, Y, E>
_[(src)](src/main/java/org/tinyj/lava/LavaBiConsumer.java)_
| _(interface)_  
`X`: first consumed value type  
`Y`: second consumed value type  
`E`: upper limit of thrown exception types  

An operation on two input values.

This is the exception declaring version of [`java.util.function.BiConsumer`]

Usually invoking a bi-consumer results in side effects. Subsequent
invocations may or may not result in further side effects.

This is a functional interface whose functional method is
[`checkedAccept`].


**`checkedAccept(X x, Y y)`**  
`x`: first consumed value  
`y`: second consumed value  

Perform operation on inputs.


***`castDown(LavaBiConsumer<? super X, ? super Y, ? extends E> biConsumer)`***
⇒ *`LavaBiConsumer<X, Y, E>`* *(`biConsumer` casted to the compatible parametrization [`LavaBiConsumer`]`<X, Y, E>`)*  
`X`: first accepted input type  
`Y`: second accepted input type  
`E`: required exception limit  
`biConsumer`: bi-consumer to adopt  

Safely casts between different [`LavaBiConsumer`] parametrization



### LavaBiFunction<X, Y, R, E>
_[(src)](src/main/java/org/tinyj/lava/LavaBiFunction.java)_
| _(interface)_  
`X`: the bi-function's first argument type  
`Y`: the bi-function's second argument type  
`R`: the bi-function's result type  
`E`: upper limit of thrown exception types  

A bi-function maps its two argument to a result.

This is the exception declaring version of [`java.util.function.BiFunction`]

While not strictly required it usually is expected that subsequent
invocations with the same arguments yield equal results.

This is a functional interface whose functional method is
[`checkedApply`].


**`checkedApply(X x, Y y)`**
⇒ *`R`* *(the function's result)*  
`x`: first argument to map  
`y`: second argument to map  

Apply the function to arguments


***`castDown(LavaBiFunction<? super X, ? super Y, ? extends R, ? extends E> biFunction)`***
⇒ *`LavaBiFunction<X, Y, R, E>`* *(`biFunction` casted to the compatible parametrization [`LavaBiFunction`]`<X, Y, R, E>`)*  
`X`: first accepted argument type  
`Y`: second accepted argument type  
`R`: required result type  
`E`: required exception limit  
`biFunction`: bi-function to adopt  

Safely casts between different [`LavaBiFunction`] parametrization



### LavaBiPredicate<X, Y, E>
_[(src)](src/main/java/org/tinyj/lava/LavaBiPredicate.java)_
| _(interface)_  
`X`: the function's argument type  
`E`: upper limit of thrown exception types  

A special kind of bi-function mapping its arguments to a `boolean` result.

This is the exception declaring version of [`java.util.function.BiPredicate`]

While not strictly required it usually is expected that subsequent
invocations with the same argument yield equal results.

This is a functional interface whose functional method is
[`checkedTest`].


**`checkedTest(X x, Y y)`**
⇒ *`boolean`* *(`true` if `x` matches, `false` otherwise)*  
`x`: first argument to the match  
`y`: second argument to the match  

Test if the arguments matche the predicate


***`castDown(LavaBiPredicate<? super X, ? super Y, ? extends E> biPredicate)`***
⇒ *`LavaBiPredicate<X, Y, E>`* *(`biPredicate` casted to the compatible parametrization [`LavaBiPredicate`]`<X, E>`)*  
`X`: first accepted argument type  
`Y`: second accepted argument type  
`E`: required exception limit  
`biPredicate`: bi-predicate to adopt  

Safely casts between different [`LavaBiPredicate`]parametrization



### LavaCondition\<E>
_[(src)](src/main/java/org/tinyj/lava/LavaCondition.java)_
| _(interface)_  
`E`: upper limit of thrown exception types  

A supplier of `boolean` values.

There is no requirement that a new or distinct result be returned each
time the condition is checked.

This is a functional interface whose functional method is
[`checkedTest()`].


**`checkedTest()`**
⇒ *`boolean`* *(a value)*  

Produce a value.


***`castDown(LavaCondition<? extends E> condition)`***
⇒ *`LavaCondition<E>`* *(`condition` casted to the compatible parametrization [`LavaCondition`]`<R, E>`)*  
`E`: required exception limit  
`condition`: supplier to adopt  

Safely casts between different [`LavaCondition`] parametrization



### LavaConsumer<X, E>
_[(src)](src/main/java/org/tinyj/lava/LavaConsumer.java)_
| _(interface)_  
`X`: consumed value type  
`E`: upper limit of thrown exception types  

An operation on an input value.

This is the exception declaring version of [`java.util.function.Consumer`]

Usually invoking a consumer results in side effects. Subsequent
invocations may or may not result in further side effects.

This is a functional interface whose functional method is
[`checkedAccept`].


**`checkedAccept(X x)`**  
`x`: consumed value  

Perform operation on input.


***`castDown(LavaConsumer<? super X, ? extends E> consumer)`***
⇒ *`LavaConsumer<X, E>`* *(`consumer` casted to the compatible parametrization [`LavaConsumer`]`<X, E>`)*  
`X`: accepted input type  
`E`: required exception limit  
`consumer`: consumer to adopt  

Safely casts between different [`LavaConsumer`] parametrization



### LavaFunction<X, R, E>
_[(src)](src/main/java/org/tinyj/lava/LavaFunction.java)_
| _(interface)_  
`X`: the function's argument type  
`R`: the function's result type  
`E`: upper limit of thrown exception types  

A function maps its argument to a result.

This is the exception declaring version of [`java.util.function.Function`]

While not strictly required it usually is expected that subsequent
invocations with the same argument yield equal results.

This is a functional interface whose functional method is
[`checkedApply`].


**`checkedApply(X x)`**
⇒ *`R`* *(the function's result)*  
`x`: argument to map  

Apply the function to an argument


***`castDown(LavaFunction<? super X, ? extends R, ? extends E> function)`***
⇒ *`LavaFunction<X, R, E>`* *(`function` casted to the compatible parametrization [`LavaFunction`]`<X, R, E>`)*  
`X`: accepted argument type  
`R`: required result type  
`E`: required exception limit  
`function`: function to adopt  

Safely casts between different [`LavaFunction`] parametrization



### LavaPredicate<X, E>
_[(src)](src/main/java/org/tinyj/lava/LavaPredicate.java)_
| _(interface)_  
`X`: the function's argument type  
`E`: upper limit of thrown exception types  

A special kind of function mapping its argument to a `boolean` result.

This is the exception declaring version of [`java.util.function.Predicate`]

While not strictly required it usually is expected that subsequent
invocations with the same argument yield equal results.

This is a functional interface whose functional method is
[`checkedTest`].


**`checkedTest(X x)`**
⇒ *`boolean`* *(`true` if `x` matches, `false` otherwise)*  
`x`: argument to the match  

Test if the argument matches the predicate


***`castDown(LavaPredicate<? super X, ? extends E> predicate)`***
⇒ *`LavaPredicate<X, E>`* *(`predicate` casted to the compatible parametrization [`LavaPredicate`]`<X, E>`)*  
`X`: accepted argument type  
`E`: required exception limit  
`predicate`: predicate to adopt  

Safely casts between different [`LavaPredicate`] parametrization



### LavaRunnable\<E>
_[(src)](src/main/java/org/tinyj/lava/LavaRunnable.java)_
| _(interface)_  
`E`: upper limit of thrown exception types  

A runnable task.

This is the exception declaring version of Java's [`java.lang.Runnable`]

Usually invoking a runnable results in side effects. Subsequent
invocations may or may not result in further side effects.

This is a functional interface whose functional method is
[`checkedRun`].


**`checkedRun()`**  

Execute the task.


***`castDown(LavaRunnable<? extends E> runnable)`***
⇒ *`LavaRunnable<E>`* *(`runnable` casted to the compatible parametrization [`LavaRunnable`]`<E>`)*  
`E`: required exception limit  
`runnable`: runnable to adopt  

Safely casts between different [`LavaRunnable`] parametrization



### LavaSupplier<R, E>
_[(src)](src/main/java/org/tinyj/lava/LavaSupplier.java)_
| _(interface)_  
`R`: type of supplied values  
`E`: upper limit of thrown exception types  

A supplier of values.

This is the exception declaring version of [`java.util.function.Supplier`]

There is no requirement that a new or distinct result be returned each
time the supplier is invoked.

This is a functional interface whose functional method is
[`checkedGet`].


**`checkedGet()`**
⇒ *`R`* *(a value)*  

Produce a value.


***`castDown(LavaSupplier<? extends R, ? extends E> supplier)`***
⇒ *`LavaSupplier<R, E>`* *(`supplier` casted to the compatible parametrization [`LavaSupplier`]`<R, E>`)*  
`R`: required result type  
`E`: required exception limit  
`supplier`: supplier to adopt  

Safely casts between different [`LavaSupplier`] parametrization



### NoException
_[(src)](src/main/java/org/tinyj/lava/NoException.java)_  

Marker class to declare that a function does not throw any [`Exception`].

It may still throw other [`Throwable`] types like [`Error`]s, e.g.
[`AssertionError`] or [`OutOfMemoryError`]

Using this class in a `throws`-clause does not keep unchecked exceptions
from being thrown from from that method. It obliges to the implementation
of that method to ensure no exception passes.


**`NoException()`** _(contructor)_  


### WrappedCheckedException
_[(src)](src/main/java/org/tinyj/lava/WrappedCheckedException.java)_  

Unchecked exception wrapping a checked exception.


**`WrappedCheckedException(Exception e)`** _(contructor)_  
`e`: the wrapped checked exception  

[`WrappedCheckedException`] cannot be instantiated directly. Use
`wrapCheckedException(Exception)` instead.


***`wrapCheckedException(Exception e)`***
⇒ *`RuntimeException`* *(`e` if `e` is `null` or a [`RuntimeException`],
a [`WrappedCheckedException`] wrapping `e` otherwise)*  
`e`: [`Exception`] to wrap  




***`unwrapCheckedException(Exception e)`***
⇒ *`Exception`* *(`e` if `e` is not a [`WrappedCheckedException`] or
`e.getCause()` otherwise)*  
`e`: [`Exception`] to unwrap  




***`wrapCheckedException(LavaRunnable<?> task)`***  
`task`: [`LavaRunnable`] to execute  

Execute `task`, wrap and rethrow any checked exception raised during
execution.


***`wrapCheckedException(LavaSupplier<R, ?> task)`***
⇒ *`R`* *(Value returned by `task.checkedGet()`)*  
`task`: [`LavaSupplier`] to execute  

Execute `task`, wrap and rethrow any checked exception raised during
execution. The result of `task.checkedGet()` is passed to the caller.


***`raiseUnchecked(Exception e)`***
⇒ *`R`*  

Raise `e`. If `e` is a checked exception a [`WrappedCheckedException`]
wrapping `e` is raised instead.


***`assertCheckedException(Exception cause)`***
⇒ *`Exception`*  


[`AssertionError`]: https://docs.oracle.com/javase/9/docs/api/java/lang/AssertionError.html
[`Error`]: https://docs.oracle.com/javase/9/docs/api/java/lang/Error.html
[`Exception`]: https://docs.oracle.com/javase/9/docs/api/java/lang/Exception.html
[`LavaBiConsumer`]: #lavabiconsumerx-y-e
[`LavaBiFunction`]: #lavabifunctionx-y-r-e
[`LavaBiPredicate`]: #lavabipredicatex-y-e
[`LavaCondition`]: #lavaconditione
[`LavaConsumer`]: #lavaconsumerx-e
[`LavaFunction`]: #lavafunctionx-r-e
[`LavaPredicate`]: #lavapredicatex-e
[`LavaRunnable`]: #lavarunnablee
[`LavaSupplier`]: #lavasupplierr-e
[`OutOfMemoryError`]: https://docs.oracle.com/javase/9/docs/api/java/lang/OutOfMemoryError.html
[`RuntimeException`]: https://docs.oracle.com/javase/9/docs/api/java/lang/RuntimeException.html
[`Throwable`]: https://docs.oracle.com/javase/9/docs/api/java/lang/Throwable.html
[`WrappedCheckedException`]: #wrappedcheckedexception
[`java.lang.Runnable`]: https://docs.oracle.com/javase/9/docs/api/java/lang/Runnable.html
[`java.util.function.BiConsumer`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/BiConsumer.html
[`java.util.function.BiFunction`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/BiFunction.html
[`java.util.function.BiPredicate`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/BiPredicate.html
[`java.util.function.Consumer`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/Consumer.html
[`java.util.function.Function`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/Function.html
[`java.util.function.Predicate`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/Predicate.html
[`java.util.function.Supplier`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/Supplier.html
