package id.layar.layartancep.ui.home;

import java.util.List;

import androidx.lifecycle.ViewModel;
import id.layar.layartancep.data.Movies;
import id.layar.layartancep.utlis.DataGenerator;

public class HomeViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public List<Movies> getMovies() {
        return DataGenerator.generateDataMovie();
    }
}



