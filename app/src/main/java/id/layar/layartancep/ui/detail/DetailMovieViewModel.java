package id.layar.layartancep.ui.detail;

import androidx.lifecycle.ViewModel;
import id.layar.layartancep.BuildConfig;

public class DetailMovieViewModel extends ViewModel {

    public String urlPath;
    public String generateURL(String posterpath){
        urlPath = BuildConfig.BASE_URL_IMG+posterpath;
        return urlPath;
    }

    //http://api.themoviedb.org/3/discover/movie?api_key=2428c31dfb862e03381053280d062d40

}
