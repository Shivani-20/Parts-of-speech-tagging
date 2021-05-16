## Background:

Parts of speech (also known as POS) and named entities are useful clues to sentence structure and meaning. Knowing whether a word is a noun or a verb tells us about likely neighboring words (nouns in English are preceded by determiners and adjectives, verbs by nouns) and syntactic structure (verbs have dependency links to nouns), making part-of speech tagging a key aspect of parsing. 

Penn Treebank part-of-speech tags:

![](tag_list.png)

## Task: 

Part-of-speech tagging: mapping from input words x1, x2,..., xn to output POS tags y1, y2,..., yn 

![](work.png)

### Using HMM Part-of-Speech Tagging:

A hidden Markov model (HMM) allows us to talk about both observed events hidden Markov model (like words that we see in the input) and hidden events (like part-of-speech tags) that we think of as causal factors in our probabilistic model. An HMM is specified by the following components:

![](components.png)

### HMM Tagging as decoding:

For any model, such as an HMM, that contains hidden variables, the task of determining the hidden variables sequence corresponding to the sequence of observations decoding is called decoding. More formally,

Decoding: Given as input an HMM λ = (A,B) and a sequence of observations O = o1,o2,...,oT , find the most probable sequence of states Q = q1q2q3 ...qT.

![](repre.png)

### Viterbi algorithm which makes HMM tagging possible:

![](viterbi.png)

![](notations.png)

### Example:

sentence = Janet will back the bill

tags = NNP,MD,VB,JJ,NN,RB,DT

Transition probabilities computed from Wall Streeet Journal corpus:

![](wsj.png)

Each a[i,j] represents the probability for transitioning between the hidden states (part-of-speech tags).

Observation likelihoods of words given tags:

![](obs.png)

Calculating viterbi values and path probabilities to find correct tags associated with the word: 

![](whats_happening.png)

## Scope

I 

<br/>

## Class diagram:

![](Class_diagram.png)

<br/>

## Activity diagram:

![](Activity_diagram.png)

<br/>

## Output: 

###first system asks for words of the sentence

![](sentence.png)

<br/>

###then for tags

![](tags.png)

<br/>

###then word probabilties

![](state_likelihoods.png)

<br/>

###then tag probabilities

![](transition_probabilities.png)

<br/>

###then word distribution

![](result.png)
