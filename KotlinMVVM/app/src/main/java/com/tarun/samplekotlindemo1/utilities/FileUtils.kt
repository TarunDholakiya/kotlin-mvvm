import java.io.BufferedReader
import java.io.FileReader

class FileUtils {
    companion object {
        fun getMoviesFromCsv(filePathName: String):
                ArrayList<Movie> = getMovies(BufferedReader(FileReader(filePathName)))

        fun getMovies(fileReader: BufferedReader): ArrayList<Movie> {
            val movies = ArrayList<Movie>()
            var line: String?

            fileReader.readLine()
            // Read the file line by line starting from the second line

            line = fileReader.readLine()
            while (line != null) {
                val tokens = line.split(",")
                if (tokens.size > 0) {
                    val movie = Movie(
                            tokens[0],
                            tokens[1],
                            tokens[2].split("|"),
                            tokens[3].split("|"),
                            Integer.parseInt(tokens[4]))
                    movies.add(movie)
                }
                line = fileReader.readLine()
            }
            return movies
        }
    }


}