package com.example.roomretro.networkoperation;

import android.content.Context;
import android.util.Log;

import com.example.roomretro.Datacallback;
import com.example.roomretro.model.Post;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.http.POST;

public class networkmanager {
    private Context context;
    private Apiservice apiservice;
    private String TAG="TAG";
    Datacallback datacallback;

    public networkmanager(Context context,Datacallback datacallback) {
        this.context = context;
        apiservice=new Apiservice();
        this.datacallback=datacallback;
    }

    public void getdata(){
        Observable<List<Post>> observable= apiservice.callservice().getpost();
            observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<List<Post>>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull List<Post> posts) {
                       datacallback.getdata(posts);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            Log.e(TAG, "onError: "+e.toString() );
                        }

                        @Override
                        public void onComplete() {
                            Log.e(TAG, "onComplete: "+"complete" );
                        }
                    });

    }

}
