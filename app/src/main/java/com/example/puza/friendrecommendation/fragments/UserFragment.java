package com.example.puza.friendrecommendation.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puza.friendrecommendation.R;
import com.example.puza.friendrecommendation.adapter.UserAdapter;
import com.example.puza.friendrecommendation.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    /*---------------featured items----------------------*/
    RecyclerView userRecyclerView;
    private RecyclerView.LayoutManager uLayoutManager;
    UserAdapter userAdapter;
    List<User> userItems;
    /*---------------------------------------------------*/


    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        /*------------------Featured Items--------------------------*/
        userRecyclerView = (RecyclerView) view.findViewById(R.id.featuredRecycler);

        userItems = getUserItems();

        userRecyclerView.setHasFixedSize(true);

        uLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        userRecyclerView.setLayoutManager(uLayoutManager);
        userAdapter = new UserAdapter(getActivity(), userItems);
        userRecyclerView.setAdapter(userAdapter);

        /*------------------------------------------------------------*/

        return view;
    }

    private List<User> getUserItems() {
        userItems = new ArrayList<User>();

        userItems.add(new User( R.drawable.banner3, "Puja Shrestha","I am a Android Application Developer."));
        userItems.add(new User( R.drawable.banner3, "Lucky Sherpa","I am a React Reveloper."));
        userItems.add(new User( R.drawable.banner3, "Thinley Shrepa","I am a JavaScript developer."));
        userItems.add(new User( R.drawable.banner3, "Sita Neupane","I am a Ruby Developer."));
        userItems.add(new User( R.drawable.banner3, "Pratibha Bista","I am a Veu Developer."));
        userItems.add(new User( R.drawable.banner3, "Subhechchha Kapali","I am a Network Administrator."));
        userItems.add(new User( R.drawable.banner3, "Prajwal Kakhapati","I am a Python Developer."));
        userItems.add(new User( R.drawable.banner3, "Pawan Sunuwar","I am a Designer and React Native Developer."));
        userItems.add(new User( R.drawable.banner3, "Abhishek kakshapati","I am JavaScript Developer"));
        userItems.add(new User( R.drawable.banner3, "Rabin Gaire","I am a Ruby and React Developer."));

        return userItems;
    }

}
