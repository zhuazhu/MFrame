package mejust.frame.di.module;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import mejust.frame.net.HttpConfigHelper;

/**
 * @author : Beaven
 * @date : 2017-12-20 11:30
 * <p>
 * 全局Module，提供全局注入
 */
@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public Application provideApplication() {
        return application;
    }

    @Singleton
    @Provides
    public HttpConfigHelper provideHttpConfigHelper() {
        return new HttpConfigHelper();
    }
}
