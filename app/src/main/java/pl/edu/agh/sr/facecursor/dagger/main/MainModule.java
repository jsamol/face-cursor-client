package pl.edu.agh.sr.facecursor.dagger.main;

import android.content.Context;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.face.FaceDetector;

import dagger.Module;
import dagger.Provides;
import pl.edu.agh.sr.facecursor.presenter.BasePresenter;
import pl.edu.agh.sr.facecursor.presenter.main.MainPresenter;
import pl.edu.agh.sr.facecursor.utils.CameraSourceConfiguration;

@Module
public class MainModule {
    private Context context;

    public MainModule(Context context) {
        this.context = context;
    }

    @Provides
    BasePresenter providePresenter(CameraSource cameraSource) {
        return new MainPresenter(cameraSource);
    }

    @Provides
    CameraSource provideCameraSource(Detector detector) {
        return new CameraSource.Builder(context, detector)
                .setRequestedPreviewSize(CameraSourceConfiguration.PREVIEW_HEIGHT,
                        CameraSourceConfiguration.PREVIEW_WIDTH)
                .setFacing(CameraSourceConfiguration.FACING)
                .setRequestedFps(CameraSourceConfiguration.REQUESTED_FPS)
                .build();
    }

    @Provides
    Detector provideDetector() {
        return new FaceDetector.Builder(context)
                .build();
    }
}
