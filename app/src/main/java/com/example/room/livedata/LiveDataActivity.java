package com.example.room.livedata;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.Transformations;
import android.nfc.Tag;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.room.R;

/**
 * LiveData 是一个数据持有者类，它持有一个值并允许观察该值
 * LiveData是与组件的生命周期相关联,观察者模式检测数值的变化!!!!!!!!
 * 不同于普通的可观察者，LiveData 遵守应用程序组件的生命周期，以便 Observer 可以指定一个其应该遵守的 Lifecycle。
 * LiveData实现了对数据的监听，利用这点，我们可以更好的实现获取数据和数据展示解耦
 * 如何实现数据更新和UI展示解耦，实现逻辑分离!!!!!!!!!!
 */
public class LiveDataActivity extends AppCompatActivity {

    private MutableLiveData<String> username;
    private TextView tvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        tvUsername = findViewById(R.id.tv_username);

        username = new MutableLiveData<>();
        username.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tvUsername.setText(s);
                Log.d("**","onChanged");
            }
        });
    }

    /**
     * 1.避免内存泄漏：由于Observers绑定本身的Lifecycle对象， 当Lifecycle被销毁时， 其自动被移除。
     *  2.Activity处于onstop状态时， 不会导致应用程序意外崩溃： 当观察者的的生命周期处于非活动状态
     *  (比如Activity处于后台堆栈)时， Observer不会接到数据的变化
     *  3.收到更改事件
     *  4.始终保持最新的数据：当Lifecycle再次回到可活动状态时(比如Activity从后台堆栈返回到前台)， 它会受到最新的更改信息
     *  5.适当的配置更改： 如果由于配置更改(比如设置旋转)重新创建Activity/Fragment时， 会立即接收到最有可用的数据
     *  6.共享资源：可用保留一个有用的实例，分享给多个Activity或者Fragment
     *  7.没有针对生命周期做出多余的针对处理： 一切生命周期的变化， 所造成的的处理事务， 由LiveData自动管理。
     * LiveData是如何始终保持最新的数据呢？
     * 在LiveData中，有4个重要的方法：
         onActive()： 当LiveData有可观察的对象时回调
         onInactive()： 当LiveData没有可观察的对象时回调
         setValue()： 当LiveData更新实例的值时调用， 并通知Observer数据的更改
         postValue: 当LiveData更新实例的值时调用， 并通知Observer数据的更改
         其中，setValue和postValue方法都是用来LiveData更新实例时调用。值得注意的是，setValue方法只能在主线程中调用，
         而postValue可以在任何线程中调用。也就是说，如果是在后台子线程中更新LiveData的值，必须调用postValue。
     */

    /**
     * 主线程中更新数据***同步和异步两个方法，可以发现这里只有对数据的更新逻辑，没有任何UI更新的逻辑。
     * @param view
     */
    public void onClickMainThread(View view) {
        username.setValue("New User Name by main thread");
    }

    /**
     * 子线程中更新数据***同步和异步两个方法，可以发现这里只有对数据的更新逻辑，没有任何UI更新的逻辑。
     * @param view
     */
    public void onClickThread(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                username.postValue("New User Name by background thread");
            }
        }).start();
    }


    /**
     * LiveData的转换:::在android.arch.lifecycle包提供了Transformations工具类，用于LieveData值的数据类型的更改
     * 有时候，在将数据变化信息发送给Observer之前，需要对LiveData值的数据类型进行更改
     * (这里说的不是值本身的变化，而是数据类型的变化)，此时，就需要需要依据当前LiveData，返回另外一个LiveData实例。
     */

    /*
    map
    先看map方法，它接受两个参数：一个LiveData作为数据源和一个转换函数Function。其中，
    传递的转换函数应在主线程中执行，因为该函数用于数据源LiveData发出的每个值，并返回发出结果值的LiveData。
    现在我们将personLiveData的值的数据类型转换String类型：

    var personMapLiveData: LiveData<String>
            personMapLiveData = Transformations.map(personLiveData, {
            it: Person? ->
            it?.name
    })

        personMapLiveData.observe(this, Observer<String> {
        tvMap.text = it
        })

    switchMap
    现在我们看看switchMap，与map类似，将LiveData的值更改信息传递给子LiveData，
    不同的是，传递给它的函数必须返回一个LiveData对象。这就意味着，这种实现可能从
    将原来的LiveData销毁，并且在数据源LiveData数值发生变化时，重新创建一个新的LiveData实例。
        var personSwitchMapLiveData: LiveData<String>
        personSwitchMapLiveData = Transformations.switchMap(personLiveData) {
            val result = MediatorLiveData<String>()
            it.name
            result.postValue(it.name)
            result
        }

        personSwitchMapLiveData.observe(this, Observer<String> {
        tvSwitchMap.text = it
        })


        ****************自定义LiveData****************
        前面提到了LiveData的重要方法中包括setValue和postValue,值得注意的是这两个方法使用protected修饰，这意味着它们只能在LiveData的子类中调用。又由于，LiveData是一个抽象类，我们并不能创建其相应的实例。如果我们想创建其实例，不得不自定义LiveData的子类，比如，前面定义的PersonLiveData。在android.arch.lifecycle包中，有LiveData的两个实现类：MutableLiveData和MediatorLiveData。

        MutableLiveData继承自LiveData,其主要是对外公布了setValue和postValue(注意方法的调用时所属线程)。

        public class MutableLiveData<T> extends LiveData<T> {
            @Override
            public void postValue(T value) {
                super.postValue(value);
            }

            @Override
            public void setValue(T value) {
                super.setValue(value);
            }
        }
        而，MediatorLiveData又继承自MutableLiveData类，也就是说该类也公开了setValue和postValue方法。该类该又增加了监测其他LiveData实例值个更改并处理它们发出的事件。

        addSource(LiveData<S> source, Observer<S> onChanged)：添加监控的LiveData实例值及LiveData的值变化时处理的Observe
        removeSource(LiveData<S> toRemote):移除监控的LiveData实例值
        如果你兴趣可以根据自己的需求自定义LiveData，比如前面的PersonLiveData。

        */




}


















