package pl.edu.agh.sr.facecursor.ui;

import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

public abstract class BaseView<T> extends AppCompatActivity {

    @Inject
    protected T presenter;

    public abstract void initDagger();
}
