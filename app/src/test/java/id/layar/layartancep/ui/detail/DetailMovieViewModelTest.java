package id.layar.layartancep.ui.detail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import id.layar.layartancep.BuildConfig;

import static org.junit.Assert.*;

public class DetailMovieViewModelTest {

    private DetailMovieViewModel viewModel;
    private String urlPath;


    @Before
    public void setUp() {
        viewModel = new DetailMovieViewModel();
        urlPath = "/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg";
    }

    @After
    public void tearDown() {
    }



    @Test
    public void generateURL() {
        String path = viewModel.generateURL(urlPath);
        assertNotNull(path);
        assertEquals(BuildConfig.BASE_URL_IMG +urlPath,path);
    }
}