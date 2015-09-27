package balanjika.smart.sindhu.contacts;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import balanjika.smart.sindhu.smartbalanjka.R;


public class kdList extends ActionBarActivity implements
        TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {

    private TabHost mTabHost;
    private ViewPager mViewPager;
    private HashMap<String, TabInfo> mapTabInfo = new HashMap<String, kdList.TabInfo>();
    private PagerAdapter mPagerAdapter;

    private class TabInfo {
        private String tag;
        private Class<?> clss;
        private Bundle args;
        private Fragment fragment;

        TabInfo(String tag, Class<?> clazz, Bundle args) {
            this.tag = tag;
            this.clss = clazz;
            this.args = args;
        }

    }

    class TabFactory implements TabContentFactory {

        private final Context mContext;
        public TabFactory(Context context) {
            mContext = context;
        }

        @Override
        public View createTabContent(String tag) {
            View v = new View(mContext);
            v.setMinimumWidth(0);
            v.setMinimumHeight(0);
            return v;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout
        setContentView(R.layout.blood);
        // Initialise the TabHost
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        this.initialiseTabHost(savedInstanceState);


        if (savedInstanceState != null) {
            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab")); // set

        }
        // Intialise ViewPager
        this.intialiseViewPager();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("tab", mTabHost.getCurrentTabTag()); // save the tab
        // selected
        super.onSaveInstanceState(outState);
    }

    private void intialiseViewPager() {

        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, Awards_Fragment.class.getName()));
        fragments.add(Fragment.instantiate(this, Kd_dates_Fragment.class.getName()));

        this.mPagerAdapter = new PagerAdapter(
                super.getSupportFragmentManager(), fragments);
        this.mViewPager = (ViewPager) super.findViewById(R.id.viewpager);
        this.mViewPager.setAdapter(this.mPagerAdapter);
        this.mViewPager.setOnPageChangeListener(this);

    }

    private void initialiseTabHost(Bundle args) {
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();
        TabInfo tabInfo = null;
        mTabHost.getTabWidget().setBackgroundColor(getResources().getColor(R.color.color_f4f4f4));
        kdList.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab1")
                .setIndicator(getResources().getString(R.string.Events)), (tabInfo = new TabInfo(
                "Tab1", Awards_Fragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        kdList.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab2")
                .setIndicator(getResources().getString(R.string.Awards)), (tabInfo = new TabInfo(
                "Tab2", Kd_dates_Fragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        mTabHost.setOnTabChangedListener(this);
    }


    private static void AddTab(kdList activity, TabHost tabHost,
                               TabHost.TabSpec tabSpec, TabInfo tabInfo) {
        tabSpec.setContent(activity.new TabFactory(activity));
        tabHost.addTab(tabSpec);
    }

    @Override
    public void onTabChanged(String tag) {
        int pos = this.mTabHost.getCurrentTab();
        this.mViewPager.setCurrentItem(pos);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset,
                               int positionOffsetPixels) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageSelected(int position) {
        // TODO Auto-generated method stub
        this.mTabHost.setCurrentTab(position);
    }
    @Override
    public void onPageScrollStateChanged(int state) {
        // TODO Auto-generated method stub

    }


    @Override
    public void onBackPressed() {

        super.onBackPressed();
        return;
    }
}
