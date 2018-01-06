package be.ap.eaict.gadder;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import be.ap.eaict.gadder.Adapters.SectionsPageAdapter;
import be.ap.eaict.gadder.Fragments.FriendlistFragment;
import be.ap.eaict.gadder.Fragments.InvitelistFragment;

public class FriendlistActivity extends AppCompatActivity {

    private SectionsPageAdapter mSectionPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendlist);


        //Tabs Adapter
        mSectionPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new FriendlistFragment(), "Friends");
        adapter.addFragment(new InvitelistFragment(), "Invites");
        viewPager.setAdapter(adapter);
    }

}
