# Clojurescript Redux

An example project which implements a [Redux](https://github.com/rackt/redux)-like project-structure with routing in ClojureScript.

## Setup

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).

## Ideas

- Parse the Bidi-routes to calculate the nested handler structure. Convert this structure into containers via multimethod.
- Use `defrecord` for actions and use `instance?` in the reducers.
- Implement memoized selectors for more performance when working with derived data.

## License

MIT
