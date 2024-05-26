## Imagine a Stack of Pancakes!

Hey there! Imagine you're making a delicious stack of pancakes. This code helps you understand how a "stack" works in computer science. We'll use your pancake stack as an example.

**What is a Stack?**

A stack is like a stack of pancakes. You can only do a few things with it:

- **Add a pancake on top (push):** `push(T elem)`
  - Imagine adding a freshly made pancake to the top of your stack.
- **Take the top pancake off (pop):** `pop()`
  - This is like taking the top pancake from the stack to eat it.
- **Peek at the top pancake (peek):** `peek()`
  - You want to see if the top pancake is your favorite (chocolate chip maybe?) without taking it off the stack.
- **Check how many pancakes are there (size):** `size()`
  - How high is your pancake stack? This tells you.
- **See if the plate is empty (isEmpty):** `isEmpty()`
  - Are there any pancakes on the plate yet?

**Let's look at the code (like a recipe for your stack):**

```java
package datastructure.stack;

public interface Stack<T> {
    // T means any type of pancake you want!

    // How many pancakes are on the stack?
    public int size();

    // Is the plate empty (no pancakes)?
    public boolean isEmpty();

    // Add a pancake to the top!
    public void push(T elem);

    // Take the top pancake off and eat it!
    public T pop();

    // Peek at the top pancake (chocolate chips?)
    public T peek();
}
```

**Time Complexity (How long does each action take?):**

Most of these actions are super fast! Think of it like this:

- **push(T elem):** Like gently placing a pancake on top - very quick! (Time Complexity: O(1))
- **pop():** Taking the top pancake - also very quick! (Time Complexity: O(1))
- **peek():** Just a quick glance - super fast! (Time Complexity: O(1))
- **size():** You might need to count a little, but it's still pretty fast (Time Complexity: Could be O(1) or O(n) depending on how the stack is implemented).
- **isEmpty():** Just a quick check to see if there are any pancakes - very fast! (Time Complexity: O(1))

**Important Note:** "O(1)" means the time it takes to do something doesn't change even if the stack gets huge.

Let me know if you'd like to see how we could actually write code to create our own stack of pancakes! 🥞
