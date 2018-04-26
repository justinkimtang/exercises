JCC=javac
JFLAGS=-g 
.SUFFIXES: .java .class
.java.class:
	$(JCC) $(JFLAGS) $*.java
CLASSES = \
	bubbleSort.java \
	bucketSort.java \
	cocktailSort.java \
	combSort.java \
	countingSort.java \
	heapSort.java \
	helper.java \
	insertionSort.java \
	mergeSort.java \
	quickSort.java \
	radixSort.java \
	selectionSort.java \
	shellSort.java \
	test.java \

default: all

all: $(CLASSES:.java=.class)

clean:
	$(RM) *.class