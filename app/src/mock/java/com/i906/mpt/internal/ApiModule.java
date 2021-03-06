package com.i906.mpt.internal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.i906.mpt.api.MockApiUtils;
import com.i906.mpt.api.foursquare.FoursquareClient;
import com.i906.mpt.api.foursquare.MockFoursquareClient;
import com.i906.mpt.api.prayer.MockPrayerClient;
import com.i906.mpt.api.prayer.PrayerClient;
import com.i906.mpt.api.prayer.PrayerData;
import com.i906.mpt.api.prayer.PrayerDataTypeAdapter;
import com.i906.mpt.date.DateTimeHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Noorzaini Ilhami
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .registerTypeAdapter(PrayerData.class, new PrayerDataTypeAdapter())
                .create();
    }

    @Provides
    @Singleton
    FoursquareClient provideFoursquareClient(MockApiUtils utils) {
        return new MockFoursquareClient(utils);
    }

    @Provides
    @Singleton
    PrayerClient providePrayerClient(MockApiUtils utils, DateTimeHelper date) {
        return new MockPrayerClient(utils, date);
    }
}
