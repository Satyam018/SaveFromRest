package com.example.roomretro.dboperation;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.example.roomretro.Datacallback;
import com.example.roomretro.model.Post;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.http.POST;

public class Dbmanager {
    private static final String TAG ="TAG" ;
    private Context context;
    Databaserooms databaserooms;
    Datacallback datacallback;

    public Dbmanager(Context context,Datacallback datacallback) {
        this.context = context;
        databaserooms= Room.databaseBuilder(context,Databaserooms.class,"table.db").build();

    }

    public void insertdata(Post post){
        Log.e(TAG, "insertdata: "+"insert" );
        Observable<String> observable=Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                databaserooms.getdatabasedao().insertdata(post);
                emitter.onNext("suucess");
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                Log.e(TAG, "onNext: "+s );
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
    public void getdata(){

        Observable<List<Post>> observable=databaserooms.getdatabasedao().allgetdata();
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Post> posts) {
                        datacallback.getsaveddata(posts);
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
