#
# Source: http://cs.millersville.edu/~katz/linuxHelp/Makefile.txt
#
# This is a simple makefile that compiles multiple C++ source files

# set the names here to be the names of your source files with the
# .cxx or .cpp replaced by .o
# Be *** SURE *** to put the .o files here rather than the source files

Objects =  fibonacci_sequence.o geometry_calculator.o long_distance_calls.o numerical_computations.o roman_numeral_converter.o time_calculator.o

# This is a simple makefile that compiles multiple C++ source files

# set the names here to be the names of your source files with the
# .cxx or .cpp replaced by .o
# Be *** SURE *** to put the .o files here rather than the source files

proj1 = fibonacci_sequence.o
proj2 = roman_numeral_converter.o
proj3 = time_calculator.o
proj4 = geometry_calculator.o
proj5 = long_distance_calls.o
proj6 = numerical_computations.o

#------------ no need to change between these lines -------------------
CFLAGS = -g -Wall
.SUFFIXES: .cxx .cpp .c

.cxx.o:
	g++ $(CFLAGS) -c $<

.cpp.o:
	g++ $(CFLAGS) -c $<

.c.o:
	g++ $(CFLAGS) -c $<


#------------ no need to change between these lines -------------------


#------------ targets --------------------------------------------
# describe how to create the targets - often there will be only one target

all: fibonacci_sequence roman_numeral_converter time_calculator geometry_calculator long_distance_calls numerical_computation

fibonacci_sequence: $(proj1)
	g++ $(CFLAGS) $(proj1) -o fibonacci_sequence

roman_numeral_converter: $(proj2)
	g++ $(CFLAGS) $(proj2) -o roman_numeral_converter

time_calculator: $(proj3)
	g++ $(CFLAGS) $(proj3) -o time_calculator
	
geometry_calculator: $(proj4)
	g++ $(CFLAGS) $(proj4) -o geometry_calculator

long_distance_calls: $(proj5)
	g++ $(CFLAGS) $(proj5) -o long_distance_calls
	
numerical_computation: $(proj6)
	g++ $(CFLAGS) $(proj6) -o numerical_computation
	

clean:
	rm -f $(Objects) fibonacci_sequence roman_numeral_converter time_calculator geometry_calculator long_distance_calls numerical_computation
#------------ dependencies --------------------------------------------
# put the .o that depends on a .h, then colon, then TAB, then the .h

#class1.o:	class1.h
#class2.o:	class2.h
#theProject.o:	class1.h class2.h


