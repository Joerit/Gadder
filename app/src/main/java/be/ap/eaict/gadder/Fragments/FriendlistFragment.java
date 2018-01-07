package be.ap.eaict.gadder.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import be.ap.eaict.gadder.Adapters.FriendslistAdapter;
import be.ap.eaict.gadder.DOM.FBRepository;
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

        FriendslistAdapter friendslistAdapter = new FriendslistAdapter(this.getActivity(), FBRepository.getInstance().getUsers());
        friendList.setAdapter(friendslistAdapter);

        return view;
    }
}
