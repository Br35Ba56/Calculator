package Calculator;

/*
 * Author: Anthony Schneider
 * File : Node.java
 * Purpose: Define a structure for Node Objects.
 */

public interface Node {
    double evaluate();

    String inOrderWalk();

    String postOrderWalk();
}
