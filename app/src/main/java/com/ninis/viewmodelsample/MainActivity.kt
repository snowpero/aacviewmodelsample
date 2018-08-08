package com.ninis.viewmodelsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ninis.viewmodelsample.has_adapter.PostListFragment
import com.ninis.viewmodelsample.none_adapter.NoneAdapterFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_show_adapter_view.setOnClickListener(this)
        btn_show_none_adapter_view.setOnClickListener(this)

        supportFragmentManager.addOnBackStackChangedListener {  }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_show_adapter_view -> {
                supportFragmentManager
                        .beginTransaction()
                        .add(R.id.fl_fragment_container, PostListFragment.newInstance(), "HasAdapterFragment")
                        .addToBackStack(null)
                        .commitAllowingStateLoss()
            }
            R.id.btn_show_none_adapter_view -> {
                supportFragmentManager
                        .beginTransaction()
                        .add(R.id.fl_fragment_container, NoneAdapterFragment.newInstance(), "NoneAdapterFragment")
                        .addToBackStack(null)
                        .commitAllowingStateLoss()
            }
        }
    }

    override fun onBackPressed() {
        val fm = supportFragmentManager
        val ft = supportFragmentManager.beginTransaction()

        if( fm.backStackEntryCount > 0 ) {
            fm.popBackStack()
            ft.commitAllowingStateLoss()
        } else {
            super.onBackPressed()
        }
    }
}
