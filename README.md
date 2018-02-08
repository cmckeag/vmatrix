# vmatrix
Context:
In the MMORPG MapleStory, you can equip nodes on your character that are meant to boost skills. A single node contains 3 unique skills: a main skill, and 2 sub skills. Each node can boost a skill by 50%, but the maximum total boost is 100%, meaning that in order to get the full boost for a particular skill, you need it to appear at least twice amongst your equipped nodes.

This program takes in an input of unique nodes that the user possesses, the desired skills that the user wants to boost, and the number of times they want each skill to appear in their V Matrix (2 or 3), and returns any possible configuration of nodes that meets the requirements.

The program treats nodes as "tuples", and searches using a brute force method that checks every possible combination of "contributing" nodes (i.e. nodes that contain at least 2 skills relevant to the user's request) and returns the ones for which the desired skills each appear at least (2 or 3) times.
