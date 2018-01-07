package com.example.room.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.ClipData;

/**
 * Fragment之间共享数据
 * 在Activity中，两个或者多个Fragment之间相互通信。这也不算麻烦，自定义回调接口，
 * 因为所有的Fragment可以通过Activity将它们绑定在一起。
 * 值得考虑的是，必须处理其他Fragment尚未创建或者不可见的情况！！！！！！！！！！！
 */
public class SharedViewModel extends ViewModel {

    private final MutableLiveData<ClipData.Item> selected = new MutableLiveData<ClipData.Item>();

    public void select(ClipData.Item item) {
        selected.setValue(item);
    }

    public LiveData<ClipData.Item> getSelected() {
        return selected;
    }

/*

    当前Activity不需要处理任何事情，也不用知道通信的相关内容。
    除了SharedViewModel契约之外，Fragment之间并未有直接关联。即使其中一个被销毁，另外一个依然正常工作。
    每个Fragment都有自己的生命周期，不受其他Fragment的生命周期的影响。

    public class MasterFragment extends Fragment {
        private SharedViewModel model;
        public void onActivityCreated() {
            model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
            itemSelector.setOnClickListener(item -> {
                model.select(item);
            });
        }
    }

    public class DetailFragment extends LifecycleFragment {
        public void onActivityCreated() {
            SharedViewModel model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
            model.getSelected().observe(this, { item ->
                    // update UI
            });
        }
    }

    值得注意的是，在获取ViewModelProvider时，
    两个Fragment都使用getActivity(),这意味着它们都将收到相同的SharedViewModel实例，该实例是作用域的是当前Activity。
    */


}