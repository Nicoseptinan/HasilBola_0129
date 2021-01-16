package com.example.hasilbola_0129.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.hasilbola_0129.ApiClient;
import com.example.hasilbola_0129.ApiService;
import com.example.hasilbola_0129.LastMatchAdapter;
import com.example.hasilbola_0129.Match;
import com.example.hasilbola_0129.MatchResponse;
import com.example.hasilbola_0129.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LastMatchFragment extends Fragment {

    private ArrayList<Match> listMatch;
    private RecyclerView rvMatch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_last_match, container, false);
        rvMatch = view.findViewById(R.id.rv_lastmatch);
        rvMatch.setHasFixedSize(true);
        rvMatch.setLayoutManager(new LinearLayoutManager(getContext()));

        ApiService service = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<MatchResponse> call = service.getLastMatch("4334");
        call.enqueue(new Callback<MatchResponse>() {
            @Override
            public void onResponse(Call<MatchResponse> call, Response<MatchResponse> response) {

                listMatch = response.body().getEvents();

                LastMatchAdapter lastMatchAdapter = new LastMatchAdapter(listMatch);
                rvMatch.setAdapter(lastMatchAdapter);
            }

            @Override
            public void onFailure(Call<MatchResponse> call, Throwable t) {

            }
        });



        return view;
    }
}
