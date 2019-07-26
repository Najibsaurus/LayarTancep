package id.layar.layartancep.ui.home;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.layar.layartancep.R;
import id.layar.layartancep.data.Movies;

public class HomeFragment extends Fragment {

    private HomeAdapter homeAdapter;
    private RecyclerView rvMovies;
    private HomeViewModel mViewModel;
    private List<Movies> moviesList;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovies = view.findViewById(R.id.recyclerviewHome);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel
        if (getActivity() != null) {
            mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
            moviesList = mViewModel.getMovies();
            homeAdapter = new HomeAdapter(getActivity());
            homeAdapter.setListMovies(moviesList);

            rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
            rvMovies.setHasFixedSize(true);
            rvMovies.setAdapter(homeAdapter);
        }
    }

}
