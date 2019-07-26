package id.layar.layartancep.ui.tv;

import androidx.lifecycle.ViewModel;

import java.util.List;

import id.layar.layartancep.data.Movies;
import id.layar.layartancep.data.Teve;
import id.layar.layartancep.utlis.DataGenerator;

public class TeveViewModel extends ViewModel {
    // TODO: Implement the ViewModel


    public List<Teve> getTeve() {
        return DataGenerator.generateDataTeve();
    }
}
