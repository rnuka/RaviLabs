package practice.coding.others;

/**
 * Created by rnuka on 11/29/16.
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
/*

(From interview-cake email, both question and solution)

Question: You're working with an intern that keeps coming to you with JavaScript code that
won't run because the braces, brackets, and parentheses are off. To save you both some time,
you decide to write a braces/brackets/parentheses validator.
Let's say:

'(', '{', '[' are called "openers."
')', '}', ']' are called "closers."
Write an efficient function that tells us whether or not an input string's openers and closers
are properly nested.

Examples:

"{ [ ] ( ) }" should return true
"{ [ ( ] ) }" should return false
"{ [ }" should return false

Link: https://www.interviewcake.com/question/java/bracket-validator
*/

public class BracketValidator {

    public boolean isValid(String code) {

        Map<Character, Character> openersToClosers = new HashMap<Character, Character>();
        openersToClosers.put('(', ')');
        openersToClosers.put('[', ']');
        openersToClosers.put('{', '}');

        Set<Character> openers = openersToClosers.keySet();
        Set<Character> closers = new HashSet<Character>(openersToClosers.values());

        Stack<Character> openersStack = new Stack<Character>();

        for (char c : code.toCharArray()) {
            if (openers.contains(c)) {
                openersStack.push(c);
            } else if (closers.contains(c)) {
                if (openersStack.empty()) {
                    return false;
                } else {
                    char lastUnclosedOpener = openersStack.pop();

                    // if this closer doesn't correspond to the most recently
                    // seen unclosed opener, short-circuit, returning false
                    if (openersToClosers.get(lastUnclosedOpener) != c) {
                        return false;
                    }
                }
            }
        }
        return openersStack.empty();
    }

}
