package bwi.prog.examWS16;

import bwi.prog.examWS16.Date;
import bwi.prog.examWS16.Movie;
import bwi.prog.examWS16.MovieList;

public class MovieDatabase {

	public static void main(String[] args) {
		MovieList movieList = new MovieList();
		
		//should output that there are no entries in the list.
		System.out.println("***Empty Movie List***");
		displayAllMovies(movieList);
		System.out.println();
		
		//add some sample movies.
		addMovie(movieList, "Star Wars: Roge One", 2016, 12, 153, 8.2F, new String[]{"Felicity Jones","Diego Luna","Forest Whitaker"});
		addMovie(movieList, "Fight Club", 1999, 11, 159, 8.8F, new String[]{"Brad Pitt","Edward Norton"});
		addMovie(movieList, "Seven", 1995, 11, 159, 8.6F, new String[]{"Brad Pitt","Morgan Freeman"});
		
		//try to add a duplicate movie. this shall be rejected and the number of movies in the list shall not change.
		addMovie(movieList, "Fight Club", 1999, 11, 159, 8.8F, new String[]{"Brad Pitt","Edward Norton"});
		
		System.out.println("***Original Movie List***");
		displayAllMovies(movieList);
		System.out.println();
		
//		//should display all movies sorted by there release date.
//		System.out.println("***Sorted by Release***");
//		displayAllMovies(sortMoviesByRelease(movieList));
//		System.out.println();

//		//should display all movies that Brad Pitt was starring in.
//		System.out.println("***Only Brad Pitt Movies***");
//		displayAllMovies(filterMoviesByActor(movieList,"Brad Pitt"));
//		System.out.println();

		//try to remove an invalid index
		removeMovie(movieList, -1);
		//remove the movie at index position 1
		removeMovie(movieList, 1);
		
		//should display the original list where the movie at position 1 was removed.
		System.out.println("***Removed Fight Club***");
		displayAllMovies(movieList);
	}
	
	//5pts
	//Display the movie name, release date, duration, actors and rating each in a separate line. 
	//List all actors in one line, with a ',' as separator. If there are no actors associated skip the actors line.
	public static void displayMovie(Movie movie){
		System.out.println(movie.name);
		System.out.println("Release: " + movie.release.month + "/" + movie.release.month);
		System.out.println("Duration: " + movie.duration);
		System.out.print("Actors: ");		
		for(int i = 0; i < movie.actors.length; i++) {
			if(i > 0) System.out.print(", ");
			System.out.print(movie.actors[i]);
		}
		
		System.out.println();

	}
	
	//3pts
	//Display all movies and add a star line before the first, after the last and between each movie. 
	//If the list has no entries output a message that there are no entries.
	//Hint: use the printStarline and the displayMovie methods to produce the output.
	public static void displayAllMovies(MovieList list){
		printStarLine();
		if(list.next == 0) System.out.println("The list is empty!");
		
		for(int i = 0; i < list.next; i++) {
			displayMovie(list.movies[i]);
			printStarLine();
		}

	}
	
	//5pts
	//Add a movie to the MovieList. 
	//Prevent duplicate entries in the MovieList by rejecting movies
	//that have the same name as an already existing movie in the MovieList.
	//If the MovieList does not have enough space for the new movie
	//call the resize method that doubles the capacity of the MovieList before you add the movie.
	public static boolean addMovie(MovieList list, Movie movie){
		for(int i = 0; i < list.next; i++) {
			if(list.movies[i].name == movie.name) return false;
		}
		
		if(list.next == list.movies.length) resize(list);
		
		list.movies[list.next] = movie;
		list.next++;

		return true;
	}
	
	//3pts
	//Remove a movie from the MovieList at the specified index. 
	//Check if the index is a valid index to prevent exceptions. 
	//If the index is invalid just do nothing.
	public static void removeMovie(MovieList list, int idx){

	}
	
	//4pts
	//Create a copy of a MovieList and return that copy.
	//You shall create a deep copy of the list so if you change(add, remove a movie) the original or the copied list
	//it shall not have an effect on the other list.
	public static MovieList createCopy(MovieList list){

		return null;
	}
	
	//7pts
	//Sort Movies in a MovieList by release date.
	//Do not alter the original MovieList instead create a copy of the original list
	//and sort the copy. Return the sorted list.
	public static MovieList sortMoviesByRelease(MovieList list){

		return null;
	}
	
	//6pts
	//Filter a MovieList by actor.
	//Do not alter the original list. 
	//Return a new MovieList with all movies starring the chosen actor.
	public static MovieList filterMoviesByActor(MovieList list, String actor){

		return null;
	}
	
	
	
	public static boolean addMovie(MovieList list, String name, int year, int month, int duration, float rating, String[] actors){		
		
		Movie movie = new Movie();
		
		movie.name = name;
		movie.release = new Date();
		movie.release.month = month;
		movie.release.year = year;
		movie.duration = duration;
		movie.rating = rating;
		movie.actors = actors;
			
		return addMovie(list, movie);
	}
	
	public static void resize(MovieList list) {
		Movie[] newList = new Movie[list.movies.length * 2];
		
		for(int i = 0; i < list.next; i++) {
			newList[i] = list.movies[i];
		}
		
		list.movies = newList;
	}
		
	public static void printStarLine(){
		System.out.println("************************");
	}
}
