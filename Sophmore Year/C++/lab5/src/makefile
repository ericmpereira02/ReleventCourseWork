#
# Source: http://cs.millersville.edu/~katz/linuxHelp/Makefile.txt
#
# This is a simple makefile that compiles multiple C++ source files

# set the names here to be the names of your source files with the
# .cxx or .cpp replaced by .o
# Be *** SURE *** to put the .o files here rather than the source files

Objects = image_struct_pointers.o image_struct_references.o image_difference.o

# This is a simple makefile that compiles multiple C++ source files

# set the names here to be the names of your source files with the
# .cxx or .cpp replaced by .o
# Be *** SURE *** to put the .o files here rather than the source files

proj1 = image_struct_pointers.o 
proj2 = image_struct_references.o
proj3 = image_difference.o

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

all: image_struct_pointers image_struct_references image_difference

image_struct_pointers: $(proj1)
	g++ $(CFLAGS) $(proj1) -o image_struct_pointers
	
image_struct_references: $(proj2)
	g++ $(CFLAGS) $(proj2) -o image_struct_references
	
image_difference: $(proj3)
	g++ $(CFLAGS) $(proj3) -o image_difference

clean:
	rm -f $(Objects) image_struct_pointers image_struct_references image_difference
#------------ dependencies --------------------------------------------
# put the .o that depends on a .h, then colon, then TAB, then the .h

image_struct_pointers.o:	dummy_driver.h
image_struct_references.o:  dummy_driver.h
image_difference.o:         dummy_driver.h


