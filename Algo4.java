import java.util.*;
import java.util.Stack;

class Algo4{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t >= 0){
            String str = sc.nextLine();
            boolean flag = isTrueExpression(str);
            if(flag){
                System.out.println(true);
            }
            else if(flag == false){
                System.out.println(false);
            }
            t--;
        }
    }

    public static boolean isTrueExpression(String str){
        str = str.replaceAll(" ", "");
        int indexEquals = -1;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '='){
                indexEquals = i;
            }
        }
        if(indexEquals == -1){
            return false;
        }
        int ans = evalute(str.substring(0, indexEquals));
        String right = str.substring(indexEquals+1, str.length());
        if(ans == Integer.parseInt(right)){
            return true;
        }
        return false;
    }

    public static int evalute(String expression){
        char[] tokens = expression.toCharArray();

		// Stack for numbers: 'values'
		Stack<Integer> values = new Stack<Integer>();

		// Stack for Operators: 'ops'
		Stack<Character> ops = new Stack<Character>();

		for (int i = 0; i < tokens.length; i++)
		{
			// Current token is a whitespace, skip it
			if (tokens[i] == ' ')
				continue;

			// Current token is a number, push it to stack for numbers
			if (tokens[i] >= '0' && tokens[i] <= '9')
			{
				StringBuffer sbuf = new StringBuffer();
				// There may be more than one digits in number
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					sbuf.append(tokens[i++]);
				values.push(Integer.parseInt(sbuf.toString()));
			}

			// Current token is an opening brace, push it to 'ops'
			else if (tokens[i] == '(')
				ops.push(tokens[i]);

			// Closing brace encountered, solve entire brace
			else if (tokens[i] == ')')
			{
				while (ops.peek() != '(')
				values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				ops.pop();
			}

			// Current token is an operator.
			else if (tokens[i] == '+' || tokens[i] == '-' ||
					tokens[i] == '*' || tokens[i] == '/')
			{
				// While top of 'ops' has same or greater precedence to current
				// token, which is an operator. Apply operator on top of 'ops'
				// to top two elements in values stack
				while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
				values.push(applyOp(ops.pop(), values.pop(), values.pop()));

				// Push current token to 'ops'.
				ops.push(tokens[i]);
			}
		}

		// Entire expression has been parsed at this point, apply remaining
		// ops to remaining values
		while (!ops.empty())
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));

		// Top of 'values' contains result, return it
		return values.pop();
    }

    public static boolean hasPrecedence(char op1, char op2)
	{
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

    public static int applyOp(char op, int b, int a)
	{
		switch (op)
		{
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new
				UnsupportedOperationException("Cannot divide by zero");
			return a / b;
		}
		return 0;
	}
}