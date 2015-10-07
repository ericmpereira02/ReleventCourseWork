#
# Source: http://cs.millersville.edu/~katz/linuxHelp/Makefile.txt
#
# This is a simple makefile that compiles multiple C++ source files

# set the names here to be the names of your source files with the
# .cxx or .cpp replaced by .o
# Be *** SURE *** to put the .o files here rather than the source files

Objects =  sum_of_two_numbers.o sales_prediction.o sales_tax.o total_purchase.o restaurant_bill.o ocean_levels.o annual_pay.o average_of_values.o

# This is a simple makefile that compiles multiple C++ source files

# set the names here to be the names of your source files with the
# .cxx or .cpp replaced by .o
# Be *** SURE *** to put the .o files here rather than the source files

proj1 = sum_of_two_numbers.o
proj2 = sales_prediction.o
proj3 = sales_tax.o
proj4 = total_purchase.o
proj5 = restaurant_bill.o
proj6 = ocean_levels.o
proj7 = annual_pay.o
proj8 = average_of_values.o
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

all: sum_of_two_numbers sales_prediction sales_tax total_purchase restaurant_bill ocean_levels annual_pay average_of_values

sum_of_two_numbers: $(proj1)
	g++ $(CFLAGS) $(proj1) -o sum_of_two_numbers

sales_prediction: $(proj2)
	g++ $(CFLAGS) $(proj2) -o sales_prediction

sales_tax: $(proj3)
	g++ $(CFLAGS) $(proj3) -o sales_tax
	
total_purchase: $(proj4)
	g++ $(CFLAGS) $(proj4) -o total_purchase
	
restaurant_bill: $(proj5)
	g++ $(CFLAGS) $(proj5) -o restaurant_bill
	
ocean_levels: $(proj6)
	g++ $(CFLAGS) $(proj6) -o ocean_levels
	
annual_pay: $(proj7)
	g++ $(CFLAGS) $(proj7) -o annual_pay
	
average_of_values: $(proj8)
	g++ $(CFLAGS) $(proj8) -o average_of_values

clean:
	rm -f $(Objects) sum_of_two_numbers sales_prediction sales_tax total_purchase restaurant_bill ocean_levels annual_pay average_of_values
#------------ dependencies --------------------------------------------
# put the .o that depends on a .h, then colon, then TAB, then the .h

#class1.o:	class1.h
#class2.o:	class2.h
#theProject.o:	class1.h class2.h
