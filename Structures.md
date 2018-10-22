# Palindrome


## Patterns

* [Palindrome Checker](https://github.com/drestion/leetcode/blob/master/techniques/Palindrome.java)
	* Recursive definition: char[i] == char[j] && ( (i+1 <= j-1 && isPalindrome(i+1, j-1)) || i+1 > j-1)
	* Nonrecursive definition: See code 
## Links

Dynamic Programming, DFS, BFS, Recursion

## Thoughts

It seems palindrome links to edit distance


# Parenthesis



## Thoughts

It seems palindrome links to edit distance

# Dynamic Programming

https://medium.com/@dakota.lillie/an-intro-to-dynamic-programming-pt-ii-edit-distance-ceed0b12fe6d

Notice that the recursion should carry enough information and you should increase the number of subproblems when necessary to exhaust ***ALL*** possible solutions.

## The Suffix model
## The Prefix model
## The Substring model
## Topological Order
## Problems needs optimal result form VS. needing just optimal result number

## Knapsack
# Search Space Shrinkage

The idea is to reduce the search space using available information. Simiar to the gradient decent idea in neuron network training.
This technique is frequently used in Dynamic Programming.

## Binary Search

A special case where the string is sorted.

## Two Pointer

A special case where the string is not sorted.


# Data Structure Design


# Sort

## Merge Sort


# Substring

## Template

# Linked List

## Fast Slower Pointers
## Cycle Detection
## Reverse List


# Random Numbers

# Tree

## Binary Search Tree
## In-order Traversal
## Level-order Traversal


# Number Ranges

Integer.MAX_VALUE = 2^32 - 1;



# Depth First Search

One key is to mark visited nodes to avoid revisiting.

## Avoid Nodes Revisiting
### Change Cell Values in Matrix
### Remove Visited Values from List
### Maintain Visited Nodes Set

# Breadth First Search

BFS may be faster than DFS in graph search


# Greedy Algorithm


# Array

If possible, sort first.

# Sorting


# Backtracking

# Permutation


# Interval

# Heap
maxHeap

# Number 
Overflow? Integer.MAX_VALUE MIN_VALUE? Check for these corner cases

# Priority Queue

# Deque