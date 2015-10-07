#
# Source: http://cs.millersville.edu/~katz/linuxHelp/Makefile.txt
#
# This is a simple makefile that compiles multiple C++ source files

# set the names here to be the names of your source files with the
# .cxx or .cpp replaced by .o
# Be *** SURE *** to put the .o files here rather than the source files

Objects =  circuit_board_price.o cyborg_data_type_sizes.o distance_per_tank_of_gas.o energy_drink_consuption.o land_calculation.o miles_per_gallon.o personal_information.o stock_commission.o
# set the names here to be the names of your source files with the
# .cxx or .cpp replaced by .o
# Be *** SURE *** to put the .o files here rather than the source files

proj1 = circuit_board_price.o
proj2 = cyborg_data_type_sizes.o
proj3 = distance_per_tank_of_gas.o
proj4 = energy_drink_consuption.o
proj5 = land_calculation.o
proj6 = miles_per_gallon.o
proj7 = personal_information.o
proj8 = stock_commission.o

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

all: circuit_board_price cyborg_data_type_sizes distance_per_tank_of_gas energy_drink_consuption land_calculation miles_per_gallon personal_information stock_commission 

circuit_board_price: $(proj1)
	g++ $(CFLAGS) $(proj1) -o circuit_board_price

cyborg_data_type_sizes: $(proj2)
	g++ $(CFLAGS) $(proj2) -o cyborg_data_type_sizes

distance_per_tank_of_gas: $(proj3)
	g++ $(CFLAGS) $(proj3) -o distance_per_tank_of_gas
	
energy_drink_consuption: $(proj4)
	g++ $(CFLAGS) $(proj4) -o energy_drink_consuption
	
land_calculation: $(proj5)
	g++ $(CFLAGS) $(proj5) -o land_calculation

miles_per_gallon: $(proj6)
	g++ $(CFLAGS) $(proj6) -o miles_per_gallon
	
personal_information: $(proj7)
	g++ $(CFLAGS) $(proj7) -o personal_information
	
stock_commission: $(proj8)
	g++ $(CFLAGS) $(proj8) -o stock_commission

clean:
	rm -f $(Objects) circuit_board_price cyborg_data_type_sizes distance_per_tank_of_gas energy_drink_consuption land_calculation miles_per_gallon personal_information stock_commission 
#------------ dependencies --------------------------------------------
# put the .o that depends on a .h, then colon, then TAB, then the .h

#class1.o:	class1.h
#class2.o:	class2.h
#theProject.o:	class1.h class2.h


