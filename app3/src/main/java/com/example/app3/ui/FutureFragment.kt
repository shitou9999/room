package com.example.app3.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.app3.R
import com.example.app3.iview.FutureView
import com.example.app3.iview.MainView
import com.example.app3.iview.SwipeToLoadLayout
import com.example.app3.presenter.FuturePresenter
import com.example.app3.ui.adapter.MovieAdapter
import com.example.app3.viewmodel.CommingsoonViewModel

class FutureFragment : BaseFragment<FuturePresenter>(), FutureView {

    private lateinit var viewModel: CommingsoonViewModel
    private lateinit var swipeToLoadLayout: SwipeToLoadLayout

    private val adapter = MovieAdapter()


    override fun onErrors(error: Throwable) {}

    override fun onRefreshCompleted() {

    }

    override fun onLoadMoreCompleted() {
//        onRefreshCompleted(swipeToLoadLayout,true)
    }

    override fun onRefresh() {
        viewModel.refresh(this)
    }

    override fun loadMore() {}

    override fun getContentViewId(): Int {
        return R.layout.fragment_future
    }

    override fun initView(mainView: MainView) {
        val recyclerView: RecyclerView = mainView.findViewById(R.id.swipe_target)
//        swipeToLoadLayout = view.findViewById(R.id.swipeToLoadLayout)
//        swipeToLoadLayout.setOnLoadMoreListener(this)
//        swipeToLoadLayout.setOnRefreshListener(this)

        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(CommingsoonViewModel::class.java)
        viewModel.getData().observeForever(Observer(adapter::setList))
        onRefresh()
    }

    override fun getTitleResId(): Int {
        return 0
    }

    override fun getPresenterInstance(): FuturePresenter {
        return FuturePresenter(this)
    }

    override fun onFragmentFirstVisible() {

    }

    private var mParam1: String? = null
    private var mParam2: String? = null

    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }


    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(param1: String, param2: String): FutureFragment {
            val fragment = FutureFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}
