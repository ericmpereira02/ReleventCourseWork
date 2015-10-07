#
# Source: http://cs.millersville.edu/~katz/linuxHelp/Makefile.txt
#
# This is a simple makefile that compiles multiple C++ source files

# set the names here to be the names of your source files with the
# .cxx or .cpp replaced by .o
# Be *** SURE *** to put the .o files here rather than the source files

Objects = linked_list.o main.o

# This is a simple makefile that compiles multiple C++ source files

# set the names here to be the names of your source files with the
# .cxx or .cpp replaced by .o
# Be *** SURE *** to put the .o files here rather than the source files

proj1 = linked_list.o
proj2 = main.o

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

all: linked_list main

linked_list: $(proj1)
	g++ $(CFLAGS) $(proj1) main.cpp -o linked_list

main: $(proj2)
	g++ $(CFLAGS) $(proj2) linked_list.cpp -o main

clean:
	rm -f $(Objects) linked_list main
#------------ dependencies --------------------------------------------
# put the .o that depends on a .h, then colon, then TAB, then the .h

linked_list.o:	linked_list.h
main.o: 	linked_list.h


