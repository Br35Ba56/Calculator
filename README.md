# Calculator

Calculator that converts infix expressions to postfix, creates a binary expression tree, and evaluates the tree recursively, displaying the result to the user.

This calculator works by converting an infix expression to postfix expression via the "Shunting yard algorithm".
Then, the postfix expression is parsed into a expression tree builder.
The expression tree builder uses a stack based algorithm to build the binary expression tree.

Through polymorphism, an expression tree object is created consisting of Operand Nodes and Operator Nodes. 
Operand Nodes and Operator Nodes both can be passed as Nodes through their implementation of the Node interface.  
Though this polymorphic design, the tree can easily be composed and traversed recursively.

Finally, the binary expression tree is evaluated recursively.

Some unused methods were left in as an example of how to traverse the expression tree using in order walk and post order walk.  
In order walk will print out the infix expression, post order walk will print out the postfix expression.
