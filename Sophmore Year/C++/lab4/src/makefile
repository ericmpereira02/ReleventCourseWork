#
# Source: http://cs.millersville.edu/~katz/linuxHelp/Makefile.txt
#
# This is a simple makefile that compiles multiple C++ source files

# set the names here to be the names of your source files with the
# .cxx or .cpp replaced by .o
# Be *** SURE *** to put the .o files here rather than the source files

Objects = numerical_computations_dynamic_memory_allocation.o numerical_computations_dynamic_array.o load_and_save_image_files.o

# This is a simple makefile that compiles multiple C++ source files

# set the names here to be the names of your source files with the
# .cxx or .cpp replaced by .o
# Be *** SURE *** to put the .o files here rather than the source files

proj1 = numerical_computations_dynamic_memory_allocation.o
proj2 = numerical_computations_dynamic_array.o
proj3 = load_and_save_image_files.o

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

all: numerical_computations_dynamic_memory_allocation numerical_computations_dynamic_array load_and_save_image_files

numerical_computations_dynamic_memory_allocation: $(proj1)
	g++ $(CFLAGS) $(proj1) -o numerical_computations_dinamic_memory_allocation
	
numerical_computations_dynamic_array: $(proj2)
	g++ $(CFLAGS) $(proj2) -o numerical_computations_dynamic_array
	
load_and_save_image_files: $(proj3)
	g++ $(CFLAGS) $(proj3) -o load_and_save_image_files

clean:
	rm -f $(Objects) numerical_computations_dinamic_memory_allocation numerical_computations_dynamic_array load_and_save_image_files
#------------ dependencies --------------------------------------------
# put the .o that depends on a .h, then colon, then TAB, then the .h

#class1.o:	class1.h
#class2.o:	class2.h
#theProject.o:	class1.h class2.h


