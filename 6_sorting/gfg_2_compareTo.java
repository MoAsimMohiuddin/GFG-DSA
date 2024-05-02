public class gfg_2_compareTo {
    public static void main(String[] args)
    {
        String str="ab";
        String str1="ba";
        System.out.println(str.compareTo(str1));
    }

    public class Movie implements Comparable<Movie>
    {
        char movieChar;
        String movieName;
        int moviePrice;
        int rating;

        public Movie(String movieName, int moviePrice, int rating, char movieChar)
        {
            this.movieChar=movieChar;
            this.movieName=movieName;
            this.moviePrice=moviePrice;
            this.rating=rating;
        }

        public int compareTo(Movie obj)
        {
            return this.movieName.compareToIgnoreCase(obj.movieName);
        }
    }
}
