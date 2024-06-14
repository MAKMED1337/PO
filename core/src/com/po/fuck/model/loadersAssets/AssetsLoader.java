package com.po.fuck.model.loadersAssets;


import com.po.fuck.model.loadersAssets.assetsDataFactory.WeaponLoader;
import com.po.fuck.model.loadersAssets.assetsDataFactory.BasicLoader;

import static com.po.fuck.model.Core.forceInit;

public class AssetsLoader {

    public static void loadAssets() {
        forceInit(WeaponLoader.class);
        forceInit(BasicLoader.class);
    }

}
