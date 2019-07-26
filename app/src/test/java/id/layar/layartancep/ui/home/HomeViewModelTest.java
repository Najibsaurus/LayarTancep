package id.layar.layartancep.ui.home;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import id.layar.layartancep.data.Movies;

import static org.junit.Assert.*;

public class HomeViewModelTest {

    private HomeViewModel viewModel;

    @Before
    public void setUp(){
        viewModel = new HomeViewModel();
    }

    @After
    public void tearDown(){

    }


    @Test
    public void getMovies(){
        List<Movies> movies = viewModel.getMovies();
        assertNotNull(movies);
        assertEquals(12, movies.size());

    }

}