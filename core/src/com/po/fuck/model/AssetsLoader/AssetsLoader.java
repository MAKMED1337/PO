package com.po.fuck.model.AssetsLoader;


import com.po.fuck.model.AssetsLoader.assetsDataFactory.WeaponLoader;
import com.po.fuck.model.AssetsLoader.assetsDataFactory.BasicLoader;

import static com.po.fuck.model.Core.forceInit;

public class AssetsLoader {

    public static void loadAssets() {
        forceInit(WeaponLoader.class);
        forceInit(BasicLoader.class);
    }

}
