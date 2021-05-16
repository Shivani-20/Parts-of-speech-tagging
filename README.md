## Background:

Parts of speech (also known as POS) and named entities are useful clues to sentence structure and meaning. Knowing whether a word is a noun or a verb tells us about likely neighboring words (nouns in English are preceded by determiners and adjectives, verbs by nouns) and syntactic structure (verbs have dependency links to nouns), making part-of speech tagging a key aspect of parsing. Knowing if a named entity like Washington is a name of a person, a place, or a university is important to many natural language understanding tasks like question answering, stance detection, or information extraction.

Penn Treebank part-of-speech tags:

![](tag_list.png)

### Task: 

part-of-speech tagging: mapping from input words x1, x2,..., xn to output POS tags y1, y2,..., yn 

![](work.png)

<br/>

## Class diagram:

![](Class_diagram.png)

<br/>

## Activity diagram:

![](Activity_diagram.png)

<br/>

## Processing starts, 

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
