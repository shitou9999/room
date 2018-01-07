package com.example.app3.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.paging.PagedList
import com.chuckiefan.architecturecomponentdemo.persistence.repository.MovieRepository
import com.example.app3.Constant
import com.example.app3.iview.RefreshView

/**
 * Created by PVer on 2018/1/7.
 */
class InTheaterViewModel(app:Application): AndroidViewModel(app) {

    private val repo = MovieRepository(app)
    private val datas = repo.getInTheaterMovies()

    /**
     * 获取数据（从仓库获取数据）
     */
    fun getData() = datas.create(0, PagedList.Config.Builder()
            .setPageSize(Constant.PAGESIZE)
            .setEnablePlaceholders(Constant.ENABLE_PLACEHOLDERS)
            .build())

    /**
     * 刷新数据
     */
    fun refresh(view: RefreshView){
        repo.refreshInTheaterMovies(view)
    }


}