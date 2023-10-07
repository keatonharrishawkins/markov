See documentation in public README.md for P3 Markov Part 2:

https://coursework.cs.duke.edu/201-public-documentation/p3-markov-part-ii/-/blob/main/README.md

This project implements a standard Markov Model to generate random text that mimics the style and word patterns of any training text supplied by the user. A HashMap optimization in the EfficientMarkov and EfficientWordMarkov classes improve runtime from O(NT) to O(N+T), for N the length of the training text and T the number of characters generated.
