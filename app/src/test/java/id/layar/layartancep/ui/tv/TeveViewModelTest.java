package id.layar.layartancep.ui.tv;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import id.layar.layartancep.data.Movies;
import id.layar.layartancep.data.Teve;
import id.layar.layartancep.ui.home.HomeViewModel;

import static org.junit.Assert.*;

public class TeveViewModelTest {


    private TeveViewModel viewModel;

    @Before
    public void setUp(){
        viewModel = new TeveViewModel();
    }

    @After
    public void tearDown(){

    }


    @Test
    public void getTeve(){
        List<Teve> teves = viewModel.getTeve();
        assertNotNull(teves);
        assertEquals(10, teves.size());

    }

}