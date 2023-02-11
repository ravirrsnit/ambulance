package com.example.app;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;

import Model.IFirebaseLoadDone;
import Model.User;
import Model.ViewHolder.UserViewHolder;

public class AllPeopleActivity extends AppCompatActivity {

   FirebaseRecyclerAdapter<User, UserViewHolder> adapter,searchAdapter;
   RecyclerView recycler_all_user;
   IFirebaseLoadDone firebaseLoadDone;


   MaterialSearchBar searchBar;
   List<String> suggestList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_people);

        //Init View
        searchBar=(MaterialSearchBar) findViewById(R.id.material_search_bar);
        searchBar.setCardViewElevation(10);
        searchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                List<String> suggest =new ArrayList<>();
                for(String search:suggestList)
                {
                    if(search.toLowerCase().contains(searchBar.getText().toLowerCase()))
                        suggest.add(search);
                }
                searchBar.setLastSuggestions(suggest);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}