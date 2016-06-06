# FunWithGraphs

Basic algorithms as part of the lecture on socio-technical information systems. In this Java program:

- a simple representation for a graph based on HashMap and HashSet is shown,
- a factory method for the creation of a random graph is implemented,
- a function to compute the clustering coefficient is - not yet - given, and
- a factory method to create graphs with higher clustering coefficient according to the preferential attachment rules introduced by Barabási and Albert is shown

The program still lacks good structure (currently, the factory methods can access the implementation details of the underlying graph implementation; something considered as a bug and
not as a feature) and the computation for the clustering coefficient is still missing.
