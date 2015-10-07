#
# Source: http://cs.millersville.edu/~katz/linuxHelp/Makefile.txt
#
# This is a simple makefile that compiles multiple C++ source files

# set the names here to be the names of your source files with the
# .cxx or .cpp replaced by .o
# Be *** SURE *** to put the .o files here rather than the source files

Objects = linked_list.o queue.o stack.o

# This is a simple makefile that compiles multiple C++ source files

# set the names here to be the names of your source files with the
# .cxx or .cpp replaced by .o
# Be *** SURE *** to put the .o files here rather than the source files

proj1 = linked_list.o
proj2 = stack.o
proj3 = queue.o

#------------ no need to change between these lines -------------------
CFLAGS = -g -pedantic -Wall -Wextra -Wshadow
.SUFFIXES: .cxx .cpp .c

.cxx.o:
	g++ $(CFLAGS) -c $<

.cpp.o:
	g++ $(CFLAGS) -c $<

.c.o:
	g++ $(CFLAGS) -c $<


#------------ no need to change between these lines -------------------


#------------ targets --------------------------------------------
# describe how to create the targets - often there will be only one targetall: linked_list queue stack main

all: exe

exe: $(proj1) $(proj2) $(proj3)
	g++ $(CFLAGS) $(proj1) $(proj2) $(proj3) main.cpp -o exe

clean:
	rm -f $(Objects) exe
#------------ dependencies --------------------------------------------
# put the .o that depends on a .h, then colon, then TAB, then the .h
linked_list.o:		linked_list.h
main.o:			linked_list.h
main.o:			queue.h
main.o:			stack.h
queue.o:		queue.h
stack.o:		stack.h
