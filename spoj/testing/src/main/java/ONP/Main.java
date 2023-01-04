package ONP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
4
a+b
(a+(b*c))
((a+b)*(z+x))
((a+t)*((b+(a+c))^(c+d)))


Output

ab+
abc*+
ab+zx+*
at+bac++cd+^*
 */
public class Main {
    public static final Map<Character, Integer> operatorPresedance = new HashMap<>();

    static {
        operatorPresedance.put('+', 0);
        operatorPresedance.put('-', 0);
        operatorPresedance.put('*', 1);
        operatorPresedance.put('/', 1);
        operatorPresedance.put('^', 2);
    }

    public static final Set<Character> operatorCharSet = new HashSet<>(Arrays.asList('+', '-', '*', '/', '^'));

    ;

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        //the number of expressions <= 100
        int testCases = Integer.parseInt(r.readLine());

        for (int t = 0; t < testCases; t++) {
            // expression [length <= 400]
            final String orignialExp = r.readLine();

            Stack<Character> operatorStack = new Stack<>();
            List<Character> outputQueue = new ArrayList<>();

            for (int i = 0; i < orignialExp.length(); i++) {
                char token = orignialExp.charAt(i);

                if (Character.isAlphabetic(token)) {
                    outputQueue.add(token);
                    continue;
                }
                if (operatorCharSet.contains(token)) {
                    while (!operatorStack.empty()) {
                        Character peekOp = operatorStack.peek();
                        if (peekOp == '(') {
                            break;
                        } else {
                            if (operatorPresedance.get(peekOp) >= operatorPresedance.get(token)) {
                                outputQueue.add(operatorStack.pop());
                            }
                            //TODO -check left associative
                        }
                    }

                    operatorStack.push(token);
                    continue;
                }
                if (token == '(') {
                    operatorStack.push(token);
                    continue;
                }

                if (token == ')') {
                    while (operatorStack.peek() != '(' && !operatorStack.empty()) {
                        outputQueue.add(operatorStack.pop());
                    }
                    if (operatorStack.peek() != '(') {
                        new RuntimeException("unmatch paratrecese");
                    }
                    operatorStack.pop();
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Character c : outputQueue) {
                sb.append(c);
            }
            while (!operatorStack.empty()) {
                Character c = operatorStack.pop();
                if (c != '(') {
                    sb.append(c);
                }
            }
            System.out.println(sb);
        }
    }

}
