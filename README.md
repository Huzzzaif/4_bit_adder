Summer II 2023 CSC 582, Assignment #1
Object-Oriented Programming of a System: The Four-Bit Adder

NOTE: Starter code (see GitHub Invitation link that follows) and instructions are for C++. C++ is
the preferred language for our course. However, due to the accelerated pace of the summer term,
you may use any object-oriented programming language of your choice for the assignment.
Introduction
Assignment #1 serves to introduce you to the following:

1. Git (https://git-scm.com/)
2. GitHub
3. CMake (https://cmake.org/documentation/)
4. astyle (http://astyle.sourceforge.net/astyle.html)
5. Doxygen (https://www.doxygen.nl/index.html)
6. Google Test (https://github.com/google/googletest/blob/master/googletest/docs/primer.md)
7. IRC (or other messaging system if embedded in GitHub)
8. C++ classes
9. Use of primitives in a system implementation.

You will be writing a virtual four-bit adder circuit, using only the logic gates in the starter code. This repository is
part of the assignment invitation in GitHub.
You may choose a team of up to a total five students for this assignment..
The purpose of the assignment is to acquaint you with C++ object-oriented programming, and to apply your current
knowledge to an object-oriented system. As computer hardware is inherently complex (as defined by Booch), it
possesses a natural hierarchy of components. It will be up to you to translate both its “is a” and “part of” hierarchies
(known as the canonical view) into C++ code.
The starter code contains an abstract base class for logic gates. The logic gates themselves are the primitives of our
system. In addition, the starter code also includes the required directory structure, concrete classes (AND, OR, NAND
object-type definitions in C++), and CMakeLists.txt files.
The four-bit adder circuit is a topic from your computer architecture course(s). You should be familiar by now with
this technology. Thus, it is an ideal system for our foray into object orientation.
You will need to verify that your implementation works, by writing unit tests using Google Test (gtest). I will
explain gtest in the accompanying video description of this assignment. I have already provided some unit tests to
get you going, which test the constructors of the AND, OR, and NAND classes, along with the entire truth-table of the
OR gate.
You will also use Doxygen to generate class and object diagrams, displaying both the object and class hierarchies of
your assignment code.

2

The GitHub assignment link is: https://classroom.github.com/a/Jpf7RaDn.
Background
Included here is a brief review of the four-bit adder. This is a great system to model with Object-Oriented

1

Programming (OOP), as computer hardware is designed and implemented as a hierarchical system.
Our system primitives are the logic gates: AND, OR, and NAND. The AND, OR, and NOT gates are shown in Fig.
1. You will make a NOT gate from a NAND primitive.
2

Figure 1. Basic Boolean operations.

Using the basic gates, we can build a half-adder circuit. You will need to implement a half-adder object-type (class)
for instantiation in the object hierarchy of your program. A half-adder circuit is shown in Fig. 2.

Figure 2. A half-adder circuit.

Figure 3 shows a full-adder, which is nothing more than two cascaded half-adders, with some additional gates for
the carry-in bit. Figure 4 shows the entire set of possible inputs, and specified outputs, of the full-adder logic circuit.

2 Because we can make a NOT gate from a NAND gate, we use the NAND gate as a primitive. This is done simply by using the
same value for both of the NAND gate’s inputs.
1 Figures are from https://www.waitingforfriday.com/?p=529, unless otherwise stated.

3

You will need to implement unit tests to verify the truth table for all circuits in this system. Each circuit represents a
level of organization of the objects in your object hierarchy.

Figure 3. A full-adder circuit.

Figure 4. The full-adder truth table (from https://www.geeksforgeeks.org/full-adder-in-digital-logic/).

Finally, in Fig. 5, we can connect together four full-adder circuits to get a four-bit adder. This could naturally be
extended to any n-bit adder. However, this assignment specifies a four-bit adder only.

Figure 5. The four-bit adder circuit.

4

For each of these circuits, starting with the half-adder, you will make the proper connections between each level of
organization in your objects. You will use a combination of inheritance (all gates derive from an abstract gate) and
class composition (a full-adder contains two half-adders, and so on).
You should build the system from only the given primitive classes:
1. AND
2. OR
3. NAND
You need a half-adder, full-adder, and finally a four-bit adder class.
Additionally, you must maintain the directory structure from the starter repository. You will notice there is already a
place-holder for the FourBitAdder.h and FourBitAdder.cpp files. FourBitAdder.h is above the intern
subdirectory in the FourBitAdder folder, while FourBitAdder.cpp is inside
[repository]/source/FourBitAdder/intern/. This file organization encapsulates the implementation of the
FourBitAdder class, by separating it from its interface: FourBitAdder.h.
Lastly, you should create an AbstractDevice class, to enforce the updating of the output pins whenever the input
pins are set on a higher-order circuit (i.e., any of the circuits in this system). There is no place-holder for an
AbstractDevice class in the starter repository.

Deliverables
In combination with making necessary piece-meal commits to your group’s git repository hosted in GitHub
Classroom, you will also need to include JavaDoc style comments for each of your classes’ member functions and
source files. You need to run astyle (a prettyprint utility) in default mode, on all of your source and header files
before committing any of their updates to the repository.
In summary, the grading rubric is:
1. Code must compile. 10%
2. IRC Channel logs for your group’s communication. 10%
3. Run astyle before each commit. Each commit must contain a comment. There must be a total of at least
10 separate commits in your final submission. 5%
4. Use Hungarian notation for variables (http://web.mst.edu/~cpp/common/hungarian.html). 5%
5. Include the output of your final Doxygen docs folder, in your final pushed commit.
3 10%

6. Class and object structure. 20%
7. Complete truth-table unit tests (using gtest) for each class in your system. 25%
8. Program correctness (passes all unit tests with correct output). 15%
Note: consult the assignment video description for further clarification and instruction.
3 Do not place your Doxygen output on a public server. This constitutes cheating, as other students would have access to your
work.
