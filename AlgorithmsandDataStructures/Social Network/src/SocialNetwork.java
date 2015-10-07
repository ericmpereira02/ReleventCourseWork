/*
* Author : Austin Haggard, ahaggard2013@my.fit.edu
* Course : CSE 2010, Section 01, Fall 2014
* Project: Lab 2, Social Networks
*/

import java.util.ArrayList;

public class SocialNetwork implements Network {

    //maximum number of people in the network
	int n;

	// names of the people in the network
	ArrayList<String> names;
	ArrayList<Integer> communities;
	ArrayList<String> friendships;
	

	// constructor
	public SocialNetwork(final int n_) {
		ArrayList<String> names_ = new ArrayList<String>();
		ArrayList<Integer> comminities_ = new ArrayList<Integer>();
		ArrayList<String> friendships_ = new ArrayList<String>();
		this.n = n_;
		this.names = names_;
		this.communities = comminities_;
		this.friendships = friendships_;
	}

	// Add a friendship between personAname - personBname into the network
	public final void addPeople(final String personAname,
			final String personBname) {
		//adds new names to the names list
		if (!names.contains(personAname)) {
			this.names.add(personAname);
		}
		if (!names.contains(personBname)) {
			this.names.add(personBname);
		}
		// creates a new friendship
		if (!friendships.contains(personAname + " - " + personBname)) {
			this.friendships.add(personAname + " - " + personBname);
			// groups the communities together
			groupCommunities();
		}
	}


	// process multiple friendship requests from a multiline string where
	// each line is in the form:  personA - personB
	// Hint: this function should be using addPeople()
	public final void processConnections(final String multiStringWithConnections) {
		String[] connections = multiStringWithConnections.split("\\n");
		//adds initial friendships
		for (int i = 0; i < connections.length; i++) {
			this.friendships.add(connections[i]);
		}
		//adds initial names
		for (int i = 0; i < connections.length; i++) {
			String[] names = connections[i].split("\\s-\\s");
			addPeople(names[0], names[1]);
		}

		groupCommunities();
	}

	public final void groupCommunities() {
		//clears communities for when new people are added
		communities.clear();
		
		for (int i = 0; i < names.size(); i++) {
			communities.add(i);
		}
		for (int i = 0; i < names.size(); i++) {

			for (int j = 0; j < names.size(); j++) {
				
				if (i != j) {
					//finds connections then sets the community into groups 
					if (areConnected(names.get(i), names.get(j))) {
						communities.set(i, communities.get(j));
						break;
					}
				}

			}
		}
	}
	// given a name return an array of people who should be invited to the party
	public final String[] inviteToParty(String name) {
		ArrayList<String> friends = new ArrayList<String>();
		int nameIndex = -1;
		int group;
		for (int i = 0; i < names.size(); i++) {

			if (name.equals(names.get(i))) {
				nameIndex = i;
				break;
			}
		}

		group = communities.get(nameIndex);
		//creates a lsit of friends to invite
		for (int i = 0; i < communities.size(); i++) {

			if (communities.get(i) == group) {
				if (!names.get(i).equals(name)) {
					friends.add(names.get(i));
				}
			}
		}
		//converts List to an array
		String[] friendsToInvite = new String[friends.size()];
		friendsToInvite = friends.toArray(friendsToInvite);
		return friendsToInvite;
	}

	// return true if there is a link of friends between personAname and
	// personBname
	public final boolean areConnected(String personAname, String personBname) {
		//splits friendships
		for (int i = 0; i < friendships.size(); i++) {
			String[] names = friendships.get(i).split("\\s-\\s");
			//finds if personA and personB are actually connected
			// according to friendships
			if (personAname.equals(names[0])) {
				if (personBname.equals(names[1])) {
					return true;
				}
			} else if (personAname.equals(names[1])) {
				if (personBname.equals(names[0])) {
					return true;
				}
			}

		}
		return false;

	}

	// print return a string containing communities of the network
	public final String printCommunities() {
		StringBuilder solution = new StringBuilder();
		ArrayList<Integer> clone = new ArrayList<Integer>();
		// number used to label communities
		int comNum = 1;
		//creates a clone so original numbers stay clean
		for (Integer number : communities) {
			clone.add(number);
		}
		//starts adding names to the solution by looping through community
		for (int i = 0; i < clone.size(); i++) {
			if (clone.get(i) != -1) {
				solution.append("Community # " + (comNum) + " ");
				comNum++;
			}
			for (int j = 0; j < clone.size(); j++) {
				//sets used community indexes to -1 to not use them again
				if (clone.get(i) == clone.get(j) && clone.get(j) != -1) {
					if (j != i) {
						clone.set(j, -1);
					}
					solution.append(names.get(j) + " ");

				}

			}
			if (clone.get(i) != -1) {
				solution.append("\n");
			}
		}
		return solution.toString();
	}
}
