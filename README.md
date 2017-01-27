# st-201617-unique-sub
Aileen and Jonah, describe your project here and how a symbol table is used in your implementation.

Our project: 
Unique substrings of length L. We will write a program that reads in text from standard input and calculate the number of unique substrings of length L that it contains. For example, if the input is cgcgggcgcg then there are 5 unique substrings of length 3: cgc, cgg, gcg, ggc, and ggg. 
We will use the string method substring(i, i + L) to extract ith substring and insert into a symbol table. We will then test it out on the first million digits of π.
