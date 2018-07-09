
import com.tarun.samplekotlindemo1.utilities.getMoviesByReleaseYear
import com.tarun.samplekotlindemo1.utilities.movie
import com.tarun.samplekotlindemo1.utilities.moviestore
import khttp.get

fun main(args: Array<String>) {

    val movies = FileUtils.getMoviesFromCsv("D:\\MovieList.csv")
    movies.forEach { movie -> println(get("http://omdbapi.com/?apikey=1277cc5b&i=${movie.id}").text) }
    movies.getMoviesByReleaseYear(1992)
    println(get("http://omdbapi.com/?apikey=1277cc5b&i=tt0068646").text)

    val movie = moviestore {
        movie {
            id = "1"
            name = "Tarun "
            stars = listOf("a", "b")
            directors = listOf("dir1", "dir2")
            releaseYear = 1991
        }
    }

    print(movie)

}



