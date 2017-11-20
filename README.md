
# TinyJ Lava-API
[![build status](https://travis-ci.org/tinyj/tinyj-lava-api.svg?branch=master)](https://travis-ci.org/tinyj/tinyj-lava-api)

Functional interfaces with checked exceptions.

Java's default functional interfaces (i.e. `java.util.function.Function` and
friends) allow for raising checked exception, which basically denies us from
using these neat lambda shorthands for anything that may throw checked
exceptions. tinyj-lava-api is a first step to fix that defining equivalent
functional interfaces with declared checked exceptions.

Additionally tinyj-lava-api defines two exception types. `NoException` is a
marker class that allows to declare a method to not to throw any exception at
all. *This is not enforced by the compiler* though. `WrappedCheckedException`
is just for wrapping checked exceptions. While `new RuntimeException(e)`
achieves the same thing using `WrappedCheckedException` allows for clearer
communication and makes unwrapping of such exceptions much easier.

## API documentation

You can find the API documentation [here](APIdoc.md).


## License

Copyright © 2017 Eric Karge <e.karge@struction.de>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
