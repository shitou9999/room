package com.example.app3.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.Uri
import android.os.Bundle
import com.example.app3.R
import com.example.app3.iview.InTheaterView
import com.example.app3.iview.MainView
import com.example.app3.iview.SwipeToLoadLayout
import com.example.app3.presenter.InTheaterPresenter
import com.example.app3.ui.adapter.MovieAdapter
import com.example.app3.viewmodel.InTheaterViewModel

/**
 *
 */
class InTheaterFragment : BaseFragment<InTheaterPresenter>(), InTheaterView {

    private lateinit var viewModel: InTheaterViewModel
    private lateinit var swipeToLoadLayout: SwipeToLoadLayout

    private val adapter = MovieAdapter()

    /**Fragment*/
    override fun onFragmentFirstVisible() {}

    /**网络请求异常*/
    override fun onError(throwable: Throwable?) {}

    /**刷新问题*/
    override fun onErrors(error: Throwable) {
        //刷新
    }

    /**刷新完成*/
    override fun onRefreshCompleted() {
//        RefreshUtil.onRefreshCompleted(swipeToLoadLayout,false)
    }

    override fun getContentViewId(): Int {
        return R.layout.fragment_in_theater
    }

    override fun initView(mainView: MainView) {
//        val recyclerView: RecyclerView = view.findViewById(R.id.swipe_target)
//        swipeToLoadLayout = view.findViewById(R.id.swipeToLoadLayout)
//        swipeToLoadLayout.setOnRefreshListener(this)
//
//        recyclerView.itemAnimator = DefaultItemAnimator()
//        recyclerView.layoutManager = LinearLayoutManager(this.context)
//        recyclerView.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(InTheaterViewModel::class.java)
        viewModel.getData().observeForever(Observer(adapter::setList))
        onRefresh()
    }

    /**刷新*/
    override fun onRefresh() {
        viewModel.refresh(this)
    }


    override fun getTitleResId(): Int {
        return 0
    }

    override fun getPresenterInstance(): InTheaterPresenter {
        return InTheaterPresenter(this)
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

    /**
     * 实例化Fragment
     */
    companion object {

        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(param1: String, param2: String): InTheaterFragment {
            val fragment = InTheaterFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }


}
