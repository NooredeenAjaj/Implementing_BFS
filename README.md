# Implementing_BFS




## Overview
This project is an implementation of the word ladder problem using a breadth-first search (BFS) algorithm. 

## Problem Description
Given a dictionary of five-letter words, the task is to construct a graph where each node represents a word. An arc is drawn from node u to node v if all of the last four letters in u are present in v. The goal is to find the length of the shortest path between a given "start" word and an "end" word for a series of queries. 

## Example

Given the following input:
5 3
there
where
input
putin
hello
there where
putin input
hello putin



The program will output:
1
1
Impossible





## Project Structure
The project consists of a single `Main` class, which includes methods to:

- Read input from the console
- Construct a graph representation of the problem
- Implement a BFS algorithm to find the shortest path between two words

## Implementation Details
- The graph is represented using an adjacency list.
- The BFS algorithm is implemented in the `findShortestPath` method.
- The `buildGraph` method constructs the graph, determining which words (nodes) are connected.

## How to Run
1. Compile the Java file:

javac Main.java

2. run :
./check_solution.sh java Main

## Requirements

Java SE 11 or above


