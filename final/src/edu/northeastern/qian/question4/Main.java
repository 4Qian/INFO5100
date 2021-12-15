package edu.northeastern.qian.question4;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        final Date DATE_1990 = new GregorianCalendar(1990, Calendar.JANUARY, 1).getTime();
        final Date DATE_2000 = new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime();

        Netflix netflix = new Netflix();

        Genre horrorGenre = new Genre("horror");
        Genre comedyGenre = new Genre("comedy");
        Genre actionGenre = new Genre("action");
        netflix.setGenres(Arrays.asList(horrorGenre, comedyGenre, actionGenre));

        Movie movie1 = new Movie("The Conjuring", new GregorianCalendar(2013, 7, 1).getTime(), Arrays.asList("a", "b"),"James Wan");
        Movie movie2 = new Movie("Child's Play 3", new GregorianCalendar(1991, 11, 1).getTime(), Arrays.asList("c", "d"), "Tom Holland");
        Movie movie3 = new Movie("The Shining", new GregorianCalendar(1980, 5, 1).getTime(), Arrays.asList("e", "f"), "Abc");
        horrorGenre.setMovies(Arrays.asList(movie1, movie2, movie3));

        Movie movie4 = new Movie("Meet the Parents", new GregorianCalendar(1990, 3, 1).getTime(), Arrays.asList("a", "b"),"Xyz");
        Movie movie5 = new Movie("The Brothers Grimsby", new GregorianCalendar(2016, 1, 1).getTime(), Arrays.asList("a", "b"),"Def");
        comedyGenre.setMovies(Arrays.asList(movie4, movie5));

        Movie movie6 = new Movie("The Matrix", new GregorianCalendar(1999, 3, 7).getTime(), Arrays.asList("a", "b"),"Xyz");
        Movie movie7 = new Movie("Rush Hour 2", new GregorianCalendar(2001, 3, 7).getTime(), Arrays.asList("x", "b"),"Xyz");
        actionGenre.setMovies(Arrays.asList(movie6, movie7));

        // add Classic
        netflix.getGenres().stream().flatMap(genre -> genre.getMovies().stream()).forEach(movie -> {
            if (movie.getReleaseDate().before(DATE_2000)) {
                movie.setTitle("(Classic)" + movie.getTitle());
            }
        });
        System.out.println("======= print netflix after adding classic");
        printNetflix(netflix);
        System.out.println();
        System.out.println();
        System.out.println();

        // get latest 3 movies;
        List<Movie> latest3Movies = netflix.getGenres().stream().flatMap(genre -> genre.getMovies().stream())
                .sorted((o1, o2) -> o1.getReleaseDate().before(o2.getReleaseDate()) ? 1 : -1).limit(3)
                .collect(Collectors.toList());
        System.out.println("======= print latest 3 movies");
        latest3Movies.stream().forEach(movie -> System.out.println(movie));
        System.out.println();
        System.out.println();
        System.out.println();

        // define predicate to find movies between 1990 and 2000
        Predicate<Movie> before2000 = movie -> movie.getReleaseDate().before(DATE_2000);
        Predicate<Movie> after1990 = movie -> !movie.getReleaseDate().before(DATE_1990);
        Predicate<Movie> between1990And2000 = after1990.and(before2000);

        List<Movie> moviesBetween1990And2000 = netflix.getGenres().stream().flatMap(genre -> genre.getMovies().stream()
                .filter(between1990And2000)).collect(Collectors.toList());
        System.out.println("======= print movies between 1990 and 2000");
        moviesBetween1990And2000.stream().forEach(movie -> System.out.println(movie));
        System.out.println();
        System.out.println();
        System.out.println();

        // add year to title
        netflix.getGenres().stream().flatMap(genre -> genre.getMovies().stream())
                .forEach(movie ->  addReleaseYearToTitle(movie));
        System.out.println("======= print netflix after adding year to title");
        printNetflix(netflix);
        System.out.println();
        System.out.println();
        System.out.println();

        // sort by title
        List<Movie> movieSortedByTitle = netflix.getGenres().stream().flatMap(genre -> genre.getMovies().stream())
                .sorted((o1, o2) -> o1.getTitle().compareTo(o2.getTitle())).collect(Collectors.toList());
        System.out.println("======= print movies sorted by title");
        movieSortedByTitle.stream().forEach( movie -> System.out.println(movie));
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private static void addReleaseYearToTitle(Movie movie) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(movie.getReleaseDate());
        int year = calendar.get(Calendar.YEAR);
        movie.setTitle(movie.getTitle() + " " + year);
    }

    private static void printNetflix(Netflix netflix) {
        for (Genre genre : netflix.getGenres()) {
            System.out.println("======= " + genre.getName() +  "========");
            genre.getMovies().stream().forEach( movie -> System.out.println(movie));
        }
    }
}