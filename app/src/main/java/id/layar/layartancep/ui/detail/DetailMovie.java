package id.layar.layartancep.ui.detail;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import id.layar.layartancep.R;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMovie extends AppCompatActivity {
    public static final String POSITION_EXTRA = "position_extra_:)";

    private TextView textTitle;
    private TextView textDescription;
    private ImageView imageView;
    private DetailMovieViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        viewModel = ViewModelProviders.of(this).get(DetailMovieViewModel.class);

        textTitle = findViewById(R.id.title_text);
        textDescription = findViewById(R.id.description);
        imageView = findViewById(R.id.img_poster);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            textTitle.setText(extras.getString("title"));
            textDescription.setText(extras.getString("description"));
            String url = viewModel.generateURL(extras.getString("image"));
            Glide.with(this).load(url).into(imageView);

        }

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
