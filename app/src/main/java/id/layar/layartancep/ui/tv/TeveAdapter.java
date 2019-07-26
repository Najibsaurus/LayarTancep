package id.layar.layartancep.ui.tv;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import id.layar.layartancep.BuildConfig;
import id.layar.layartancep.R;
import id.layar.layartancep.data.Movies;
import id.layar.layartancep.data.Teve;
import id.layar.layartancep.ui.detail.DetailMovie;

public class TeveAdapter extends RecyclerView.Adapter<TeveAdapter.TeveViewHolder> {
    private final Activity activity;
    private List<Teve> mTeve = new ArrayList<>();

    public TeveAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<Teve> getListMovie() {
        return mTeve;
    }

    void setListTeve(List<Teve> listTeve) {
        if (listTeve == null) return;
        this.mTeve.clear();
        this.mTeve.addAll(listTeve);
    }


    @NonNull
    @Override
    public TeveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new TeveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeveViewHolder holder, int position) {
        final Teve pos = getListMovie().get(position);
        if (pos != null){
            holder.titleItemView.setText(pos.getTitle());
            Glide.with(holder.itemView.getContext()).load(BuildConfig.BASE_URL_IMG+pos.getPoster_path()).into(holder.imagePoster);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, DetailMovie.class);
                    intent.putExtra("title", pos.getTitle());
                    intent.putExtra("description", pos.getOverview());
                    intent.putExtra("image", pos.getPoster_path());
                    activity.startActivity(intent);
                }
            });

        } else {
            holder.titleItemView.clearComposingText();
        }
    }


    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    class TeveViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleItemView;
        private final ImageView imagePoster;

        private TeveViewHolder(View itemView) {
            super(itemView);
            titleItemView = itemView.findViewById(R.id.title);
            imagePoster = itemView.findViewById(R.id.imagePoster);

        }
    }
}

