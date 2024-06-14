package com.po.fuck.model.Loaders;


import com.po.fuck.model.Loaders.Loaders.*;

import static com.po.fuck.model.Core.forceInit;

public class AssetsLoader {

    public static void loadAssets() {
        forceInit(WeaponLoader.class);
        forceInit(BasicLoader.class);
    }

}
