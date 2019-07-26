package id.layar.layartancep.ui.tv;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import id.layar.layartancep.R;
import id.layar.layartancep.data.Movies;
import id.layar.layartancep.data.Teve;
import id.layar.layartancep.ui.home.HomeAdapter;
import id.layar.layartancep.ui.home.HomeViewModel;

public class TeveFragment extends Fragment {

    private TeveAdapter teveAdapter;
    private RecyclerView rvTeve;
    private TeveViewModel mViewModel;
    private List<Teve> teveList;


    public static TeveFragment newInstance() {
        return new TeveFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.teve_fragment, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTeve = view.findViewById(R.id.recyclerviewTeve);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TeveViewModel.class);
        // TODO: Use the ViewModel
        if (getActivity() != null) {
            teveList = mViewModel.getTeve();
            teveAdapter = new TeveAdapter(getActivity());
            teveAdapter.setListTeve(teveList);

            rvTeve.setLayoutManager(new LinearLayoutManager(getContext()));
            rvTeve.setHasFixedSize(true);
            rvTeve.setAdapter(teveAdapter);
        }
    }

}
