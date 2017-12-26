package be.ap.eaict.gadder.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import be.ap.eaict.gadder.Adapters.FriendslistAdapter;
import be.ap.eaict.gadder.DOM.DummyRepository;
import be.ap.eaict.gadder.DOM.User;
import be.ap.eaict.gadder.R;

/**
 * Created by Kevin-Laptop on 25/12/2017.
 */

public class FriendlistFragment extends Fragment{

    private ListView friendList;

    private Button btnDelete;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friendlist_fragment, container, false);

        friendList = (ListView) view.findViewById(R.id.friendlist);

        FriendslistAdapter friendslistAdapter = new FriendslistAdapter(this.getActivity(), DummyRepository.getInstance().getUsers());
        friendList.setAdapter(friendslistAdapter);

        return view;
    }
}
