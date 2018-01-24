package fr.wcs.wcstravel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ResultFlightActivity extends AppCompatActivity {

    TravelModel mTravelModel;
    TextView mResultDeparturePlace, mResultArrivalPlace, mResultDepartureDate, mResultReturnDate;
    List<ResultTripModel> mResultTripModel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_flight);

        mResultDeparturePlace = findViewById(R.id.result_departure_place);
        mResultArrivalPlace = findViewById(R.id.result_arrival_place);
        mResultDepartureDate = findViewById(R.id.result_departure_date);
        mResultReturnDate = findViewById(R.id.result_return_date);

        //récupération de l'objet via Intent
        mTravelModel = getIntent().getExtras().getParcelable("TheTravel");

        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mResultDeparturePlace.setText(mTravelModel.getDeparturePlace());
        mResultArrivalPlace.setText(mTravelModel.getArrivalPlace());
        mResultDepartureDate.setText(sdf.format(mTravelModel.getDepartureDate().getTime()));
        mResultReturnDate.setText(sdf.format(mTravelModel.getReturnDate().getTime()));

        RecyclerView recyclerView = findViewById(R.id.recycler_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ResultTravelAdapter(mResultTripModel, this));
    }
}
