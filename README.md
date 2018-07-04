# vmatrix
Context:
Uses a brute force method to find an optimal number of desired pairs out of sets of trios. Not much to see here.

This program takes in an input of unique nodes that the user possesses, the desired items that the user wants from the trios, and the number of times they want each item to appear in their V Matrix (2 or 3), and returns any possible configuration of nodes that meets the requirements.

The program treats nodes as "tuples", and searches using a brute force method that checks every possible combination of "contributing" nodes (i.e. nodes that contain at least 2 items relevant to the user's request) and returns the ones for which the desired items each appear at least (2 or 3) times.
