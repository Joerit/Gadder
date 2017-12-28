package be.ap.eaict.gadder.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import be.ap.eaict.gadder.Adapters.FriendInviteAdapter;
import be.ap.eaict.gadder.DOM.DummyRepository;
import be.ap.eaict.gadder.DOM.FBRepository;
import be.ap.eaict.gadder.R;

/**
 * Created by Kevin-Laptop on 25/12/2017.
 */

public class InvitelistFragment extends Fragment{

    private ListView inviteList;
    private Button btnDecline;
    private Button btnAccept;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.invitelist_fragment, container, false);

        inviteList = (ListView) view.findViewById(R.id.invitelist);

        FriendInviteAdapter friendInviteAdapter = new FriendInviteAdapter(this.getActivity(), FBRepository.getInstance().getUsers());
        inviteList.setAdapter(friendInviteAdapter);

        return view;
    }
}
