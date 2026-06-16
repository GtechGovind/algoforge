# Programming Patterns (Design + Real-World View)

## How to read this section

Use one pattern at a time.

1. Read the problem it solves.
2. See the simple picture.
3. Copy the tiny template.
4. Try one short example.
5. Explain in one line: “I used this because ...”

---

## 1) Factory Pattern

### Easy idea

A factory is a robot that gives you the right object from one button.

### Visual

```text
Request ──> Factory ──> {Email, SMS, Push}
```

### Real use

Choosing how to notify a user without changing core flow.

### Tiny template

```python
class Notifier:
    def send(self, message):
        pass

class EmailNotifier(Notifier): ...
class SmsNotifier(Notifier): ...

class NotifierFactory:
    @staticmethod
    def create(kind):
        if kind == "email": return EmailNotifier()
        if kind == "sms":   return SmsNotifier()
        raise ValueError("bad kind")
```

### Use / Avoid

- Use: add a new type by adding one class.
- Avoid: scattering `if/else` all through core logic.

### 1-line test

Can I add a third channel without changing the caller?

---

## 2) Abstract Factory

### Easy idea

A family shop that creates a full matching set.

### Visual

```text
Theme ──> WidgetFactory ──> Button + Dialog + Card
```

### Real use

Dark mode UI needs a dark button and dark dialog together.

### Tiny template

```java
interface WidgetFactory {
  Button makeButton();
  Dialog makeDialog();
}

class DarkThemeFactory implements WidgetFactory { ... }
class LightThemeFactory implements WidgetFactory { ... }

void render(WidgetFactory f) {
  f.makeButton().render();
  f.makeDialog().render();
}
```

### Use / Avoid

- Use: families of objects that must stay consistent.
- Avoid: mixing families manually in many places.

---

## 3) Singleton

### Easy idea

Only one copy of a shared object exists for the whole app.

### Visual

```text
+-------------------+
|   AppConfig       |
| single shared box  |
+-------------------+
```

### Real use

Global settings, app configuration, connection pools.

### Tiny template

```java
public final class AppConfig {
  private static final AppConfig INSTANCE = new AppConfig();
  private AppConfig() {}
  public static AppConfig getInstance() { return INSTANCE; }
}
```

### Use / Avoid

- Use: shared infra state.
- Avoid: storing business logic there.

---

## 4) Builder

### Easy idea

Build one pizza step by step. No giant constructor with 12 args.

### Visual

```text
report = new builder
  -> title
  -> date range
  -> format
  -> build
```

### Real use

Complex object with optional fields.

### Tiny template

```javascript
class ReportBuilder {
  setTitle(t) { this.t = t; return this; }
  setRange(a, b) { this.range = [a, b]; return this; }
  withChart(v) { this.chart = v; return this; }
  build() { return {...this}; }
}
```

### Use / Avoid

- Use: readability and safe defaults.
- Avoid: overusing for tiny objects.

---

## 5) Strategy

### Easy idea

You can swap one behavior while everything else stays the same.

### Visual

```text
Context -> Strategy A
Context -> Strategy B
```

### Real use

Discount logic, parsing formats, shipping calculations.

### Tiny template

```javascript
const rate = {
  flat:  p => p - 20,
  pct:   p => p * 0.9,
  bogo:  p => Math.ceil(p / 2),
}

function checkout(price, mode) {
  return rate[mode](price);
}
```

### Use / Avoid

- Use: multiple formulas for one task.
- Avoid: too many strategy variants for rare cases.

---

## 6) Observer

### Easy idea

Many listeners hear one update.

### Visual

```text
Subject
  ├─> A updates
  ├─> B updates
  └─> C updates
```

### Real use

Price feed updates UI, logs, alerts together.

### Tiny template

```python
class Subject:
  def __init__(self): self.listeners = []
  def attach(self, fn): self.listeners.append(fn)
  def notify(self, v):
    for f in self.listeners: f(v)
```

### Use / Avoid

- Use: one event source, many consumers.
- Avoid: circular update chains.

---

## 7) Adapter

### Easy idea

Adapter = adapter plug that makes old and new APIs fit.

### Visual

```text
YourCode -> Adapter -> ThirdPartyCode
```

### Real use

Legacy payment SDK with different method signature.

### Tiny template

```javascript
class Adapter {
  constructor(newGateway){ this.g = newGateway; }
  pay(amount, account) {
    const r = this.g.transfer({ from: account, amount });
    return r.ok ? `tx-${r.id}` : null;
  }
}
```

### Use / Avoid

- Use: third-party mismatch.
- Avoid: stacking many adapters to hide design smell.

---

## 8) Decorator

### Easy idea

Wrap behavior like layers on a sandwich.

### Visual

```text
Base stream
  + compression layer
  + encryption layer
  = final stream
```

### Real use

Add optional features (cache, compression, auth) without new subclasses.

### Tiny template

```python
class BaseResponse:
  def wrap(self, data): return data
class Compression(BaseResponse): ...
class Encryption(BaseResponse): ...
```

### Use / Avoid

- Use: optional layers that can be combined.
- Avoid: when class hierarchy is already simple.

---

## Quick practice block

1. Pick one pattern.
2. Write 3 real examples from your project.
3. Pick one and refactor one function.
4. Explain why it is better in 1 line.

Goal: every pattern page should end with a mini code memory, not just theory.
