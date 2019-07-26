package id.layar.layartancep.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import id.layar.layartancep.BuildConfig;
import id.layar.layartancep.ui.detail.DetailMovie;
import id.layar.layartancep.R;
import id.layar.layartancep.data.Movies;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MoviesViewHolder> {
    private final Activity activity;
    private List<Movies> mMovies = new ArrayList<>();

    public HomeAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<Movies> getListMovie() {
        return mMovies;
    }

    void setListMovies(List<Movies> listCourses) {
        if (listCourses == null) return;
        this.mMovies.clear();
        this.mMovies.addAll(listCourses);
    }


    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        Movies pos = getListMovie().get(position);
        if (pos != null){
            holder.titleItemView.setText(pos.getTitle());
            Glide.with(holder.itemView.getContext()).load(BuildConfig.BASE_URL_IMG+pos.getPoster_path()).into(holder.imagePoster);
            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(activity, DetailMovie.class);
                intent.putExtra("title", pos.getTitle());
                intent.putExtra("description", pos.getOverview());
                intent.putExtra("image", pos.getPoster_path());
                activity.startActivity(intent);
            });

        } else {
            holder.titleItemView.clearComposingText();
        }
    }


    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    class MoviesViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleItemView;
        private final ImageView imagePoster;

        private MoviesViewHolder(View itemView) {
            super(itemView);
            titleItemView = itemView.findViewById(R.id.title);
            imagePoster = itemView.findViewById(R.id.imagePoster);

        }
    }
}
