# Arithmetic Calculator

This calculator evaluates simple arithmetic expression.
Fraction value not supported.

## Lexer

Scans source code to output tokens

## Parser

The parser takes tokens and builds meaning/structure.

```text
expression -> term
            ( ("+" | "-") term )*

term       -> factor
            ( ("*" | "/") factor )*

factor     -> NUMBER
            | "(" expression ")"
```

